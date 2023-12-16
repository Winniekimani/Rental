package com.winnie.action;

import com.winnie.app.bean.BillingBeanI;
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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/tenant")
public class TenantAction extends BaseAction {

    @EJB
    private TenantBeanI tenantBean ;
    @EJB
    private BillingBeanI billingBean;
    public void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {

        HttpSession httpSession = req.getSession();

        String deleteTenantId = req.getParameter("deleteTenantId");

        if (deleteTenantId != null && !deleteTenantId.isEmpty()) {
            Long tenantId = Long.valueOf(deleteTenantId);
            tenantBean.delete(Tenant.class, tenantId);
        }


        renderPage(req,resp,2, Tenant.class,tenantBean.list(new Tenant()) );





    }
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Tenant tenant = serializeForm(Tenant.class, req.getParameterMap());




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






    }


}







