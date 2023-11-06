package com.winnie.app.model.entity;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Tenant implements Serializable {
    private String firstName;
    private String lastName;
    private String phone;
    private Date leaseStartDate;
    private Date leaseEndDate;
    private double rentAmount;
    private String houseId;
    private String paymentStatus;


    public Tenant() {
    }

    public Tenant(String firstName, String lastName, String phone, Date leaseStartDate, Date leaseEndDate, double rentAmount,  String houseId, String paymentStatus) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.leaseStartDate = leaseStartDate;
        this.leaseEndDate = leaseEndDate;
        this.rentAmount = rentAmount;
        this.houseId = houseId;
        this.paymentStatus = paymentStatus;
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

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String tableRow() {
        StringBuilder trBuilder = new StringBuilder();
        trBuilder.append("<tr>");

        trBuilder.append("<td>").append(getFirstName()).append("</td>");
        trBuilder.append("<td>").append(getLastName()).append("</td>");
        trBuilder.append("<td>").append(getPhone()).append("</td>");

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        trBuilder.append("<td>").append(getLeaseStartDate() != null ? dateFormat.format(getLeaseStartDate()) : "").append("</td>");
        trBuilder.append("<td>").append(getLeaseEndDate() != null ? dateFormat.format(getLeaseEndDate()) : "").append("</td>");

        trBuilder.append("<td>").append(getRentAmount() == 0 ? "" : new DecimalFormat("#,###.##").format(getRentAmount())).append("</td>");
        trBuilder.append("<td>").append(getHouseId()).append("</td>");
        trBuilder.append("<td>").append(getPaymentStatus()).append("</td>");
        trBuilder.append("</tr>");

        return trBuilder.toString();
    }

}
