package com.winnie.action;

import com.winnie.app.bean.TenantBean;
import com.winnie.app.bean.TenantBeanI;
import com.winnie.app.model.entity.Tenant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/tenants")
public class Tenants extends BaseAction {

    public void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {

            TenantBeanI tenantbean = new TenantBean();


        renderPage(req,resp,2, Tenant.class,tenantbean.list(Tenant.class) );


    }


}







