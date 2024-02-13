package com.winnie.rest.api;

import com.winnie.app.bean.BillingBeanI;
import com.winnie.app.bean.HouseBeanI;
import com.winnie.app.model.entity.Billing;
import com.winnie.app.model.entity.House;

import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/billing")
public class BillingRestApi extends BaseRestApi{
    @EJB
    private BillingBeanI billingBean;

    @Path("/add")
    @RolesAllowed("LOGGED-IN")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response add(Billing billing) {

        billing=billingBean.add(billing);
        return respond();

    }
    @Path("/list")
    @RolesAllowed("LOGGED-IN")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list(){
        return respond(billingBean.list(new Billing()));
    }

    @Path("/delete/{id}")
    @RolesAllowed("LOGGED-IN")
    @DELETE
    public Response delete(@PathParam("id") Long id){
        billingBean.delete(Billing.class,id);
        return Response.status(Response.Status.OK).entity("Delete Successful").build();

    }

    @Path("/tenant/{id}")
    @RolesAllowed("LOGGED-IN")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response tenantBill(@PathParam("id") Long id){
        return respond(billingBean.getBillingByTenantId(id));

    }

}
