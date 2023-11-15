package com.winnie.database;

import com.winnie.app.model.entity.House;
import com.winnie.app.model.entity.Payment;
import com.winnie.app.model.entity.Tenant;
import com.winnie.app.model.entity.User;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Database implements Serializable {

    private String databaseCreateAt;
    private List<User>users = new ArrayList<>();
    private List<House>houses= new ArrayList<>();
    private List<Payment>payments= new ArrayList<>();

    private List<Tenant>tenants= new ArrayList<>();
    private static  Database dbInstance;
    private Database(){}

    public static Database getDbInstance(){
        if (dbInstance==null)
             dbInstance=new Database();
             dbInstance.databaseCreateAt= DateFormat.getDateTimeInstance().format(new Date());
        System.out.println("database created at "+dbInstance.getDatabaseCreateAt());


        return dbInstance;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<House> getHouses() {
        return houses;
    }

    public void setHouses(List<House> houses) {
        this.houses = houses;
    }

    public List<Tenant> getTenants() {
        return tenants;
    }

    public void setTenants(List<Tenant> tenants) {
        this.tenants = tenants;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public String getDatabaseCreateAt() {
        return databaseCreateAt;
    }

}
