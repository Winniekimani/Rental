package com.winnie.utility.cdievents;

import com.winnie.app.model.entity.Billing;

public class BillingEmailEvent {
    private Billing billing;

    public BillingEmailEvent(Billing billing) {
        this.billing = billing;
    }

    public Billing getBilling() {
        return billing;
    }
}
