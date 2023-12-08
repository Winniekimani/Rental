package com.winnie.app.bean;

import com.winnie.app.model.entity.AuditLog;

import javax.ejb.Singleton;
import javax.enterprise.event.Observes;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;

@Singleton
public class AuditLogBean implements Serializable {

    @PersistenceContext
    private EntityManager em;

    public void log(@Observes AuditLog auditLog){
        System.out.println("Adding audit log!!");
        em.merge(auditLog);
    }

}
