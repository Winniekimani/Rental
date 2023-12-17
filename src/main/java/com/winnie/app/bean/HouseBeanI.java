package com.winnie.app.bean;

import com.winnie.app.model.entity.House;

import javax.ejb.Remote;
import java.util.List;


public interface HouseBeanI extends GenericBeanI<House>{

    List<House> listAvailableHouses();
    House getById(Long id);


    // Update method to update the house status
    void update(House house);
}

