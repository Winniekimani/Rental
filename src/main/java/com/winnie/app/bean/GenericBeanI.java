package com.winnie.app.bean;

import java.io.Serializable;
import java.util.List;

public interface GenericBeanI <T> extends Serializable {

    List<T> list(Class<?> entity);

   void add(T entity);

    void deleteById(Class<?> entityClass, long id);

   /* void delete(T entity, long id);*/

/*
    boolean deleteById(Class<?> entityClass, long id);*/



    void update(T entity);



}
