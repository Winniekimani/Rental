package com.winnie.action;

import com.winnie.database.Database;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/delete")
public class DeleteHouse extends HttpServlet {


    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();


            Database database = Database.getDbInstance();
            String houseId = req.getParameter("houseId");

            // Remove the house from the database
            database.getHouses().removeIf(house -> house.getHouseId().equals(houseId));

            /*List<House> houses = database.getHouses();
            for (House house : houses) {
                if (house.getHouseId().equals(houseId)) {
                    houses.remove(house);
                    break;  // Optional - to break the loop after the first removal
                }
            }*/


            resp.sendRedirect("./houses");

    }
}