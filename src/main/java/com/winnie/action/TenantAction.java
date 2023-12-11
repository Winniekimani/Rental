package com.winnie.action;

import com.winnie.app.bean.TenantBeanI;
import com.winnie.app.model.entity.House;
import com.winnie.app.model.entity.Tenant;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/tenant")
public class TenantAction extends BaseAction {

    @EJB
    private TenantBeanI tenantBean ;
    public void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {

        HttpSession httpSession = req.getSession();

        String deleteTenantId = req.getParameter("deleteTenantId");

        if (deleteTenantId != null && !deleteTenantId.isEmpty()) {
            Long tenantId = Long.valueOf(deleteTenantId);
            tenantBean.delete(Tenant.class, tenantId);
        }

        renderPage(req,resp,2, Tenant.class,tenantBean.list(new Tenant()) );

    }
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Tenant tenant = serializeForm(Tenant.class, req.getParameterMap());

        try {
            tenantBean.add(tenant);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

      resp.sendRedirect("./tenant");
    /*
        renderPage(req,resp,2, Tenant.class,tenantBean.list(Tenant.class) );*/



    }


}







