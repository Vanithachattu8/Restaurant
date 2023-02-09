package com.sprint.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "restaurant")
public class Restaurant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="restaurant_id")
	private long restaurantId;
	
	@Column(name= "table_number")
	private int tableNumber;
	
	@Column(name = "seating")
	private int seating;
	

//@JsonIgnoreProperties("restaurant")
//@ManyToMany
////@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
//@JoinTable(
//        joinColumns = {@JoinColumn(name = "id", nullable = false, updatable = false)},
//        inverseJoinColumns = {@JoinColumn(name = "booking_id", nullable = false, updatable = false)}
//)
//	private List<Booking> booking;

	@OneToOne
	@JoinColumn(name = "admin_id")
	private Admin admin;
}
