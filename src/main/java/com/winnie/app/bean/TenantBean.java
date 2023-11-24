package com.winnie.app.bean;

import com.winnie.app.View.html.HtmlComponent;
import com.winnie.app.model.entity.House;
import com.winnie.app.model.entity.Tenant;
import com.winnie.database.Database;
import com.winnie.database.MysqlDatabase;

import javax.ejb.Stateless;
import java.io.Serializable;
import java.util.List;

@Stateless
public class TenantBean extends GenericBean<Tenant> implements TenantBeanI, Serializable {



}
