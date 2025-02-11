package com.piioni.nobsSpring.product.services;

import com.piioni.nobsSpring.Query;
import com.piioni.nobsSpring.product.ProductRepository;
import com.piioni.nobsSpring.product.model.Product;
import com.piioni.nobsSpring.product.model.ProductDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetProductsService implements Query<Void, List<Product>> {
    private final ProductRepository productRepository;

    public GetProductsService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<List<Product>> execute(Void input) {
        List<Product> products = productRepository.findAll();
        List<ProductDTO> productDTOS = products.stream().map(ProductDTO::new).toList();

        return ResponseEntity.status(HttpStatus.OK).body(products);
    }


}
