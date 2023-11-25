package com.winnie.dao;

import com.winnie.app.bean.GenericBeanI;
import com.winnie.database.MysqlDatabase;

import javax.ejb.EJB;
import java.util.List;

public class GenericDao <T> implements GenericDaoI<T> {

private MysqlDatabase database;


    @SuppressWarnings({"unchecked","rawtypes"})
    @Override
    public List<T> list(Class<?> entity) {

        return (List<T>) database.select(entity);

    }

    @Override
    public T add(T entity) {

        database.insert(entity);
        return entity;
    }

    @Override
    public void delete(String entity) {

    }

    @Override
    public void update(T entity) {

    }

    public MysqlDatabase getDatabase() {
        return database;
    }

    public void setDatabase(MysqlDatabase database) {
        this.database = database;
    }
}

