package com.winnie.action;

import com.winnie.app.View.dropdown.HouseTypeDropDown;
import com.winnie.app.View.html.AppPage;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/add-tenant")
public class AddTenant extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();


            String addTenantForm = "<br/>Add Tenant<br/><form action=\"./tenant-action\" method=\"post\">" +
                    "            <label for=\"firstName\">First Name:</label>" +
                    "            <input type=\"text\" id=\"firstName\" name=\"firstName\" required><br><br>" +
                    "            <label for=\"lastName\">Last Name:</label>" +
                    "            <input type=\"text\" id=\"lastName\" name=\"lastName\" required><br><br>" +
                    "            <label for=\"phone\">Phone:</label>" +
                    "            <input type=\"text\" id=\"phone\" name=\"phone\"><br><br>" +
                    "            <label for=\"leaseStartDate\">Lease Start Date:</label>" +
                    "            <input type=\"date\" id=\"leaseStartDate\" name=\"leaseStartDate\"><br><br>" +
                    "            <label for=\"leaseEndDate\">Lease End Date:</label>" +
                    "            <input type=\"date\" id=\"leaseEndDate\" name=\"leaseEndDate\"><br><br>" +
                    "            <label for=\"rentAmount\">Rent Amount:</label>" +
                    "            <input type=\"text\" id=\"rentAmount\" name=\"rentAmount\"><br><br>" +
                    "            <label for=\"houseNumber\">House Id:</label>" +
                    "            <input type=\"text\" id=\"houseId\" name=\"houseId\"><br><br>" +
                    "            <label for=\"paymentStatus\">Payment Status:</label>" +
                    "            <select id=\"paymentStatus\" name=\"paymentStatus\">" +
                    "                <option value=\"paid\">Paid</option>" +
                    "                <option value=\"unpaid\">Unpaid</option>" +
                    "            </select><br><br>" +
                    "            <button type=\"submit\">Save</button>" +
                    "        </form>";
            String listOfTenants = "<h2>List of Available Houses</h2>\n" ;
            new AppPage().renderHtml(req, resp, 1, addTenantForm + "<br/>" );


    }
}