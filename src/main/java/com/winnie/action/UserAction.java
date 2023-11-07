package com.winnie.action;

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
import java.util.Date;

@WebServlet("/user")
public class UserAction extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

                HttpSession httpSession = req.getSession();
            Database database = Database.getDbInstance();

        String username= req.getParameter("username");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmPassword");

        if (password.equals(confirmPassword)){
            database.getUsers().add(new User(100L, username, password));

            httpSession.setAttribute("username",username);

            httpSession.setAttribute("loggedIn",new Date().getTime() + "");

            resp.sendRedirect("./houses");
        }
            resp.sendRedirect("./");




    }
}