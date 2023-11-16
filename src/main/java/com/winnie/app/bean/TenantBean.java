package com.winnie.app.bean;

import com.winnie.app.View.html.HtmlComponent;
import com.winnie.app.model.entity.House;
import com.winnie.app.model.entity.Tenant;
import com.winnie.database.Database;

import java.io.Serializable;
import java.util.List;

public class TenantBean implements TenantBeanI, Serializable {
    @Override
    public String listOfTenants() {


        return HtmlComponent.table(Database.getDbInstance().getTenants());
    }

    @Override
    public Tenant addTenant(Tenant tenant) throws Exception {
        Database db = Database.getDbInstance();
        db.getTenants().add(tenant);
        return tenant;
    }

    @Override

    public void deleteTenant(String tenantId) {
        if (tenantId != null && !tenantId.isEmpty()) {
            Database db = Database.getDbInstance();
            db.getTenants().removeIf(tenant -> tenant.getTenantId().equals(tenantId));
        }

         /*  List<House> houses = database.getHouses();
            for (House house : houses) {
                if (house.getHouseId().equals(houseId)) {
                    houses.remove(house);
                    break;  // Optional - to break the loop after the first removal
                }
            }*/

    }
}
