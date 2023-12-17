package com.winnie.action;

import com.winnie.app.bean.BillingBeanI;
import com.winnie.app.bean.HouseBeanI;
import com.winnie.app.bean.TenantBeanI;
import com.winnie.app.model.entity.Billing;
import com.winnie.app.model.entity.House;
import com.winnie.app.model.entity.Tenant;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(urlPatterns = {"/tenant", "/tenant-edit-as-tenant"})
public class TenantAction extends BaseAction {

    @EJB
    private TenantBeanI tenantBean;
    @EJB
    private BillingBeanI billingBean;

  /*  @EJB
    private HouseBeanI houseBean;*/

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession httpSession = req.getSession();

        String deleteTenantId = req.getParameter("deleteTenantId");

        if (deleteTenantId != null && !deleteTenantId.isEmpty()) {
            Long tenantId = Long.valueOf(deleteTenantId);
            tenantBean.delete(Tenant.class, tenantId);
        }


        renderPage(req, resp, 2, Tenant.class, tenantBean.list(new Tenant()));


    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Tenant tenant = serializeForm(Tenant.class, req.getParameterMap());

        Long tenantId = Long.valueOf(req.getParameter("modelName"));
        tenant.setId(tenantId);

        try {
            // Add the tenant and retrieve the added tenant with generated ID
            tenant = tenantBean.add(tenant);

            // Retrieve the updated tenant from the database
            tenant = tenantBean.tenantByEmail(tenant.getEmail());


            List<Billing> billingList = billingBean.getBillingListByEmail(tenant.getEmail());
            // Set billingList to the tenant
            tenant.setBillings(billingList);

            tenantBean.add(tenant);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        resp.sendRedirect("./tenant");


       /* // Retrieve the existing tenant from the database
        Tenant existingTenant = tenantBean.tenantByEmail(tenant.getEmail());

        // Update the properties of the existing tenant
        try {
            BeanUtils.copyProperties(existingTenant, tenant);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }*/
/*
        if (tenant.getHouseId() != null) {
            // Retrieve the House from the database based on houseId
            House house = houseBean.findById(tenant.getHouseId()); // Assuming you have a method like this in your HouseBean
            existingTenant.setHouse(house);*/

            if (req.getServletPath().equals("/tenant-edit-as-tenant")) {
                // You don't need to add the tenant here; it's already updated
                tenantBean.add(tenant);
                resp.sendRedirect("./tenant_page.jsp");
            }
        }


    }








