package com.winnie.action;

import com.winnie.app.View.html.HtmlComponent;
import com.winnie.app.bean.HouseBean;
import com.winnie.app.bean.HouseBeanI;
import com.winnie.app.model.entity.House;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/house-action")
public class HouseAction extends BaseAction {

    private HouseBeanI houseBean = new HouseBean();
    /*private House house = new House();*/

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();


       renderPage(req,resp,1, House.class, houseBean.list(House.class));
    }
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        House house = serializeForm(House.class,req.getParameterMap());

        try {
            houseBean.add(house);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        resp.sendRedirect("./house-action");






    }
}


