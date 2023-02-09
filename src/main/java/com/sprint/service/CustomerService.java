package com.sprint.service;

import java.util.List;

import com.sprint.exceptions.CustomerNotFoundException;
import com.sprint.models.Customer;

public interface CustomerService {
public List<Customer> findCustomersByFrequencyOfVisits();
public Customer findCustomerById(long id) throws CustomerNotFoundException;
public List<Customer> getCustomers();
}