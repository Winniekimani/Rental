package com.winnie.app.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DecimalFormat;

public class House implements Serializable {
    private String houseType;
    private String houseLocation;

    //no of rooms
    //housename
    private BigDecimal housePrice;

    public House() {
    }

    public House(String houseType, String houseLocation, BigDecimal housePrice) {
        this.houseType = houseType;
        this.houseLocation = houseLocation;
        this.housePrice = housePrice;
    }


    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
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

    public String tableRow(){
        StringBuilder trBuilder = new StringBuilder();
        trBuilder.append("<tr>");
        trBuilder.append("<td>").append(getHouseType().isBlank()?"":getHouseType().trim()).append("</td>");
        trBuilder.append("<td>").append(getHouseLocation().isBlank()?"": getHouseLocation().trim()).append("</td>");
        trBuilder.append("<td>").append(getHousePrice()==null?""
            :new DecimalFormat("#,###.##").format(getHousePrice())).append("</td>");
        trBuilder.append("<tr>");

        return trBuilder.toString();

    }

}
