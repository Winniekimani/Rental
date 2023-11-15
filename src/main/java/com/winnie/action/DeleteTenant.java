package com.winnie.action;

import com.winnie.app.View.html.HtmlComponent;
import com.winnie.app.model.entity.Tenant;
import com.winnie.database.Database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/delete-tenant")
public class DeleteTenant extends BaseAction {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Database database = Database.getDbInstance();
        String houseId = req.getParameter("houseId");

        database.getTenants().removeIf(tenant -> tenant.getHouseId().equals(houseId));

            /*List<House> houses = database.getHouses();
            for (House house : houses) {
                if (house.getHouseId().equals(houseId)) {
                    houses.remove(house);
                    break;  // Optional - to break the loop after the first removal
                }
            }*/
        resp.sendRedirect("./tenants");




    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Code to handle POST requests
        String houseId = req.getParameter("houseId");

        // Remove the tenant from the database
        Database database = Database.getDbInstance();
        database.getTenants().removeIf(tenant -> tenant.getHouseId().equals(houseId));

        // Redirect to the tenants page after deletion
        resp.sendRedirect("./tenants");
    }
}