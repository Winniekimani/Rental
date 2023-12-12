package com.winnie.app.bean;

import java.io.Serializable;
import java.util.List;

public interface GenericBeanI <T> extends Serializable {

    List<T> list(T entity);

   T add(T entity);

    void delete(Class<?> klass, Long id);


    void update(T entity);



}
