/*
package com.winnie.action;


import com.winnie.app.bean.HouseBeanI;
import com.winnie.app.model.entity.House;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/availableHouses")
public class AvailableHousesAction extends HttpServlet {

    @EJB
    private HouseBeanI houseBean;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the list of available houses
        List<House> availableHouses = houseBean.listAvailableHouses();

        // Set the list of available houses as an attribute in the request
        request.setAttribute("availableHouses", availableHouses);

        // Forward the request to the JSP page
        RequestDispatcher dispatcher = request.getRequestDispatcher("./vacant_houses.jsp");
        dispatcher.forward(request, response);
    }
}
*/
