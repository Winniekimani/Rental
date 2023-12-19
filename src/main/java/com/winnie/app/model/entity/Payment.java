package com.winnie.app.model.entity;

import com.winnie.app.View.html.HtmlTable;
import com.winnie.app.View.html.WinnieHtmlFormField;
import com.winnie.app.View.html.WinnieHtmlForms;
import com.winnie.app.View.html.WinnieTableColHeader;
import com.winnie.database.helper.DbTable;
import com.winnie.database.helper.DbTableColumn;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
@Entity
@Table(name="payment")
@HtmlTable(name = "Payment",addUrl = "./payment?action=add",deleteUrl = "./payment?deletePaymentId=",editUrl = "./payment?action=update&editPaymentId=")
@WinnieHtmlForms(label = "Payments" )
public class Payment extends BaseEntity {

    @WinnieTableColHeader(header = "PaymentAmount")
    @WinnieHtmlFormField(label = "Amount to Pay")
    @Column(name="amount")
    private BigDecimal amount;
    @WinnieTableColHeader(header = "PaymentDate")
    @WinnieHtmlFormField(label = "Payment Date")
    @Column(name="date")
    @Temporal(TemporalType.DATE)
    private Date paymentDate;


    @WinnieTableColHeader(header="PaymentNumber")
    @WinnieHtmlFormField(label="Payment No")
    @Column(name="payment_no")
    private String paymentNo;
    @WinnieTableColHeader(header = "PaymentMethod")
    @WinnieHtmlFormField(label = "Payment Method")
    @Column(name="payment_method")
    private String paymentMethod;

    @WinnieTableColHeader(header = "PaymentStatus")
    @WinnieHtmlFormField(label = "Payment Status")
    @Column(name="payment_status")
    @Enumerated(value = EnumType.STRING)
    private PaymentStatus paymentStatus;

    //should have tenant id

    public Payment() {
    }
    public Payment(BigDecimal amount, Date paymentDate, String paymentNo, String paymentMethod, PaymentStatus paymentStatus) {
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.paymentNo = paymentNo;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
    }



    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
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

    public String getPaymentNo() {
        return paymentNo;
    }

    public void setPaymentNo(String paymentNo) {
        this.paymentNo = paymentNo;
    }
}
