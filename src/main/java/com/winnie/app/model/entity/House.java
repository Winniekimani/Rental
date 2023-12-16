package com.winnie.app.model.entity;

import com.winnie.app.View.html.HtmlTable;
import com.winnie.app.View.html.WinnieHtmlFormField;
import com.winnie.app.View.html.WinnieHtmlForms;
import com.winnie.app.View.html.WinnieTableColHeader;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


@NamedQueries({
        @NamedQuery(name = House.HouseByType, query = "FROM House h  WHERE h.houseType = 'Mansion'"),
        @NamedQuery(name = House.HouseByLocation, query = "FROM House h WHERE h.houseLocation = 'roysambu'")
})

@Entity
@Table(name="house")
@WinnieHtmlForms(label = "House")
@HtmlTable(name = "House",addUrl = "./house?action=add",deleteUrl = "./house?deleteHouseId=",editUrl = "./edit-house?editHouseId=")

public class House extends BaseEntity{

    public static final String HouseByType = "House.FindByType";
    public static final String HouseByLocation = "House.FindByLocation";

    @OneToMany(mappedBy = "house", cascade = CascadeType.ALL)
    private List<Tenant> tenants;


    @OneToMany(mappedBy = "house", cascade = CascadeType.ALL)
    private List<Booking> bookings;

    @WinnieTableColHeader(header="HouseNo")
    @WinnieHtmlFormField(label="House No")
    @Column(name = "house_no")
    private String houseNo;

    @WinnieTableColHeader(header="HouseName")
    @WinnieHtmlFormField(label="House Name")
    @Column(name="house_name")
    private String houseName;
    @WinnieTableColHeader(header="HouseStatus")
    @WinnieHtmlFormField(label="House Status")
    @Column(name = "house_status")
    private String houseStatus;

    @WinnieTableColHeader(header="HouseDescription")
    @WinnieHtmlFormField(label="House Description")
    @Column(name = "house_description",columnDefinition = "text")
    private String houseDescription;

    @WinnieTableColHeader(header="HouseType")
    @WinnieHtmlFormField(label="House Type")
    @Column(name="house_type")
    @Enumerated(value = EnumType.STRING)
    private HouseType houseType;


    @WinnieTableColHeader(header="HouseLocation")
    @WinnieHtmlFormField(label="House Location")
    @Column(name="house_location")
    private String houseLocation;

    @WinnieTableColHeader(header="HousePrice")
    @WinnieHtmlFormField(label="House Price")
    @Column(name="house_price")
    private BigDecimal housePrice;


    public House() {
    }


    public House(String houseNo, String houseStatus, String houseDescription, String houseName, HouseType houseType, String houseLocation, BigDecimal housePrice) {
        this.houseNo = houseNo;
        this.houseStatus = houseStatus;
        this.houseDescription = houseDescription;
        this.houseName = houseName;
        this.houseType = houseType;
        this.houseLocation = houseLocation;
        this.housePrice = housePrice;

    }




    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getHouseStatus() {
        return houseStatus;
    }

    public void setHouseStatus(String houseStatus) {
        this.houseStatus = houseStatus;
    }

    public String getHouseDescription() {
        return houseDescription;
    }

    public void setHouseDescription(String houseDescription) {
        this.houseDescription = houseDescription;
    }

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public HouseType getHouseType() {
        return houseType;
    }

    public void setHouseType(HouseType houseType) {
        this.houseType = houseType;
    }

    public String getHouseLocation() {
        return houseLocation;
    }

    public void setHouseLocation(String houseLocation) {
        this.houseLocation = houseLocation;
    }

    public BigDecimal getHousePrice() {
        return housePrice;
    }

    public void setHousePrice(BigDecimal housePrice) {
        this.housePrice = housePrice;
    }



}