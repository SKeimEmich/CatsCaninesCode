package edu.emich.CatsCaninesCode.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Record {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private int serviceCode;
	private String date;
	private String description;
//	private int monthsOfEffect; // recorded as number of months
	private double cost; // Temporarily removed - Sam Keim
	
	@ManyToOne
	private Appointment appointment;

	public Record() {
		
	}
	public Record(String code, String date, String cost, String description, Appointment appointment)
	{
		super();
		this.serviceCode = Integer.valueOf(code);
		this.date = date;
		this.cost = Double.parseDouble(cost);
		this.description = description;
		this.appointment = appointment;
	}
	
	public Record(long id, String code, String date, String cost, String description, Appointment appointment)
	{
		super();
		this.id = id;
		this.serviceCode = Integer.valueOf(code);
		this.date = date;
		this.cost = Double.parseDouble(cost);
		this.description = description;
		this.appointment = appointment;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = Integer.valueOf(serviceCode);
	}
	

	public String getDate() {
//		String date = this.date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		return date;
	}

	public void setDate(String date) {
//		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//		LocalDate setDate = LocalDate.parse(date, format);
		this.date = date;
	}
	
	public double getCost() {
		return cost;
	}
	
	public void setCost(double cost)
	{
		this.cost = cost;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
//
//	public int getMonthsOfEffect() {
//		return monthsOfEffect;
//	}
//
//	public void setMonthsOfEffect(int monthsOfEffect) {
//		this.monthsOfEffect = monthsOfEffect;
//	}

	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

	@Override
	public String toString() {
		return "Record [serviceCode=" + serviceCode + ", description=" + description + 
//				", monthsOfEffect=" + monthsOfEffect +
				", appointment=" + appointment + "]";
	}
	
}
