package com.winnie.action;


import com.winnie.app.model.entity.PaymentStatus;
import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.Converter;

public class PaymentStatusConverter implements Converter {
    @SuppressWarnings("unchecked")
    // This class converts a string to a PaymentStatus
    @Override
    public <T> T convert(Class<T> type, Object value) {
        if (value == null) {
            return null;
        }

        if (value instanceof String) {
            String stringValue = (String) value;

            // Handle empty string as a specific default PaymentStatus value
            if (stringValue.isEmpty()) {
                // Set the default PaymentStatus when an empty string is encountered
                return (T) PaymentStatus.PAID; // Adjust this line based on your enum or default value
            }

            try {
                return (T) PaymentStatus.valueOf(stringValue);
            } catch (IllegalArgumentException e) {
                throw new ConversionException("Invalid PaymentStatus value: " + stringValue);
            }
        } else {
            throw new ConversionException("Value is not a String");
        }
    }
}
