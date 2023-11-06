package com.winnie.action;

import com.winnie.app.View.dropdown.HouseTypeDropDown;
import com.winnie.app.View.html.AppPage;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/registerUser")
public class RegisterUser extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter print = resp.getWriter();
        print.write("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "  <title>Login</title>\n" +
                "\n" +
                "  <style>\n" +
                "    body {\n" +
                "      font-family: Arial, sans-serif;\n" +
                "      text-align: center;\n" +
                "    }\n" +
                "\n" +
                "    .login-container {\n" +
                "      background-color: #fff;\n" +
                "      width: 400px;\n" +
                "      margin: 50px auto;\n" +
                "      padding: 20px;\n" +
                "      border-radius: 5px;\n" +
                "      box-shadow: 0 0 5px rgba(0, 0, 0, 0.2);\n" +
                "    }\n" +
                "\n" +
                "    h2 {\n" +
                "      color: rgb(1, 69, 171);\n" +
                "    }\n" +
                "\n" +
                "    form {\n" +
                "      text-align: left;\n" +
                "    }\n" +
                "\n" +
                "    input[type=\"text\"],\n" +
                "    input[type=\"password\"] {\n" +
                "      width: 95%;\n" +
                "      padding: 10px;\n" +
                "      margin: 10px 0;\n" +
                "      border: 1px solid #ccc;\n" +
                "      border-radius: 5px;\n" +

                "    }\n" +
                "\n" +
                "    input[type=\"text\"]:focus,\n" +
                "    input[type=\"password\"]:focus {\n" +
                "      border-color: rgb(238, 238, 238);\n" +
                "      outline: none;\n" +
                "    }\n" +
                "\n" +
                "    input[type=\"submit\"] {\n" +
                "      background-color: rgb(0, 53, 133);\n" +
                "      color: #fff;\n" +
                "      padding: 10px 20px;\n" +
                "      border: none;\n" +
                "      border-radius: 10px;\n" +
                "      cursor: pointer;\n" +
                "    }\n" +
                "  </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "<div class=\"login-container\">\n" +

                "  <br> <br>\n" +
                "  <h3>Register User</h3>\n" +
                "  <form action=\"./user\" method=\"post\">\n" +
                "    <label for=\"username\">Username:</label>\n" +
                "    <input type=\"text\"  name=\"username\" required />\n" +
                "\n" +
                "    <label for=\"password\">Password:</label>\n" +
                "    <input type=\"password\" name=\"password\" required>\n" +
                "\n" +
                "    <label >Confirm Password:</label>\n" +
                "    <input type=\"password\" name=\"confirmPassword\" required>\n" +
                "\n" +
                "    <input type=\"submit\"  />\n" +
                "\n" +
                "  </form>\n" +
                "<a href=\"./\">Back to Login</a>"+
                "</div>\n" +
                "</body>\n" +
                "</html>");
    }

}