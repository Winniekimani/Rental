package com.winnie.app.bean;


import com.winnie.dao.GenericDao;
import com.winnie.dao.GenericDaoI;


import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class GenericBean<T> implements GenericBeanI<T> {

    @PersistenceContext
    private EntityManager em;


    @Inject private GenericDaoI<T>genericDao;



    @SuppressWarnings({"unchecked","rawtypes"})
    @Override
    public List<T> list(T entity) {

        genericDao.setEm(em);
        return  genericDao.list(entity);


    }

    @Override
    public T add(T entity) {


        genericDao.setEm(em);
         return genericDao.add(entity);


    }

    @Override
    public void delete(Class<?> klass, Long id) {

        genericDao.setEm(em);
        genericDao.delete(klass,id);
    }


    @PostConstruct
    public void initialize() {
        if (genericDao == null) {
            throw new IllegalStateException("genericDao has not been injected.");
        }
    }

    public GenericDaoI<T> getDao() {
        genericDao.setEm(em);
        return (GenericDao<T>) genericDao;
    }



}
