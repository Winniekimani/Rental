package com.winnie.action;

import com.winnie.app.bean.UserBean;
import com.winnie.app.bean.UserBeanI;
import com.winnie.app.model.entity.House;
import com.winnie.app.model.entity.User;
import com.winnie.database.Database;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;

@WebServlet("/user")
public class UserAction extends BaseAction {
    UserBeanI userBean= new UserBean();
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        try {
            userBean.register(serializeForm(User.class, req.getParameterMap()));
        } catch (Exception ex){
            ex.printStackTrace();
        }

        resp.sendRedirect("./");

            /*User registerUser=new User();
            serializeForm(User.class,req.getParameterMap());

        try {
            userBean.register(registerUser);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        resp.sendRedirect("./");*/




    }
}