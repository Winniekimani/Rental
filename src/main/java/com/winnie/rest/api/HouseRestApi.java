package com.winnie.rest.api;

import com.winnie.app.bean.HouseBean;
import com.winnie.app.bean.HouseBeanI;
import com.winnie.app.model.entity.House;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/house")
public class HouseRestApi extends BaseRestApi{
    @EJB private HouseBeanI houseBean;

    @Path("/add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response add(House house) {

       house=houseBean.add(house);
       return respond();

    }

    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list(){
        return respond(houseBean.list(new House()));
    }

}
