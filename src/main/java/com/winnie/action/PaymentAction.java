package com.winnie.action;

import com.winnie.app.bean.PaymentBeanI;
import com.winnie.app.model.entity.Payment;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/payment")
public class PaymentAction extends BaseAction {

    @EJB
    private  PaymentBeanI paymentBean ;

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



        renderPage(req, resp, 3, Payment.class,paymentBean.list(Payment.class));



    }


        public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
            paymentBean.add(serializeForm(Payment.class, req.getParameterMap()));

            resp.sendRedirect("./payment");

        }







}

