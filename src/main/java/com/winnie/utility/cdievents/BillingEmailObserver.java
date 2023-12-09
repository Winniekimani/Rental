package com.winnie.utility.cdievents;

import com.winnie.app.model.entity.Billing;

import javax.enterprise.event.Observes;

public class BillingEmailObserver {
    public void sendBillingEmail(@Observes BillingEmailEvent event) {
        Billing billing = event.getBilling();

        // Code to send an email with billing information
        String recipientEmail = billing.getTenant().getEmail();
        String subject = "Billing Information";
        String body = "Dear tenant, here is your billing information:\n" +"";
        // Include relevant billing details here

        // Code to send the email (use your email sending mechanism)
        // Example: EmailService.sendEmail(recipientEmail, subject, body);
    }
}
