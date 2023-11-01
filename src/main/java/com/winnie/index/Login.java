package com.winnie.index;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class Login extends HttpServlet {
    public  void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {


        String username=req.getParameter("username");
        String password=req.getParameter("password");



        if (username.equals("winnie") && password.equals("kimani")){
            RequestDispatcher requestDispatcher=req.getRequestDispatcher("./app/Home.html");
            requestDispatcher.include(req,resp);
        }else{
            PrintWriter print = resp.getWriter();
            //print.write("welcome to rental software");
            print.write("<html><body>invalid login details<a href =\".\">Login again</a></body></html>");
        }

    }
}
