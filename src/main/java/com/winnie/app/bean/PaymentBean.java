package com.winnie.app.bean;

import com.winnie.app.model.entity.House;
import com.winnie.app.model.entity.Payment;

import javax.ejb.Stateless;
import java.io.Serializable;
import java.util.List;

@Stateless
public class PaymentBean extends GenericBean<Payment> implements PaymentBeanI, Serializable {

}
