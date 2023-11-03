package com.winnie.home;

import com.winnie.app.bean.HouseBean;
import com.winnie.app.bean.HouseBeanI;
import com.winnie.app.model.House;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/home")
public class Home extends HttpServlet {
    public  void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {


        ServletContext ctx=getServletContext();


        /*String homeInfo=(String) req.getAttribute("homeInfo");

            PrintWriter print = resp.getWriter();
            print.write("<html><body><a href =\".\">" +homeInfo +"</a></body></html>");*/

       /* RequestDispatcher requestDispatcher= req.getRequestDispatcher("./app/Home.html");
        requestDispatcher.forward(req,resp);*/

        HouseBeanI housebean = new HouseBean();

        PrintWriter print = resp.getWriter();
        print.write("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "    <style>\n" +
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
                 "welcome"+ctx.getAttribute("username")+"</br>"+
                "\n" +
                "<h2>List of Available Houses</h2>\n" );
        print.write(housebean.listOfHousesAvailable());
        print.write("\n" +
                "</body>\n" +
                "</html>");

    }



}
