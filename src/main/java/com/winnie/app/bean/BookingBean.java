package com.winnie.app.bean;

import com.winnie.app.model.entity.Billing;
import com.winnie.app.model.entity.Booking;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

@Stateless
public class BookingBean extends GenericBean<Booking> implements BookingBeanI, Serializable {
    @PersistenceContext
    private EntityManager em;


    public Booking addBooking(Booking booking) {
        // Add your business logic for booking, e.g., validation, setting additional fields
        return getDao().add(booking);
    }

    public List<Booking> getBookingsByTenant(Long tenantId) {
        // Implement logic to retrieve bookings for a specific tenant
        return em.createQuery("SELECT b FROM Booking b WHERE b.tenant.id = :tenantId", Booking.class)
                .setParameter("tenantId", tenantId)
                .getResultList();
    }
}
