package com.winnie.action;

import com.winnie.app.View.html.HtmlComponent;
import com.winnie.app.bean.BillingBeanI;
import com.winnie.app.bean.TenantBeanI;
import com.winnie.app.model.entity.Billing;


import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/billing")
public class BillingAction extends BaseAction {

    @EJB
    private BillingBeanI billingBean;

    @EJB
    private TenantBeanI tenantBean;


    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();


        String action =req.getParameter("action");
        if (action!=null && action.equals("update")) {
            String editBillingId = req.getParameter("editBillingId");
            if (editBillingId != null && !editBillingId .isEmpty()) {
                Long billingId = Long.valueOf(editBillingId);
                Billing billing = billingBean.find(Billing.class,billingId);
                billing.setId(billingId);
                req.setAttribute("content", HtmlComponent.editHtmlForm(Billing.class,billing));
                RequestDispatcher dispatcher=req.getRequestDispatcher("./app/index.jsp");
                dispatcher.forward(req,resp);
            }
        }

        String deleteBillingId = req.getParameter("deleteBillingId");

        System.out.println(deleteBillingId);

        if (deleteBillingId != null ) {
            billingBean.delete(Billing.class, Long.valueOf(deleteBillingId));

        }
        List<Billing> billingList = billingBean.getBillingListByEmail("email");
        req.setAttribute("billingList", billingList); // Set the billing list in the request scope


        renderPage(req,resp,4, Billing.class, billingBean.list(new Billing()));




    }
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

       Billing billing = serializeForm(Billing.class,req.getParameterMap());


        try {

            try {

                String idParameter = req.getParameter("id");
                if (idParameter != null) {
                    Long houseId = Long.valueOf(idParameter);
                } else {
                    System.err.println("Error: 'id' parameter is missing or null");
                }
            } catch (NumberFormatException e) {
                System.err.println("Error parsing 'id' parameter to Long: " + e.getMessage());
            }

            billingBean.add(billing);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        resp.sendRedirect("./billing");



    }


}