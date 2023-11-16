package com.winnie.app.bean;

import com.winnie.app.model.entity.House;

public interface HouseBeanI {
    String listOfHousesAvailable();
    House addHouse(House house) throws Exception;
    void deleteHouse(String houseId);

    void updateHouse(House updatedHouse);
}