package com.sprint.service;

import java.util.Comparator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.exceptions.CustomerNotFoundException;
import com.sprint.models.Booking;
import com.sprint.models.Customer;
import com.sprint.repository.BookingRepository;
import com.sprint.repository.CustomerRepository;


@Service
public class CustomerImpl implements CustomerService{
	
	private BookingRepository bookingRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	 @Autowired
	  public CustomerImpl(BookingRepository bookingRepository) 
	 {
		  this.bookingRepository = bookingRepository;
	 }

	@Override
	public List<Customer> findCustomersByFrequencyOfVisits() {
		List<Booking> bookings = bookingRepository.findAll(); 
		  Map<Long, Integer> customerVisitCounts = new HashMap<>();
		  for (Booking booking : bookings) { 
			  Long customerId = booking.getId();
			  customerVisitCounts.put(customerId, customerVisitCounts.getOrDefault(customerId, 0) + 1);
			  } 
		 List<Customer> customers = customerVisitCounts.entrySet().stream() 
				 .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())) 
					  .map(entry -> bookingRepository.findById(entry.getKey()).get().getCustomer())
					  .collect(Collectors.toList()); 
			  return customers; 
	}

	@Override
	public Customer findCustomerById(long id) throws CustomerNotFoundException {
		if(customerRepository.getOne(id)==null) {
			throw new CustomerNotFoundException("Customer with given Id is not present");
			}
		return customerRepository.getOne(id);
	}

	@Override
	public List<Customer> getCustomers() {
		return customerRepository.findAll();
	}

}
