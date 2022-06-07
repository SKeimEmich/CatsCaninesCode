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
	
	private Long appointmentId;
	private int serviceCode;
	private String description;
	private int monthsOfEffect; // recorded as number of months
//	private double cost; // Temporarily removed - Sam Keim
	
	@ManyToOne
	private Appointment appointment;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(Long appointmentId) {
		this.appointmentId = appointmentId;
	}

	public int getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(int serviceCode) {
		this.serviceCode = serviceCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getMonthsOfEffect() {
		return monthsOfEffect;
	}

	public void setMonthsOfEffect(int monthsOfEffect) {
		this.monthsOfEffect = monthsOfEffect;
	}

	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

	@Override
	public String toString() {
		return "Record [serviceCode=" + serviceCode + ", description=" + description + ", monthsOfEffect="
				+ monthsOfEffect + ", appointment=" + appointment + "]";
	}
	
}
