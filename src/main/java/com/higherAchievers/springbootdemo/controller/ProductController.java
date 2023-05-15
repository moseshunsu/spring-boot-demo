package com.higherAchievers.springbootdemo.controller;

import com.higherAchievers.springbootdemo.dto.ProductRequest;
import com.higherAchievers.springbootdemo.entity.Product;
import com.higherAchievers.springbootdemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping
    public ProductRequest saveProduct(@RequestBody ProductRequest productRequest) {
        return productService.addProduct(productRequest);
    }
    @GetMapping
    public List<Product> fetchAllProducts() {
        return productService.fetchAllProducts();
    }

    @GetMapping("/{productId}")
    public Optional<Product> fetchProductById(@PathVariable(value = "productId") Long productId) {
        return productService.fetchProductById(productId);
    }

    @GetMapping("/productName")
    public Product fetchProductByName(@RequestParam("productName") String productName) {
        return productService.fetchProductByName(productName);
    }

//    @GetMapping("/{productName}")
//    public Product fetchProductByName(@PathVariable(value = "productName") String productName) {
//        return productService.fetchProductByName(productName);
//    }

    @PutMapping("/{id}")
    public ProductRequest UpdateProduct(@PathVariable(value = "id", required = true) Long id,
                                        @RequestBody ProductRequest productRequest){
        return productService.updateProduct(id,productRequest);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(Long id){
        productService.deleteProduct(id);
        return "Product successfully deleted";
    }

    @GetMapping("/date")
    public ProductRequest findByDateCreated(@RequestParam("date") LocalDateTime date){
        return productService.findByDateCreated(date);
    }

}
