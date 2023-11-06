package com.winnie.app.bean;

import com.winnie.app.model.entity.House;
import com.winnie.app.model.entity.Tenant;
import com.winnie.database.Database;

import java.io.Serializable;
import java.util.List;

public class TenantBean implements TenantBeanI, Serializable {
    @Override
    public String listOfTenants() {

        List<Tenant>tenants=Database.getDbInstance().getTenants();
        StringBuilder trBuilder = new StringBuilder();
        trBuilder.append("<table><tr><th>FirstName</th><th>LastName</th><th>Phone</th><th>LeaseStartDate</th><th>LeaseEndDate</th><th>RentAmount</th><th>HouseId</th><th>PaymentStatus</th></tr>");
        for (Tenant tenant: tenants)
            trBuilder.append(tenant.tableRow());

        trBuilder.append("</table>");

        return trBuilder.toString();
    }

    @Override
    public House addTenant(Tenant tenant) throws Exception {
        return null;
    }

    @Override
    public void deleteTenant(Tenant tenant) {

    }
}
