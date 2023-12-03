package com.winnie.action;

import com.winnie.app.bean.TenantBeanI;
import com.winnie.app.model.entity.Tenant;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/tenant")
public class TenantAction extends BaseAction {

    @EJB
    private TenantBeanI tenantBean ;
    public void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {

          /*  TenantBeanI tenantbean = new TenantBean();*/


        renderPage(req,resp,2, Tenant.class,tenantBean.list(Tenant.class) );


    }
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        com.winnie.app.model.entity.Tenant tenant = serializeForm(Tenant.class, req.getParameterMap());

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







