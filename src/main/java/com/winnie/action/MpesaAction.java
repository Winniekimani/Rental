package com.winnie.action;

import com.winnie.app.bean.GlobalBean;
import com.winnie.app.model.entity.Booking;
import com.winnie.app.model.entity.House;
import com.winnie.app.model.entity.Tenant;
import com.winnie.app.model.entity.User;
import com.winnie.utility.BasicAuthHelper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/mpesa-action")
public class MpesaAction extends HttpServlet {

    @Inject
    GlobalBean globalBean;


    public void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {


        HttpSession httpSession= req.getSession();
        User user= (User) httpSession.getAttribute("user");
        String amount = req.getParameter("housePrice");
        String slicedAmount=amount.substring(0,amount.indexOf('.'));
        String finalAmount=slicedAmount.substring(0,slicedAmount.length()-1);

        Tenant tenant= (Tenant) httpSession.getAttribute("tenant");
        String phoneNumber=tenant.getPhone();
        char numberSeven='7';
        int indexOfSeven=phoneNumber.indexOf(numberSeven);
        String subStringPhoneNumber=phoneNumber.substring(indexOfSeven);
        String finalPhoneNumber="254"+subStringPhoneNumber;


        String endPoint = "http://localhost:8080/Rental/rest/house-payments/pay?amount="+finalAmount+"&phoneNumber="+finalPhoneNumber+"";
        OkHttpClient client = new OkHttpClient();



        String username = user.getUsername();
        String password = user.getPassword();

        // Encode credentials in Base64
        String credentials = BasicAuthHelper.encodeCredentials(username, password);

        Request request = new Request.Builder()
                .url(endPoint)
                .header("Authorization", "Basic " + credentials)
                .build();

        try {
            Response response = client.newCall(request).execute();

            // Get the response code
            int statusCode = response.code();
            System.out.println("Response Code: " + statusCode);

            // Read the response data
            String responseData = response.body().string();
            System.out.println("Response Data: " + responseData);

        } catch (IOException e) {
            e.printStackTrace();
        }
        resp.sendRedirect(endPoint);

    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
