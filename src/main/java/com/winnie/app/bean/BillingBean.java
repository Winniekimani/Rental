package com.winnie.app.bean;

import com.winnie.app.model.entity.Billing;
import com.winnie.app.model.entity.Tenant;
import com.winnie.utility.TransactIonNoGenerator;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Stateless
public class BillingBean extends GenericBean<Billing> implements BillingBeanI,Serializable {

    @PersistenceContext
    EntityManager em;
    @Inject
  /*  @BillNo*/
    @Named("bill")
    private TransactIonNoGenerator txnNoGenerator;

    @Override
    public Billing add(Billing billing) {
        if (billing.getPaymentDate() == null) {
            billing.setPaymentDate(new Date());
        }


        if (billing.getTenantId()==null){
            throw new RuntimeException("tenant is required");
        }

        // Generate and set the bill number
        billing.setBillNo(txnNoGenerator.generate());

        billing.setTenant(getDao().getEm().find(Tenant.class,billing.getTenantId()));

        billing= getDao().add(billing);
        return getDao().add(billing);


    }
    @Override
    public void delete (Class<?> klass, Long id){
        Billing o = em.find(Billing.class, id);
        em.remove(o);
    }

    @Override
    public List<Billing> getBillingListByEmail(String email) {
        return em.createQuery("FROM Billing billing WHERE billing.tenant.email = :email", Billing.class)
                .setParameter("email", email)
                .getResultList();


    }

    @Override
    public List<Billing> getBillingByTenantId(Long tenantId) {
        return em.createQuery("FROM Billing billing WHERE billing.tenantId =:tenantId", Billing.class)
                .setParameter("tenantId", tenantId)
                .getResultList();


    }


}
