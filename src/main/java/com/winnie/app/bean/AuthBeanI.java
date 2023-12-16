package com.winnie.app.bean;

import com.winnie.app.model.entity.Tenant;
import com.winnie.app.model.entity.User;

import java.sql.SQLException;

public interface AuthBeanI {
    User authenticate(User loginUser) throws SQLException;

    User auntheticate(User tenantUser) throws Exception;



}
