package com.winnie.utility.cdievents;

import com.winnie.app.model.entity.House;

public class HouseCreatedEvent {
    private House house;

    String houseDetails;

    public String getHouseDetails() {
        return houseDetails;
    }

    public void setHouseDetails(String houseDetails) {
        this.houseDetails = houseDetails;
    }

    public HouseCreatedEvent(House house) {
        this.house = house;
    }

    public House getHouse() {
        return house;
    }
}
