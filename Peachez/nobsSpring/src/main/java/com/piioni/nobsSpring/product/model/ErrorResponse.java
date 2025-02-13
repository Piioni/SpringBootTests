package com.piioni.nobsSpring.product.model;

import lombok.Getter;

@Getter
public class ErrorResponse {
    // Can make your message as big as you want
    private final String message;

    public ErrorResponse(String message) {
        this.message = message;
    }
}
