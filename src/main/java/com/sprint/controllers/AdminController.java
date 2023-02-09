package com.sprint.controllers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sprint.exceptions.CustomerNotFoundException;
import com.sprint.exceptions.TransactionRecordNotFoundException;
import com.sprint.models.Booking;
import com.sprint.models.Customer;
import com.sprint.repository.AdminRepository;
import com.sprint.repository.CustomerRepository;
import com.sprint.repository.TransactionRepository;
import com.sprint.service.AdminImpl;
import com.sprint.service.BookingImpl;
import com.sprint.service.CustomerImpl;

@RestController
@RequestMapping("/admin")
public class AdminController {
	  
	  @Autowired
	  private TransactionRepository transactionRepository;
	  
	  @Autowired
	  private AdminRepository adminRepository;
	  
	  @Autowired
	  AdminImpl adminImpl;
	  
	  @Autowired
	  private CustomerImpl customerImpl;
	  
	  @Autowired
	   private BookingImpl bookingImpl;
	  
	  @Autowired
	   public AdminController(CustomerImpl customerImpl) {
	      this.customerImpl = customerImpl;
	   }
	  
	   public AdminController(BookingImpl bookingImpl) {
	      this.bookingImpl = bookingImpl;
	   }
	   
	// Display a list of customers ordered by frequency of visits
	   @GetMapping(value="/customers/visits")
	   public List<Customer> getCustomersByFrequencyOfVisits(Model model) {
	      List<Customer> customers = customerImpl.findCustomersByFrequencyOfVisits();

	      model.addAttribute("customers", customers);

	      return customers;
	   }
	      // display list of bookings for a given  date
	      @GetMapping(value="/customers")
	      public List<Booking> getBookings(@RequestParam("date") LocalDate date,
	    		  Model model) throws TransactionRecordNotFoundException{
	         List<Booking> bookings = bookingImpl.findBookingByDate(date);

	         model.addAttribute("bookings", bookings);

	         return bookings;
	      
	   }
	  
	  
	  @GetMapping(value="/{id}/amountSpentOnDate")
	  public Double getTotalAmountSpentByCustomerIdBetweenDates(@PathVariable("id") Long customerId,
			  													@RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate,
	                                                            @RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate
	                                                             ) {
	    return transactionRepository.findTotalAmountSpentByCustomerIdBetweenDates(customerId, endDate,startDate);
	  }
	  
	  @PostMapping(value="/bookings")
	  public String getDiscounts(@RequestParam("customerId") Long customerId,Model model) throws CustomerNotFoundException {
	    
		  double discount;
		  discount=adminImpl.discountsForCustomers(customerId);
	      model.addAttribute("discount", discount);
	      return "Discount available";
	    }
	  
	  @GetMapping(value="/{id}")
	  public Double getCalculateMoneySpent(@PathVariable("id") Long customerId) throws CustomerNotFoundException
	  {
		  return adminImpl.calculateMoneySpent(customerId);
	  }
	  
	//@PostMapping
	}

