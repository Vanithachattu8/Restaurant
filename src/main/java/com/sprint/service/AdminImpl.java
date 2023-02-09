package com.sprint.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.exceptions.CustomerNotFoundException;
import com.sprint.models.Booking;
import com.sprint.models.Customer;
import com.sprint.models.Transaction;
import com.sprint.repository.AdminRepository;
import com.sprint.repository.BookingRepository;
import com.sprint.repository.CustomerRepository;
import com.sprint.repository.TransactionRepository;

@Service
public class AdminImpl implements AdminService{

	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private CustomerService customerService;
	
	private TransactionRepository transactionRepository;
	private CustomerRepository customerRepository;
	private BookingRepository bookingRepository;
	
	@Override
	public double calculateMoneySpent(long customerId)throws CustomerNotFoundException {
		Customer existingCustomer =customerService.findCustomerById(customerId);
		if(existingCustomer.getCustomerId()!=customerId) {
			throw new CustomerNotFoundException("Customer with given Id is not present");
			}
		
		Customer customer=customerService.findCustomerById(customerId);
		return customer.getCost();
	
	}
	
	@Override
	public double discountsForCustomers(Long customerId) throws CustomerNotFoundException {
		Optional<Customer> customer = customerRepository.findById(customerId);
	    if (!customer.isPresent()) {
	    	throw new CustomerNotFoundException("Customer with given Id is not Found");
	    }
	    Customer c = customer.get();
	    
//	    c.setBookingsCount(c.getBookingsCount() + 1);
//	    customerRepository.save(c);

	    double discount = 0.0;
	    if (bookingRepository.count() >= 5) {
	      discount = 0.10;
	    } else if (bookingRepository.count() >= 10) {
	    	discount = 0.15;
    }

	  return discount;
	}
}




//@Override
//public int UpdateAvailableTables() {
//	
//	return 0;	
//}
//@Override
//public String sendInfoToCustomer() {
//	// TODO Auto-generated method stub
//	return null;
//}
//list of transactions
//list of tables
//list og bookings
//@Controller
//public class BookingController {
//
//  @Autowired
//  private CustomerRepository customerRepository;
//
//  @PostMapping("/bookings")
//  public String makeBooking(@RequestParam("customerId") Long customerId, Model model) {
//    Optional<Customer> customer = customerRepository.findById(customerId);
//    if (!customer.isPresent()) {
//      // Handle error
//    }
//
//    Customer c = customer.get();
//    c.setBookingsCount(c.getBookingsCount() + 1);
//    customerRepository.save(c);
//    double discount = 0.0;
//    if (c.getBookingsCount() >= 5) {
//      discount = 0.10;
//    } else if (c.getBookingsCount() >= 10) {
//      discount = 0.15;
//    }
//
//    model.addAttribute("discount", discount);
//    return "booking_confirmation";
//  }
//}
