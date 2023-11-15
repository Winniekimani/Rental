package com.winnie.action;

import com.winnie.app.View.html.HtmlComponent;
import com.winnie.app.model.entity.House;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet("/add")
public class AddHouse extends BaseAction{

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        renderPage(req,resp,1,HtmlComponent.htmlForm(House.class) + "<br/>" );


    }
}



