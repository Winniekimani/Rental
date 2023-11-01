package com.winnie.app.bean;

import com.winnie.app.model.House;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class HouseBean implements HouseBeanI,Serializable {
    public String listOfHousesAvailable(){

        List<House> houses= new ArrayList<>();
        houses.add(new House("two-bedroom Apartment","kawangware", BigDecimal.valueOf(20000)));
        houses.add(new House("besitter Apartment","roysambu", BigDecimal.valueOf(12000)));
        houses.add(new House("villa","runda", BigDecimal.valueOf(8500000)));
        houses.add(new House("one bedroom apartment","kilimani", BigDecimal.valueOf(50000)));
        houses.add(new House("airbnb","garden-city", BigDecimal.valueOf(2500)));
        houses.add(new House("studio apartments","kahawa", BigDecimal.valueOf(30000)));
        houses.add(new House("mansion","runda", BigDecimal.valueOf(80000000)));
        houses.add(new House("bungalow","hurlingham", BigDecimal.valueOf(26500000)));
        houses.add(new House("penthouse","parklands", BigDecimal.valueOf(26500000)));
        houses.add(new House("airbnb","parklands", BigDecimal.valueOf(5000)));

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
