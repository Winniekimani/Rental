package com.winnie.app.model.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "booking")
public class Booking  extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "house_id", nullable = false)
    private House house;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "tenant_id", nullable = false)
    private Tenant tenant;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "booking_date", nullable = false)
    private Date bookingDate;

    public Booking() {
    }

    public Booking(House house, Tenant tenant) {
        this.house = house;
        this.tenant = tenant;
    }

    @PrePersist
    protected void onCreate() {
        bookingDate = new Date();
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

}
