package com.sprint.service;

import com.sprint.exceptions.CustomerNotFoundException;

public interface AdminService {
	
	public double discountsForCustomers(Long customerId)throws CustomerNotFoundException;
	public double calculateMoneySpent(long customerId)throws CustomerNotFoundException;
	
	//public String sendInfoToCustomer();
		//public int UpdateAvailableTables();
	//public List<>findByCustomerId(customerId);
}