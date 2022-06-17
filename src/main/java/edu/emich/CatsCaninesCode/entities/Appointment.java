package edu.emich.CatsCaninesCode.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Appointment {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
		
	private LocalDate date;
	
	private double amtOwed;
	private double amtPaid;
	
	@ManyToOne
	private Pet pet;
	
	@OneToMany(mappedBy="appointment")
	private Set<Record> records;
	
	public Appointment() {
		
	}
	
	public Appointment(String date, String amtOwed, String amtPaid, Pet pet) {
		super();
		setDate(date);
		this.amtOwed = Double.parseDouble(amtOwed);
		this.amtPaid = Double.parseDouble(amtPaid);
		this.pet = pet;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getDate() {
		String date = this.date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
		return date;
	}

	public void setDate(String date) {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd['T']HH:mm");
		LocalDate setDate = LocalDate.parse(date, format);
		this.date = setDate;
		
	}
	
	public double getAmtOwed() {
		return amtOwed;
	}
	
	public void setAmtOwed(double amtOwed)
	{
		this.amtOwed = amtOwed;
	}
	
	public double getAmtPaid() {
		return amtPaid;
	}
	
	public void setAmtPaid(double amtPaid)
	{
		this.amtPaid = amtPaid;
	}
	
	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}

	public Set<Record> getRecords() {
		return records;
	}

	public void setRecords(Set<Record> records) {
		this.records = records;
	}

	@Override
	public String toString() {
		return "Appointment [id=" + id + ", date=" + date + ", pet=" + pet + "]";
	}
	
	
	
}
