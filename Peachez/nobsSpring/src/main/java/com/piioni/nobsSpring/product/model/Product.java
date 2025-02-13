package com.piioni.nobsSpring.product.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;
import jakarta.validation.constraints.NotNull;

@Entity
@Data
@Table(name = "product")
public class Product {

    @Id // This annotation is used to define the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // This annotation is used to define the strategy to generate the primary key
    @Column(name = "id") // This annotation is used to define the column name
    private Integer id;

    @NotNull(message = "Name is required")
    @Column(name = "name")
    private String name;

    @Size(min = 20, message = "Description must be at least 20 characters long")
    @Column(name = "description")
    private String description;

    @PositiveOrZero(message = "Price must be positive")
    @Column(name = "price")
    private Double price;

}
