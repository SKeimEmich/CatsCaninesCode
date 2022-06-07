package edu.emich.CatsCaninesCode.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

enum UserType {
	STAFF,
	CLIENT
}

@Entity
public class User {

	@Id
	private String email;

	private String name;
	private String address;
	private String password;
	private String phone;
	private UserType userType;
	
	@OneToMany(mappedBy="user")
	private Set<Pet> pets;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public UserType getUserType() {
		return userType;
	}
	public void setUserType(UserType userType) {
		this.userType = userType;
	}
	public Set<Pet> getPets() {
		return pets;
	}
	public void setPets(Set<Pet> pets) {
		this.pets = pets;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", address=" + address + ", email=" + email + ", password=" + password
				+ ", userType=" + userType + ", pets=" + pets + "]";
	}
	
	
}
