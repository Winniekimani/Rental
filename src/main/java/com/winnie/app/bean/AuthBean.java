package com.winnie.app.bean;

import com.winnie.app.model.entity.User;
import com.winnie.database.Database;
import com.winnie.database.MysqlDatabase;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


@Stateless
@Remote
public class AuthBean  implements AuthBeanI,Serializable {

    Database database = Database.getDbInstance();

    public User authenticate(User loginUser) throws SQLException {

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




    }
}
