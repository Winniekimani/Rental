package com.winnie.app.bean;

import com.winnie.app.model.entity.House;
import com.winnie.app.model.entity.Payment;
import com.winnie.app.model.entity.Tenant;
import com.winnie.app.model.entity.User;
import com.winnie.dao.GenericDao;
import com.winnie.dao.GenericDaoI;
import com.winnie.database.Database;
import com.winnie.database.MysqlDatabase;

import javax.ejb.EJB;
import javax.inject.Inject;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class GenericBean<T> implements GenericBeanI<T> {



    @EJB
    MysqlDatabase database;

    @Inject private GenericDaoI<T>genericDao;
 /*   private final GenericDaoI<T>genericDao=new GenericDao<>();*/



    @SuppressWarnings({"unchecked","rawtypes"})
    @Override
    public List<T> list(Class<?> entity) {


       /* return (List<T>) MysqlDatabase.select(entity);*/
        genericDao.setDatabase(database);
        return  genericDao.list(entity);


    }

    @Override
    public void  add(T entity) {

       /* MysqlDatabase.insert(entity);
        return entity;*/
        genericDao.setDatabase(database);
        genericDao.add(entity);


    }

    @Override
    public void deleteById(Class<?> entityClass, long id) {
        genericDao.setDatabase(database);
        genericDao.deleteById(entityClass, id);
    }

   /* @Override
    public boolean deleteById(Class<?> entityClass, long id) {
        genericDao.setDatabase(database);
        return genericDao.deleteById(entityClass, id);
    }*/

   /* @Override
    public void delete(T entity) {

        genericDao.setDatabase(database);
        genericDao.delete(entity);
    }*/

    /*@Override
    public void delete(T entity, long entityID) {
        genericDao.setDatabase(database);
        genericDao.delete(entity,entityID);
    }*/




    @Override
    public void update(T entity) {

    }

    public GenericDaoI<T> getDao() {
        genericDao.setDatabase(database);
        return(GenericDaoI<T>) genericDao;
    }



}
