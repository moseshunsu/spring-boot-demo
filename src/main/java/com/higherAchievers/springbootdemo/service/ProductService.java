package com.higherAchievers.springbootdemo.service;

import com.higherAchievers.springbootdemo.dto.ProductRequest;
import com.higherAchievers.springbootdemo.entity.Product;
import com.higherAchievers.springbootdemo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductRequest addProduct(ProductRequest request) {
        Product newProduct = new Product();
        newProduct.setName(request.getName());
        newProduct.setQuantity(request.getQuantity());
        newProduct.setDescription(request.getDescription());
        newProduct.setSkuCode(request.getSkuCode());

        Product savedProduct = productRepository.save(newProduct);

        ProductRequest response = new ProductRequest();
        response.setName(savedProduct.getName());
        response.setDescription(savedProduct.getDescription());
        response.setSkuCode(savedProduct.getSkuCode());
        response.setQuantity(response.getQuantity());
        return response;
    }

    public List<Product> fetchAllProducts() {
        return productRepository.findAll();
    }
}
