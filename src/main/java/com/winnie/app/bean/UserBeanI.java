package com.winnie.app.bean;

import com.winnie.app.model.entity.User;

import java.sql.SQLException;

public interface UserBeanI {
    boolean register(User var1) throws SQLException;

    boolean unregister(User var1);
}
