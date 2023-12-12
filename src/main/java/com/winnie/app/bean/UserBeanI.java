package com.winnie.app.bean;

import com.winnie.app.model.entity.User;

import java.sql.SQLException;

public interface UserBeanI{
    boolean register(User user) throws SQLException;
    boolean unregister(User user);
}
