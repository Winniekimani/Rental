package com.winnie.auth;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(urlPatterns = "/login")

public class Login extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        HttpSession httpSession= req.getSession();
        if (StringUtils.isNotBlank((String) httpSession.getAttribute("loggedIn")))
        resp.sendRedirect("./home");
        else
            resp.sendRedirect("./");


    }
        public  void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {



            HttpSession httpSession= req.getSession(true);
            httpSession.setAttribute("loggedIn",new Date().getTime() + "");

            ServletContext ctx=getServletContext();
        String username=req.getParameter("username");
        String password=req.getParameter("password");



        if (username.equals(ctx.getInitParameter("username")) &&
                password.equals(ctx.getInitParameter("password"))){
            ctx.setAttribute("username",username);

            resp.sendRedirect("./home");
            //RequestDispatcher requestDispatcher=req.getRequestDispatcher("./home");
            //requestDispatcher.forward(req,resp);
            //resp.sendRedirect("./app/Home.html");
        }else{
            PrintWriter print = resp.getWriter();
            //print.write("welcome to rental software");
            print.write("<html><body>invalid login details<a href =\".\">Login again</a></body></html>");
        }

    }
}
