package com.winnie.app.model.entity;

import com.winnie.app.View.html.HtmlTable;
import com.winnie.app.View.html.WinnieHtmlFormField;
import com.winnie.app.View.html.WinnieHtmlForms;
import com.winnie.app.View.html.WinnieTableColHeader;
import com.winnie.database.helper.DbTable;
import com.winnie.database.helper.DbTableColumn;

import java.math.BigDecimal;
import java.util.Date;
@DbTable(name="bills")
@WinnieHtmlForms(label = "Bills")
@HtmlTable(name = "Bill",addUrl = "./billing?action=add",deleteUrl = "./billing?action=delete")
public class Billing extends BaseEntity {


 /*   private Tenant tenant;*/

    @WinnieTableColHeader(header="TenantId")
    @WinnieHtmlFormField(label="Tenant id")
    @DbTableColumn(name="tenantId",type = "BigInt")
    private Long tenantId;

    @WinnieTableColHeader(header="BillNo")
    @WinnieHtmlFormField(label="Bill No")
    @DbTableColumn(name="bill")
    private String billNo;

    @WinnieTableColHeader(header="HouseCharge")
    @WinnieHtmlFormField(label="House Charges")
    @DbTableColumn(name="house_charges",type = "decimal (10,2)")
    private BigDecimal houseCharge;

    @WinnieTableColHeader(header="OtherCharges")
    @WinnieHtmlFormField(label="Other Charges")
    @DbTableColumn(name="other_charges",type = "decimal (10,2)")
    private BigDecimal otherCharges;



    @WinnieTableColHeader(header="PaymentDate")
    @WinnieHtmlFormField(label="Payment Date")
    @DbTableColumn(name="payment_date",type = "Date")
    private Date paymentDate;

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public BigDecimal getHouseCharge() {
        return houseCharge;
    }

    public void setHouseCharge(BigDecimal houseCharge) {
        this.houseCharge = houseCharge;
    }

    public BigDecimal getOtherCharges() {
        return otherCharges;
    }

    public void setOtherCharges(BigDecimal otherCharges) {
        this.otherCharges = otherCharges;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    @Override
    public String toString() {
        return "Billing{" +
                "tenantId=" + tenantId +
                ", billNo='" + billNo + '\'' +
                ", HouseCharge=" + houseCharge +
                ", otherCharges=" + otherCharges +
                ", paymentDate=" + paymentDate +
                '}';
    }
}
