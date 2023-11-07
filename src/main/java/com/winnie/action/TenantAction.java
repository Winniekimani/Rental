package com.winnie.action;

import com.winnie.app.model.entity.House;
import com.winnie.app.model.entity.HouseType;
import com.winnie.app.model.entity.Tenant;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet("/tenant-action")
public class TenantAction  extends HttpServlet {


    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();


            Database database = Database.getDbInstance();

            String firstName = req.getParameter("firstName");
            String lastName = req.getParameter("lastName");
            String phone = req.getParameter("phone");
            String houseId = req.getParameter("houseId");
            String paymentStatus = req.getParameter("paymentStatus");


            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date leaseStartDate = null;
            java.util.Date leaseEndDate = null;

            try {
                leaseStartDate = dateFormat.parse(req.getParameter("leaseStartDate"));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            try {
                leaseEndDate = dateFormat.parse(req.getParameter("leaseEndDate"));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }

            double  rentAmount = Double.parseDouble(req.getParameter("rentAmount"));


            database.getTenants().add(new Tenant(firstName,lastName,phone,leaseStartDate,leaseEndDate,rentAmount,houseId,paymentStatus));

            resp.sendRedirect("./tenants");


        }
    }

