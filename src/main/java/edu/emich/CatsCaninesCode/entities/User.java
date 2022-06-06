package edu.emich.CatsCaninesCode.entities;

import java.util.Set;

import javax.persistence.OneToMany;

public class User {

	private String name;
	private String address;
	private String email;
	private String password;
	@OneToMany(mappedBy="pet")
	private Set<Pet> pets;
}
