package com.winnie.app.bean;

import java.io.Serializable;
import java.util.List;

public interface GenericBeanI <T> extends Serializable {

    List<T> list(T entity);

   void add(T entity);

    void update(T entity);



}
