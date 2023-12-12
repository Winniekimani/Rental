package com.winnie.app.View.toolbar;

import com.winnie.app.model.view.MenuLink;
import com.winnie.app.model.view.MenuLinkStatus;

import javax.servlet.annotation.WebServlet;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TopToolBar  implements Serializable ,Menu{



    private final List<MenuLink> links = new ArrayList<>();

    {
        links.add(new MenuLink("./home", "Home", "glyphicon glyphicon-home", MenuLinkStatus.ACTIVE));
        links.add(new MenuLink("./house", "Houses", "glyphicon glyphicon-tasks", MenuLinkStatus.NOT_ACTIVE));
        links.add(new MenuLink("./tenant", "Tenants", "glyphicon glyphicon-user", MenuLinkStatus.NOT_ACTIVE));
        links.add(new MenuLink("./payment", "Payments", "glyphicon glyphicon-usd", MenuLinkStatus.NOT_ACTIVE));
        links.add(new MenuLink("./billing", "Billings", "glyphicon glyphicon-bold", MenuLinkStatus.NOT_ACTIVE));
        links.add(new MenuLink("./logout", "Logout", "glyphicon glyphicon-log-out", MenuLinkStatus.NOT_ACTIVE));
    }


    @Override
    public String menu(int activeLinkIndex) {
        this.activateLink(activeLinkIndex);

        String menuBar="<div class=\"col-md-2 menucontent\">\n" +
                "      <a href=\"#\">\n" +
                "          <h1>Dashboard</h1>\n" +
                "      </a>\n" +
                "      <ul class=\"nav nav-pills nav-stacked\">";

        for (MenuLink link:links)
            menuBar+= "<li role=\"presentation\"><a "+(link.getStatus()== MenuLinkStatus.ACTIVE? "Class=\"active\"" : "")
                    + "href=\"" + link.getUrl() + "\"> <span class=\""+link.getIcon()+"\"></span> "+link.getLabel() + "</a></li>\n" ;

        menuBar+="</ul>\n" +
                "  </div>" ;
        return menuBar;
    }

    private void activateLink(int linkIndex){
        for (int index = 0; index < links.size(); index++){
            if (index == linkIndex)
                links.get(index).setStatus(MenuLinkStatus.ACTIVE);
            else
                links.get(index).setStatus(MenuLinkStatus.NOT_ACTIVE);
        }

    }




}
