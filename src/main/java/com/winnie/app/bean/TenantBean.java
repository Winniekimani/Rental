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


        return HtmlComponent.table( Database.getDbInstance().getTenants());
    }

    @Override
    public Tenant addTenant(Tenant tenant) throws Exception {
        Database db= Database.getDbInstance();
        db.getTenants().add(tenant);
        return tenant;
    }

    @Override
    public void deleteTenant(Tenant tenant) {


        Database db= Database.getDbInstance();
        db.getTenants().remove(tenant);

    }
}
