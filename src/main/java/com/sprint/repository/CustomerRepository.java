package com.sprint.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sprint.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Long>{

}
