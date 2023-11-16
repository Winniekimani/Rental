package com.winnie.app.bean;

import com.winnie.app.View.html.HtmlComponent;
import com.winnie.app.model.entity.House;
import com.winnie.database.Database;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class HouseBean implements HouseBeanI,Serializable {
    public String listOfHousesAvailable(){

        return HtmlComponent.table( Database.getDbInstance().getHouses());
    }

    @Override
    public House addHouse(House house) throws Exception {
        Database db= Database.getDbInstance();
        db.getHouses().add(house);
        return house;
    }



    public void deleteHouse(String houseId) {
        Database db = Database.getDbInstance();
        // Remove the house from the database
        db.getHouses().removeIf(house -> house.getHouseId().equals(houseId));

         /*  List<House> houses = database.getHouses();
            for (House house : houses) {
                if (house.getHouseId().equals(houseId)) {
                    houses.remove(house);
                    break;  // Optional - to break the loop after the first removal
                }
            }*/

    }


    @Override
    public void updateHouse(House updatedHouse) {
        List<House> houses = Database.getDbInstance().getHouses();
        for (int i = 0; i < houses.size(); i++) {
            House house = houses.get(i);
            if (house.getHouseId().equals(updatedHouse.getHouseId())) {
                houses.set(i, updatedHouse);
                return;
            }
        }
    }




}