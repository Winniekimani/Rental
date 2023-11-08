package com.winnie.app.model.entity;

import java.io.Serializable;

public enum HouseType implements Serializable {
    BEDSITTER_APARTMENT("bedsitter"),
    ONE_BEDROOM_APARTMENT("one-bedroom"),
    TWO_BEDROOM_APARTMENT("two-bedroom"),

    AIRBNB("airnb"),

    MANSION("mansion"),
    VILLA("villa"),
    BUNGALOW("bungalow"),
    COTTAGE("cottage"),

    FARMHOUSE("farm-house"),
     PENTHOUSE("penthouse");

    private String value;

    HouseType(String value) {
        this.value = value;
    }

}
