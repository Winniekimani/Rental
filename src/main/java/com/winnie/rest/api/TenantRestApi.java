package com.winnie.rest.api;

import com.winnie.app.bean.HouseBeanI;
import com.winnie.app.bean.TenantBeanI;
import com.winnie.app.model.entity.Billing;
import com.winnie.app.model.entity.House;
import com.winnie.app.model.entity.Tenant;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/tenant")
public class TenantRestApi extends BaseRestApi{
    @EJB
    private TenantBeanI tenantBean;

    @Path("/add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response add(Tenant tenant) {

        tenant=tenantBean.add(tenant);
        return respond();

    }

    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list(){
        return respond(tenantBean.list(new Tenant()));
    }

    @Path("/delete/{id}")
    @DELETE
    public Response delete(@PathParam("id") Long id){
        tenantBean.delete(Tenant.class,id);
        return Response.status(Response.Status.OK).entity("Delete Successful").build();

    }
}
