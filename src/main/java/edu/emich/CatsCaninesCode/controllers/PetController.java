package edu.emich.CatsCaninesCode.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.emich.CatsCaninesCode.entities.Pet;
import edu.emich.CatsCaninesCode.entities.User;
import edu.emich.CatsCaninesCode.repos.AppointmentRepo;
import edu.emich.CatsCaninesCode.repos.PetRepo;
import edu.emich.CatsCaninesCode.repos.RecordRepo;
import edu.emich.CatsCaninesCode.repos.UserRepo;

@Controller
@RequestMapping("/pet")
public class PetController {

	@Autowired
	private PetRepo pRepo;
	
	@Autowired
	private UserRepo uRepo;
	
	@Autowired
	private AppointmentRepo aRepo;
	
	@Autowired
	private RecordRepo rRepo;
	
//****************create pet controller**************************************************
	@RequestMapping("/create")
	public ModelAndView createpet() {
		return new ModelAndView("/pet/create");
	}
	
	@PostMapping("/create")
	public ModelAndView newPetPost(
			@RequestParam("petName") String name,
			@RequestParam("petDOB") String dob,
			@RequestParam("petSpecies") String species,
			@RequestParam("petDescription") String description,
			@RequestParam("ownerEmail") String email
			) {
		
		User user = uRepo.findByEmailIgnoreCase(email);
		if(user == null) {
			// no user found with this email, abort
			System.exit(0);
		}
		Pet pet = new Pet(name, dob, species, description, user);
		pRepo.save(pet);
		return new ModelAndView("/pet/create", "message", String.format("%s registered successfully! Thank you %s!", name, user.getName()));
	}
//*****************************************************************************************
		
		
	@RequestMapping("/view")
	public ModelAndView viewPet() {
		return new ModelAndView("todo");
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
