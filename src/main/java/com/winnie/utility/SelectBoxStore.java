package com.winnie.utility;

import com.winnie.app.bean.HouseBeanI;
import com.winnie.app.bean.TenantBeanI;
import com.winnie.app.model.entity.House;
import com.winnie.app.model.entity.Tenant;

import javax.ejb.EJB;
import java.io.Serializable;
import java.util.List;

public class SelectBoxStore implements Serializable {


    @EJB
    private TenantBeanI tenantBean;


    @EJB
    HouseBeanI houseBean;
    public List<Tenant> tenants(){
        return tenantBean.list(new Tenant());
    }

    public List<House> houses(){
        return houseBean.list(new House());
    }


}

