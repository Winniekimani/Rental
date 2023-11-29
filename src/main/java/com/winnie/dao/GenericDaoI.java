package com.winnie.dao;

import com.winnie.database.MysqlDatabase;

import java.io.Serializable;
import java.util.List;

public interface GenericDaoI <T> extends Serializable {

    List<T> list(Class<?> entity);

   void add(T entity);

   /* void delete(T entity);*/
    void delete(Class<?> clazz,Long id);

    void update(T entity);



   MysqlDatabase getDatabase();

     void setDatabase(MysqlDatabase database) ;

}