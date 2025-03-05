package com.piioni.nobsSpring.exceptions;

import lombok.Getter;

@Getter
public enum ErrorMesagges {
    PRODUCT_NOT_FOUND("Product not found"),
    NAME_REQUIRED("Product name is required"),
    DESCRIPTION_LENGTH("Product description must be at least 20 characters long"),
    PRICE_CANNOT_BE_NEGATIVE("Product price is required and must be greater than 0");
    // Can add more error messages here
    // All messages in one place

    private final String message;

    ErrorMesagges(String message) {
        this.message = message;
    }

}
