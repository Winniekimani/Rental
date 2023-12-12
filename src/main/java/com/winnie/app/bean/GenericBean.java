package com.winnie.app.bean;


import com.winnie.dao.GenericDao;
import com.winnie.dao.GenericDaoI;


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


    @Override
    public T edit(T entity,Long id) {

        genericDao.setEm(em);
      return genericDao.edit(entity,id);
    }

    public GenericDaoI<T> getDao() {
       /* genericDao.setDatabase(database);*/
        genericDao.setEm(em);
        return (GenericDao<T>) genericDao;
    }



}
