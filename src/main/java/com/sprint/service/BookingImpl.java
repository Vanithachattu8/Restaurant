package com.sprint.service;

import java.time.LocalDate;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.exceptions.BookingNotFoundException;
import com.sprint.exceptions.TransactionRecordNotFoundException;
import com.sprint.exceptions.BookingAlreadyExistsException;
import com.sprint.models.Admin;
import com.sprint.models.Booking;
import com.sprint.repository.BookingRepository;

@Service
public class BookingImpl implements BookingService
{
	private BookingRepository bookingRepository;
	@Autowired
	public BookingImpl(BookingRepository bookingRepository){
		this.bookingRepository = bookingRepository;
	}
	
	private Admin admin=new Admin();
	//allow a customer
	
	@Override
	public Booking createBooking(LocalDate date, int numberOfGuests) throws BookingAlreadyExistsException {
		Optional<Booking> existingBooking = bookingRepository.findByDateAndNumberOfGuests(date, numberOfGuests);
		Booking booking;
		if(existingBooking.isPresent()) {
			throw new BookingAlreadyExistsException("Table is already booked for given date and party size");
			//customer already exists exception
			}
		else
		{
		admin.setAdminId(1);
		booking = new Booking();
		booking.setDate(date);
		booking.setTime(LocalTime.now());
		booking.setAdmin(admin);
		booking.setNumberOfGuests(numberOfGuests);
		}
		return bookingRepository.save(booking);
	}
	
	public List<Booking> findBookingByDate(LocalDate date)throws TransactionRecordNotFoundException{
		try
		{
		return bookingRepository.findByDate(date);
		}
		catch(Exception e)
		{
			throw new TransactionRecordNotFoundException("Transaction records are not found for given date ");
		}
	
	}
	
	@Override
	public Booking updateBooking(long bookingId, LocalTime newTime) throws BookingNotFoundException 
	{
	
	      Booking booking = bookingRepository.findById(bookingId).orElseThrow(() -> new BookingNotFoundException("Booking not found with ID: " + bookingId));
	      booking.setTime(newTime);
	      return bookingRepository.save(booking);
	}


	@Override
	public void cancelBooking(Long bookingId) throws BookingNotFoundException {
		Booking booking = bookingRepository.findById(bookingId)
			      .orElseThrow(() -> new BookingNotFoundException("Booking not found with ID: " + bookingId));
			    bookingRepository.delete(booking);
		
	}


	
//	@Override
//	public List<Booking> getBookingsByCustomerId(Long customerId) {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
