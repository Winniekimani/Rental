package com.winnie.index;

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

        PrintWriter print = resp.getWriter();

        if (username.equals("winnie") && password.equals("kimani")){
            print.write("welcome to rental software");
        }else{
            print.write("<html><body>invalid login details<a href =\".\">Login again</a></body></html>");
        }

    }
}
