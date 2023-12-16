package com.winnie.app.bean;

import com.winnie.app.model.entity.Billing;
import com.winnie.app.model.entity.Booking;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface BookingBeanI extends GenericBeanI<Booking>{

    Booking addBooking(Booking booking);
    List<Booking> getBookingsByTenant(Long tenantId);
}
