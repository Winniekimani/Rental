package com.winnie.action;

import com.winnie.app.bean.TenantBean;
import com.winnie.app.bean.TenantBeanI;

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
            String addTenantForm =
                    "<div class=\"addTenantButton\" >\n" +
                    "            <a href=\"./add-tenant\">Add Tenant</a>\n" +
                    "        </div>";


            String availableTenants = "<h2>List of Available Tenants</h2>\n" + tenantbean.listOfTenants();


        renderPage(req,resp,2,addTenantForm + "<br/>" + availableTenants );






    }


}







