package com.winnie.action;

import com.winnie.app.View.html.HtmlComponent;
import com.winnie.app.model.entity.House;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet("/add")
public class AddHouse extends BaseAction{

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();/*

            *//*HouseTypeDropDown houseTypeDropDown = new HouseTypeDropDown();
            String houseTypeDropdown = houseTypeDropDown.menu();*//*
            String addHouseForm = "<br/>Add House<br/>" +
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
/*
            new AppPage().renderHtml(req, resp, 1, HtmlComponent.htmlForm(new House()) + "<br/>" );*/
        /*new AppPage().renderHtml(req, resp, 1, HtmlComponent.htmlForm(House.class) + "<br/>" );*/

        renderPage(req,resp,1,HtmlComponent.htmlForm(House.class) + "<br/>" );


    }
}



