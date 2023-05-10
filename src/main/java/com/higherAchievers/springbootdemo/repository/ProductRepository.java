package com.higherAchievers.springbootdemo.repository;

import com.higherAchievers.springbootdemo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findByName(String productName);

    boolean existsByName(String productName);
}
