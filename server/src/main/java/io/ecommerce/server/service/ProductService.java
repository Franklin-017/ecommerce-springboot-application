package io.ecommerce.server.service;

import io.ecommerce.server.dao.ProductDao;
import io.ecommerce.server.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductDao productDao;

    @Autowired
    public ProductService(ProductDao productDao) {
        this.productDao = productDao;
    }

    // Add Product
    public ResponseEntity<Product> addProduct(Product product) {
        try {
            Product _product = productDao.save(product);
            return new ResponseEntity<>(_product, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Add All Products
    public ResponseEntity<List<Product>> addAllProducts(List<Product> products) {
        try {
            List<Product> _products = productDao.saveAll(products);
            return new ResponseEntity<>(_products, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get All Product from Database
    public ResponseEntity<List<Product>> getAllProducts() {
        try {
            List<Product> products = productDao.findAll();
            if(products.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return new ResponseEntity<>(products, HttpStatus.OK);
        } catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get Product by Id
    public ResponseEntity<Optional<Product>> getProductById(long id) {
        try {
            Optional<Product> productData = productDao.findById(id);
            if(productData.isEmpty())
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(productData, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Delete Product By Id
    public ResponseEntity<HttpStatus> deleteProduct(long id) {
        try {
            productDao.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Update Product data
    public ResponseEntity<Optional<Product>> updateProduct(long id, Product product) {
        try {
            Optional<Product> productData = productDao.findById(id);
            if(productData.isPresent()) {
                return new ResponseEntity<>(productData, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
