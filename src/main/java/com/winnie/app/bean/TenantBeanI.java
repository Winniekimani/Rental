package com.winnie.app.bean;

import com.winnie.app.model.entity.House;
import com.winnie.app.model.entity.Tenant;

import javax.ejb.Remote;

@Remote
public interface TenantBeanI extends GenericBeanI<Tenant> {


}
