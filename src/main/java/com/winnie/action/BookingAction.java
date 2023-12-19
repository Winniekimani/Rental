package com.winnie.action;

import com.winnie.app.bean.BookingBeanI;
import com.winnie.app.bean.HouseBeanI;
import com.winnie.app.model.entity.Booking;
import com.winnie.app.model.entity.House;
import com.winnie.app.model.entity.Tenant;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/book-house")
public class BookingAction extends BaseAction{

    @EJB
    private BookingBeanI bookingBean;

    @EJB
    private HouseBeanI houseBean;

    public void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        System.out.println(" \nThis worked 1");
        Booking  booking = serializeForm(Booking.class, req.getParameterMap());

        Long houseId = Long.parseLong(req.getParameter("houseId"));

        System.out.println(" \nThis worked");
        House house = houseBean.getById(houseId);

        System.out.println("house Id" + house.getId());
        System.out.println("Tenant " + req.getSession().getAttribute("tenant"));
        Tenant tenant = (Tenant) req.getSession().getAttribute("tenant");

        System.out.println("Tenant Id \t"+tenant.getId());
        System.out.println("Tenant email \t"+tenant.getEmail());
        System.out.println("Tenant houseId \t" + tenant.getHouseId());



        booking = new Booking(house, tenant);
        bookingBean.addBooking(booking);

        house.setHouseStatus("Booked");
        houseBean.update(house);
        resp.sendRedirect("./vacant_houses.jsp");

    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(" \nThis worked 2");
    }
}