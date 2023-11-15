package com.winnie.app.model.entity;

import java.io.Serializable;

public enum PaymentStatus implements Serializable {

    PAID("paid"),
    UNPAID("unpaid");

    private String value;

    PaymentStatus(String value) {
        this.value = value;
    }

    }
