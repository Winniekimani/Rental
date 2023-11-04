package com.winnie.app.View.html;

import com.winnie.app.View.css.AppCss;
import com.winnie.app.View.toolbar.TopToolBar;

import javax.servlet.ServletContext;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.io.Serializable;

public class AppPage implements Serializable {

    public void renderHtml(HttpServletRequest req, HttpServletResponse resp,
                           int activeMenu, String content) throws IOException {

        HttpSession session= req.getSession();


        ServletContext ctx = req.getServletContext();

        PrintWriter print = resp.getWriter();

        print.write("<!DOCTYPE html>" +
                "<html>" +

                "<head>" +
                new AppCss().getStyle() +
                "</head>" +

                "<body>" +

                new TopToolBar().menu(activeMenu) +

                //"<h3>" + ctx.getInitParameter("AppName") + "<h3>" +
                "<br/>&nbsp;<br/>" +
                "<h3>Welcome: " + session.getAttribute("username") + "</h3><br/>");

        print.write(content);
        print.write("<a href=\"./logout\">Logout</a>" +
                "</body>" +
                "</html>");
    }

}
