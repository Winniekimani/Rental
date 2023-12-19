package com.winnie.app.model.entity;

import java.io.Serializable;

public enum HouseAvailability  implements Serializable {
    AVAILABLE("available"),
    TAKEN("taken");

    private String value;

    HouseAvailability(String value) {
        this.value = value;
    }
}
