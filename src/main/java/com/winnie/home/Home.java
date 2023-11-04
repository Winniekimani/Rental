package com.winnie.home;

import com.winnie.app.bean.HouseBean;
import com.winnie.app.bean.HouseBeanI;
import com.winnie.app.model.House;
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
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/home")
public class Home extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        HttpSession httpSession= req.getSession();
        if (StringUtils.isNotBlank((String) httpSession.getAttribute("loggedIn"))){
            ServletContext ctx=getServletContext();

            HouseBeanI housebean = new HouseBean();

            PrintWriter print = resp.getWriter();

            print.write("<!DOCTYPE html>\n" +
                    "<html>\n" +
                    "<head>\n" +
                    "    <style>\n" +
                    "        ul.topnav {\n" +
                    "            list-style-type: none;\n" +
                    "            margin: 0;\n" +
                    "            padding: 0;\n" +
                    "            overflow: hidden;\n" +
                    "            background-color: #333;\n" +
                    "        }\n" +
                    "        ul.topnav li { float: left; }\n" +
                    "        ul.topnav li a {\n" +
                    "            display: block;\n" +
                    "            color: white;\n" +
                    "            text-align: center;\n" +
                    "            padding: 14px 16px;\n" +
                    "            text-decoration: none;\n" +
                    "        }\n" +
                    "        ul.topnav li a:hover { background-color: #ddd; }\n" +
                    "        ul.topnav li a.active { background-color: #04AA6D; }\n" +
                    "    </style>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "<ul class=\"topnav\">\n" +
                    "<li><a class=\"active\" href=\"./home\">Home</a></li>\n" +
                    "<li><a href=\"./homejournals\">HouseJournals</a></li>\n" +
                    "<li><a href=\"#tenants\">Tenants</a></li>\n" +
                    "<li><a href=\"#payments\">Payments</a></li>\n" +
                    "<li><a href=\"#houseTypes\">House Types</a></li>\n" +
                    "</ul>\n" +
                    "welcome" + ctx.getAttribute("username") + "</br>\n" +
                    "<h2>List of Available Houses</h2>\n" +
                    "<table>\n" + housebean.listOfHousesAvailable() + "</table>\n" +
                    "serverInfo:" + ctx.getServerInfo() + "</br>\n" +
                    "<a href=\"./logout\">Logout</a>\n" +
                    "</body>\n" +
                    "</html>");

        }

        else{
            resp.sendRedirect("./");
        }



    }



}
