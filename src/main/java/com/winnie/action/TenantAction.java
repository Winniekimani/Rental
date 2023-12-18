package com.winnie.action;

import com.winnie.app.View.html.HtmlComponent;
import com.winnie.app.bean.BillingBeanI;
import com.winnie.app.bean.TenantBeanI;
import com.winnie.app.model.entity.Billing;
import com.winnie.app.model.entity.Tenant;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/tenant"})
public class TenantAction extends BaseAction {

    @EJB
    private TenantBeanI tenantBean;
    @EJB
    private BillingBeanI billingBean;



    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession httpSession = req.getSession();

        String action =req.getParameter("action");
        if (action!=null && action.equals("update")){

            String editTenantId = req.getParameter("editTenantId");
            if (editTenantId != null && !editTenantId .isEmpty()) {
                Long tenantId = Long.valueOf(editTenantId);
                Tenant tenant = tenantBean.find(Tenant.class,tenantId);
                tenant.setId(tenantId);
                req.setAttribute("content", HtmlComponent.editHtmlForm(Tenant.class,tenant));
                RequestDispatcher dispatcher=req.getRequestDispatcher("./app/index.jsp");
                dispatcher.forward(req,resp);
            }
        }

        String deleteTenantId = req.getParameter("deleteTenantId");

        if (deleteTenantId != null && !deleteTenantId.isEmpty()) {
            Long tenantId = Long.valueOf(deleteTenantId);
            tenantBean.delete(Tenant.class, tenantId);
        }


        renderPage(req, resp, 2, Tenant.class, tenantBean.list(new Tenant()));


    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {




        try {

            Tenant tenant = serializeForm(Tenant.class, req.getParameterMap());

            Long tenantId = Long.valueOf(req.getParameter("id"));
            tenant.setId(tenantId);
            tenant.setHouseId(tenant.getHouseId());
            System.out.println("new tenant = " + tenant);
            /*// Add the tenant and retrieve the added tenant with generated ID
            tenant = tenantBean.add(tenant);*/

          /*  // Retrieve the updated tenant from the database
            tenant = tenantBean.tenantByEmail(tenant.getEmail());*/


            List<Billing> billingList = billingBean.getBillingListByEmail(tenant.getEmail());
            // Set billingList to the tenant
            tenant.setBillings(billingList);

            tenantBean.add(tenant);

            resp.sendRedirect("./tenant");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

      /*  resp.sendRedirect("./tenant");*/





        }


    }








