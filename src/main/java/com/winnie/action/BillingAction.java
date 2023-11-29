package com.winnie.action;

import com.winnie.app.bean.BillingBeanI;
import com.winnie.app.bean.HouseBeanI;
import com.winnie.app.model.entity.Billing;
import com.winnie.app.model.entity.House;
import com.winnie.app.model.entity.Payment;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/billing")
public class BillingAction extends BaseAction {

    @EJB
    private BillingBeanI billingBean;


    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();

        renderPage(req,resp,4, Billing.class, billingBean.list(Billing.class));


    }
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /* billingBean.add(serializeForm(Billing.class, req.getParameterMap()));*/
       Billing billing = serializeForm(Billing.class,req.getParameterMap());


        System.out.println("billing = " + billing);
        try {
            billingBean.add(billing);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        resp.sendRedirect("./billing");



    }
}