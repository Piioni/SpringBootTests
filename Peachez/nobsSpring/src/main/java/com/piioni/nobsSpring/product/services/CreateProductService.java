package com.piioni.nobsSpring.product.services;

import com.piioni.nobsSpring.Command;
import com.piioni.nobsSpring.product.ProductRepository;
import com.piioni.nobsSpring.product.model.Product;
import com.piioni.nobsSpring.product.model.ProductDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreateProductService implements Command<Product, ProductDTO> {
    private final ProductRepository productRepository;

    public CreateProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<ProductDTO > execute(Product product) {
        // Validate product before saving
        // ProductValidator.execute(product);

        Product savedProduct = productRepository.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ProductDTO(savedProduct));
    }


}
