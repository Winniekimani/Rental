package com.winnie.app.bean;

import com.winnie.app.model.House;

public interface HouseBeanI {
    String listOfHousesAvailable();
    House addOrUpdateHouse(House house) throws Exception;
   void deleteHouse(House house);
}
