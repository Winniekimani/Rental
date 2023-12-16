package com.winnie.app.bean;
import com.winnie.app.model.entity.House;
import com.winnie.app.model.entity.Tenant;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

@Stateless
@Named("tenantBean")
@Remote
public class TenantBean extends GenericBean<Tenant> implements TenantBeanI, Serializable {

    @PersistenceContext
    EntityManager em;
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
    @Override
    public Tenant tenantByEmail(String email) {
        try {
            return em.createQuery("FROM Tenant t WHERE t.email=:email", Tenant.class)
                    .setParameter("email", email)
                    .getSingleResult();
        } catch (NoResultException e) {
            // Handle the case when no result is found, for example, return null or throw a custom exception.
            return null; // or throw a custom exception if needed
        }
    }

    public List<Tenant> tenantListByEmail(String email) {
        return em.createQuery("FROM Tenant t WHERE t.email = :email", Tenant.class)
                .setParameter("email", email)
                .getResultList();
    }


    @Override
    public List<Tenant> getList() {
        return em.createQuery("FROM Tenant t", Tenant.class).getResultList();
    }



}
