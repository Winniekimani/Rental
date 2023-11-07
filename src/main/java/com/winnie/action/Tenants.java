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

    public void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        HttpSession httpSession= req.getSession();


            TenantBeanI tenantbean = new TenantBean();
            String addTenantForm =
                    "<div class=\"addTenantButton\" >\n" +
                    "            <a href=\"./add-tenant\">Add Tenant</a>\n" +
                    "        </div>";


            String availableTenants = "<h2>List of Available Tenants</h2>\n" + tenantbean.listOfTenants();
            new AppPage().renderHtml(req, resp, 1, addTenantForm + "<br/>" + availableTenants);





    }


}
            //new AppPage().renderHtml(req,resp,2,"<h2>tenants </h2>tenants list available here");








