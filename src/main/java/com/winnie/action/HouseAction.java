package com.winnie.action;

import com.winnie.app.View.html.HtmlComponent;
import com.winnie.app.bean.HouseBean;
import com.winnie.app.bean.HouseBeanI;
import com.winnie.app.model.entity.House;
import org.apache.commons.lang3.StringUtils;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/house/*")
public class HouseAction extends BaseAction {

    @EJB private HouseBeanI houseBean;


    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();

        String deleteHouseId = req.getParameter("deleteHouseId");

        if (deleteHouseId != null && !deleteHouseId.isEmpty()) {
            Long houseId = Long.valueOf(deleteHouseId);
            houseBean.delete(House.class, houseId);
        }
        renderPage(req,resp,1, House.class, houseBean.list(new House()));


    }
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        House house = serializeForm(House.class,req.getParameterMap());

        try {
            houseBean.add(house);
            renderPage(req,resp,1, House.class, houseBean.list(new House()));
          /*  resp.sendRedirect("./house");*/
        } catch (Exception e) {
            throw new RuntimeException(e);
        }






    }



}


