package com.winnie.app.View.html;

import com.winnie.app.View.dropdown.HouseTypeDropDown;
import com.winnie.app.model.entity.House;
import com.winnie.app.model.entity.HouseType;
import com.winnie.database.Database;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.List;

public class HtmlComponent implements Serializable {

    public static String table(List<? >models) {


        if(models == null || models.isEmpty())
            return StringUtils.EMPTY;

        Field [] fields = models.get(0).getClass().getDeclaredFields();

        StringBuilder trBuilder = new StringBuilder();
        trBuilder.append("<table><tr>");

        for (Field field:fields){
            trBuilder.append("<th>" + field.getName() + "</th>");

        }
        trBuilder.append("</tr>");
        for (Object model:models){
            trBuilder.append("<tr>");
             for (Field field:fields){

                 try {
                     field.setAccessible(true);
                     trBuilder.append("<td>").append(field.get(model)).append("</td>");

                 } catch (IllegalAccessException e) {
                     throw new RuntimeException(e);
                 }
             }
            // Add delete and update buttons
            trBuilder.append("<td>").append(((House) model).deleteHouse()).append("</td>");
            trBuilder.append("<td>").append(((House) model).updateHouse()).append("</td>");
             trBuilder.append("</tr>");

        }
        trBuilder.append("</table>");
        return trBuilder.toString();
        /*List<House> houses= Database.getDbInstance().getHouses();

        StringBuilder trBuilder = new StringBuilder();
        trBuilder.append("<table><tr><th>HouseId</th><th>HouseName</th><th>HouseType</th><th>HouseLocation</th><th>HousePrice</th></tr>");
        for (House house: houses)
            trBuilder.append(house.tableRow());

        trBuilder.append("</table>");

        return trBuilder.toString();*/


    }
    public static String htmlForm(Object model){

        String htmlForm= "<br/>Add House<br/>" +
                "<form action=\"./house-action\" method=\"post\">" ;

                Field [] fields = model.getClass().getDeclaredFields();

           /* for (Field  field : fields){

                String fieldName=field.getName();
                htmlForm+="<label for=\""+ fieldName + "\">"+ fieldName + ":</label><br>";
                htmlForm+= "<input type=\"text\" id=\""+fieldName+"\" name=\""+fieldName+"\"><br>" ;
                htmlForm+= "<select name=\""+ fieldName + "\" id=\""+ fieldName +"\">";

                htmlForm += "<option value=\"" + fieldName+ "\">" + fieldName+ "</option>";


            }*/
        for (Field field : fields) {
            field.setAccessible(true); // Make the field accessible

            String fieldName = field.getName();
            htmlForm += "<label for=\"" + fieldName + "\">" + fieldName + ":</label><br>";

            if (field.getType().isEnum()) {
                htmlForm += "<select name=\"" + fieldName + "\" id=\"" + fieldName + "\">";
                for (Object enumConstant : field.getType().getEnumConstants()) {
                    htmlForm += "<option value=\"" + enumConstant.toString() + "\">" + enumConstant.toString() + "</option>";
                }
                htmlForm += "</select><br>";
            } else {
                htmlForm += "<input type=\"text\" id=\"" + fieldName + "\" name=\"" + fieldName + "\"><br>";
            }
        }
            htmlForm+= "<input type=\"submit\" value=\"Add House\">";
            htmlForm+=  "</form>";

        return htmlForm;

    }

}
    /*
                "<br/>Add House<br/>" +
                "<form action=\"./house-action\" method=\"post\">" +

                "<label for=\"houseId\">House ID:</label><br>" +
                "<input type=\"text\" id=\"houseId\" name=\"houseId\"><br>" +

                "<label for=\"houseName\">House Name:</label><br>" +
                "<input type=\"text\" id=\"houseName\" name=\"houseName\"><br>" +

                //"<label for=\"houseType\">House Type:</label><br>" +
                //houseTypeDropdown + "<br>" +

                " <label for=\"houseType\">House Type:</label><br>"+

                "<select name=\"houseType\" id=\"houseType\">" +

                "<option value=\"BEDSITTER_APARTMENT\">Bedsitter Apartment</option>\n" +
                "<option value=\"ONE_BEDROOM_APARTMENT\">One Bedroom Apartment</option>\n" +
                "<option value=\"TWO_BEDROOM_APARTMENT\">Two Bedroom Apartment</option>\n" +
                "<option value=\"AIRBNB\">Airbnb</option>\n" +
                "<option value=\"MANSION\">Mansion</option>\n" +
                "<option value=\"VILLA\">Villa</option>\n" +
                "<option value=\"BUNGALOW\">Bungalow</option>\n" +
                "<option value=\"COTTAGE\">Cottage</option>\n" +
                "<option value=\"FARMHOUSE\">Farmhouse</option>\n" +
                "<option value=\"PENTHOUSE\">Penthouse</option>\n" +
                "</select><br>"+
                "<label for=\"houseLocation\">House Location:</label><br>" +
                "<input type=\"text\" id=\"houseLocation\" name=\"houseLocation\"><br>" +
                "<label for=\"housePrice\">House Price:</label><br>" +
                "<input type=\"text\" id=\"housePrice\" name=\"housePrice\"><br><br>" +
                "<input type=\"submit\" value=\"Add House\">" +
                "</form>";*/





