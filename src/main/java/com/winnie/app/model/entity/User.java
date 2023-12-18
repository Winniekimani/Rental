package com.winnie.app.model.entity;

import com.winnie.database.helper.DbTable;
import com.winnie.database.helper.DbTableColumn;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table( name="users")
public class User extends BaseEntity {

    @Column(name="email")
    private String email;

   @Column(name="username")
   private String username;

    @Column(name="password")
    private String password;

    @Transient
    private String confirmPassword;

    @Transient
    private String oldPassword;

  /*  @Transient*/
    @Column(name="userRole")
    private String userRole;

    @ManyToOne(fetch = FetchType.EAGER)
    private Tenant tenant;

    public User(){}

    public User(String username) {
        this.username = username;
    }

    public User(Long id, String username, String password) {
       // this.id = id;
        setId(id);
        this.username = username;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }
}
