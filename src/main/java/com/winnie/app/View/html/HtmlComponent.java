package com.winnie.app.View.html;

import com.winnie.app.View.dropdown.HouseTypeDropDown;
import com.winnie.app.model.entity.House;
import com.winnie.app.model.entity.HouseType;
import com.winnie.database.Database;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class HtmlComponent implements Serializable {

    public static String table(List<?> models) {


        if (models == null || models.isEmpty())
            return StringUtils.EMPTY;

        Field[] fields = models.get(0).getClass().getDeclaredFields();

        StringBuilder trBuilder = new StringBuilder();
        trBuilder.append("<table><tr>");

        for (Field field : fields) {
            if (!field.isAnnotationPresent(WinnieTableColHeader.class))
                continue;
            else
                trBuilder.append("<th>" + field.getAnnotation(WinnieTableColHeader.class).header() + "</th>");

        }
        trBuilder.append("</tr>");
        for (Object model : models) {
            trBuilder.append("<tr>");
            for (Field field : fields) {
                if (!field.isAnnotationPresent(WinnieTableColHeader.class))
                    continue;
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

        public static String htmlForm(Class<?> modelClass) {

       /* WinnieHtmlForms winnieHtmlForms=null;
        if (modelClass.isAnnotationPresent(WinnieHtmlForms.class))
             winnieHtmlForms=modelClass.getAnnotation(WinnieHtmlForms.class);

        if (winnieHtmlForms==null)
            return StringUtils.EMPTY;*/


            String htmlForm = "<br/>Add " + modelClass.getSimpleName() + "<br/>" +
                    "<form action=\"./" + modelClass.getSimpleName().toLowerCase() + "-action\" method=\"post\">";

            Field[] fields = modelClass.getDeclaredFields();

            for (Field field : fields) {
                if (!field.isAnnotationPresent(WinnieHtmlFormField.class))
                    continue;
                WinnieHtmlFormField formField=field.getAnnotation(WinnieHtmlFormField.class);
                field.setAccessible(true);
                String fieldName = field.getName();
                htmlForm += "<label for=\"" + (StringUtils.isBlank(formField.labelFor())?fieldName: formField.labelFor())
                        + "\">"
                        + (StringUtils.isBlank(formField.label())?fieldName: formField.label()) + ":</label><br>";

                Class<?> fieldType = field.getType();

                if (fieldType.isEnum()) {
                    htmlForm += "<select name=\"" + (StringUtils.isBlank(formField.selectName())?fieldName: formField.selectName())
                            + "\" id=\"" + (StringUtils.isBlank(formField.id())?fieldName: formField.id()) + "\">";
                    Object[] enumConstants = fieldType.getEnumConstants();
                    for (Object enumConstant : enumConstants) {
                        htmlForm += "<option value=\"" + enumConstant.toString() + "\">" + enumConstant.toString() + "</option>";
                    }
                    htmlForm += "</select><br>";
                } else if (fieldType == String.class) {
                    htmlForm += "<input type=\"text\" id=\"" + (StringUtils.isBlank(formField.id())?fieldName: formField.id())
                            + "\" name=\""
                            + (StringUtils.isBlank(formField.name())?fieldName: formField.name()) + "\"><br>";
                } else if (fieldType == int.class || fieldType == Integer.class || fieldType == double.class || fieldType == Double.class) {
                    htmlForm += "<input type=\"number\" step=\"any\" id=\"" + (StringUtils.isBlank(formField.id())?fieldName: formField.id())
                            + "\" name=\"" + (StringUtils.isBlank(formField.name())?fieldName: formField.name()) + "\"><br>";
                } else if (fieldType == Date.class) {
                    htmlForm += "<input type=\"date\" id=\"" + (StringUtils.isBlank(formField.id())?fieldName: formField.id())
                            + "\" name=\"" + (StringUtils.isBlank(formField.name())?fieldName: formField.name()) + "\"><br>";
                } else if (fieldType == BigDecimal.class) {
                    htmlForm += "<input type=\"number\" step=\"any\" id=\"" + (StringUtils.isBlank(formField.id())?fieldName: formField.id())
                            + "\" name=\"" + (StringUtils.isBlank(formField.name())?fieldName: formField.name()) + "\"><br>";

                }
                    // Add additional handling for other data types if needed
            }

            htmlForm += "<input type=\"submit\" value=\"Add " + modelClass.getSimpleName() + "\">";
            htmlForm += "</form>";

            return htmlForm;
        }
    }


    /*public static String htmlForm(Class<?> modelClass) {
        String htmlForm = "<br/>Add " + modelClass.getSimpleName() + "<br/>" +
                "<form action=\"./" + modelClass.getSimpleName().toLowerCase() + "-action\" method=\"post\">";

        Field[] fields = modelClass.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            String fieldName = field.getName();
            htmlForm += "<label for=\"" + fieldName + "\">" + fieldName + ":</label><br>";

            Class<?> fieldType = field.getType();

            if (fieldType.isEnum()) {
                htmlForm += "<select name=\"" + fieldName + "\" id=\"" + fieldName + "\">";
                Object[] enumConstants = fieldType.getEnumConstants();
                for (Object enumConstant : enumConstants) {
                    htmlForm += "<option value=\"" + enumConstant.toString() + "\">" + enumConstant.toString() + "</option>";
                }
                htmlForm += "</select><br>";
            } else if (fieldType == String.class) {
                htmlForm += "<input type=\"text\" id=\"" + fieldName + "\" name=\"" + fieldName + "\"><br>";
            } else if (fieldType == int.class || fieldType == Integer.class || fieldType == double.class || fieldType == Double.class) {
                htmlForm += "<input type=\"number\" step=\"any\" id=\"" + fieldName + "\" name=\"" + fieldName + "\"><br>";
            } else if (fieldType == Date.class) {
                htmlForm += "<input type=\"date\" id=\"" + fieldName + "\" name=\"" + fieldName + "\"><br>";
            } else if (fieldType == BigDecimal.class) {
                htmlForm += "<input type=\"number\" step=\"any\" id=\"" + fieldName + "\" name=\"" + fieldName + "\"><br>";

            }
            // Add additional handling for other data types if needed
        }

        htmlForm += "<input type=\"submit\" value=\"Add " + modelClass.getSimpleName() + "\">";
        htmlForm += "</form>";

        return htmlForm;
    }
}*/

    /*public static String htmlForm(Object model){

        String htmlForm= "<br/>Add House<br/>" +
                "<form action=\"./house-action\" method=\"post\">" ;

                Field [] fields = model.getClass().getDeclaredFields();

           *//* for (Field  field : fields){

                String fieldName=field.getName();
                htmlForm+="<label for=\""+ fieldName + "\">"+ fieldName + ":</label><br>";
                htmlForm+= "<input type=\"text\" id=\""+fieldName+"\" name=\""+fieldName+"\"><br>" ;
                htmlForm+= "<select name=\""+ fieldName + "\" id=\""+ fieldName +"\">";

                htmlForm += "<option value=\"" + fieldName+ "\">" + fieldName+ "</option>";


            }*//*
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

}*/
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
                "<option value=\"ONE_BEDROOM_APARTMENT\">One -bedroom Apartment</option>\n" +
                "<option value=\"TWO_BEDROOM_APARTMENT\">Two-Bedroom Apartment</option>\n" +
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





