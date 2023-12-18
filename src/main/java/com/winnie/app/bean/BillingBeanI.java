package com.winnie.app.bean;

import com.winnie.app.model.entity.Billing;
import com.winnie.app.model.entity.Tenant;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface BillingBeanI extends GenericBeanI<Billing>{


    List<Billing> getBillingListByEmail(String email);

    List<Billing> getBillingByTenantId(Long tenantId);

    Billing find(Class<Billing> billingClass, Long billingId);
}
