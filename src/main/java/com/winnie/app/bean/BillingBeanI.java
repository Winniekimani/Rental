package com.winnie.app.bean;

import com.winnie.app.model.entity.Billing;
import com.winnie.app.model.entity.House;

import javax.ejb.Remote;
import javax.ejb.Stateless;

@Remote
public interface BillingBeanI extends GenericBeanI<Billing>{
}
