package com.winnie.action;

import com.winnie.app.bean.BillingBeanI;
import com.winnie.app.bean.HouseBeanI;
import com.winnie.app.bean.TenantBeanI;
import com.winnie.app.model.entity.Billing;
import com.winnie.app.model.entity.House;
import com.winnie.app.model.entity.Payment;
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

@WebServlet("/billing")
public class BillingAction extends BaseAction {

    @EJB
    private BillingBeanI billingBean;

    @EJB
    private TenantBeanI tenantBean;


    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();


        String deleteBillingId = req.getParameter("deleteBillingId");

        System.out.println(deleteBillingId);

        if (deleteBillingId != null ) {
            billingBean.delete(Billing.class, Long.valueOf(deleteBillingId));

        }
/*
        List<Billing> billingList = billingBean.getBillingListByEmail("email");
        req.setAttribute("billingList", billingList); // Set the billing list in the request scope*/


        renderPage(req,resp,4, Billing.class, billingBean.list(new Billing()));




    }
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

       Billing billing = serializeForm(Billing.class,req.getParameterMap());

        Long billingId = Long.valueOf(req.getParameter("modelName"));
        billing.setId(billingId);

        System.out.println("billing = " + billing);
        try {

            billingBean.add(billing);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }/*
        renderPage(req,resp,4, Billing.class, billingBean.list(Billing.class));*/

        resp.sendRedirect("./billing");



    }


}