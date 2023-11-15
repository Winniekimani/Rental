package com.winnie.action;

import com.winnie.app.bean.HouseBean;
import com.winnie.app.bean.HouseBeanI;
import com.winnie.app.model.entity.House;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/house-action")
public class HouseAction extends BaseAction {

    private HouseBeanI houseBean = new HouseBean();
    private House house = new House();

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();

        String addHouseButton =
                "<div class=\"addHouseButton\" >\n" +
                        "    <a href=\"./add\">Add House</a>\n" +
                        "</div>";


        String availableHouses = "<h2>List of Available Houses</h2>\n" + houseBean.listOfHousesAvailable();

       renderPage(req,resp,1, addHouseButton + "<br/>"
                + "<br/>" + availableHouses);
    }
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        serializeForm(house,req.getParameterMap());

        try {
            houseBean.addHouse(house);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        resp.sendRedirect("./house-action");






    }
}


