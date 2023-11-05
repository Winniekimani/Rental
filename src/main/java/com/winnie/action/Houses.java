package com.winnie.action;

import com.winnie.app.View.html.AppPage;
import com.winnie.app.model.entity.House;
import com.winnie.database.Database;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet("/houses")
public class Houses extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        HttpSession httpSession= req.getSession();
        if (StringUtils.isNotBlank((String) httpSession.getAttribute("loggedIn"))){
            ServletContext ctx=getServletContext();

            new AppPage().renderHtml(req, resp, 1,
                    "<h2>Houses</h2> available houses are here");

        }

        else{
            resp.sendRedirect("./");
        }



    }



}
