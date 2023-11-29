package com.winnie.app.bean;

import com.winnie.app.View.html.HtmlComponent;
import com.winnie.app.model.entity.House;
import com.winnie.app.model.entity.Tenant;
import com.winnie.database.Database;
import com.winnie.database.MysqlDatabase;
import com.winnie.utility.RentCalculator;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Stateless
public class TenantBean extends GenericBean<Tenant> implements TenantBeanI, Serializable {

/*
    @Inject
    private RentCalculator rentCalculator;

    @Inject
    private MysqlDatabase mysqlDatabase; // Inject the MysqlDatabase

    @Override
    public Tenant add(Tenant tenant) {
        calculateAndSetRent(tenant);
        super.add(tenant);
        return tenant;
    }

    private void calculateAndSetRent(Tenant tenant) {
        if (tenant.getHouseId() != null) {
            House house = mysqlDatabase.getHouseById(tenant.getHouseId());

            if (house != null) {
                BigDecimal calculatedRent = rentCalculator.calculateRent(house);
                tenant.setRentAmount(calculatedRent);
            } else {
                System.out.println("Error: House not found for the given houseId.");
            }
        } else {
            System.out.println("Warning: Tenant does not have a house. Rent calculation skipped.");
        }
    }*/


}
