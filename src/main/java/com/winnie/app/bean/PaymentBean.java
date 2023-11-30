package com.winnie.app.bean;

import com.winnie.app.model.entity.Billing;
import com.winnie.app.model.entity.House;
import com.winnie.app.model.entity.Payment;
import com.winnie.utility.BillNoGenerator;
import com.winnie.utility.PaymentNo;
import com.winnie.utility.PaymentNoGenerator;
import com.winnie.utility.TransactIonNoGenerator;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Stateless
public class PaymentBean extends GenericBean<Payment> implements PaymentBeanI, Serializable {



    @Inject
    @PaymentNo
    TransactIonNoGenerator txnNoGenerator;

    @Override
    public void add(Payment payment) {
        if (payment.getPaymentDate() == null) {
            payment.setPaymentDate(new Date());
        }

        // Generate and set the bill number
       payment.setPaymentNo(txnNoGenerator.generate());

        getDao().add(payment);

    }
}
