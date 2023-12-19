package com.winnie.action;

import com.winnie.app.bean.AuthBeanI;
import com.winnie.app.bean.BillingBeanI;
import com.winnie.app.bean.TenantBeanI;
import com.winnie.app.model.entity.Tenant;
import com.winnie.app.model.entity.User;
import org.apache.commons.lang3.StringUtils;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

@WebServlet(urlPatterns = "/login")

public class LoginAction extends BaseAction {

    @EJB
    AuthBeanI authBean;
    @EJB
    TenantBeanI tenantBean;

    @EJB
    BillingBeanI billingBean;

    ServletContext servletCtx = null;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        servletCtx = config.getServletContext();
    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        if (StringUtils.isNotBlank((String) httpSession.getAttribute("loggedIn")))
            resp.sendRedirect("./home");
        else {
            servletCtx.setAttribute("loginError", "");
            resp.sendRedirect("./");
        }
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println(">>>>>>>>>>>>>>>>");

        User loginUser = serializeForm(User.class, req.getParameterMap());


        try {
            servletCtx.setAttribute("loginError", "");
            User userDetails = authBean.authenticate(loginUser);
            System.out.println("user details " + userDetails);

            if (userDetails != null) {


                HttpSession httpSession = req.getSession(true);
                httpSession.setAttribute("loggedIn", new Date().getTime() + "");
                httpSession.setAttribute("username", loginUser.getUsername());
                httpSession.setAttribute("activeMenu", 0);

                Tenant tenant = tenantBean.tenantByEmail(userDetails.getEmail());
                if (tenant != null) {
                    httpSession.setAttribute("tenant", tenant);
                }

                if (userDetails.getUserRole().equals("tenant")) {
                    httpSession.setAttribute("email", userDetails.getEmail());
                    httpSession.setAttribute("tenantBean", tenantBean);
                    httpSession.setAttribute("billingBean", billingBean);
                    RequestDispatcher dispatcher = req.getRequestDispatcher("./tenant_page.jsp");
                    dispatcher.forward(req, resp);
                  /*  resp.sendRedirect("./tenant_page.jsp");*/
                }
                    resp.sendRedirect("./home.jsp");

            }
        } catch (SQLException | RuntimeException e) {
            servletCtx.setAttribute("loginError", "Invalid Login Details");
            resp.sendRedirect("./index.jsp");
        }


    }
}


