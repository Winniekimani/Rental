package com.winnie.auth;

import com.winnie.app.model.entity.User;
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
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(urlPatterns = "/login")

public class Login extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        HttpSession httpSession= req.getSession();
        /*if (StringUtils.isNotBlank((String) httpSession.getAttribute("loggedIn")))
        resp.sendRedirect("./houses");
        else*/
            resp.sendRedirect("./");

    }
        public  void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {



            ServletContext ctx=getServletContext();
        String username=req.getParameter("username");
        String password=req.getParameter("password");

            Database database = Database.getDbInstance();
            System.out.println("what time was this database created:" +database.getDatabaseCreateAt());

            for (User user : database.getUsers()){

                if (username.equals(user.getUsername()) && password.equals(user.getPassword())){
                    HttpSession httpSession= req.getSession(true);
                    httpSession.setAttribute("loggedIn",new Date().getTime() + "");
                    httpSession.setAttribute("username",username);

                    resp.sendRedirect("./houses");

                }
            }
            PrintWriter print = resp.getWriter();
            print.write("<html><body>invalid login details<a href =\".\">Login again</a></body></html>");



        /*if (username.equals(ctx.getInitParameter("username")) &&
                password.equals(ctx.getInitParameter("password"))){
            httpSession.setAttribute("username",username);

            resp.sendRedirect("./home");

        }else{
            PrintWriter print = resp.getWriter();
            //print.write("welcome to rental software");
            print.write("<html><body>invalid login details<a href =\".\">Login again</a></body></html>");
        }*/

    }
}
