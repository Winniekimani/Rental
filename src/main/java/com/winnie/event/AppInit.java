package com.winnie.event;

import com.winnie.app.bean.HouseBean;
import com.winnie.app.bean.HouseBeanI;
import com.winnie.app.bean.PaymentBeanI;
import com.winnie.app.model.entity.*;
import com.winnie.database.Database;
import com.winnie.database.MysqlDatabase;
import com.winnie.database.helper.DbTable;
import com.winnie.database.helper.DbTableColumn;
import com.winnie.database.helper.DbTableId;
import org.apache.commons.lang3.ArrayUtils;

import javax.ejb.EJB;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


@WebListener
public class AppInit implements ServletContextListener {

    @EJB
    PaymentBeanI paymentBean;
    @Override
    public void contextInitialized(ServletContextEvent sce) {


       Payment payment = new Payment(BigDecimal.valueOf(4600),new Date(12/4/2019),"mpesa",PaymentStatus.PAID);
        paymentBean.add(payment);


    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {


       /* try {
            MysqlDatabase database = MysqlDatabase.getInstance();
            if (database.getConnection() != null) {
                database.getConnection().close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }*/

    }

}





