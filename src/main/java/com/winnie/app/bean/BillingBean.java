package com.winnie.app.bean;

import com.winnie.app.model.entity.Billing;
import com.winnie.app.model.entity.House;
import com.winnie.utility.BillNoGenerator;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Stateless
public class BillingBean extends GenericBean<Billing> implements BillingBeanI,Serializable {
    /*public List<Billing> list() {
        // You can directly call the list method from GenericBean
        return super.list(Billing.class);
    }*/

    @Inject
    private BillNoGenerator billNoGenerator;

    @Override
    public void add(Billing billing) {
        if (billing.getPaymentDate() == null) {
            billing.setPaymentDate(new Date());
        }

        // Generate and set the bill number
        billing.setBillNo(billNoGenerator.generate());

        getDao().add(billing);

    }
}
