package com.winnie.app.bean;

import com.winnie.app.model.entity.House;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface HouseBeanI extends GenericBeanI<House>{

    List<House> listAvailableHouses();
    House getById(Long id);
}

