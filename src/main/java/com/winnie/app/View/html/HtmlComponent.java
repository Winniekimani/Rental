package com.winnie.app.View.html;


import com.winnie.app.model.entity.House;
import com.winnie.app.model.entity.HouseType;
import com.winnie.app.model.entity.Payment;
import com.winnie.app.model.entity.Tenant;
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
            // Add delete and update buttons// Add delete and update buttons based on the model type
                   if (model instanceof House) {
                       trBuilder.append("<td>").append(((House) model).deleteHouse()).append("</td>");
                       trBuilder.append("<td>").append(((House) model).updateHouse()).append("</td>");
                  } else if (model instanceof Tenant) {

                       trBuilder.append("<td>").append(((Tenant) model).deleteTenant()).append("</td>");
                   }
            trBuilder.append("</tr>");

        }
        trBuilder.append("</table>");
        return trBuilder.toString();

    }

        public static String htmlForm(Class<?> modelClass) {

        WinnieHtmlForms winnieHtmlForms=null;
        if (modelClass.isAnnotationPresent(WinnieHtmlForms.class))
             winnieHtmlForms=modelClass.getAnnotation(WinnieHtmlForms.class);

        if (winnieHtmlForms==null)
            return StringUtils.EMPTY;


            String htmlForm =  "<div class=\"login-container\">"+
                    "<br/>Add " + modelClass.getSimpleName() + "<br/>" +
                    "<form action=\"./" + modelClass.getSimpleName().toLowerCase() + "-action\" method=\"post\">";
                    //"<div class=\"login-container\">";

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
                            + "\" name=\"" + (StringUtils.isBlank(formField.name())?fieldName: formField.name()) + "\"><br><br>";

                }
                    // Add additional handling for other data types if needed
            }

            htmlForm += "<input type=\"submit\" value=\"Add " + modelClass.getSimpleName() + "\">";
            htmlForm += "</div>"+
                    "</form>"+
                    "<br/><hr/><br/>";

            return htmlForm;
        }
    }









