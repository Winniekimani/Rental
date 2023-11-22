package com.winnie.action;

import com.winnie.app.View.html.HtmlComponent;
import com.winnie.app.bean.HouseBean;
import com.winnie.app.bean.HouseBeanI;
import com.winnie.app.bean.TenantBean;
import com.winnie.app.bean.TenantBeanI;
import com.winnie.app.model.entity.House;
import com.winnie.app.model.entity.Tenant;
import com.winnie.database.Database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/delete-tenant")
public class DeleteTenant extends BaseAction {
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();

        String tenantId = req.getParameter("tenantId");

        // Calling the deleteTenant method from TenantBean
        TenantBean tenantBean = new TenantBean();
        tenantBean.delete(tenantId);

        // Redirect to the tenants page after deletion
        resp.sendRedirect("./tenants");





    }

}