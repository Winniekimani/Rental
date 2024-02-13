package com.winnie.rest.api;

import com.winnie.app.bean.HouseBean;
import com.winnie.app.bean.HouseBeanI;
import com.winnie.app.model.entity.House;

import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/house")
public class HouseRestApi extends BaseRestApi{
    @EJB private HouseBeanI houseBean;

    @RolesAllowed("LOGGED-IN")
    @Path("/add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response add(House house) {

       house=houseBean.add(house);
       return respond();

    }

    @Path("/list")
    @RolesAllowed("LOGGED-IN")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list(){
        return respond(houseBean.list(new House()));
    }

    @Path("/delete/{id}")
    @RolesAllowed("LOGGED-IN")
    @DELETE
    public Response delete(@PathParam("id") Long id){
        houseBean.delete(House.class,id);
        return Response.status(Response.Status.OK).entity("Delete Successful").build();
    }
}

