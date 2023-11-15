package com.winnie.app.model.entity;

import com.winnie.app.View.html.WinnieHtmlFormField;
import com.winnie.app.View.html.WinnieHtmlForms;
import com.winnie.app.View.html.WinnieTableColHeader;

import java.io.Serializable;
import java.util.Date;
@WinnieHtmlForms(label = "Payments" )
public class Payment implements Serializable {

    @WinnieTableColHeader(header = "PaymentId")
    @WinnieHtmlFormField(label = "Id Payment")
    private String paymentId;
    @WinnieTableColHeader(header = "PaymentAmount")
    @WinnieHtmlFormField(label = "Amount to Pay")
    private double amount;
    @WinnieTableColHeader(header = "PaymentDate")
    @WinnieHtmlFormField(label = "Payment Date")
    private Date paymentDate;

    @WinnieTableColHeader(header = "PaymentMethod")
    @WinnieHtmlFormField(label = "Payment Method")
    private String paymentMethod;

    @WinnieTableColHeader(header = "PaymentStatus")
    @WinnieHtmlFormField(label = "Payment Status")
    private PaymentStatus paymentStatus;

    public Payment() {
    }

    public Payment(String paymentId, double amount, Date paymentDate, String paymentMethod, PaymentStatus paymentStatus) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
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

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

}
