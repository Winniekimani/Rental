package com.winnie.action;

import com.winnie.app.View.html.HtmlComponent;
import com.winnie.app.bean.BillingBeanI;
import com.winnie.app.bean.TenantBeanI;
import com.winnie.app.model.entity.Billing;
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


@WebServlet("/edit-billing")
public class EditBillingAction extends BaseAction{

    @PersistenceContext
    EntityManager em;
    @EJB
    BillingBeanI billingBean;
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();

        String editBillingId = req.getParameter("editBillingId");
        if (editBillingId != null && !editBillingId .isEmpty()) {
            Long billingId = Long.valueOf(editBillingId);
            Billing billing = em.find(Billing.class,billingId);
            billing.setId(billingId);
            req.setAttribute("content", HtmlComponent.editHtmlForm(Billing.class,billing));
            RequestDispatcher dispatcher=req.getRequestDispatcher("./app/index.jsp");
            dispatcher.forward(req,resp);
        }

    }
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        Billing billing = serializeForm(Billing.class,req.getParameterMap());


        try {
            billingBean.edit(billing,"id",billing.getId());
            renderPage(req,resp,1, Billing.class, billingBean.list(new Billing()));
            /*  resp.sendRedirect("./house");*/
        } catch (Exception e) {
            throw new RuntimeException(e);
        }



    }






}