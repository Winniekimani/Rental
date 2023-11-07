package com.winnie.event;

import com.winnie.app.model.entity.House;
import com.winnie.app.model.entity.HouseType;
import com.winnie.app.model.entity.Tenant;
import com.winnie.app.model.entity.User;
import com.winnie.database.Database;
import com.winnie.utils.TenantUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;

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




        System.out.println("************** Adding Tenants*********");
        //database.getTenants().add(new Tenant("winnie","kimani","0746450089",24/102023,15/10/2024,50000.00,"12A","paid"));

        try {
            database.getTenants().add(TenantUtils.createTenant("Winnie", "Kimani", "0746450089", "24/10/2023", "20/10/2024", 100000.00, "12A", "paid"));
            database.getTenants().add(TenantUtils.createTenant("maryann", "njeri", "0748970089", "24/3/2023", "25/12/2024", 25000.00, "5", "unpaid"));
            database.getTenants().add(TenantUtils.createTenant("vincent", "njenga", "0746450089", "24/2/2023", "10/8/2024", 60000.00, "12A", "unpaid"));
            database.getTenants().add(TenantUtils.createTenant("fredrick", "kamau", "0746470089", "24/5/2023", "15/09/2024", 58000.00, "8", "paid"));
            database.getTenants().add(TenantUtils.createTenant("mwihaki", "wanjiru", "07464900089", "24/6/2023", "15/02/2024", 5000.00, "10B", "paid"));
            database.getTenants().add(TenantUtils.createTenant("ochieng", "omera", "0748900089", "24/9/2023", "15/112/2024", 60000.00, "20", "unpaid"));
            database.getTenants().add(TenantUtils.createTenant("ochieng", "omera", "0751050089", "29/9/2023", "15/11/2024", 70000.00, "24", "unpaid"));
            database.getTenants().add(TenantUtils.createTenant("ochieng", "omera", "074950089", "28/9/2023", "15/12/2024", 20000.00, "228B", "unpaid"));
            database.getTenants().add(TenantUtils.createTenant("ochieng", "omera", "0740450089", "20/9/2023", "15/10/2024", 10000.00, "26", "paid"));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }


    }


    @Override
    public void contextDestroyed(ServletContextEvent sce) {}
}

