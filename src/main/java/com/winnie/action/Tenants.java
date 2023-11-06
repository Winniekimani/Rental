package com.winnie.action;

import com.winnie.app.View.html.AppPage;
import com.winnie.app.bean.HouseBean;
import com.winnie.app.bean.HouseBeanI;
import com.winnie.app.bean.TenantBean;
import com.winnie.app.bean.TenantBeanI;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/tenants")
public class Tenants extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        if (StringUtils.isNotBlank((String) httpSession.getAttribute("loggedIn"))) {
            TenantBeanI tenantbean = new TenantBean();
            if (StringUtils.isNotBlank((String) httpSession.getAttribute("loggedIn"))) {
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

                String tenantList = "<h2>List of tenants</h2>\n" + tenantbean.listOfTenants();
                new AppPage().renderHtml(req, resp, 2, addTenantForm + "<br/>" + tenantList);

            } else {
                resp.sendRedirect("./");
            }
        }
    }
}

            //new AppPage().renderHtml(req,resp,2,"<h2>tenants </h2>tenants list available here");








