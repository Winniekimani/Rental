package com.winnie.app.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DecimalFormat;

public class House implements Serializable {
    private String houseType;
    private String Location;

    //no of rooms
    //housename
    private BigDecimal housePrice;

    public House() {
    }

    public House(String houseType, String location, BigDecimal housePrice) {
        this.houseType = houseType;
        Location = location;
        this.housePrice = housePrice;
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
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
        trBuilder.append("<td>").append(getLocation().isBlank()?"":getLocation().trim()).append("</td>");
        trBuilder.append("<td>").append(getHousePrice()==null?""
            :new DecimalFormat("#,###.##").format(getHousePrice())).append("</td>");
        trBuilder.append("<tr>");

        return trBuilder.toString();

    }

}
