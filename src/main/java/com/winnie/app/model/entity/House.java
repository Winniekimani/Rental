package com.winnie.app.model.entity;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DecimalFormat;

public class House implements Serializable {

    private String houseId;

    private String houseName;
    private HouseType houseType;
    private String houseLocation;

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

   /* public String tableRow(){


        StringBuilder trBuilder = new StringBuilder();
        trBuilder.append("<tr>");
        trBuilder.append("<td>").append(StringUtils.trimToEmpty(getHouseId())).append("</td>");
        trBuilder.append("<td>").append(getHouseName() != null ? getHouseName() : "").append("</td>");
        trBuilder.append("<td>").append(getHouseType() != null ? getHouseType().toString() : "").append("</td>");
        trBuilder.append("<td>").append(getHouseLocation() != null ? getHouseLocation().trim() : "").append("</td>");
        trBuilder.append("<td>").append(getHousePrice() != null ? new DecimalFormat("#,###.##").format(getHousePrice()) : "").append("</td>");
        trBuilder.append("<td>").append(deleteHouse()).append("</td>");
        trBuilder.append("<td>").append(updateHouse()).append("</td>");
        trBuilder.append("<tr>");
        return trBuilder.toString();
       *//* StringBuilder trBuilder = new StringBuilder();
        trBuilder.append("<tr>");
        trBuilder.append("<td>").append(StringUtils.trimToEmpty(getHouseId())).append("</td>");
        trBuilder.append("<td>").append(getHouseName()).append("</td>");

        //trBuilder.append("<td>").append(getHouseType()).append("</td>");
        trBuilder.append("<td>").append(getHouseType().name()).append("</td>");
        trBuilder.append("<td>").append(getHouseLocation().isBlank()?"": getHouseLocation().trim()).append("</td>");
        trBuilder.append("<td>").append(getHousePrice()==null?""
            :new DecimalFormat("#,###.##").format(getHousePrice())).append("</td>");

        //button to remove house
        trBuilder.append("<td>").append(deleteHouse()).append("</td>");
        trBuilder.append("<td>").append(updateHouse()).append("</td>");
        trBuilder.append("<tr>");

        return trBuilder.toString();*//*

    }*/


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
