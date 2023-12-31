package com.winnie.action;

import com.winnie.app.bean.UserBeanI;
import com.winnie.app.model.entity.User;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/user")
public class UserAction extends BaseAction {
    @EJB
    UserBeanI userBean;
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            User user = serializeForm(User.class, req.getParameterMap());
            userBean.register(user);
        } catch (Exception ex){
            ex.printStackTrace();
        }

        resp.sendRedirect("./");


    }
}