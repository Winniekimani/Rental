package com.winnie.app.View.toolbar;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

public class BottomToolBar implements Menu, Serializable {
    @Override
    public String menu(int activeLinkIndex) {
        return StringUtils.EMPTY;
    }
}
