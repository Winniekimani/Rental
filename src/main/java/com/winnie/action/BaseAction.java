package com.winnie.action;

import com.winnie.app.model.entity.HouseType;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;

import javax.servlet.http.HttpServlet;
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
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

    }
}
