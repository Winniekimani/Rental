package com.winnie.rest.api;

import com.winnie.app.bean.MpesaBeanI;

import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

@Path("/house-payments")
public class MpesaRestApi extends BaseRestApi{

    @EJB
    MpesaBeanI mpesaBean;
    @Path("/pay")
    @RolesAllowed("LOGGED-IN")
    @GET
    @Produces(MediaType.APPLICATION_JSON)

    public Response pay(@QueryParam("amount") String amount, @QueryParam("phoneNumber") String phoneNumber ) throws IOException {
        String stkPush = mpesaBean.STKPushSimulation(amount, phoneNumber);
        return respond(stkPush);
    }


}
