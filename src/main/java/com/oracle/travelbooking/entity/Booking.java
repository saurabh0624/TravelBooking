package com.oracle.travelbooking.entity;

import java.sql.Date;
import java.time.LocalDate;
import java.util.TreeSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long bookingId;
	
	private LocalDate bookingDate;
	
	@NotNull
	@NotBlank
	private String destination;
	
	private String hotelName;
	
	private TreeSet<String> activities;
	
	private String vehicle;
	
	@Min(0)
	private int bookingAmount;
	
	private String paymentStatus;

}
