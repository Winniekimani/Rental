package com.winnie.app.bean;


import com.winnie.app.model.entity.House;
import com.winnie.app.model.entity.HouseType;
import com.winnie.database.MysqlDatabase;
import com.winnie.utility.ReferenceNumberGenerator;
import com.winnie.utility.RentCalculator;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
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

    @Inject
    private RentCalculator rentCalculator;

    @Inject
    private ReferenceNumberGenerator referenceNumberGenerator;


    public List<House> list() {
        // You can directly call the list method from GenericBean

        List<House> houseList = super.list(House.class);
        // Calculate rent for each house using Injected RentCalculator
        for (House house : houseList) {
            BigDecimal calculatedRent = rentCalculator.calculateRent(house);
            house.setCalculatedRent(calculatedRent);
        }
      /*  return super.list(House.class);*/
        return houseList;
    }



   /* public List<House> list(Class<?> entity) {
        List<House> houseList = new ArrayList<>();
        String sql = "SELECT name, type, location, price FROM house";

        try {
            Connection conn = MysqlDatabase.getInstance().getConnection();


            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    House house = new House();
                    //house.setHouseId(resultSet.getString("id"));
                    house.setHouseName(resultSet.getString("name"));
                    house.setHouseType(HouseType.valueOf(resultSet.getString("type")));
                    house.setHouseLocation(resultSet.getString("location"));
                    house.setHousePrice(resultSet.getBigDecimal("price"));

                    houseList.add(house);

                }
                return houseList;



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }*/
}

