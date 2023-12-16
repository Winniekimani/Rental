package com.winnie.action;

import com.winnie.app.View.html.HtmlComponent;
import com.winnie.app.bean.HouseBeanI;
import com.winnie.app.model.entity.House;
import com.winnie.app.model.entity.Tenant;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/edit-house")
public class EditHouseAction extends BaseAction{

    @PersistenceContext
    EntityManager em;
    @EJB
    HouseBeanI houseBean;
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();

        String editHouseId = req.getParameter("editHouseId");
        if (editHouseId != null && !editHouseId.isEmpty()) {
            Long houseId = Long.valueOf(editHouseId);
            House house = em.find(House.class,houseId);
            req.setAttribute("content", HtmlComponent.editHtmlForm(House.class,house));
            RequestDispatcher dispatcher=req.getRequestDispatcher("./app/index.jsp");
            dispatcher.forward(req,resp);
        }

    }
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        House house = serializeForm(House.class,req.getParameterMap());


        try {
            houseBean.edit(house,"id",house.getId());
            renderPage(req,resp,1, House.class, houseBean.list(new House()));
            /*  resp.sendRedirect("./house");*/
        } catch (Exception e) {
            throw new RuntimeException(e);
        }



        }






}
