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

@WebServlet("/house")
public class HouseAction extends BaseAction {

    @EJB private HouseBeanI houseBean;


    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();


        String action = req.getParameter("action");

        if ("delete".equals(action)) {
            String idParameter = req.getParameter("id");

            if (StringUtils.isNotBlank(idParameter)) {
                try {
                    Long id = Long.parseLong(idParameter);

                    // Use the ID to delete the house using GenericBean
                    houseBean.deleteById(House.class, id);

                } catch (NumberFormatException e) {
                    // Handle the case where idParameter is not a valid Long
                    e.printStackTrace(); // Log the exception or handle it appropriately
                }
            }
        }



        renderPage(req,resp,1, House.class, houseBean.list(House.class));


    }
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        House house = serializeForm(House.class,req.getParameterMap());

        try {
            houseBean.add(house);
            renderPage(req,resp,1, House.class, houseBean.list(House.class));
          /*  resp.sendRedirect("./house");*/
        } catch (Exception e) {
            throw new RuntimeException(e);
        }






    }



}


