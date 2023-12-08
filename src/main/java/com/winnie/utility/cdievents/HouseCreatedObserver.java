package com.winnie.utility.cdievents;

import com.winnie.app.model.entity.House;

import javax.enterprise.event.Observes;

public class HouseCreatedObserver {

    public void notifyHouseCreated(@Observes HouseCreatedEvent event) {
       /* House house = event.getHouse();*/
        String notifyHouseCreated= event.getHouseDetails();

        // Code to handle the house created event
        // For example, log the event, update statistics, etc.
    }
}
