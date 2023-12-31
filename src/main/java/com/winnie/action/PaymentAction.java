package com.winnie.action;

import com.winnie.app.View.html.HtmlComponent;
import com.winnie.app.bean.PaymentBeanI;
import com.winnie.app.model.entity.House;
import com.winnie.app.model.entity.Payment;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
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


        String action =req.getParameter("action");
        if (action!=null && action.equals("update")) {
            String editPaymentId = req.getParameter("editPaymentId");
            if (editPaymentId != null && !editPaymentId .isEmpty()) {
                Long paymentId = Long.valueOf(editPaymentId);
                Payment payment = paymentBean.find(Payment.class,paymentId);
                payment.setId(paymentId);
                req.setAttribute("content", HtmlComponent.editHtmlForm(Payment.class,payment));
                RequestDispatcher dispatcher=req.getRequestDispatcher("./app/index.jsp");
                dispatcher.forward(req,resp);
            }
        }


        HttpSession httpSession = req.getSession();

        String deletePaymentId = req.getParameter("deletePaymentId");

        if (deletePaymentId != null && !deletePaymentId.isEmpty()) {
            Long paymentId = Long.valueOf(deletePaymentId);
            paymentBean.delete(Payment.class, paymentId);
        }


        renderPage(req, resp, 3, Payment.class,paymentBean.list(new Payment()));



    }


        public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {


            Payment payment= serializeForm(Payment.class,req.getParameterMap());
/*
            Long paymentId = Long.valueOf(req.getParameter("id"));*/
           /* payment.setId(paymentId);*/
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
                paymentBean.add(payment);
                renderPage(req, resp, 3, Payment.class,paymentBean.list(new Payment()));
            } catch (ServletException e) {
                throw new RuntimeException(e);
            }

        }







}

