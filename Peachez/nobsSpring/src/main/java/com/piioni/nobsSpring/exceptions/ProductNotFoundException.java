package com.piioni.nobsSpring.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException() {
        super(ErrorMesagges.PRODUCT_NOT_FOUND.getMessage());
    }
}
