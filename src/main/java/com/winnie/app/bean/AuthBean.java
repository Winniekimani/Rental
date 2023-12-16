package com.winnie.app.bean;

import com.winnie.app.model.entity.AuditLog;
import com.winnie.app.model.entity.User;
import com.winnie.utility.EncryptText;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import java.io.Serializable;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;


@Stateless
@Remote
public class AuthBean extends GenericBean<User> implements AuthBeanI, Serializable {


    @Inject
    private EncryptText encryptText;

    @Inject
    private Event<AuditLog> logger;

    public User authenticate(User loginUser) throws SQLException {

        try {
            loginUser.setPassword(encryptText.encrypt(loginUser.getPassword()));
        } catch (Exception ex){
            throw new RuntimeException(ex.getMessage());
        }

        List<User> users = list(loginUser);

        if (users.isEmpty() || users.get(0) == null)
            throw new RuntimeException("Invalid user!!");


        AuditLog log = new AuditLog();
        log.setLogDetails("User logged in at " + DateFormat.getDateTimeInstance().format(new Date())
                + ", " + users.get(0).getUsername());

        logger.fire(log);
        return users.get(0);




    }

    @Override
    public User auntheticate(User tenantUser) throws Exception {

        if (tenantUser.getUsername() == null || tenantUser.getPassword() == null)
            throw new Exception("Invalid password or username");


        tenantUser.setPassword(encryptText.encrypt(tenantUser.getPassword()));

        List<User> users = list(tenantUser);
        if (users == null || users.isEmpty() || users.get(0) == null)
            throw new Exception("Invalid username or password");

        return users.get(0);


    }


}

