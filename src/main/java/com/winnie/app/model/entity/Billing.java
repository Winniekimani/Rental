package com.winnie.app.model.entity;
import com.winnie.app.View.html.HtmlTable;
import com.winnie.app.View.html.WinnieHtmlFormField;
import com.winnie.app.View.html.WinnieHtmlForms;
import com.winnie.app.View.html.WinnieTableColHeader;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
@Entity
@Table(name = "bills")
@WinnieHtmlForms(label = "Bills")
@HtmlTable(name = "Bill",addUrl = "./billing?action=add",deleteUrl = "./billing?deleteBillingId=",editUrl = "./billing?action=update&editBillingId=")
public class Billing extends BaseEntity {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tenant_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Tenant tenant;


    @WinnieHtmlFormField(label = "Tenant",selectList = "tenants", selectValue = "id", selectValueInSuper=true, selectDisplay = "firstName")
    @Formula("(tenant_id)")
    private Long tenantId;

    @WinnieTableColHeader(header="Name")
    @Formula("(select t.fName from tenant t where t.id=tenant_id)")
    private String firstName;



    @WinnieTableColHeader(header="BillNo")
   /* @WinnieHtmlFormField(label="Bill No")*/
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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
