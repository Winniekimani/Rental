package com.winnie.app.bean;

import com.winnie.app.model.entity.House;
import com.winnie.app.model.entity.Tenant;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface TenantBeanI extends GenericBeanI<Tenant> {

    Tenant tenantByEmail(String email);
    List<Tenant> getList();

    List<Tenant> tenantListByEmail(String email);
}
