package com.piioni.nobsSpring.product;

import com.piioni.nobsSpring.product.model.Product;
import com.piioni.nobsSpring.product.model.ProductDTO;
import com.piioni.nobsSpring.product.model.UpdateProductCommand;
import com.piioni.nobsSpring.product.services.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class ProductController {
    // Dependency injection is used to inject the services into the controller
    private final CreateProductService createProductService;
    private final GetProductsService getProductsService;
    private final UpdateProductService updateProductService;
    private final DeleteProductService deleteProductService;
    private final GetProductService getProductService;

    public ProductController(CreateProductService createProductService,
                             GetProductsService getProductsService,
                             UpdateProductService updateProductService,
                             DeleteProductService deleteProductService,
                             GetProductService getProductService) {
        this.createProductService = createProductService;
        this.getProductsService = getProductsService;
        this.updateProductService = updateProductService;
        this.deleteProductService = deleteProductService;
        this.getProductService = getProductService;

    }

    // Post mapping is used to define the endpoint for creating a product
    @PostMapping("/product")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody Product product) {
        return createProductService.execute(product);
    }

    // Get mapping is used to define the endpoint for getting all products
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts() {
        return getProductsService.execute(null);
    }

    // Get mapping is used to define the endpoint for getting a product by id
    // Path variable is used to define the path parameter for the endpoint URL
    @GetMapping("/product/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Integer id) {
        return getProductService.execute(id);
    }

    // Put mapping is used to define the endpoint for updating a product
    @PutMapping("/product/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable Integer id, @RequestBody Product product) {
        // need to pass in both id and product
        return updateProductService.execute(new UpdateProductCommand(id, product));
    }

    // Delete mapping is used to define the endpoint for deleting a product
    @DeleteMapping("/product/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id) {
        return deleteProductService.execute(id);
    }

}
