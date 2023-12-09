package com.winnie.app.bean;
import com.winnie.app.model.entity.House;
import com.winnie.app.model.entity.Tenant;
import org.apache.commons.lang3.StringUtils;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
@Stateless
public class TenantBean extends GenericBean<Tenant> implements TenantBeanI, Serializable {

    @Override
    public Tenant add(Tenant tenant){
        if (tenant==null)
            throw new RuntimeException("invalid tenant details");

        if (tenant.getHouseId()==null)
               throw new RuntimeException("house is required");

        tenant.setHouse(getDao().getEm().find(House.class,tenant.getHouseId()));

        if (tenant.getHouse()==null){
            throw new RuntimeException("invalid customer details");
        }

        tenant = getDao().add(tenant);

        return tenant;
    }


}
