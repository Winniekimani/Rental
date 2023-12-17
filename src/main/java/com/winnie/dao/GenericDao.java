package com.winnie.dao;



import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;
import java.lang.reflect.Field;
import java.util.*;

public class GenericDao <T> implements GenericDaoI<T> {

    private EntityManager em;

    @Override
    public List<T> list(T entity) {


        Class<?> clazz = entity.getClass();

        String simpleName = entity.getClass().getSimpleName();

        String tAlias = (simpleName.charAt(0) + "_").toLowerCase();
        String jpql = "FROM " + entity.getClass().getSimpleName() + " " + tAlias;

        StringBuilder whereClause = new StringBuilder();
        Map<String, Object> whereParams = new HashMap<>();

        List<Field> fields = new ArrayList<>(Arrays.asList(clazz.getSuperclass().getDeclaredFields()));
        fields.addAll(Arrays.asList(clazz.getDeclaredFields()));

        for (Field field : fields) {
            if (!field.isAnnotationPresent(Column.class))
                continue;

            Column column = field.getAnnotation(Column.class);
            field.setAccessible(true);

            try {
                if (field.get(entity) != null) {
                    String colName = StringUtils.isEmpty(column.name()) ? field.getName() : column.name();

                    whereClause
                            .append(whereParams.isEmpty() ? "" : " AND ")
                            .append(tAlias).append(".").append(colName).append("=:").append(colName);

                    whereParams.put(colName, field.get(entity));
                }

            } catch (IllegalAccessException iEx) {
                iEx.printStackTrace();

            }
        }

        jpql = jpql + (whereParams.isEmpty() && StringUtils.isBlank(whereClause) ? "" : " WHERE " + whereClause);

        jpql = jpql.replace(", FROM", " FROM");
        System.out.println("jpql: " + jpql);

        TypedQuery<T> query = (TypedQuery<T>) em.createQuery(jpql, entity.getClass());

        for (Map.Entry<String, Object> entry : whereParams.entrySet()) {
            System.out.println("param Name: " + entry.getKey() + " = " + entry.getValue());
            query = query.setParameter(entry.getKey(), entry.getValue());
        }

        return query.getResultList();


    }



    @Override
    public List<Object[]> nativeQuery(String sql) {
        return getEm().createNativeQuery(sql).getResultList();

    }

    @Override
    public T add(T entity) {

        return em.merge(entity);
    }


    @Override
    public void edit(Object entity, String columnName, Object columnValue) {
        try {
            Class<?> clazz = entity.getClass();
            if (!clazz.isAnnotationPresent(Entity.class)) {
                throw new RuntimeException("Entity Annotation Does Not Exist");
            }

            List<Field> fields = new ArrayList<>(Arrays.asList(clazz.getSuperclass().getDeclaredFields()));
            fields.addAll(Arrays.asList(clazz.getDeclaredFields()));

            StringBuilder setBuilder = new StringBuilder();

            for (Field field : fields) {
                if (!field.isAnnotationPresent(Column.class) || field.isAnnotationPresent(Id.class)) {
                    continue;
                }

                field.setAccessible(true);
                Column column = field.getAnnotation(Column.class);

                setBuilder.append(column.name()).append(" = :").append(field.getName()).append(", ");
            }

            // Remove the trailing comma and space from setBuilder
            setBuilder.delete(setBuilder.length() - 2, setBuilder.length());

            String jpqlQuery = "UPDATE " + clazz.getSimpleName() + " SET " + setBuilder +
                    " WHERE " + columnName + " = :columnValue";

            Query query = em.createQuery(jpqlQuery);

            // Set parameters for SET clause
            for (Field field : fields) {
                if (field.isAnnotationPresent(Column.class) && !field.isAnnotationPresent(Id.class)) {
                    query.setParameter(field.getName(), field.get(entity));
                }
            }

            // Set parameter for WHERE clause (column value)
            query.setParameter("columnValue", columnValue);

            query.executeUpdate();
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Class<?> klass, Long id) {
        Object record = em.find(klass, id);
        if (record != null)
            em.remove(record);
    }


    public T update(T entity) {
        return em.merge(entity);
    }

    @Override
    public T getById(Class<T> type, Long id) {
        return em.find(type, id);
    }

    @Override
    public EntityManager getEm() {
        return em;
    }

    @Override
    public void setEm(EntityManager em) {

        this.em = em;
    }
}


