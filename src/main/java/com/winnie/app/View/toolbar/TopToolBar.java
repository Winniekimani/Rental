package com.winnie.app.View.toolbar;

import com.winnie.app.model.view.MenuLink;
import com.winnie.app.model.view.MenuLinkStatus;

import javax.servlet.annotation.WebServlet;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



public class TopToolBar  implements Serializable ,Menu{

    private final List<MenuLink> links = new ArrayList<>();

    {
        links.add(new MenuLink("./home", "Home", MenuLinkStatus.ACTIVE));
        links.add(new MenuLink("./properties", "Houses", MenuLinkStatus.NOT_ACTIVE));
        links.add(new MenuLink("./tenants", "Tenants", MenuLinkStatus.NOT_ACTIVE));
        links.add(new MenuLink("./housetypes","HouseTypes", MenuLinkStatus.NOT_ACTIVE));
        links.add(new MenuLink("./payments", "Payments", MenuLinkStatus.NOT_ACTIVE));
    }

    /*@Override
    public String menu(List<MenuLink> links) {


        String menuBar="<ul class=\"topnav\">\n" +;

        for (MenuLink link:links)
               menuBar+= "<li><a "+(link.getStatus()== MenuLinkStatus.ACTIVE? "Class=\"active\"" : "")
                       + "href=\"" + link.getUrl() + "\">"+link.getLabel() + "</a></li>\n" ;
                //"<li><a href=\"./houses\">Houses/a></li>\n" +
                //"<li><a href=\"#tenants\">Tenants</a></li>\n" +
                //"<li><a href=\"#payments\">Payments</a></li>\n" +
               // "<li><a href=\"#houseTypes\">House Types</a></li>\n" +
                menuBar+="</ul>\n" ;
        return menuBar;
    }*/

    @Override
    public String menu(int activeLinkIndex) {
        this.activateLink(activeLinkIndex);

        String menuBar="<ul class=\"topnav\">";

        for (MenuLink link:links)
            menuBar+= "<li><a "+(link.getStatus()== MenuLinkStatus.ACTIVE? "Class=\"active\"" : "")
                    + "href=\"" + link.getUrl() + "\">"+link.getLabel() + "</a></li>\n" ;
        //"<li><a href=\"./homejournals\">HouseJournals</a></li>\n" +
        //"<li><a href=\"#tenants\">Tenants</a></li>\n" +
        //"<li><a href=\"#payments\">Payments</a></li>\n" +
        // "<li><a href=\"#houseTypes\">House Types</a></li>\n" +
        menuBar+="</ul>\n" ;
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
