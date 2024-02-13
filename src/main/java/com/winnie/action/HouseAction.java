package com.winnie.action;
import com.winnie.app.View.html.HtmlComponent;
import com.winnie.app.bean.HouseBeanI;
import com.winnie.app.model.entity.House;
import com.winnie.app.model.entity.Payment;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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
    public void doPost(HttpServletRequest req, HttpServletResponse resp) {
       House house = serializeForm(House.class,req.getParameterMap());

        try {


            try {
                String idParameter = req.getParameter("id");
                if (idParameter != null) {
                    Long houseId = Long.valueOf(idParameter);


                } else {
                    System.err.println("Error: 'id' parameter is missing or null");
                }


            } catch (NumberFormatException e) {
                System.err.println("Error parsing 'id' parameter to Long: " + e.getMessage());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            houseBean.add(house);
            renderPage(req, resp, 1, House.class,houseBean.list(new House()));
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }

    }

    }






