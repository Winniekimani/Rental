package com.winnie.action;

import com.winnie.app.View.html.AppPage;
import com.winnie.app.bean.HouseBean;
import com.winnie.app.bean.HouseBeanI;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/homejournals")
public class HomeJournal extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        HttpSession httpSession= req.getSession();
        if (StringUtils.isNotBlank((String) httpSession.getAttribute("loggedIn"))){
            ServletContext ctx=getServletContext();

            HouseBeanI houseBeanI = new HouseBean();
            new AppPage().renderHtml(req, resp, 1,
                    "<h2>Journals </h2> Journals list/register will go here");

           /* PrintWriter print = resp.getWriter();
            print.write("<!DOCTYPE html>\n" +
                    "<html>\n" +
                    "<head>\n" +
                    "    <style>\n" +
                    "  ul.topnav {\n" +
                    "      list-style-type: none;\n" +
                    "      margin: 0;\n" +
                    "      padding: 0;\n" +
                    "      overflow: hidden;\n" +
                    "      background-color: #333;\n" +
                    "    }\n" +
                    "\n" +
                    "    ul.topnav li { float: left; }\n" +
                    "\n" +
                    "    ul.topnav li a {\n" +
                    "      display: block;\n" +
                    "      color: white;\n" +
                    "      text-align: center;\n" +
                    "      padding: 14px 16px;\n" +
                    "      text-decoration: none;\n" +
                    "    }\n" +
                    "\n" +
                    "    ul.topnav li a:hover { background-color: #ddd; }\n" +
                    "\n" +
                    "    ul.topnav li a.active { background-color: #04AA6D; }" +
                    "        table {\n" +
                    "          font-family: arial, sans-serif;\n" +
                    "          border-collapse: collapse;\n" +
                    "          width: 100%;\n" +
                    "        }\n" +
                    "\n" +
                    "        td, th {\n" +
                    "          border: 1px solid #dddddd;\n" +
                    "          text-align: left;\n" +
                    "          padding: 8px;\n" +
                    "        }\n" +
                    "\n" +
                    "        tr:nth-child(even) {\n" +
                    "          background-color: #dddddd;\n" +
                    "        }\n" +
                    "    </style>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "<ul class=\"topnav\">\n "+
                    "<li><a href=\"./home\">Home</a></li>\n "+
                    "<li><a class=\"active\" href=\"./homejournals\">HouseJournals</a></li>\n "+
                    "<li><a href=\"#tenants\">Tenants</a></li>\n "+
                    "<li><a href=\"#payments\">Payments</a></li>\n "+
                    "<li><a href=\"#houseTypes\">House Types</a></li>\n "+
                    "</ul>" +
                    "welcome"+ctx.getAttribute("username")+"</br>"+
                    "\n" +
                    //"<a href=\"./home\">Go back home</a>" +
                    "<h2>journals</h2>\n" );
            print.write("</br>journals table");
            print.write("\n" +
                    "<a href=\"./logout\">Logout</a>" +
                    "</body>\n" +
                    "</html>");*/

        }

        else{
            resp.sendRedirect("./");
        }



    }

}
