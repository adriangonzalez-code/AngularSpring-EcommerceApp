package com.driagon.ecommerce.app.repositories;

import com.driagon.ecommerce.app.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
public interface IProductRepository extends JpaRepository<Product, Long> {
}