package com.winnie.app.model.entity;

import com.winnie.app.View.html.HtmlTable;
import com.winnie.app.View.html.WinnieHtmlFormField;
import com.winnie.app.View.html.WinnieHtmlForms;
import com.winnie.app.View.html.WinnieTableColHeader;
import com.winnie.database.helper.DbTable;
import com.winnie.database.helper.DbTableColumn;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DecimalFormat;
@DbTable
(name="house")
@WinnieHtmlForms(label = "House")
@HtmlTable(name = "House",addUrl = "./house?action=add")
public class House extends BaseEntity{

  /*  @WinnieTableColHeader(header="HouseId")
    @WinnieHtmlFormField(label="House Id")
    @DbTableColumn(name="id")
    private String houseId;*/
    @WinnieTableColHeader(header="HouseName")
    @WinnieHtmlFormField(label="House Name")
    @DbTableColumn(name="name")
    private String houseName;
    @WinnieTableColHeader(header="HouseType")
    @WinnieHtmlFormField(label="House Type")
    @DbTableColumn(name="type")
    private HouseType houseType;


    @WinnieTableColHeader(header="HouseLocation")
    @WinnieHtmlFormField(label="House Location")
    @DbTableColumn(name="location")
    private String houseLocation;

    @WinnieTableColHeader(header="HousePrice")
    @WinnieHtmlFormField(label="House Price")
    @DbTableColumn(name="price",type="decimal(10,2)")
    private BigDecimal housePrice;



    public House() {
    }

    public House(String houseId, String houseName, HouseType houseType, String houseLocation, BigDecimal housePrice) {
        //this.houseId = houseId;
        this.houseName = houseName;
        this.houseType = houseType;
        this.houseLocation = houseLocation;
        this.housePrice = housePrice;
    }
/*
    public String getHouseId() {
        return houseId;
    }

    public void setHouseId(String houseId) {
        this.houseId = houseId;
    }*/

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