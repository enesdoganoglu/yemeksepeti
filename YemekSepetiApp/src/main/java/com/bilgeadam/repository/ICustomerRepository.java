package com.bilgeadam.repository;

import com.bilgeadam.repository.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByCustomerNameAndPassword(String customername, String password);
}
