package com.winnie.app.bean;

import com.winnie.app.model.entity.Payment;

import javax.ejb.Remote;

@Remote
public interface PaymentBeanI extends GenericBeanI<Payment> {
}
