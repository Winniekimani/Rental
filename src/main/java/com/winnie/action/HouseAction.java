package com.winnie.action;

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


    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();

        if (StringUtils.isNotBlank((String) httpSession.getAttribute("loggedIn"))) {
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
                req.getRequestDispatcher("/home").forward(req, resp);
                return;
            }

            database.getHouses().add(new House(houseId,houseName,houseType, houseLocation, housePrice));
            resp.sendRedirect("./home");
        } else {
            resp.sendRedirect("./");
        }
    }
}
