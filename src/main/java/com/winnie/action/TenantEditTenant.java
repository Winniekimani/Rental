package com.winnie.action;


import com.winnie.app.bean.TenantBeanI;
import com.winnie.app.model.entity.Billing;
import com.winnie.app.model.entity.Tenant;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/tenant-user-update")
public class TenantEditTenant extends BaseAction {
    @EJB
    TenantBeanI tenantBean;

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Tenant tenant = serializeForm(Tenant.class, req.getParameterMap());

        tenantBean.add(tenant);
        resp.sendRedirect("./tenant_page.jsp");

    }
}
