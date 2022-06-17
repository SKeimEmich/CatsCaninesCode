package edu.emich.CatsCaninesCode.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.emich.CatsCaninesCode.entities.Appointment;
import edu.emich.CatsCaninesCode.entities.Pet;
import edu.emich.CatsCaninesCode.entities.User;
import edu.emich.CatsCaninesCode.repos.AppointmentRepo;
import edu.emich.CatsCaninesCode.repos.PetRepo;
import edu.emich.CatsCaninesCode.repos.UserRepo;

@Controller
@RequestMapping("/pet")
public class PetController {

	@Autowired
	private PetRepo pRepo;
	
	@Autowired
	private AppointmentRepo aRepo;
		
	@Autowired
	private UserRepo uRepo;

//****************create pet controller**************************************************
	@RequestMapping("/create/{email}")
	public ModelAndView createpet(@PathVariable("email") String email) {
		User user = uRepo.findByEmailIgnoreCase(email);
		if(user == null) {
			// no user found with this email, abort
			return new ModelAndView("/pet/create", "danger", "User not found.");
		}
		return new ModelAndView("/pet/create", "email", email);
	}
	
	@PostMapping("/create/{email}")
	public ModelAndView newPetPost(
			@RequestParam("petName") String name,
			@RequestParam("petDOB") String dob,
			@RequestParam("petSpecies") String species,
			@RequestParam("petDescription") String description,
			@PathVariable("email") User user
			) {
		pRepo.save(new Pet(name, dob, species, description, user));
		return new ModelAndView("/pet/create", "success", String.format("%s registered successfully! Thank you %s!", name, user.getName()));
	}
//*****************************************************************************************
		
		
	@RequestMapping("/view/{id}")
	public ModelAndView viewPet(@PathVariable("id") long id) {
		// Get pet
		Pet pet = pRepo.findById(id).orElse(null);
		
		// pet not found
		if(pet == null) {
			return new ModelAndView("/pet/view", "danger", "Pet not found, please try again.");
		}
		
		// Get appointments
		List<Appointment> appointments = aRepo.findByPetId(id);
		
		// Create new View
		ModelAndView returnView = new ModelAndView("/pet/view");
		
		// Add objects
		if(!appointments.isEmpty()) {
			returnView.addObject("appointments", appointments);
		}
		
		returnView.addObject("pet", pet);

		return returnView;
	}
			
	@RequestMapping("/edit")
	public ModelAndView editPet() {
		return new ModelAndView("todo");
	}
	
	@PostMapping("/edit")
	public ModelAndView editPetPost() {
		return new ModelAndView("todo");
	}
	
}
