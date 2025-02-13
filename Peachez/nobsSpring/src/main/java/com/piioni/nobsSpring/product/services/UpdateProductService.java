package com.piioni.nobsSpring.product.services;

import com.piioni.nobsSpring.Command;
import com.piioni.nobsSpring.exceptions.ProductNotFoundException;
import com.piioni.nobsSpring.product.ProductRepository;
import com.piioni.nobsSpring.product.model.Product;
import com.piioni.nobsSpring.product.model.ProductDTO;
import com.piioni.nobsSpring.product.model.UpdateProductCommand;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateProductService implements Command<UpdateProductCommand, ProductDTO> {
    private final ProductRepository productRepository;

    public UpdateProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<ProductDTO> execute(UpdateProductCommand command) {
        Optional<Product> productOptional = productRepository.findById(command.getId());
        if (productOptional.isPresent()) {
            Product product = command.getProduct();
            product.setId(command.getId());
            // Validate product before saving
            // ProductValidator.execute(product);
            productRepository.save(product);
            return ResponseEntity.ok(new ProductDTO(product));
        }

        throw new ProductNotFoundException();
    }

}
