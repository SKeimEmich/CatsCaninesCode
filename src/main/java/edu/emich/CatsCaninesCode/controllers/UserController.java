package edu.emich.CatsCaninesCode.controllers;

import java.util.List;

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
@RequestMapping("/user")
public class UserController {

	@Autowired
	private PetRepo pRepo;
	
	@Autowired
	private UserRepo uRepo;
	
//****************create owner controller**************************************************
	@RequestMapping("/create")
	public ModelAndView createowner() {
		return new ModelAndView("/user/create");
	}
	
	@PostMapping("/create")
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

		return new ModelAndView("/user/create", "message", String.format("New account for %s registered successfully!", name));
	}
//*****************************************************************************************

	@RequestMapping("/edit")
	public ModelAndView editUser() {
		return new ModelAndView("todo");
	}
	
	@PostMapping("/edit")
	public ModelAndView editUserPost() {
		return new ModelAndView("todo");
	}
	
	@RequestMapping("/lookup")
	public ModelAndView userLookup() {
		return new ModelAndView("user/lookup");
	}
	
	@PostMapping("/lookup")
	public ModelAndView userLookupPost(
			@RequestParam("email") String email) {
		User user = uRepo.findByEmailIgnoreCase(email);
		
		// Check for user not found, return error message
		if(user == null) {
			return new ModelAndView("user/lookup", "danger", String.format("%s not found, please try again.", email));
		}
		// User was found, get list of pets
		List<Pet> petList = pRepo.findByUserEmailIgnoreCase(email);
		
		// pass pet list and user to ModelAndView
		ModelAndView returnView = new ModelAndView("user/lookup");
		returnView.addObject("user", user);
		returnView.addObject("pets", petList);
		
		return returnView;
	}

}
