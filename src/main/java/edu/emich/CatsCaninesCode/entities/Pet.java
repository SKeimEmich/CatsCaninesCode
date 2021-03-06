package edu.emich.CatsCaninesCode.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Pet {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String species;
	private String description;
	private String dateOfBirth;
	@ManyToOne
	private User user;
	
	@OneToMany(mappedBy="pet")
	private Set<Appointment> appointments;

	public Pet() {
		
	}
	public Pet(String name, User user) {
		super();
		this.name = name;
		this.user = user;
	}
	
	public Pet(String name, String date, String species, String description, User user) {
		super();
		this.name = name;
		this.dateOfBirth = date;
		this.species = species;
		this.description = description;
		this.user = user;
	}
	public Pet(long id, String name, String date, String species, String description, User user) {
		super();
		this.name = name;
		this.dateOfBirth = date;
		this.species = species;
		this.description = description;
		this.user = user;
		this.id = id;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

//	public String getDateOfBirth() {
//		if(dateOfBirth != null) {
//			String date = dateOfBirth.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
//			return date;
//		} else {
//			return "";
//		}
//	}
//
//	public void setDateOfBirth(String dateOfBirth) {
//		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//		LocalDate setDueDate = LocalDate.parse(dateOfBirth, format);
//		this.dateOfBirth = setDueDate;
//	}
	
	public String getDateOfBirth() {
	return dateOfBirth;
	}


public void setDateOfBirth(String dateOfBirth) {
	this.dateOfBirth = dateOfBirth;
}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(Set<Appointment> appointments) {
		this.appointments = appointments;
	}

	@Override
	public String toString() {
		return "Pet [name=" + name + ", species=" + species + ", description=" + description + ", dateOfBirth="
				+ dateOfBirth + ", owner=" + user + "]";
	}
	
}
