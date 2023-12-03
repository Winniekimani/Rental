package com.winnie.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/home")
public class HomeAction extends BaseAction {

    public void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("./home.jsp");
       dispatcher.forward(req,resp);

    }
}
