package com.winnie.app.bean;

import com.winnie.app.model.entity.User;
import com.winnie.utility.EncryptText;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Stateless
@Remote
public class AuthBean extends GenericBean<User> implements AuthBeanI, Serializable {

   /* @PersistenceContext
    EntityManager em;*/


    @Inject
    private EncryptText encryptText;

    public User authenticate(User loginUser) throws SQLException {

        try {
            loginUser.setPassword(encryptText.encrypt(loginUser.getPassword()));
        } catch (Exception ex){
            throw new RuntimeException(ex.getMessage());
        }

        List<User> users = list(loginUser);

        if (users.isEmpty() || users.get(0) == null)
            throw new RuntimeException("Invalid user!!");


        return users.get(0);




    }


}

