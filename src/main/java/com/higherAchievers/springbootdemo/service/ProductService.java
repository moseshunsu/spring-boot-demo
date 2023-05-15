package com.higherAchievers.springbootdemo.service;

import com.higherAchievers.springbootdemo.dto.ProductRequest;
import com.higherAchievers.springbootdemo.entity.Product;
import com.higherAchievers.springbootdemo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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

        return mapToDo(savedProduct);
//        ProductRequest response = new ProductRequest();
//        response.setName(savedProduct.getName());
//        response.setDescription(savedProduct.getDescription());
//        response.setSkuCode(savedProduct.getSkuCode());
//        response.setQuantity(response.getQuantity());
//        return response;
    }

    public ProductRequest mapToDo (Product product) {
        ProductRequest response = new ProductRequest();
        response.setName(product.getName());
        response.setDescription(product.getDescription());
        response.setQuantity(product.getQuantity());
        response.setSkuCode(product.getSkuCode());
        return response;
    }

    public List<Product> fetchAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> fetchProductById(Long productId) {
        return productRepository.findById(productId);
    }

    public Product fetchProductByName(String productName) {
        boolean isProductExist = productRepository.existsByName(productName);

        if(isProductExist) {
            return productRepository.findByName(productName);
        } else return null;
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public ProductRequest updateProduct(Long id, ProductRequest productRequest) {
        Product updateProduct =
                productRepository.findById(id).orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND));
        updateProduct.setName(productRequest.getName());
        updateProduct.setDescription(productRequest.getDescription());
        updateProduct.setQuantity(productRequest.getQuantity());
        updateProduct.setSkuCode(productRequest.getSkuCode());

        Product updatedProduct = productRepository.save(updateProduct);
        return mapToDo(updatedProduct);
    }

    public ProductRequest findByDateCreated(LocalDateTime date) {
        return mapToDo(productRepository.findByCreatedAt(date));
    }

}
