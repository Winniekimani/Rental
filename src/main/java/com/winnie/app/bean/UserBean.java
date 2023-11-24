package com.winnie.app.bean;

import com.winnie.app.model.entity.User;
import com.winnie.database.Database;
import com.winnie.database.MysqlDatabase;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.concurrent.ThreadLocalRandom;

@Stateless
@Remote
public class UserBean implements Serializable,UserBeanI {

    public UserBean() {
    }

    public boolean register(User user) throws SQLException {
        if (user.getPassword().equals(user.getConfirmPassword())) {
            MysqlDatabase.insert(user);
            return true;
        } else {
            return false;
        }
    }

    public boolean unregister(User user) {
        return true;
    }
}
