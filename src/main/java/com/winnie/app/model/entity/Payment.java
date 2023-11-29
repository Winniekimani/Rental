package com.winnie.app.model.entity;

import com.winnie.app.View.html.HtmlTable;
import com.winnie.app.View.html.WinnieHtmlFormField;
import com.winnie.app.View.html.WinnieHtmlForms;
import com.winnie.app.View.html.WinnieTableColHeader;
import com.winnie.database.helper.DbTable;
import com.winnie.database.helper.DbTableColumn;
import java.math.BigDecimal;
import java.util.Date;
@DbTable(name="payment")
@HtmlTable(name = "Payment",addUrl = "./payment?action=add",deleteUrl = "./payment?action=delete")
@WinnieHtmlForms(label = "Payments" )
public class Payment extends BaseEntity {

  /*  @WinnieTableColHeader(header = "PaymentId")
    @WinnieHtmlFormField(label = "Id Payment")
    @DbTableColumn(name="id")
    private String paymentId;*/
    @WinnieTableColHeader(header = "PaymentAmount")
    @WinnieHtmlFormField(label = "Amount to Pay")
    @DbTableColumn(name="amount",type="decimal(10,2)")
    private BigDecimal amount;
    @WinnieTableColHeader(header = "PaymentDate")
    @WinnieHtmlFormField(label = "Payment Date")
    @DbTableColumn(name="date",type = "Date")
    private Date paymentDate;

    @WinnieTableColHeader(header = "PaymentMethod")
    @WinnieHtmlFormField(label = "Payment Method")
    @DbTableColumn(name="payment_method")
    private String paymentMethod;

    @WinnieTableColHeader(header = "PaymentStatus")
    @WinnieHtmlFormField(label = "Payment Status")
    @DbTableColumn(name="type")
    private PaymentStatus paymentStatus;

    public Payment() {
    }

    public Payment(BigDecimal amount, Date paymentDate, String paymentMethod, PaymentStatus paymentStatus) {
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
    }

   /*
    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }*/

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

}
