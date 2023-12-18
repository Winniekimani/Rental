package com.winnie.app.bean;

import com.winnie.app.model.entity.House;
import com.winnie.app.model.entity.Tenant;

import javax.ejb.Remote;
import java.util.List;


public interface TenantBeanI extends GenericBeanI<Tenant> {

    Tenant tenantUserUpdateDetails(Tenant updateTenant);

    Tenant tenantByEmail(String email);
    List<Tenant> getList();

    List<Tenant> tenantListByEmail(String email);

    Tenant find(Class<Tenant> tenantClass, Long tenantId);
}
