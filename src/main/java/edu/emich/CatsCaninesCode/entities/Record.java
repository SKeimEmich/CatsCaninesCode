package edu.emich.CatsCaninesCode.entities;

import javax.persistence.ManyToOne;

public class Record {
	
	private int serviceCode;
	private String description;
	private int lengthOfEffect; // recorded as number of months
	private double cost;
	
	@ManyToOne
	private Appointment appointment;
}
