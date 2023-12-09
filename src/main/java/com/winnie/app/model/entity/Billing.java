package com.winnie.app.model.entity;

import com.winnie.app.View.html.HtmlTable;
import com.winnie.app.View.html.WinnieHtmlFormField;
import com.winnie.app.View.html.WinnieHtmlForms;
import com.winnie.app.View.html.WinnieTableColHeader;
import com.winnie.database.helper.DbTable;
import com.winnie.database.helper.DbTableColumn;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
@Entity
@Table(name = "bills")
@WinnieHtmlForms(label = "Bills")
@HtmlTable(name = "Bill",addUrl = "./billing?action=add",deleteUrl = "./billing?action=delete")
public class Billing extends BaseEntity {


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tenant_id")
    private Tenant tenant;

    @WinnieHtmlFormField(label = "Tenant ID")
    @Formula("(tenant_id)")
    private Long tenantId;
   /* @WinnieTableColHeader(header="TenantId")
    @WinnieHtmlFormField(label="Tenant id")
    @Column (name="tenantId", columnDefinition = "BigInt")
    private Long tenantId;*/

    @WinnieTableColHeader(header="BillNo")
    @WinnieHtmlFormField(label="Bill No")
    @Column(name="bill_no")
    private String billNo;

    @WinnieTableColHeader(header="HouseCharge")
    @WinnieHtmlFormField(label="House Charges")
    @Column(name="house_charges")
    private BigDecimal houseCharge;

    @WinnieTableColHeader(header="OtherCharges")
    @WinnieHtmlFormField(label="Other Charges")
    @Column(name="other_charges")
    private BigDecimal otherCharges;


    @WinnieTableColHeader(header="PaymentDate")
    @WinnieHtmlFormField(label="Payment Date")
    @Column(name="payment_date")
    @Temporal(TemporalType.DATE)
    private Date paymentDate;

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

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
