package com.winnie.app.bean;

import com.winnie.app.model.entity.House;

public interface HouseBeanI {
    String listOfHousesAvailable();
    House addHouse(House house) throws Exception;
   void deleteHouse(House house);

    void updateHouse(House updatedHouse);
}
