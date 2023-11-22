package com.winnie.action;

import com.winnie.app.View.html.HtmlComponent;
import com.winnie.app.bean.PaymentBean;
import com.winnie.app.bean.PaymentBeanI;
import com.winnie.app.model.entity.House;
import com.winnie.app.model.entity.Payment;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/payment-action")
public class Payments  extends BaseAction {

    private final PaymentBeanI paymentBean = new PaymentBean();

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PaymentBean paymentBean= new PaymentBean();

        renderPage(req, resp, 3, Payment.class,paymentBean.list(Payment.class));




    }


        public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
            paymentBean.add(serializeForm(Payment.class, req.getParameterMap()));

            resp.sendRedirect("./payment-action");

        }







}

