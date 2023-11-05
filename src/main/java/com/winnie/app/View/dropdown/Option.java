package com.winnie.app.View.dropdown;

import com.winnie.app.model.entity.HouseType;

import java.io.Serializable;

public class Option implements Serializable {
    private HouseType optionName;
    private String label;

    public Option(HouseType optionName, String label) {
        this.optionName = optionName;
        this.label = label;
    }

    public Option() {
    }

    public HouseType getOptionName() {
        return optionName;
    }

    public void setOptionName(HouseType optionName) {
        this.optionName = optionName;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
