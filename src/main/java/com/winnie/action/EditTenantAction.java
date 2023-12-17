package com.winnie.action;

import com.winnie.app.View.html.HtmlComponent;

import com.winnie.app.bean.TenantBeanI;

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

@WebServlet("/edit-tenant")
public class EditTenantAction extends BaseAction{

    @PersistenceContext
    EntityManager em;
    @EJB
    TenantBeanI tenantBean;
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();

        String editTenantId = req.getParameter("editTenantId");
        if (editTenantId != null && !editTenantId .isEmpty()) {
            Long tenantId = Long.valueOf(editTenantId);
            Tenant tenant = em.find(Tenant.class,tenantId);
            tenant.setId(tenantId);
            req.setAttribute("content", HtmlComponent.editHtmlForm(Tenant.class,tenant));
            RequestDispatcher dispatcher=req.getRequestDispatcher("./app/index.jsp");
            dispatcher.forward(req,resp);
        }

    }
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


       Tenant tenant = serializeForm(Tenant.class,req.getParameterMap());


        try {
            tenantBean.edit(tenant,"id",tenant.getId());
            renderPage(req,resp,1, Tenant.class, tenantBean.list(new Tenant()));
            /*  resp.sendRedirect("./house");*/
        } catch (Exception e) {
            throw new RuntimeException(e);
        }



    }






}