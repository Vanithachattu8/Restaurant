package com.sprint.controllers;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprint.exceptions.BookingAlreadyExistsException;
import com.sprint.exceptions.BookingNotFoundException;
import com.sprint.exceptions.CustomerNotFoundException;
import com.sprint.models.Booking;
import com.sprint.models.Customer;
import com.sprint.repository.CustomerRepository;
import com.sprint.service.BookingService;
import com.sprint.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	private BookingService bookingService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	CustomerRepository customerRepository;
	  
		@Autowired
	  public CustomerController(BookingService bookingService) {
	    this.bookingService = bookingService;
	  }
	//@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)	
//		 @PostMapping("/book")
//		   public Booking bookTable(@RequestParam("date") LocalDate date,
//		                           @RequestParam("numberOfGuests") int numberOfGuests,
//		                           Model model) {
//		      Booking booking = bookingService.createBooking(date, numberOfGuests);
//
//		      model.addAttribute("booking", booking);
//
//		      return booking;
//		   }
		@PostMapping(value="/book/{date}/{g}")
		public Booking bookTable(@PathVariable @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate date,@PathVariable int g) throws BookingAlreadyExistsException
		{
			return bookingService.createBooking(date, g);
		}
	  
	  @PutMapping(value="/bookings/{bookingId}")
	  public ResponseEntity<Booking> updateBooking(@PathVariable Long bookingId, @RequestBody LocalTime newTime) throws BookingNotFoundException{
		   Booking updatedBooking = null;
		
			updatedBooking = bookingService.updateBooking(bookingId, newTime);
		   return ResponseEntity.ok(updatedBooking);
	  }
	  
	  @DeleteMapping(value="/bookings/{bookingId}")
	  public ResponseEntity<Void> cancelBooking(@PathVariable Long bookingId)throws BookingNotFoundException {
	    
			bookingService.cancelBooking(bookingId);
	    return ResponseEntity.noContent().build();
	  }
	  
	  @GetMapping(value="/{id}")
	  public Customer getCustomerById(@PathVariable Long id) throws CustomerNotFoundException{
        return customerService.findCustomerById(id);
    }
    
	  @GetMapping
	  public List<Customer> getAllCustomers(){
        return customerService.getCustomers();
    }
	  
//    @GetMapping(value="/name/{name}")
//    public List<Customer> getCustomerByName(@PathVariable String name){
//        return customerService.findCustomerByName(name);
//    }
    
  //Display a list of customers ordered by frequency of visits
//  @GetMapping(value="/frequency")
//  public List<Customer> getAllCustomersOrderByCountBookings(){
//      return customerRepository.findAllByBookings();
//  }
	  
	  


//
//    
//    
//    

}
