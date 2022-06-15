package edu.emich.CatsCaninesCode.controllers;


import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.emich.CatsCaninesCode.entities.Pet;
import edu.emich.CatsCaninesCode.entities.User;
import edu.emich.CatsCaninesCode.entities.Appointment;
import edu.emich.CatsCaninesCode.entities.Record;
import edu.emich.CatsCaninesCode.repos.PetRepo;
import edu.emich.CatsCaninesCode.repos.UserRepo;
import edu.emich.CatsCaninesCode.repos.AppointmentRepo;
import edu.emich.CatsCaninesCode.repos.RecordRepo;

@Controller
public class MainController {
	
	
	@Autowired
	private PetRepo pRepo;
	
	@Autowired
	private UserRepo uRepo;
	
	@Autowired
	private AppointmentRepo aRepo;
	
	@Autowired
	private RecordRepo rRepo;
	
	@RequestMapping("/")
	public ModelAndView index() {
		return new ModelAndView("home/index", "message", "Hello World!");
//		return new ModelAndView("register");
	}
	@RequestMapping("/register")
	public ModelAndView register() {
		return new ModelAndView("register");
	}
	
	@PostMapping("/")
	public ModelAndView postNewPet(
			@RequestParam("ownerName") String userName,
			@RequestParam("email") String email,
			@RequestParam("petName") String petName,
			@RequestParam("password") String password
			) {
		
		
		User user = new User(userName, email, password);
		uRepo.save(user);
		List<User> userList = uRepo.findByEmailIgnoreCase(email);
		Pet pet = new Pet(petName, userList.get(0));
		pRepo.save(pet);
		return new ModelAndView("register", "message", String.format("%s registered successfully! Thank you %s!", petName, userName));
	}
	

//****************create owner controller**************************************************
	@RequestMapping("/admin/createowner")
	public ModelAndView createowner() {
		return new ModelAndView("/admin/createowner");
	}
	
	@PostMapping("/admin/createowner")
	public ModelAndView postNewOwner(
			@RequestParam("ownerName") String name,
			@RequestParam("ownerEmail") String email,
			@RequestParam("ownerAddress") String address,
			@RequestParam("ownerPhoneNumber") String phone,
			@RequestParam("ownerPassword") String password,
			@RequestParam("history") String acctType
			) {
		
		
		User user = new User(name, email, address, password, phone, acctType);
		uRepo.save(user);
		List<User> userList = uRepo.findByEmailIgnoreCase(email);
		//Pet pet = new Pet(petName, userList.get(0));
		//pRepo.save(pet);
		return new ModelAndView("/admin/createowner", "message", String.format("%s registered successfully! Thank you %s!", name, name));
	}
//*****************************************************************************************
	
	
//****************create pet controller**************************************************
	@RequestMapping("/admin/createpet")
	public ModelAndView createpet() {
		return new ModelAndView("/admin/createpet");
	}
	
	@PostMapping("/admin/createpet")
	public ModelAndView postNewPet(
			@RequestParam("petName") String name,
			@RequestParam("petDOB") String dob,
			@RequestParam("petSpecies") String species,
			@RequestParam("petDescription") String description,
			@RequestParam("ownerEmail") String email
			) {
		
		List<User> userList = uRepo.findByEmailIgnoreCase(email);
		if(userList.size() == 0) {
			// no user found with this email, abort
			System.exit(0);
		}
		User user = userList.get(0);
		Pet pet = new Pet(name, dob, species, description, user);
		pRepo.save(pet);
		return new ModelAndView("/admin/createpet", "message", String.format("%s registered successfully! Thank you %s!", name, name));
	}
//*****************************************************************************************

	
//****************create appointment controller********************************************
	@RequestMapping("/admin/createappointment")
	public ModelAndView createappointment() {
		return new ModelAndView("/admin/createappointment");
	}
	
	@PostMapping("/admin/createappointment")
	public ModelAndView postNewAppointment(
			@RequestParam("date") String date,
			@RequestParam("amtOwed") String owed,
			@RequestParam("amtPaid") String paid,
			@RequestParam("petID") String id
			) {
		
//		List<User> petList = pRepo.findByIDIgnoreCase(petID);
//		if(userList.size() == 0) {
//			// no user found with this email, abort
//			System.exit(0);
//		}
//		User user = userList.get(0);
		Appointment appointment = new Appointment(date, owed, paid);
		aRepo.save(appointment);
		return new ModelAndView("/admin/createappointment", "message", String.format("Appointment on %s registered successfully! Thank you!", date));
	}
	
//*****************************************************************************************
	
	
//****************create record controller*************************************************
	@RequestMapping("/admin/createrecord")
	public ModelAndView createrecord() {
		return new ModelAndView("/admin/createrecord");
	}
	
	
	@PostMapping("/admin/createrecord")
	public ModelAndView postNewRecord(
			@RequestParam("serviceCode") String code,
			@RequestParam("renewalDate") String date,
			@RequestParam("appointmentID") String id,
			@RequestParam("cost") String cost,
			@RequestParam("description") String description
			) {
		
//		List<User> petList = pRepo.findByIDIgnoreCase(petID);
//		if(userList.size() == 0) {
//			// no user found with this email, abort
//			System.exit(0);
//		}
//		User user = userList.get(0);
		Record record = new Record(code, date, id, cost, description);
		rRepo.save(record);
		return new ModelAndView("/admin/createrecord", "message", String.format("%s record registered successfully! Thank you!", description));
	}
	
//*****************************************************************************************


	@RequestMapping("/userlookup")
	public ModelAndView userLookup() {
		return new ModelAndView("userlookup");
	}
	
	@PostMapping("/userlookup")
	public ModelAndView showUserLookup(
			@RequestParam("email") String email) {
		List<User> userList = uRepo.findByEmailIgnoreCase(email);
		return new ModelAndView("userlookup", "users", userList);
	}
	
	@RequestMapping("{email}/pets")
	public ModelAndView editTask(@PathVariable("email") User user) {
		List<Pet> petList = pRepo.findByUserEmailIgnoreCase(user.getEmail());
		return new ModelAndView("petlookup", "pets", petList);
	}
}