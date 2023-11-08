package com.winnie.app.bean;

import com.winnie.app.model.entity.User;

public interface AuthBeanI {
    User authenticate(User loginUser);
}
