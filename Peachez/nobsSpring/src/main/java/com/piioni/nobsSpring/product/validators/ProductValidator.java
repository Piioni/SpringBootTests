package com.piioni.nobsSpring.product.validators;

import com.piioni.nobsSpring.exceptions.ErrorMesagges;
import com.piioni.nobsSpring.exceptions.ProductNotValidException;
import com.piioni.nobsSpring.product.model.Product;
import io.micrometer.common.util.StringUtils;

public class ProductValidator {

    public ProductValidator() {
    }

    public static void execute(Product product) {
        if (StringUtils.isEmpty(product.getName())) {
            throw new ProductNotValidException(ErrorMesagges.NAME_REQUIRED.getMessage());
        }

        if (product.getDescription().length() < 20) {
            throw new ProductNotValidException(ErrorMesagges.DESCRIPTION_LENGTH.getMessage());
        }

        if (product.getPrice() == null || product.getPrice() < 0) {
            throw new ProductNotValidException(ErrorMesagges.PRICE_CANNOT_BE_NEGATIVE.getMessage());
        }
    }
}
