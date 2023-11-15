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
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;




@WebServlet("/edit-house")
public class EditHouse extends BaseAction {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String houseId = req.getParameter("houseId");
        House house = getHouseByIdFromDatabase(houseId);

        if (house != null) {
            req.setAttribute("house", house);

            // Display the edit form directly in the servlet
            resp.setContentType("text/html");
            PrintWriter out = resp.getWriter();
            out.println("<html><body>");
            out.println("<form action='./house-action' method='post'>");
            out.println("House ID: " + house.getHouseId() + "<br>");
            out.println("House ID: <input type='text' name='houseId' value='" + house.getHouseId() + "'><br>");
            out.println("House Name: <input type='text' name='houseName' value='" + house.getHouseName() + "'><br>");
            out.println("House Type: <input type='text' name='houseType' value='" + house.getHouseType() + "'><br>");
            out.println("House Location: <input type='text' name='houseLocation' value='" + house.getHouseLocation() + "'><br>");
            out.println("House Price: <input type='text' name='housePrice' value='" + house.getHousePrice() + "'><br>");
            out.println("<input type='submit' value='Save Changes'>");
            out.println("</form>");
            out.println("</body></html>");
        } else {
            resp.sendRedirect("./houses");
        }
    }

    private House getHouseByIdFromDatabase(String houseId) {
        List<House> houses = Database.getDbInstance().getHouses();
        for (House house : houses) {
            if (house.getHouseId().equals(houseId)) {
                return house;
            }
        }
        return null; // House not found
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String houseId = req.getParameter("houseId");
        House house = getHouseByIdFromDatabase(houseId);

        if (house != null) {
            house.setHouseName(req.getParameter("houseName"));
            house.setHouseType(HouseType.valueOf(req.getParameter("houseType")));
            house.setHouseLocation(req.getParameter("houseLocation"));
            house.setHousePrice(new BigDecimal(req.getParameter("housePrice")));

            updateHouseInDatabase(house);

            resp.sendRedirect("./houses");
        } else {
            resp.sendRedirect("./houses");
        }
    }

    private void updateHouseInDatabase(House updatedHouse) {
        HouseBeanI houseBean = new HouseBean(); // Instantiate HouseBean
        houseBean.updateHouse(updatedHouse); // Call the updateHouse method in HouseBean
    }
}




