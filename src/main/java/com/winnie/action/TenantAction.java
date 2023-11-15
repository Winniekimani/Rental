package com.winnie.action;

import com.winnie.app.bean.HouseBean;
import com.winnie.app.bean.HouseBeanI;
import com.winnie.app.bean.TenantBean;
import com.winnie.app.bean.TenantBeanI;
import com.winnie.app.model.entity.House;
import com.winnie.app.model.entity.HouseType;
import com.winnie.app.model.entity.Tenant;
import com.winnie.database.Database;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet("/tenant-action")
public class TenantAction  extends BaseAction{

    private TenantBeanI tenantBean = new TenantBean();
    private Tenant tenant = new Tenant();


    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        serializeForm(tenant,req.getParameterMap());

        try {
            tenantBean.addTenant(tenant);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


            resp.sendRedirect("./tenants");


        }
    }

