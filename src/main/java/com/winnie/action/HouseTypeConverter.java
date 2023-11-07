package com.winnie.action;

import com.winnie.app.model.entity.HouseType;
import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.Converter;

public class HouseTypeConverter implements Converter {
    @SuppressWarnings("unchecked")
    @Override
    public <T> T convert(Class<T> type, Object value) {
        if (value == null) {
            return null;
        }

        if (value instanceof String) {
            String stringValue = (String) value;
            try {
                return (T) HouseType.valueOf(stringValue);
            } catch (IllegalArgumentException e) {
                throw new ConversionException("Invalid HouseType value: " + stringValue);
            }
        } else {
            throw new ConversionException("Value is not a String");
        }
    }
}