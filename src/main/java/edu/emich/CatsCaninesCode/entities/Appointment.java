package edu.emich.CatsCaninesCode.entities;

import java.time.LocalDate;

import javax.persistence.ManyToOne;

public class Appointment {

	private LocalDate date;
	private double amtOwed;
	private double amtPaid;
	@ManyToOne
	private Pet pet;
//	@OneToMany
	
}
