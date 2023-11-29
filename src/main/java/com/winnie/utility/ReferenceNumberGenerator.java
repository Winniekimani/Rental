package com.winnie.utility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class ReferenceNumberGenerator {

    public String generate(EntityType entityType) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yy/MM/dd");
        String prefix = getPrefix(entityType);

        return prefix + dateFormat.format(new Date()) + "-" + ThreadLocalRandom.current().nextInt(1000, 2000 + 1);
    }

    private String getPrefix(EntityType entityType) {
        switch (entityType) {
            case HOUSE:
                return "HOUSE_REF";
            case TENANT:
                return "TENANT_REF";
            case PAYMENT:
                return "PAYMENT_REF";
            case BILL:
                return "BILL_REF";
            default:
                throw new IllegalArgumentException("Unknown entity type");
        }
    }

    public enum EntityType {
        HOUSE, TENANT, PAYMENT, BILL
    }
}
