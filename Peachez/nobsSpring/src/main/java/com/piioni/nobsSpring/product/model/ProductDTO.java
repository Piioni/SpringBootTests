package com.piioni.nobsSpring.product.model;

import lombok.Data;

@Data
public class ProductDTO {
    // This class is used to define the data transfer object for the product
    private Integer id;
    private String name;
    private String description;

    // This constructor is used to create a new product DTO
    public ProductDTO(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
    }

}
