package com.winnie.event;

import com.winnie.app.model.entity.House;
import com.winnie.app.model.entity.HouseType;
import com.winnie.app.model.entity.User;
import com.winnie.database.Database;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.math.BigDecimal;

@WebListener
public class AppInit implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("************** Adding new user*********");

        Database database = Database.getDbInstance();
        database.getUsers().add(new User(0L,"kimani.com","0000"));
        database.getUsers().add(new User(0L,"vinny.com","1992"));
        database.getUsers().add(new User(0L,"njeri.com","1995"));



        System.out.println("************** Adding Houses*********");
        database.getHouses().add(new House("1","20A", HouseType.BEDSITTER_APARTMENT,"kawangware", BigDecimal.valueOf(20000)));
        database.getHouses().add(new House("2","1A",HouseType.BUNGALOW,"roysambu", BigDecimal.valueOf(120000)));
        database.getHouses().add(new House("3","3A", HouseType.MANSION,"runda", BigDecimal.valueOf(8500000)));
        database.getHouses().add(new House("4","12A", HouseType.FARMHOUSE,"kilimani", BigDecimal.valueOf(50000)));
        database.getHouses().add(new House("5","9A", HouseType.AIRBNB,"garden-city", BigDecimal.valueOf(2500)));
        database.getHouses().add(new House("6","13A", HouseType.TWO_BEDROOM_APARTMENT,"kahawa", BigDecimal.valueOf(30000)));
        database.getHouses().add(new House("7","10A", HouseType.VILLA,"runda", BigDecimal.valueOf(80000000)));
        database.getHouses().add(new House("8","14A", HouseType.PENTHOUSE,"hurlingham", BigDecimal.valueOf(26500000)));
        database.getHouses().add(new House("9","15A", HouseType.ONE_BEDROOM_APARTMENT,"parklands", BigDecimal.valueOf(50000)));
        database.getHouses().add(new House("10","16A", HouseType.COTTAGE,"parklands", BigDecimal.valueOf(5000)));
    }


    @Override
    public void contextDestroyed(ServletContextEvent sce) {}
}

