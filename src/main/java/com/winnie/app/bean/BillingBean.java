package com.winnie.app.bean;

import com.winnie.app.model.entity.Billing;
import com.winnie.app.model.entity.House;
import com.winnie.utility.BillNo;
import com.winnie.utility.BillNoGenerator;
import com.winnie.utility.TransactIonNoGenerator;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
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

        // Generate and set the bill number
        billing.setBillNo(txnNoGenerator.generate());

        return getDao().add(billing);

    }
}
