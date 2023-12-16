package com.winnie.app.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.winnie.app.View.html.HtmlTable;
import com.winnie.app.View.html.WinnieHtmlFormField;
import com.winnie.app.View.html.WinnieHtmlForms;
import com.winnie.app.View.html.WinnieTableColHeader;
import org.hibernate.annotations.Formula;


import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="tenant")
@HtmlTable(name = "Tenant",addUrl = "./tenant?action=add",deleteUrl = "./tenant?deleteTenantId=",editUrl = "./edit-tenant?editTenantId=")
@WinnieHtmlForms(label = "Tenants")
public class Tenant extends BaseEntity{


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "house_id")
    private House house;

    @OneToMany(mappedBy = "tenant", fetch = FetchType.EAGER)
    private List<Billing> billings;

    @WinnieHtmlFormField(label = "House ",selectList = "houses", selectValue = "id", selectValueInSuper=true, selectDisplay = "houseName")
    @Formula("(House_id)")
    private Long houseId;

    @WinnieTableColHeader(header = "House")
    @Formula("(select h.house_name from house h where h.id=house_id)")
    private String houseName;
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
    @Column(unique = true)
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


    @OneToMany(mappedBy = "tenant",fetch = FetchType.LAZY)
    private List<User> users ;


    @Transient
    private String password;

    @Transient
    private String confirmPassword;

    public Tenant() {
    }



    // Add this method to set billings
    public void setBillings(List<Billing> billings) {
        this.billings = billings;
    }

    @JsonIgnore
    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public Long getHouseId() {
        return houseId;
    }

    public void setHouseId(Long houseId) {
        this.houseId = houseId;
    }

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

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

    @Override
    public String toString() {
        return "Tenant{" +
                "house=" + house +
                ", billings=" + billings +
                ", houseId=" + houseId +
                ", houseName='" + houseName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", leaseStartDate=" + leaseStartDate +
                ", leaseEndDate=" + leaseEndDate +
                ", rentAmount=" + rentAmount +
                '}';
    }
}
