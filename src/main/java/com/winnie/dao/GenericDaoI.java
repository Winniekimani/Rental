package com.winnie.dao;



import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

public interface GenericDaoI <T> extends Serializable {

    List<T> list(T entity);


    List<Object[]> nativeQuery(String sql);

    T add(T entity);

    void delete(Class<?> klass, Long id);
    EntityManager getEm();

    void setEm(EntityManager em);

}