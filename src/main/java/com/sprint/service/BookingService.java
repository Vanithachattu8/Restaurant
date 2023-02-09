package com.sprint.service;


import java.time.LocalDate;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.sprint.exceptions.BookingNotFoundException;
import com.sprint.exceptions.TransactionRecordNotFoundException;
import com.sprint.exceptions.BookingAlreadyExistsException;
import com.sprint.models.Booking;

public interface BookingService {
	List<Booking> findBookingByDate(LocalDate date)throws TransactionRecordNotFoundException;
	//List<Booking> getBookingsByCustomerId(Long customerId);
	Booking updateBooking(long bookingId,LocalTime newTime) throws BookingNotFoundException;
	Booking createBooking(LocalDate date ,int numberOfGuests) throws BookingAlreadyExistsException;
	public void cancelBooking(Long bookingId) throws BookingNotFoundException;
}