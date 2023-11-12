package com.winnie.action;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/home")
public class HomeAction extends BaseAction {

    public void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        renderPage(req,resp,0,"<div class='HomePage'>" +

                "" +
                "" +
                "</div>" );

      /*  req.setAttribute("activeMenu",0);
        req.setAttribute("content","<div class='HomePage'>" +

                "" +
                "" +
                "</div>" );
        RequestDispatcher dispatcher=req.getRequestDispatcher(".app/index.jsp");
        dispatcher.forward(req,resp);*/


       /* new AppPage().renderHtml(req, resp, 0,
                "<div class='HomePage'>" +

                        "" +
                        "" +
                        "</div>" );*/

    }
}
