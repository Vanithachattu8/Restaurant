package com.sprint.repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sprint.models.Booking;
import com.sprint.models.Customer;
import com.sprint.models.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction,Long>{ 
	@Query("SELECT SUM(r.cost) FROM Transaction r,Customer c WHERE c.customerId = :customerId AND r.date BETWEEN :date AND :date1")
	  Double findTotalAmountSpentByCustomerIdBetweenDates(@Param("customerId") Long customerId,
	                                                      @Param("date1") LocalDate endDate,
	                                                      @Param("date") LocalDate startDate);

}
