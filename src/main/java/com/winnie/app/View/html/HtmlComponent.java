package com.winnie.app.View.html;


import com.winnie.database.helper.DbTableId;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class HtmlComponent implements Serializable {

    public static String table(Class<?>clazz,List<?> models) {



        // Class<?> clazz = models.get(0).getClass();
        if (!clazz.isAnnotationPresent(HtmlTable.class))
            return StringUtils.EMPTY;


        HtmlTable htmlTable = clazz.getAnnotation(HtmlTable.class);

        Field[] fields = clazz.getDeclaredFields();

        StringBuilder trBuilder = new StringBuilder();
        trBuilder.append("<table><tr>");
        trBuilder.append( "<div class=\"addHouseButton\" >\n" +
                "    <a href=\""+htmlTable.addUrl()+"\">Add " + htmlTable.name() +"</a>\n" +
                "</div>");
        trBuilder.append("<h4> List of " + htmlTable.name() + "</h4>");

        for (Field field : fields) {
            if (!field.isAnnotationPresent(WinnieTableColHeader.class))
                continue;
            else
                trBuilder.append("<th>" + field.getAnnotation(WinnieTableColHeader.class).header() + "</th>");

        }

        trBuilder.append("</tr>");
        for (Object model : models) {
            trBuilder.append("<tr>");
            /* int id =0;*/
            for (Field field : fields) {
                if (!field.isAnnotationPresent(WinnieTableColHeader.class))
                    continue;
                try {
                    field.setAccessible(true);
                   /* if(field.isAnnotationPresent(DbTableId.class))
                        id=(int)field.get(model);*/
                    trBuilder.append("<td>").append(field.get(model)).append("</td>");

                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }

            trBuilder.append("<td>").append( "<div class=\"addHouseButton\" >\n" +
                    "    <a href=\""+htmlTable.editUrl()+"\">Edit" + htmlTable.name() +"</a>\n" +
                    "</div></td>");
            trBuilder.append("<td>").append( "<div class=\"addHouseButton\" >\n" +
                    "    <a href=\""+htmlTable.deleteUrl()+ "?id=" + getIdFromModel(model)  +"\">Delete" + htmlTable.name() +"</a>\n" +
                    "</div></td>");
            // Add delete and update buttons// Add delete and update buttons based on the model type
         /*   if (model instanceof House) {
                trBuilder.append("<td>").append(((House) model).deleteHouse()).append("</td>");
                trBuilder.append("<td>").append(((House) model).updateHouse()).append("</td>");
            } else if (model instanceof Tenant) {

                trBuilder.append("<td>").append(((Tenant) model).deleteTenant()).append("</td>");
            }*/

            trBuilder.append("</tr>");

        }
        trBuilder.append("</table>");
        return trBuilder.toString();

    }

    private static String getIdFromModel(Object model) {
        try {
            // Assuming that the ID field is named "id" in the base entity - modify as needed
            Field idField = findIdField(model.getClass());
            idField.setAccessible(true);
            Object idValue = idField.get(model);
            return idValue != null ? idValue.toString() : "";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private static Field findIdField(Class<?> modelClass) {
        while (modelClass != null) {
            try {
                Field[] fields = modelClass.getDeclaredFields();
                for (Field field : fields) {
                    if (field.isAnnotationPresent(DbTableId.class)) {
                        return field;
                    }
                }
                modelClass = modelClass.getSuperclass();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }



    public static String htmlForm(Class<?> modelClass) {

        WinnieHtmlForms winnieHtmlForms = null;
        if (modelClass.isAnnotationPresent(WinnieHtmlForms.class))
            winnieHtmlForms = modelClass.getAnnotation(WinnieHtmlForms.class);

        if (winnieHtmlForms == null)
            return StringUtils.EMPTY;


        String htmlForm = "<div class=\"login-container\">" +
                "<br/>Add " + modelClass.getSimpleName() + "<br/>" +
                "<form action=\"./" + modelClass.getSimpleName().toLowerCase() + "\" method=\"post\">";
        //"<div class=\"login-container\">";

        Field[] fields = modelClass.getDeclaredFields();

        for (Field field : fields) {
            if (!field.isAnnotationPresent(WinnieHtmlFormField.class))
                continue;
            WinnieHtmlFormField formField = field.getAnnotation(WinnieHtmlFormField.class);
            field.setAccessible(true);
            String fieldName = field.getName();
            htmlForm += "<label for=\"" + (StringUtils.isBlank(formField.labelFor()) ? fieldName : formField.labelFor())
                    + "\">"
                    + (StringUtils.isBlank(formField.label()) ? fieldName : formField.label()) + ":</label><br>";

            Class<?> fieldType = field.getType();

            if (fieldType.isEnum()) {
                htmlForm += "<select name=\"" + (StringUtils.isBlank(formField.selectName()) ? fieldName : formField.selectName())
                        + "\" id=\"" + (StringUtils.isBlank(formField.id()) ? fieldName : formField.id()) + "\">";
                Object[] enumConstants = fieldType.getEnumConstants();
                for (Object enumConstant : enumConstants) {
                    htmlForm += "<option value=\"" + enumConstant.toString() + "\">" + enumConstant.toString() + "</option>";
                }
                htmlForm += "</select><br>";
            } else if (fieldType == String.class) {
                htmlForm += "<input type=\"text\" id=\"" + (StringUtils.isBlank(formField.id()) ? fieldName : formField.id())
                        + "\" name=\""
                        + (StringUtils.isBlank(formField.name()) ? fieldName : formField.name()) + "\"><br>";
            } else if (fieldType == int.class || fieldType == Integer.class || fieldType == double.class || fieldType == Double.class) {
                htmlForm += "<input type=\"number\" step=\"any\" id=\"" + (StringUtils.isBlank(formField.id()) ? fieldName : formField.id())
                        + "\" name=\"" + (StringUtils.isBlank(formField.name()) ? fieldName : formField.name()) + "\"><br>";
            } else if (fieldType == Date.class) {
                htmlForm += "<input type=\"date\" id=\"" + (StringUtils.isBlank(formField.id()) ? fieldName : formField.id())
                        + "\" name=\"" + (StringUtils.isBlank(formField.name()) ? fieldName : formField.name()) + "\"><br>";
            } else if (fieldType == BigDecimal.class) {
                htmlForm += "<input type=\"number\" step=\"any\" id=\"" + (StringUtils.isBlank(formField.id()) ? fieldName : formField.id())
                        + "\" name=\"" + (StringUtils.isBlank(formField.name()) ? fieldName : formField.name()) + "\"><br><br>";

            }else if(fieldType== Long.class){

                htmlForm += "<input type=\"number\" id=\"" + (StringUtils.isBlank(formField.id()) ? fieldName : formField.id())
                        + "\" name=\""
                        + (StringUtils.isBlank(formField.name()) ? fieldName : formField.name()) + "\"><br>";
            }
            // Add additional handling for other data types if needed
        }

        htmlForm += "<input type=\"submit\" value=\"Add " + modelClass.getSimpleName() + "\">";
        htmlForm += "</div>" +
                "</form>" +
                "<br/><hr/><br/>";

        return htmlForm;
    }
}