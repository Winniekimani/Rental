package com.winnie.app.model.view;

import java.io.Serializable;

public class MenuLink implements Serializable {

    //implement getter and setters
    private String url;

    private String label;

    private MenuLinkStatus status;

    private String icon;

    public MenuLink(String url, String label, String icon, MenuLinkStatus status){
        this.url = url;
        this.label = label;
        this.status = status;
        this.icon = icon;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public MenuLinkStatus getStatus() {
        return status;
    }

    public void setStatus(MenuLinkStatus status) {
        this.status = status;
    }

}
