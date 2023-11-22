package com.winnie.app.bean;

import com.winnie.app.model.entity.House;
import com.winnie.app.model.entity.Payment;
import com.winnie.app.model.entity.Tenant;
import com.winnie.app.model.entity.User;
import com.winnie.dao.GenericDao;
import com.winnie.dao.GenericDaoI;
import com.winnie.database.Database;
import com.winnie.database.MysqlDatabase;

import java.lang.reflect.ParameterizedType;
import java.util.List;

public class GenericBean<T> implements GenericBeanI<T> {


    GenericDaoI<T>genericDao=new GenericDao<>();

    @SuppressWarnings({"unchecked","rawtypes"})
    @Override
    public List<T> list(Class<?> entity) {
        //return (List<T>) MysqlDatabase.select(entity);
        return genericDao.list(entity);

    }

    @Override
    public T add(T entity) {

        genericDao.add(entity);
        return entity;
        /*MysqlDatabase.insert(entity);
        return entity;*/
    }


    @Override
    public void delete(String entity) {

    }



    @Override
    public void update(T entity) {

    }

    public GenericDao<T> getDao(){
        return (GenericDao<T>) genericDao;
    }




}
