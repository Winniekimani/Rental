package com.winnie.action;

import com.winnie.app.View.dropdown.HouseTypeDropDown;
import com.winnie.app.View.html.AppPage;
import com.winnie.app.bean.HouseBean;
import com.winnie.app.bean.HouseBeanI;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/home")
public class Home extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        HttpSession httpSession= req.getSession();
        if (StringUtils.isNotBlank((String) httpSession.getAttribute("loggedIn"))){

            HouseBeanI housebean = new HouseBean();
            HouseTypeDropDown houseTypeDropDown = new HouseTypeDropDown();
            String houseTypeDropdown = houseTypeDropDown.menu();
            String addHouseForm = "<br/>Add House<br/><form action=\"./house-action\" method=\"post\">" +
                    "<label for=\"houseId\">House ID:</label><br>" +
                    "<input type=\"text\" id=\"houseId\" name=\"houseId\"><br>" +
                    "<label for=\"houseName\">House Name:</label><br>" +
                    "<input type=\"text\" id=\"houseName\" name=\"houseName\"><br>" +
                    "<label for=\"houseType\">House Type:</label><br>" +
                    houseTypeDropdown + "<br>" +
                    "<label for=\"houseLocation\">House Location:</label><br>" +
                    "<input type=\"text\" id=\"houseLocation\" name=\"houseLocation\"><br>" +
                    "<label for=\"housePrice\">House Price:</label><br>" +
                    "<input type=\"text\" id=\"housePrice\" name=\"housePrice\"><br><br>" +
                    "<input type=\"submit\" value=\"Add House\">" +
                    "</form>";
            String availableHouses = "<h2>List of Available Houses</h2>\n" + housebean.listOfHousesAvailable();
            new AppPage().renderHtml(req, resp, 0, addHouseForm + "<br/>" + availableHouses);

        }

        else{
            resp.sendRedirect("./");
        }



    }



}
