package com.winnie.auth;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/login",initParams = {
        @WebInitParam(name="username",value="winnie"),
        @WebInitParam(name="password",value="kimani")
})

public class Login extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {

        resp.sendRedirect("./");
    }
        public  void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {

            ServletContext ctx=getServletContext();


        String username=req.getParameter("username");
        String password=req.getParameter("password");



        if (username.equals(ctx.getInitParameter("username")) &&
                password.equals(ctx.getInitParameter("password"))){
            ctx.setAttribute("username",username);

            RequestDispatcher requestDispatcher=req.getRequestDispatcher("./home");
            requestDispatcher.forward(req,resp);
            //resp.sendRedirect("./app/Home.html");
        }else{
            PrintWriter print = resp.getWriter();
            //print.write("welcome to rental software");
            print.write("<html><body>invalid login details<a href =\".\">Login again</a></body></html>");
        }

    }
}
