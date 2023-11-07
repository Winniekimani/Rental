package com.winnie.action;

import com.winnie.app.bean.HouseBean;
import com.winnie.app.bean.HouseBeanI;
import com.winnie.app.model.entity.House;
import com.winnie.app.model.entity.HouseType;
import com.winnie.database.Database;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet("/house-action")
public class HouseAction extends HttpServlet {

    private HouseBeanI houseBean = new HouseBean();
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();

        try {
            houseBean.addHouse(new House(req.getParameter("houseId"),req.getParameter("houseName"),
                    HouseType.valueOf(req.getParameter("houseType")),
                    req.getParameter("houseLocation"),new BigDecimal(req.getParameter("housePrice"))));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        resp.sendRedirect("./houses");



    }
}



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
