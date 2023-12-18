package com.winnie.action;
import com.winnie.app.View.html.HtmlComponent;
import com.winnie.app.bean.HouseBeanI;
import com.winnie.app.model.entity.House;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
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
        String action =req.getParameter("action");
        if (action!=null && action.equals("update")) {
            String editHouseId = req.getParameter("editHouseId");
            if (editHouseId != null && !editHouseId.isEmpty()) {
                Long houseId = Long.valueOf(editHouseId);
                House house =houseBean.getById(houseId);
                house.setId(houseId);
                req.setAttribute("content", HtmlComponent.editHtmlForm(House.class,house));
                RequestDispatcher dispatcher=req.getRequestDispatcher("./app/index.jsp");
                dispatcher.forward(req,resp);
            }
        }

            String deleteHouseId = req.getParameter("deleteHouseId");
        if (deleteHouseId != null && !deleteHouseId.isEmpty()) {
            Long houseId = Long.valueOf(deleteHouseId);
            houseBean.delete(House.class, houseId);
        }
            renderPage(req,resp,1, House.class, houseBean.list(new House()));



    }
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {




        House house = serializeForm(House.class,req.getParameterMap());

        Long houseId =  Long.valueOf(req.getParameter("id"));
        house.setId(houseId);

        try {
            houseBean.add(house);
            renderPage(req,resp,1, House.class, houseBean.list(new House()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }




    }



}


