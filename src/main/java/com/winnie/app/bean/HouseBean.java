package com.winnie.app.bean;


import com.winnie.app.model.entity.House;


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


    public List<House> list() {
        return super.list(new House());
    }


    @Inject
    public void tryMethodInjection(){
        System.out.println("method injection trial............");
    }



}

