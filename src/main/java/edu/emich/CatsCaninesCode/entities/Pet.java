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
public class Pet {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String species;
	private String description;
	private LocalDate dateOfBirth;
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

	public String getDateOfBirth() {
		if(dateOfBirth != null) {
			String date = dateOfBirth.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			return date;
		} else {
			return "";
		}
	}

	public void setDateOfBirth(String dateOfBirth) {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate setDueDate = LocalDate.parse(dateOfBirth, format);
		this.dateOfBirth = setDueDate;
	}

	public User getOwner() {
		return user;
	}

	public void setOwner(User owner) {
		this.user = owner;
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
