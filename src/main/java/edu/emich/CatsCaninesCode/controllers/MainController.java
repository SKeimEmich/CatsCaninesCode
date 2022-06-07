package edu.emich.CatsCaninesCode.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.emich.CatsCaninesCode.entities.Pet;
import edu.emich.CatsCaninesCode.entities.User;
import edu.emich.CatsCaninesCode.repos.PetRepo;
import edu.emich.CatsCaninesCode.repos.UserRepo;

@Controller
public class MainController {
	
	
	@Autowired
	private PetRepo pRepo;
	
	@Autowired
	private UserRepo uRepo;
	
	@RequestMapping("/")
	public ModelAndView index() {
//		return new ModelAndView("index", "message", "Hello World!");
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
//		user = uRepo.findByEmail(email).get(0);
//		Pet pet = new Pet(petName, user);
//		pRepo.save(pet);
		return new ModelAndView("register", "message", String.format("%s registered successfully!", petName));
	}
	
	
}
