package com.winnie.app.bean;

import com.winnie.app.model.entity.Billing;
import com.winnie.app.model.entity.House;
import com.winnie.app.model.entity.Tenant;
import com.winnie.utility.BillNo;
import com.winnie.utility.BillNoGenerator;
import com.winnie.utility.TransactIonNoGenerator;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

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

      /*  System.out.println(">>>>>>>>>>>>>>>>>>>>native query implementation>>>>>>>>>>>>>>>>>");
        List<Object[]> tenants = getDao().nativeQuery("select t.tenant_id, t.fName from tenant t");

        for (Object[] tenant : tenants){
            System.out.println("Tenant ID " + tenant[0]);
            System.out.println("Tenant Name " + tenant[1]);

            billing.setTenantId(((BigInteger) tenant[0]).longValue());
        }
        System.out.println(">>>>>>>>>>>>>>>>>>>>>");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();*/

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
