package com.winnie.app.model.entity;

import com.winnie.app.View.html.WinnieHtmlFormField;
import com.winnie.app.View.html.WinnieHtmlForms;
import com.winnie.app.View.html.WinnieTableColHeader;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DecimalFormat;
@WinnieHtmlForms(label = "House")
public class House implements Serializable {

    @WinnieTableColHeader(header="HouseId")
    @WinnieHtmlFormField(label="House Id")
    private String houseId;
    @WinnieTableColHeader(header="HouseName")
    @WinnieHtmlFormField(label="House Name")
    private String houseName;
    @WinnieTableColHeader(header="HouseType")
    @WinnieHtmlFormField(label="House Type")
    private HouseType houseType;


    @WinnieTableColHeader(header="HouseLocation")
    @WinnieHtmlFormField(label="House Location")
    private String houseLocation;

    @WinnieTableColHeader(header="HousePrice")
    @WinnieHtmlFormField(label="House Price")
    private BigDecimal housePrice;



    public House() {
    }

    public House(String houseId, String houseName, HouseType houseType, String houseLocation, BigDecimal housePrice) {
        this.houseId = houseId;
        this.houseName = houseName;
        this.houseType = houseType;
        this.houseLocation = houseLocation;
        this.housePrice = housePrice;
    }

    public String getHouseId() {
        return houseId;
    }

    public void setHouseId(String houseId) {
        this.houseId = houseId;
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



    public String deleteHouse() {
        // Add a button to remove the house
        return "<form action=\"./delete\" method=\"post\">" +
                "<input type=\"hidden\" name=\"houseId\" value=\"" + getHouseId() + "\" />" +
                "<input type=\"submit\" value=\"Remove\" />" +
                "</form>";
    }

    public String updateHouse() {
        // Add a button to edit the house
        return "<form action=\"./edit-house\" method=\"get\">" +
                "<input type=\"hidden\" name=\"houseId\" value=\"" + getHouseId() + "\" />" +
                "<input type=\"submit\" value=\"Edit\" />" +
                "</form>";
    }

}