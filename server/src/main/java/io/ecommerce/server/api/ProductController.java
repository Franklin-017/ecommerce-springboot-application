package io.ecommerce.server.api;

import io.ecommerce.server.model.Product;
import io.ecommerce.server.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:3000")
@RequestMapping("/product")
@RestController
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProduct() {
        return productService.getAllProducts();
    }

    @PostMapping("/products")
    public ResponseEntity<List<Product>> addAllProducts(@RequestBody List<Product> products) {
        return productService.addAllProducts(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Product>> getPersonById(@PathVariable long id) {
        return productService.getProductById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteProduct(@PathVariable long id) {
        return productService.deleteProduct(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Optional<Product>> updateProduct(@PathVariable long id, Product product) {
        return productService.updateProduct(id, product);
    }

}
