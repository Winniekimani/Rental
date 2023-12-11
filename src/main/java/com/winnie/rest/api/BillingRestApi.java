package com.winnie.rest.api;

import com.winnie.app.bean.BillingBeanI;
import com.winnie.app.bean.HouseBeanI;
import com.winnie.app.model.entity.Billing;
import com.winnie.app.model.entity.House;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/billing")
public class BillingRestApi extends BaseRestApi{
    @EJB
    private BillingBeanI billingBean;

    @Path("/add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response add(Billing billing) {

        billing=billingBean.add(billing);
        return respond();

    }

    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list(){
        return respond(billingBean.list(new Billing()));
    }

}
