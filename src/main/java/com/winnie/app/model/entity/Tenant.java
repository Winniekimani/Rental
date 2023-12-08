package com.winnie.app.model.entity;

import com.winnie.app.View.html.HtmlTable;
import com.winnie.app.View.html.WinnieHtmlFormField;
import com.winnie.app.View.html.WinnieHtmlForms;
import com.winnie.app.View.html.WinnieTableColHeader;
import org.hibernate.annotations.Formula;


import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="tenant")
@HtmlTable(name = "Tenant",addUrl = "./tenant?action=add",deleteUrl = "./tenant?action=delete")
@WinnieHtmlForms(label = "Tenants")
public class Tenant extends BaseEntity{

    @WinnieTableColHeader(header="FirstName")
    @WinnieHtmlFormField(label="First Name")
    @Column(name="fName")
    private String firstName;
    @WinnieTableColHeader(header="LastNAme")
    @WinnieHtmlFormField(label="Last Name")
    @Column(name="lName")
    private String lastName;
    @WinnieTableColHeader(header="Tenant's Phone No")
    @WinnieHtmlFormField(label="Phone No")
    @Column(name="phone")
    private String phone;

    @WinnieTableColHeader(header="TenantEmail")
    @WinnieHtmlFormField(label="Tenant Email")
    @Column
    private String email;

    @WinnieTableColHeader(header="LeaseStartDate")
    @WinnieHtmlFormField(label="Lease StartDate")
    @Column(name="startDate")
    @Temporal(TemporalType.DATE)
    private   Date  leaseStartDate;
    @WinnieTableColHeader(header="LeaseEndDate")
    @WinnieHtmlFormField(label="Lease EndDate")
    @Column(name="endDate")
    @Temporal(TemporalType.DATE)
    private Date leaseEndDate;
    @WinnieTableColHeader(header="RentAmount")
    @WinnieHtmlFormField(label="Rent Amount")
    @Column(name="Amount")
    private BigDecimal rentAmount;
  /*  @WinnieTableColHeader(header="TenantHouseId")
    @WinnieHtmlFormField(label="Tenant HouseId")
    @Column(name="house_id")
    private String houseId;*/


    public Tenant() {
    }
/*
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "house_id")
    private House house;

    @WinnieHtmlFormField (label = "House ID")
    @Formula("(house_id)")
    private Long houseId;


    public Long getHouseId() {
        return houseId;
    }

    public void setHouseId(Long houseId) {
        this.houseId = houseId;
    }


    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }*/

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getLeaseStartDate() {
        return leaseStartDate;
    }

    public void setLeaseStartDate(Date leaseStartDate) {
        this.leaseStartDate = leaseStartDate;
    }

    public Date getLeaseEndDate() {
        return leaseEndDate;
    }

    public void setLeaseEndDate(Date leaseEndDate) {
        this.leaseEndDate = leaseEndDate;
    }

    public BigDecimal getRentAmount() {
        return rentAmount;
    }

    public void setRentAmount(BigDecimal rentAmount) {
        this.rentAmount = rentAmount;
    }


    /*
    public String getHouseId() {
        return houseId;
    }

    public void setHouseId(String houseId) {
        this.houseId = houseId;
    }*/

}
