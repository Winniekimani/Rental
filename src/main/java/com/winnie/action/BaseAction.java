package com.winnie.action;

import com.winnie.app.model.entity.HouseType;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class BaseAction extends HttpServlet {

//registering custom converter of housetype
    static {
        ConvertUtils.register(new HouseTypeConverter(), HouseType.class);
    }
    public void serializeForm(Object bean, Map<String, ? extends Object> requestMap){

        try {
            BeanUtils.populate(bean,requestMap);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }

    }

    public void renderPage(HttpServletRequest  req, HttpServletResponse res, int activeMenu, String content)

    throws ServletException, IOException {

        req.setAttribute("activeMenu",activeMenu);
        req.setAttribute("content",content);
        RequestDispatcher dispatcher=req.getRequestDispatcher("./app/index.jsp");
        dispatcher.forward(req,res);


    }

}
