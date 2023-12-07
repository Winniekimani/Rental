package com.winnie.app.model.entity;

import com.winnie.database.helper.DbTable;
import com.winnie.database.helper.DbTableColumn;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;


@Entity
@Table( name="users")
public class User extends BaseEntity {

   @Column(name="username")
   private String username;

    @Column(name="password")
    private String password;

    @Transient
    private String confirmPassword;

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
}
