package com.winnie.app.bean;

import com.winnie.app.model.entity.Billing;
import com.winnie.app.model.entity.Tenant;
import com.winnie.utility.TransactIonNoGenerator;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;


@Stateless
public class BillingBean extends GenericBean<Billing> implements BillingBeanI,Serializable {

    @Inject
  /*  @BillNo*/
    @Named("bill")
    private TransactIonNoGenerator txnNoGenerator;

    @Override
    public Billing add(Billing billing) {
        if (billing.getPaymentDate() == null) {
            billing.setPaymentDate(new Date());
        }


        if (billing.getTenantId()==null){
            throw new RuntimeException("tenant is required");
        }

        // Generate and set the bill number
        billing.setBillNo(txnNoGenerator.generate());

        billing.setTenant(getDao().getEm().find(Tenant.class,billing.getTenantId()));

        billing= getDao().add(billing);
        return getDao().add(billing);



    }
}
