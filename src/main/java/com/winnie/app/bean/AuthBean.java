package com.winnie.app.bean;

import com.winnie.app.model.entity.User;
import com.winnie.database.Database;
import com.winnie.database.MysqlDatabase;

import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class AuthBean  implements AuthBeanI,Serializable {

    Database database = Database.getDbInstance();

    public User authenticate(User loginUser) throws SQLException {

/*
        MysqlDatabase database=MysqlDatabase.getInstance();

        Connection conn= database.getConnection();*/
        PreparedStatement statement=MysqlDatabase.getInstance().getConnection()
                .prepareStatement("select id, username from users where username=? and password=? limit 1");

        statement.setString(1, loginUser.getUsername());
        statement.setString(2, loginUser.getPassword());

        ResultSet result=statement.executeQuery();

        User user= new User();
        while (result.next()){
            user.setId(result.getLong("id"));
            user.setUsername(result.getString("username"));
        }
        return user;

    /*    User userDetails = null;
        *//*for (User user : database.getUsers()) {

            if (loginUser.getUsername().equals(user.getUsername()) && loginUser.getPassword().equals(user.getPassword())) {

                userDetails=user;
                break;
               *//**//* HttpSession httpSession = req.getSession(true);
                httpSession.setAttribute("loggedIn", new Date().getTime() + "");
                httpSession.setAttribute("username", loginUser.getUsername());

                resp.sendRedirect("./houses");*//**//*
            }
        }*//*
        return userDetails;*/



    }
}
