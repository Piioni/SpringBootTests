package com.piioni.nobsSpring.product.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "product")
public class Product {

    @Id // This annotation is used to define the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // This annotation is used to define the strategy to generate the primary key
    @Column(name = "id") // This annotation is used to define the column name
    private Integer id;
    private String name;
    private String description;
    private Double price;

}
