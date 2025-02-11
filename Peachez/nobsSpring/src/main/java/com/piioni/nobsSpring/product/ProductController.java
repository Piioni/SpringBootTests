package com.piioni.nobsSpring.product;

import com.piioni.nobsSpring.product.model.Product;
import com.piioni.nobsSpring.product.services.CreateProductService;
import com.piioni.nobsSpring.product.services.DeleteProduct;
import com.piioni.nobsSpring.product.services.GetProductsService;
import com.piioni.nobsSpring.product.services.UpdateProduct;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    private final CreateProductService createProductService;
    private final GetProductsService getProductsService;
    private final UpdateProduct updateProduct;
    private final DeleteProduct deleteProduct;

    public ProductController(CreateProductService createProductService,
                             GetProductsService getProductsService,
                             UpdateProduct updateProduct,
                             DeleteProduct deleteProduct) {
        this.createProductService = createProductService;
        this.getProductsService = getProductsService;
        this.updateProduct = updateProduct;
        this.deleteProduct = deleteProduct;
    }

    @PostMapping
    public ResponseEntity<String> createProduct() {
        return createProductService.execute(null);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getProducts() {
        return getProductsService.execute(null);
    }

    @PutMapping
    public ResponseEntity<String> updateProduct() {
        return updateProduct.execute(null);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteProduct() {
        return deleteProduct.execute(null);
    }


}
