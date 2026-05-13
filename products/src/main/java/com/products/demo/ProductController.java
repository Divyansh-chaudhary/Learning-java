package com.products.demo;

import com.products.demo.model.Product;
import com.products.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    private  ProductService service;

    @GetMapping("/allProducts")
    public List<Product> getAllProducts() {
        return service.getAllProducts();
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable int productId) {
        Product product = service.getProductById(productId);
        if(product != null)
            return new ResponseEntity<>(product, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/product/image/{productId}")
    public ResponseEntity<byte[]> getProductImage(@PathVariable Integer productId) {
        Product product = service.getProductById(productId);
        if (product == null || product.getImageData() == null || product.getImageData().length == 0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        MediaType mediaType = MediaType.parseMediaType(product.getImageType());
        return ResponseEntity.ok().contentType(mediaType).body(product.getImageData());
    }

    @PostMapping("/save")
    public ResponseEntity<?> addProduct(@RequestPart Product product, @RequestPart MultipartFile image)  {
        Product savedProduct = null;
        try {
            savedProduct = service.addProduct(product, image);
            return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
        } catch (IOException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateProduct(@RequestPart Product product, @RequestPart MultipartFile image) {
        Product updatedProduct = null;
        try {
            updatedProduct = service.updateProductById(product, image);
            return new ResponseEntity<>("Updated", HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/product/{productId}")
    public ResponseEntity<String> deleteProduct(@PathVariable int productId) {
        Product product = service.getProductById(productId);
        if(product == null)
            return new ResponseEntity<>("Product is not found", HttpStatus.NO_CONTENT);
        service.deleteProduct(productId);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
}
