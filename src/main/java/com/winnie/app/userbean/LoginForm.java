package com.winnie.app.userbean;

import java.io.Serializable;

public class LoginForm implements Serializable {
    private String usernamePlaceHolder="username";
    private String passwordPlaceHolder="password";

    public String getUsernamePlaceHolder() {
        return usernamePlaceHolder;
    }

    public void setUsernamePlaceHolder(String usernamePlaceHolder) {
        this.usernamePlaceHolder = usernamePlaceHolder;
    }

    public String getPasswordPlaceHolder() {
        return passwordPlaceHolder;
    }

    public void setPasswordPlaceHolder(String passwordPlaceHolder) {
        this.passwordPlaceHolder = passwordPlaceHolder;
    }
}
