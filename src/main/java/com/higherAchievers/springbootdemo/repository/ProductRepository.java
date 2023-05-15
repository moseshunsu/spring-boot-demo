package com.higherAchievers.springbootdemo.repository;

import com.higherAchievers.springbootdemo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findByName(String productName);
    boolean existsByName(String productName);
    Product findByCreatedAt(LocalDateTime dateTime);

}
