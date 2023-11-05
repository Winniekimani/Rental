package com.winnie.app.View.dropdown;

import com.winnie.app.model.entity.HouseType;

import java.util.ArrayList;
import java.util.List;

public class HouseTypeDropDown implements OptionMenu{

    List<Option>houseTypeList= new ArrayList<>();
    public HouseTypeDropDown() {
        houseTypeList.add(new Option(HouseType.BEDSITTER_APARTMENT, "one-bedroom-Apartment"));
        houseTypeList.add(new Option(HouseType.VILLA, "villa"));
        houseTypeList.add(new Option(HouseType.ONE_BEDROOM_APARTMENT, "one-bedroom"));
        houseTypeList.add(new Option(HouseType.TWO_BEDROOM_APARTMENT, "two-bedroom"));
        houseTypeList.add(new Option(HouseType.MANSION, "mansion"));
        houseTypeList.add(new Option(HouseType.BUNGALOW, "bungalow"));
        houseTypeList.add(new Option(HouseType.AIRBNB, "airbnb"));
        houseTypeList.add(new Option(HouseType.PENTHOUSE, "penthouse"));
        houseTypeList.add(new Option(HouseType.COTTAGE, "cottage"));
        houseTypeList.add(new Option(HouseType.FARMHOUSE, "farmhouse"));
        // Add more items here
    }

    @Override
    public String menu() {


        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<select id=\"houseType\" name=\"houseType\">");

        for (Option houseType : houseTypeList) {
            stringBuilder.append("<option value=\"").append(houseType.getOptionName()).append("\">")
                    .append(houseType.getLabel())
                    .append("</option>");
        }

        stringBuilder.append("</select>");
        return stringBuilder.toString();


       /* StringBuilder stringBuilder = new StringBuilder()
                .append(
                        "<label for=\"houseType\">HouseType</label>\n" +
                                "<select  id=\"houseType\" name=\"houseType\">\n");

        for (Option houseType : houseTypeList) {
            stringBuilder.append("<option value=\"").append(houseType.getOptionName()).append("\">")
                    .append(houseType.getLabel())
                    .append("</option>\n");
        }
        stringBuilder.append("</select>");

        return stringBuilder.toString();*/
    }
}
