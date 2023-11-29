package com.winnie.app.bean;


import com.winnie.app.model.entity.House;
import com.winnie.app.model.entity.HouseType;
import com.winnie.database.MysqlDatabase;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class HouseBean extends GenericBean<House> implements HouseBeanI, Serializable {


  /*  HouseBean houseBean = new HouseBean();
    List<House> houseList = houseBean.list();*/

    public List<House> list() {
        // You can directly call the list method from GenericBean
        return super.list(House.class);
    }


    @Inject
    public void tryMethodInjection(){
        System.out.println("method injection trial............");
    }



}

