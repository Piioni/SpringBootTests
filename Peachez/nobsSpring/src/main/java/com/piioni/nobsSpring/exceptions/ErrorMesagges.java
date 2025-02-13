package com.piioni.nobsSpring.exceptions;

public enum ErrorMesagges {
    PRODUCT_NOT_FOUND("Product not found");
    // Can add more error messages here
    // All messages in one place

    private final String message;

    ErrorMesagges(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
