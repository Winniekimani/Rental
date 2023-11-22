package com.winnie.app.bean;

import com.winnie.app.View.html.HtmlComponent;
import com.winnie.app.model.entity.House;
import com.winnie.app.model.entity.HouseType;
import com.winnie.database.Database;
import com.winnie.database.MysqlDatabase;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HouseBean extends GenericBean<House> implements HouseBeanI, Serializable {



    public List<House> list(Class<?> entity) {
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
    }
}

