package com.winnie.app.bean;

import com.winnie.app.model.entity.House;
import com.winnie.app.model.entity.Tenant;

public interface TenantBeanI {

    String listOfTenants();
    House addTenant(Tenant tenant) throws Exception;
    void deleteTenant(Tenant tenant);
}