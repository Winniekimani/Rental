package com.winnie.utility;

import com.winnie.app.bean.TenantBeanI;
import com.winnie.app.model.entity.Tenant;

import javax.ejb.EJB;
import java.io.Serializable;
import java.util.List;

public class SelectBoxStore implements Serializable {


    @EJB
    private TenantBeanI tenantBean;


    public List<Tenant> tenants(){
        return tenantBean.list(new Tenant());
    }

}

