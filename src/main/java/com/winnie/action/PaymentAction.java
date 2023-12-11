package com.winnie.action;

import com.winnie.app.bean.PaymentBeanI;
import com.winnie.app.model.entity.Payment;
import com.winnie.app.model.entity.Tenant;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/payment")
public class PaymentAction extends BaseAction {

    @EJB
    private  PaymentBeanI paymentBean ;

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession httpSession = req.getSession();

        String deletePaymentId = req.getParameter("deletePaymentId");

        if (deletePaymentId != null && !deletePaymentId.isEmpty()) {
            Long paymentId = Long.valueOf(deletePaymentId);
            paymentBean.delete(Payment.class, paymentId);
        }


        renderPage(req, resp, 3, Payment.class,paymentBean.list(new Payment()));



    }


        public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
            paymentBean.add(serializeForm(Payment.class, req.getParameterMap()));

            try {
                renderPage(req, resp, 3, Payment.class,paymentBean.list(new Payment()));
            } catch (ServletException e) {
                throw new RuntimeException(e);
            }

        }







}

