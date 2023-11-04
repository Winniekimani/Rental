package com.winnie.event;

import com.winnie.app.model.entity.House;
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
        System.out.println("************** initializing database*********");

        Database database = Database.getDbInstance();
        database.getUsers().add(new User(0L,"kimani.com","0000"));
        database.getUsers().add(new User(0L,"vinny.com","1992"));
        database.getUsers().add(new User(0L,"njeri.com","1995"));



        database.getHouses().add(new House("two-bedroom Apartment","kawangware", BigDecimal.valueOf(20000)));
        database.getHouses().add(new House("besitter Apartment","roysambu", BigDecimal.valueOf(12000)));
        database.getHouses().add(new House("villa","runda", BigDecimal.valueOf(8500000)));
        database.getHouses().add(new House("one bedroom apartment","kilimani", BigDecimal.valueOf(50000)));
        database.getHouses().add(new House("airbnb","garden-city", BigDecimal.valueOf(2500)));
        database.getHouses().add(new House("studio apartments","kahawa", BigDecimal.valueOf(30000)));
        database.getHouses().add(new House("mansion","runda", BigDecimal.valueOf(80000000)));
        database.getHouses().add(new House("bungalow","hurlingham", BigDecimal.valueOf(26500000)));
        database.getHouses().add(new House("penthouse","parklands", BigDecimal.valueOf(26500000)));
        database.getHouses().add(new House("airbnb","parklands", BigDecimal.valueOf(5000)));
    }


    @Override
    public void contextDestroyed(ServletContextEvent sce) {}
}

