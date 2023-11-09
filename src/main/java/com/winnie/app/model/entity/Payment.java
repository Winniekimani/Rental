package com.winnie.app.model.entity;

import com.winnie.app.View.html.WinnieHtmlFormField;
import com.winnie.app.View.html.WinnieHtmlForms;

import java.io.Serializable;
import java.util.Date;
@WinnieHtmlForms(label = "Payments" )
public class Payment implements Serializable {

   @WinnieHtmlFormField(label = "Id Payment")
    private String paymentId;
    @WinnieHtmlFormField(label = "Amount to Pay")
    private double amount;
    @WinnieHtmlFormField(label = "Payment Date")
    private Date paymentDate;

    @WinnieHtmlFormField(label = "Payment Method")
    private String paymentMethod;

    public Payment() {
    }

    public Payment(String paymentId, double amount, Date paymentDate, String paymentMethod) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
