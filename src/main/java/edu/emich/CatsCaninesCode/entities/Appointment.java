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
	
//I think I need this
//	private long pet_id;
	
//	private LocalDate date;
	private String date;
	
// 	temporarily removed attributes - Sam Keim
	private double amtOwed;
	private double amtPaid;
	
	@ManyToOne
	private Pet pet;
	
	@OneToMany(mappedBy="appointment")
	private Set<Record> records;
	
	public Appointment(String date, String amtOwed, String amtPaid) {
		super();
//		this.pet_id = Long.parseLong(pet_id);
		this.date = date;
		this.amtOwed = Double.parseDouble(amtOwed);
		this.amtPaid = Double.parseDouble(amtPaid);

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
//	public Long getPetId() {
//		return pet_id;
//	}
//
//	public void setPetId(long pet_id) {
//		this.pet_id = pet_id;
//	}

	public String getDate() {
//		String date = this.date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		return date;
	}

	public void setDate(String date) {
//		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//		LocalDate setDate = LocalDate.parse(date, format);
		this.date = date;
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
	

//	public Pet getPet() {
//		return pet;
//	}
//
//	public void setPet(Pet pet) {
//		this.pet = pet;
//	}

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
