package com.winnie.action;

import com.winnie.app.bean.BookingBean;
import com.winnie.app.bean.BookingBeanI;
import com.winnie.app.bean.HouseBeanI;
import com.winnie.app.model.entity.Booking;
import com.winnie.app.model.entity.House;
import com.winnie.app.model.entity.Tenant;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

@WebServlet("/booking/*")
public class BookingAction extends BaseAction{

    @EJB
    private BookingBeanI bookingBean;

    @EJB
    private HouseBeanI houseBean;

    public void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {


        Booking  booking = serializeForm(Booking.class,req.getParameterMap());

        // Get houseId from the request parameter
        Long houseId = Long.parseLong(req.getParameter("houseId"));

        // Perform booking confirmation logic
        House house = houseBean.getById(houseId);
        Tenant tenant = (Tenant) req.getSession().getAttribute("tenant");
        Date bookingDate = new Date();  // You may want to customize the booking date logic

        booking = new Booking(house, tenant, bookingDate);
        bookingBean.addBooking(booking);

        // Update the house status to 'Booked'
        house.setHouseStatus("Booked");
        houseBean.update(house);



    }
}
