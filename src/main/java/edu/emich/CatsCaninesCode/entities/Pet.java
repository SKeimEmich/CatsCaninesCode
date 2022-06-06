package edu.emich.CatsCaninesCode.entities;

import java.time.LocalDate;

import javax.persistence.ManyToOne;

public class Pet {
	
	private String name;
	private String species;
	private String description;
	private LocalDate dateOfBirth;
	@ManyToOne
	private User owner;
}
