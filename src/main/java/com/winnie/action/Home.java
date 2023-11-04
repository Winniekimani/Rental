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

@WebServlet("/home")
public class Home extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        HttpSession httpSession= req.getSession();
        if (StringUtils.isNotBlank((String) httpSession.getAttribute("loggedIn"))){

            HouseBeanI housebean = new HouseBean();
            new AppPage().renderHtml(req,resp,0,"<h2>List of Available Houses</h2>\n"+
                    "<br/>Add House<br/><form action=\"./houses\" method=\"post\">" +

                    "<label for=\"houseType\">House Type:</label><br>" +
                    "<input type=\"text\" id=\"houseType\" name=\"houseType\"><br>"+
                   " <label for=\"houseLocation\">House Location:</label><br>"+
                    "<input type=\"text\" id=\"houseLocation\" name=\"houseLocation\"><br>"+
                   " <label for=\"housePrice\">House Price:</label><br>"+
                    "<input type=\"text\" id=\"housePrice\" name=\"housePrice\"><br><br>"+
                    "<input type=\"submit\" value=\"Add House\">" +
                    "</form><br/>"+housebean.listOfHousesAvailable());


            /*PrintWriter print = resp.getWriter();

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
                    ................. +
                    "welcome" + ctx.getAttribute("username") + "</br>\n" +
                    "<h2>List of Available Houses</h2>\n" +
                    "<table>\n" + housebean.listOfHousesAvailable() + "</table>\n" +
                    "serverInfo:" + ctx.getServerInfo() + "</br>\n" +
                    "<a href=\"./logout\">Logout</a>\n" +
                    "</body>\n" +
                    "</html>");
*/
        }

        else{
            resp.sendRedirect("./");
        }



    }



}
