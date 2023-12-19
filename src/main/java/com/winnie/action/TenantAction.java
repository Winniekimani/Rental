package com.winnie.action;

import com.winnie.app.View.html.HtmlComponent;
import com.winnie.app.bean.BillingBeanI;
import com.winnie.app.bean.TenantBeanI;
import com.winnie.app.model.entity.Billing;
import com.winnie.app.model.entity.House;
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


        try {
            String deleteTenantId = req.getParameter("deleteTenantId");
            if (deleteTenantId != null && !deleteTenantId.isEmpty()) {
                Long tenantId = Long.valueOf(deleteTenantId);

                // Attempt to delete Tenant
                try {
                    tenantBean.delete(Tenant.class, tenantId);
                    resp.sendRedirect("./tenant");
                } catch (Exception ex) {
                    ex.printStackTrace(); // Print the exception stack trace
                    req.setAttribute("error", "Error deleting tenant: " + ex.getMessage());
                    renderPage(req, resp, 2, Tenant.class, tenantBean.list(new Tenant()));
                }
            } else {
                renderPage(req, resp, 2, Tenant.class, tenantBean.list(new Tenant()));
            }
        } catch (Exception e) {
            throw new ServletException("Error processing request", e);
        }


/*

        String deleteTenantId = req.getParameter("deleteTenantId");

        if (deleteTenantId != null && !deleteTenantId.isEmpty()) {
            Long tenantId = Long.valueOf(deleteTenantId);
            tenantBean.delete(Tenant.class, tenantId);
        }
        renderPage(req, resp, 2, Tenant.class, tenantBean.list(new Tenant()));*/





    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Tenant tenant = serializeForm(Tenant.class, req.getParameterMap());


        try {



            try {
                // Check if the "id" parameter is present
                String idParameter = req.getParameter("id");
                if (idParameter != null) {
                    // Parse the "id" parameter to Long
                    Long houseId = Long.valueOf(idParameter);
                    // Rest of your code...
                } else {
                    // Handle the case when "id" is not present in the request
                    // For example, you might set a default value or log a message
                    System.err.println("Error: 'id' parameter is missing or null");
                }
            } catch (NumberFormatException e) {
                // Handle the NumberFormatException, e.g., log an error message
                System.err.println("Error parsing 'id' parameter to Long: " + e.getMessage());
            }

            // Add the tenant and retrieve the added tenant with generated ID
            tenant = tenantBean.add(tenant);

            // Retrieve the updated tenant from the database
            tenant = tenantBean.tenantByEmail(tenant.getEmail());


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








