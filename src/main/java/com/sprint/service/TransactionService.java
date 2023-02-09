package com.sprint.service;

import java.util.Date;
import com.sprint.models.Transaction;

public interface TransactionService {
 public Transaction getTransactionByBookingId(Long BookingId);
 public Transaction getTransactionByCustomerId(Long Customer);
 public Transaction getAllTransactionByDateAndTime(Date date);
 }
