package com.winnie.utility;

import com.winnie.app.model.entity.House;
import com.winnie.app.model.entity.HouseType;

import java.math.BigDecimal;

public class RentCalculator {

    public BigDecimal calculateRent(House house) {
        HouseType houseType = house.getHouseType();
        BigDecimal baseRent = BigDecimal.ZERO; // Default base rent

        // Adjust base rent based on house type
        switch (houseType) {
            case BEDSITTER_APARTMENT:
                baseRent = BigDecimal.valueOf(4200); // Example: Apartment base rent
                break;
            case ONE_BEDROOM_APARTMENT:
                baseRent = BigDecimal.valueOf(1200); // Example: Apartment base rent
                break;
            case TWO_BEDROOM_APARTMENT:
                baseRent = BigDecimal.valueOf(1200); // Example: Apartment base rent
                break;
            case VILLA:
                baseRent = BigDecimal.valueOf(2500); // Example: Villa base rent
                break;
            case AIRBNB:
                baseRent = BigDecimal.valueOf(1200); // Example: Apartment base rent
                break;
            case MANSION:
                baseRent = BigDecimal.valueOf(2500); // Example: Villa base rent
                break;
            case BUNGALOW:
                baseRent = BigDecimal.valueOf(2500); // Example: Villa base rent
                break;

            case FARMHOUSE:
                baseRent = BigDecimal.valueOf(2500); // Example: Villa base rent
                break;
            case COTTAGE:
                baseRent = BigDecimal.valueOf(2500); // Example: Villa base rent
                break;
            case PENTHOUSE:
                baseRent = BigDecimal.valueOf(2500); // Example: Villa base rent
                break;

            // Default case (if house type is not recognized)
            default:
                System.out.println("Warning: Unknown house type. Using default base rent.");
                break;
        }

        // You can add additional adjustments based on other factors like location, amenities, etc.

        return baseRent;
    }
}
