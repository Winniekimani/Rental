package com.winnie.app.model.entity;

import com.winnie.app.View.html.WinnieHtmlFormField;
import com.winnie.app.View.html.WinnieHtmlForms;
import com.winnie.app.View.html.WinnieTableColHeader;

import java.io.Serializable;
import java.util.Date;

@WinnieHtmlForms(label = "Tenants")
public class Tenant implements Serializable {

    @WinnieTableColHeader(header="FirstName")
    @WinnieHtmlFormField(label="First Name")
    private String firstName;
    @WinnieTableColHeader(header="LastNAme")
    @WinnieHtmlFormField(label="Last Name")
    private String lastName;
    @WinnieTableColHeader(header="Tenant's Phone No")
    @WinnieHtmlFormField(label="Phone No")
    private String phone;

    @WinnieTableColHeader(header="LeaseStartDate")
    @WinnieHtmlFormField(label="Lease StartDate")
    private String leaseStartDate;
    @WinnieTableColHeader(header="LeaseEndDate")
    @WinnieHtmlFormField(label="Lease EndDate")
    private String leaseEndDate;
    @WinnieTableColHeader(header="RentAmount")
    @WinnieHtmlFormField(label="Rent Amount")
    private double rentAmount;
    @WinnieTableColHeader(header="TenantHouseId")
    @WinnieHtmlFormField(label="Tenant HouseId")
    private String houseId;


    public Tenant() {
    }


    public Tenant(String firstName, String lastName, String phone, String leaseStartDate, String leaseEndDate, double rentAmount, String houseId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.leaseStartDate = leaseStartDate;
        this.leaseEndDate = leaseEndDate;
        this.rentAmount = rentAmount;
        this.houseId = houseId;
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

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLeaseStartDate() {
        return leaseStartDate;
    }

    public void setLeaseStartDate(String leaseStartDate) {
        this.leaseStartDate = leaseStartDate;
    }

    public String getLeaseEndDate() {
        return leaseEndDate;
    }

    public void setLeaseEndDate(String leaseEndDate) {
        this.leaseEndDate = leaseEndDate;
    }

    public double getRentAmount() {
        return rentAmount;
    }

    public void setRentAmount(double rentAmount) {
        this.rentAmount = rentAmount;
    }

    public String getHouseId() {
        return houseId;
    }

    public void setHouseId(String houseId) {
        this.houseId = houseId;
    }


    public String deleteTenant() {
        // Add a button to remove the house
        return "<form action=\"./delete-tenant\" method=\"post\">" +
                "<input type=\"hidden\" name=\"houseId\" value=\"" + getHouseId() + "\" />" +
                "<input type=\"submit\" value=\"Remove\" />" +
                "</form>";
    }


    /*public String updateTenant() {
        // Add a button to edit the house
        return "<form action=\"./edit-house\" method=\"get\">" +
                "<input type=\"hidden\" name=\"houseId\" value=\"" + getHouseId() + "\" />" +
                "<input type=\"submit\" value=\"Edit\" />" +
                "</form>";
    }*/

}
