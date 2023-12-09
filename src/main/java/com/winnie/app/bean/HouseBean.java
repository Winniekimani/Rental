package com.winnie.app.bean;


import com.winnie.app.model.entity.AuditLog;
import com.winnie.app.model.entity.House;


import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

@Stateless
public class HouseBean extends GenericBean<House> implements HouseBeanI, Serializable {


  @Inject
    private Event<AuditLog> logger;

    public List<House> list() {
        return super.list(new House());
    }

    @Override
    public House add(House house){

       house = getDao().add(house);
        AuditLog log = new AuditLog();
        log.setLogDetails("A house of " + house.getHouseNo() + " was added at "
                + DateFormat.getDateTimeInstance().format(new Date()));
        log.setLogDetails("a new house with house number " +house.getHouseNo()+ "and name" + house.getHouseName() +" was added at "  + " in " +house.getHouseLocation() +"area");

        logger.fire(log);

        return house;
    }



    @Inject
    public void tryMethodInjection(){
        System.out.println("method injection trial............");
    }





}

