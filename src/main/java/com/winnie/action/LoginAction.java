package com.winnie.action;

import com.winnie.app.bean.AuthBean;
import com.winnie.app.bean.AuthBeanI;
import com.winnie.app.model.entity.User;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;

@WebServlet(urlPatterns = "/login")

public class LoginAction extends BaseAction {

    AuthBeanI authBean = new AuthBean();

    public void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        HttpSession httpSession= req.getSession();
        if (StringUtils.isNotBlank((String) httpSession.getAttribute("loggedIn")))

        resp.sendRedirect("./home");
        else
            resp.sendRedirect("./");

    }
        public  void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {

        User loginUser= new User();
        serializeForm(User.class,req.getParameterMap());

            User userDetails= null;
            try {
                userDetails = authBean.authenticate(loginUser);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            if (userDetails!=null ){
            HttpSession httpSession= req.getSession(true);
            httpSession.setAttribute("loggedIn",new Date().getTime() + "");
            httpSession.setAttribute("username",loginUser.getUsername());
            httpSession.setAttribute("activeMenu",0);

            resp.sendRedirect("./home");

        }

            PrintWriter print = resp.getWriter();
            print.write("<html><body>invalid login details<a href =\".\">Login again</a></body></html>");



    }
}


