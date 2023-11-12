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
       /* new AppPage().renderHtml(req, resp, 1, addHouseButton + "<br/>"
                + "<br/>" + availableHouses);*/


/*
        req.setAttribute("activeMenu",1);
        req.setAttribute("content",addHouseButton + "<br/>"
                + "<br/>" + availableHouses );
        RequestDispatcher dispatcher=req.getRequestDispatcher(".app/index.jsp");
        dispatcher.forward(req,resp);*/

        renderPage(req,resp,1, addHouseButton + "<br/>"
                + "<br/>" + availableHouses);
    }
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();

        serializeForm(house,req.getParameterMap());

        try {
            houseBean.addHouse(house);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //resp.sendRedirect("./houses");
        resp.sendRedirect("./house-action");





    }
}

//then this
       /* try {
            houseBean.addHouse(new House(req.getParameter("houseId"),req.getParameter("houseName"),
                    HouseType.valueOf(req.getParameter("houseType")),
                    req.getParameter("houseLocation"),new BigDecimal(req.getParameter("housePrice"))));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        resp.sendRedirect("./houses");*/

//first like this
        /*if (StringUtils.isNotBlank((String) httpSession.getAttribute("loggedIn"))) {
            Database database = Database.getDbInstance();

            String houseId=req.getParameter("houseId");
            String houseName=req.getParameter("houseName");
            HouseType houseType = HouseType.valueOf(req.getParameter("houseType"));
            String houseLocation = req.getParameter("houseLocation");
            BigDecimal housePrice;

            try {
                housePrice = new BigDecimal(req.getParameter("housePrice"));
            } catch (NumberFormatException e) {
                // Set an error message
                req.setAttribute("error", "Please enter a valid house price.");
                req.getRequestDispatcher("/houses").forward(req, resp);
                return;
            }

            database.getHouses().add(new House(houseId,houseName,houseType, houseLocation, housePrice));
            resp.sendRedirect("./houses");
        } else {
            resp.sendRedirect("./");

        }*/
