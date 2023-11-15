package com.winnie.action;

import com.winnie.app.View.html.HtmlComponent;
import com.winnie.app.model.entity.Payment;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/payments")
public class Payments  extends BaseAction {


    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        renderPage(req, resp, 3, HtmlComponent.htmlForm(Payment.class));


    }
}

