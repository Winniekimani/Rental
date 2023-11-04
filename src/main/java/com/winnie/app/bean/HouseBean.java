package com.winnie.app.bean;

import com.winnie.app.model.entity.House;
import com.winnie.database.Database;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class HouseBean implements HouseBeanI,Serializable {
    public String listOfHousesAvailable(){

        List<House> houses= Database.getDbInstance().getHouses();

        StringBuilder trBuilder = new StringBuilder();
        trBuilder.append("<table><tr><th>HouseType</th><th>Location</th><th>HousePrice</th>");
        for (House house: houses)
            trBuilder.append(house.tableRow());

        trBuilder.append("</table>");

        return trBuilder.toString();
    }


    public House addOrUpdateHouse(House house) throws Exception{

       return null;
    }

    public void deleteHouse(House house){

    }

}
