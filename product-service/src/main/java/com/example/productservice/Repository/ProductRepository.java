package com.example.productservice.Repository;

import com.example.productservice.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {


    Product findByProductId(Long id);

    Product findByProductName(String pName);
}
