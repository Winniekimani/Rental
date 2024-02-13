package com.winnie.app.bean;

import com.winnie.app.model.entity.Tenant;
import com.winnie.app.model.entity.User;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class GlobalBean implements Serializable {


    private User user;

    private Tenant tenant;



    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    public GlobalBean() {

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
