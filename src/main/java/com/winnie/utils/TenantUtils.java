package com.winnie.utils;

import com.winnie.app.model.entity.Tenant;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TenantUtils {
   /* // Method to parse a date string to a Date object
    public static Date parseStringToDate(String dateString) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.parse(dateString);
    }*/

    public static Tenant createTenant(String firstName, String lastName, String phone, String leaseStartDate, String leaseEndDate, double rentAmount, String houseId, String paymentStatus) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return new Tenant(firstName, lastName, phone, dateFormat.parse(leaseStartDate), dateFormat.parse(leaseEndDate), rentAmount, houseId, paymentStatus);
    }
}
