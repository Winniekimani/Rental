package com.winnie.dao;

import com.winnie.app.bean.GenericBeanI;
import com.winnie.database.MysqlDatabase;

import java.util.List;

public class GenericDao <T> implements GenericDaoI<T> {


    @SuppressWarnings({"unchecked","rawtypes"})
    @Override
    public List<T> list(Class<?> entity) {
        return (List<T>) MysqlDatabase.select(entity);

    }

    @Override
    public T add(T entity) {

        MysqlDatabase.insert(entity);
        return entity;
    }

    @Override
    public void delete(String entity) {

    }

    @Override
    public void update(T entity) {

    }



}

