package com.winnie.action;

import com.winnie.app.View.html.HtmlComponent;
import com.winnie.app.model.entity.HouseType;
import com.winnie.app.model.entity.PaymentStatus;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class BaseAction extends HttpServlet {

    //registering custom converter of housetype
    static {
        ConvertUtils.register(new HouseTypeConverter(), HouseType.class);
        ConvertUtils.register(new PaymentStatusConverter(), PaymentStatus.class);
    }



    @SuppressWarnings("unchecked")
    public <T> T serializeForm(Class<?> clazz, Map<String, String[]> requestMap) {

        T clazzInstance;

        try {
            clazzInstance = (T) clazz.getDeclaredConstructor().newInstance();

            DateConverter converter = new DateConverter( null );
            converter.setPattern("yyyy-mm-dd");
            ConvertUtils.register(converter, Date.class);

            requestMap.forEach((k,v)-> System.out.println(k + " " + v[0]));

            BeanUtils.populate(clazzInstance, requestMap);

        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | InstantiationException e ) {
            throw new RuntimeException(e);
        }

        return clazzInstance;
    }


    public void renderPage(HttpServletRequest  req, HttpServletResponse res, int activeMenu,  Class<?> entity, List<?> entityList)

            throws ServletException, IOException {

        req.setAttribute("activeMenu",activeMenu);
      /*  req.setAttribute("content",content);*/

        if (StringUtils.trimToEmpty(req.getParameter("action")).equals("add"))
            req.setAttribute("content", HtmlComponent.htmlForm(entity));
        else
            req.setAttribute("content", HtmlComponent.table(entity, entityList));
        RequestDispatcher dispatcher=req.getRequestDispatcher("./app/index.jsp");
        dispatcher.forward(req,res);


    }

}