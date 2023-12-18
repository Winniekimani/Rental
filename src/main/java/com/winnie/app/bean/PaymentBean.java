package com.winnie.app.bean;
import com.winnie.app.model.entity.Payment;

import com.winnie.utility.TransactIonNoGenerator;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.Date;


@Stateless
public class PaymentBean extends GenericBean<Payment> implements PaymentBeanI, Serializable {

    @PersistenceContext
    EntityManager em;
    @Inject
   /* @PaymentNo*/
    @Named("payment")
    TransactIonNoGenerator txnNoGenerator;

    @Override
    public Payment add(Payment payment) {
        if (payment.getPaymentDate() == null) {
            payment.setPaymentDate(new Date());
        }

        // Generate and set the bill number
       payment.setPaymentNo(txnNoGenerator.generate());

        return getDao().add(payment);

    }



    @Override
    public Payment find(Class<Payment> paymentClass, Long paymentId) {
        return em.find(Payment.class,paymentId);
    }
}
