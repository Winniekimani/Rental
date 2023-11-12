package com.winnie.app.userbean;

import com.winnie.app.model.view.MenuLink;

import java.io.Serializable;
import java.util.List;

public class NavBarBean implements Serializable {
    private List<MenuLink> links;
    private int activeLinkIndex;

    public List<MenuLink> getLinks() {
        return links;
    }

    public void setLinks(List<MenuLink> links) {
        this.links = links;
    }

    public int getActiveLinkIndex() {
        return activeLinkIndex;
    }

    public void setActiveLinkIndex(int activeLinkIndex) {
        this.activeLinkIndex = activeLinkIndex;
    }
}
