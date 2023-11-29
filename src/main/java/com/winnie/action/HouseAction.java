package com.winnie.action;

import com.winnie.app.View.html.HtmlComponent;
import com.winnie.app.bean.HouseBean;
import com.winnie.app.bean.HouseBeanI;
import com.winnie.app.model.entity.House;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/house")
public class HouseAction extends BaseAction {

    @EJB private HouseBeanI houseBean;


    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();


/*
        // TODO Auto-generated method stub
        String action = req.getParameter("action");
        int id = Integer.parseInt(req.getParameter("id"));

        if(action.equals("delete"))
            // get the user element by Id
            houseBean.delete((House)houseBean.getByID(id, new House()),id);
*/


        renderPage(req,resp,1, House.class, houseBean.list(House.class));
    }
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        House house = serializeForm(House.class,req.getParameterMap());

        try {
            houseBean.add(house);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        resp.sendRedirect("./house");



    }



}


