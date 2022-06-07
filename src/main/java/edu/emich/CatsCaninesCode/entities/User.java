package edu.emich.CatsCaninesCode.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {

	@Id
	private String email;

	private String name;
	private String address;
	private String password;
	private String phone;
	private String acctType;
	
	@OneToMany(mappedBy="user")
	private Set<Pet> pets;
	
	public User() {
	}
	
	public User(String email, String name, String password) {
		super();
		this.email = email;
		this.name = name;
		this.password = password;
	}
	
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
	public String getUserType() {
		return acctType;
	}
	public void setUserType(String acctType) {
		this.acctType = acctType;
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
				+ ", userType=" + acctType + ", pets=" + pets + "]";
	}
	
	
}
