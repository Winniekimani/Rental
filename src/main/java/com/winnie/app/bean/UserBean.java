package com.winnie.app.bean;

import com.winnie.app.model.entity.User;
import com.winnie.database.Database;

import java.io.Serializable;

public class UserBean implements Serializable,UserBeanI {

    Database database = Database.getDbInstance();
    @Override
    public boolean register(User user) {

        if (user.getPassword().equals(user.getConfirmPassword())){
            database.getUsers().add(new User(100L, user.getUsername(), user.getConfirmPassword()));
            return true;
        }

        return false;
    }

    @Override
    public boolean unregister(User user) {

        return true;
    }
}
