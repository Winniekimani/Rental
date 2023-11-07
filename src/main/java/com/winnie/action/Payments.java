package com.winnie.action;

import com.winnie.app.View.html.AppPage;
import com.winnie.app.bean.HouseBean;
import com.winnie.app.bean.HouseBeanI;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/payments")
public class Payments  extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        HttpSession httpSession= req.getSession();



            new AppPage().renderHtml(req,resp,3,"<h2>Payments </h2>payment info available here");

    }




}

