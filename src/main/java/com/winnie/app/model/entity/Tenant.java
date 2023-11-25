package com.winnie.app.model.entity;

import com.winnie.app.View.html.HtmlTable;
import com.winnie.app.View.html.WinnieHtmlFormField;
import com.winnie.app.View.html.WinnieHtmlForms;
import com.winnie.app.View.html.WinnieTableColHeader;
import com.winnie.database.helper.DbTable;
import com.winnie.database.helper.DbTableColumn;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@DbTable(name="tenant")
@HtmlTable(name = "Tenant",addUrl = "./tenant?action=add")
@WinnieHtmlForms(label = "Tenants")
public class Tenant extends BaseEntity{

  /*  @WinnieTableColHeader(header="TenantId")
    @WinnieHtmlFormField(label="Tenant Id")
    @DbTableColumn(name="tenant_id")
    private String tenantId;*/
    @WinnieTableColHeader(header="FirstName")
    @WinnieHtmlFormField(label="First Name")
    @DbTableColumn(name="fName")
    private String firstName;
    @WinnieTableColHeader(header="LastNAme")
    @WinnieHtmlFormField(label="Last Name")
    @DbTableColumn(name="lName")
    private String lastName;
    @WinnieTableColHeader(header="Tenant's Phone No")
    @WinnieHtmlFormField(label="Phone No")
    @DbTableColumn(name="phone")
    private String phone;

    @WinnieTableColHeader(header="LeaseStartDate")
    @WinnieHtmlFormField(label="Lease StartDate")
    @DbTableColumn(name="startDate")
    private String leaseStartDate;
    @WinnieTableColHeader(header="LeaseEndDate")
    @WinnieHtmlFormField(label="Lease EndDate")
    @DbTableColumn(name="endDate")
    private String leaseEndDate;
    @WinnieTableColHeader(header="RentAmount")
    @WinnieHtmlFormField(label="Rent Amount")
    @DbTableColumn(name="Amount",type="decimal(10,2)")
    private BigDecimal rentAmount;
    @WinnieTableColHeader(header="TenantHouseId")
    @WinnieHtmlFormField(label="Tenant HouseId")
    @DbTableColumn(name="house_id")
    private String houseId;


    public Tenant() {
    }

    public Tenant(String firstName, String lastName, String phone, String leaseStartDate, String leaseEndDate, BigDecimal rentAmount, String houseId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.leaseStartDate = leaseStartDate;
        this.leaseEndDate = leaseEndDate;
        this.rentAmount = rentAmount;
        this.houseId = houseId;
    }

    /*
    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }*/

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

    public BigDecimal getRentAmount() {
        return rentAmount;
    }

    public void setRentAmount(BigDecimal rentAmount) {
        this.rentAmount = rentAmount;
    }

    public String getHouseId() {
        return houseId;
    }

    public void setHouseId(String houseId) {
        this.houseId = houseId;
    }

}
