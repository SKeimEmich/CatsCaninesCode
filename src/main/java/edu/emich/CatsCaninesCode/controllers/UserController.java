package edu.emich.CatsCaninesCode.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.emich.CatsCaninesCode.entities.Pet;
import edu.emich.CatsCaninesCode.entities.User;
import edu.emich.CatsCaninesCode.repos.PetRepo;
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

	@RequestMapping("/edit/{email}")
	public ModelAndView editUser(@PathVariable("email") String email, RedirectAttributes redir) {
		User user = uRepo.findByEmailIgnoreCase(email);
		
		// check if email is valid
		if(user == null) {
			redir.addFlashAttribute("danger", String.format("Invalid email address: %s. Please try again.", email));
			return new ModelAndView("redirect:/user/lookup");
		}
		
		return new ModelAndView("user/edit", "user", user);
	}
	
	@PostMapping("/edit/{email}")
	public ModelAndView editUserPost(
			@RequestParam("ownerName") String name,
			@RequestParam("ownerEmail") String email,
			@RequestParam("ownerAddress") String address,
			@RequestParam("ownerPhoneNumber") String phone,
			@RequestParam("ownerPassword") String password,
			@RequestParam("history") String acctType,
			RedirectAttributes redir
			) {
		User user = new User(name, email, address, password, phone, acctType);
		uRepo.save(user);
		redir.addFlashAttribute("success", String.format("%s updated successfully.", name));
		return new ModelAndView("redirect:/user/lookup");

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
		
		if(!petList.isEmpty()){
			returnView.addObject("pets", petList);
		}
		
		return returnView;
	}
	
	@RequestMapping("/delete/{email}")
	public ModelAndView delete(@PathVariable("email") String email, RedirectAttributes redir) {
		// check for email validity
		if(uRepo.existsById(email)){
			// delete
			try {
				uRepo.deleteById(email);
				redir.addFlashAttribute("success", String.format("%s deleted successfully.", email));
			} catch (Exception e) {
				redir.addFlashAttribute("danger", "Unable to delete user that contains pets. Please delete pets first.");
			}
		} else {
			redir.addFlashAttribute("danger", "Invalid email, please try again.");
		}
		return new ModelAndView("redirect:/user/lookup");
	}

}
