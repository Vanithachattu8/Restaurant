package com.sprint.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprint.models.Admin;
import com.sprint.models.Booking;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Long>{
	//List<Booking> findByCustomerId(Long customerId);
}
