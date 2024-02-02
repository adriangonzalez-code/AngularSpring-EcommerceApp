package com.driagon.ecommerce.app.repositories;

import com.driagon.ecommerce.app.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {
}