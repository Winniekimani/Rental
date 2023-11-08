package com.winnie.app.bean;

import com.winnie.app.model.entity.User;

public interface UserBeanI {
    boolean register(User user);
    boolean unregister(User user);
}
