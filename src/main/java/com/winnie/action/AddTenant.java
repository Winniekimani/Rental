package com.winnie.action;

import com.winnie.app.View.html.HtmlComponent;
import com.winnie.app.bean.TenantBean;
import com.winnie.app.bean.TenantBeanI;
import com.winnie.app.model.entity.House;
import com.winnie.app.model.entity.Tenant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/add-tenant")
public class AddTenant extends BaseAction {
    TenantBeanI tenantBean = new TenantBean();

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        renderPage(req,resp,2, Tenant.class,tenantBean.list(Tenant.class));



    }
}