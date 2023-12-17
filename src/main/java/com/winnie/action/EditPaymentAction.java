package com.winnie.action;

import com.winnie.app.View.html.HtmlComponent;
import com.winnie.app.bean.PaymentBeanI;
import com.winnie.app.bean.TenantBeanI;
import com.winnie.app.model.entity.Payment;
import com.winnie.app.model.entity.Tenant;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/edit-payment")
public class EditPaymentAction extends BaseAction{

    @PersistenceContext
    EntityManager em;
    @EJB
    PaymentBeanI paymentBean;
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();

        String editPaymentId = req.getParameter("editPaymentId");
        if (editPaymentId != null && !editPaymentId .isEmpty()) {
            Long paymentId = Long.valueOf(editPaymentId);
            Payment payment = em.find(Payment.class,paymentId);
            payment.setId(paymentId);
            req.setAttribute("content", HtmlComponent.editHtmlForm(Payment.class,payment));
            RequestDispatcher dispatcher=req.getRequestDispatcher("./app/index.jsp");
            dispatcher.forward(req,resp);
        }

    }
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        Payment payment = serializeForm(Tenant.class,req.getParameterMap());


        try {
            paymentBean.edit(payment,"id",payment.getId());
            renderPage(req,resp,1, Payment.class, paymentBean.list(new Payment()));
            /*  resp.sendRedirect("./house");*/
        } catch (Exception e) {
            throw new RuntimeException(e);
        }



    }






}