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
	
	//not sure if this is needed? d.biske
	//private LocalDate date;
	private String petId;
	private String date;
	private double amtOwed;
	private double amtPaid;
	
	@ManyToOne
	private Pet pet;
	
	@OneToMany(mappedBy="appointment")
	private Set<Record> records;

	public Appointment() {
		
	}
	
	public Appointment(String petId, String date, double amtOwed, double amtPaid)
	{
		super();
		this.petId = petId;
		this.date = date;
		this.amtOwed = amtOwed;
		this.amtPaid = amtPaid;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getPetId() {
		return petId;
	}
	
	public void setPetID(String petId) {
		this.petId = petId;
	}

	public String getDate() {
		//String date = this.date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		return date;
	}

	public void setDate(String date) {
		//DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		//LocalDate setDate = LocalDate.parse(date, format);
		this.date = date;
	}
	
	public double getamtOwed() {
		return amtOwed;
	}
	
	public void setAmountOwed(double amtOwed) {
		this.amtOwed = amtOwed;
	}
	
	public double getamtPaid() {
		return amtPaid;
	}
	
	public void setAmountPaid(double amtPaid) {
		this.amtOwed = amtPaid;
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
