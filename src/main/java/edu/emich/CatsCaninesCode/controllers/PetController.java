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
	public ModelAndView createpet(@PathVariable("email") String email, RedirectAttributes redir) {
		User user = uRepo.findByEmailIgnoreCase(email);
		if(user == null) {
			// no user found with this email, abort
			redir.addFlashAttribute("danger", String.format("Owner email %s not found.", email));
			return new ModelAndView("redirect:/user/lookup");
		}
		return new ModelAndView("pet/create", "email", email);
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
		ModelAndView returnView = new ModelAndView("pet/create");
		
		returnView.addObject("success", String.format("%s registered successfully! Thank you %s!", name, user.getName()));
		returnView.addObject("email", user.getEmail());
		return returnView;
	}
//*****************************************************************************************
		
		
	@RequestMapping("/view/{id}")
	public ModelAndView viewPet(@PathVariable("id") long id, RedirectAttributes redir) {
		// Get pet
		Pet pet = pRepo.findById(id).orElse(null);
		
		// pet not found
		if(pet == null) {
			redir.addFlashAttribute("danger", String.format("Pet Id %d not found, please try again.", id));
			return new ModelAndView("redirect:/user/lookup");
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
			
	@RequestMapping("/edit/{id}")
	public ModelAndView editPet(@PathVariable("id") long id, RedirectAttributes redir) {
		Pet pet = pRepo.findById(id).orElse(null);
		// check if id is valid
		if(pet == null) {
			redir.addFlashAttribute("danger", String.format("Invalid pet id: %d. Please try again.", id));
			return new ModelAndView("redirect:/user/lookup");
		}
		return new ModelAndView("pet/edit", "pet", pet);
	}
	
	@PostMapping("/edit/{id}")
	public ModelAndView editPetPost(
			@PathVariable("id") long id,
			@RequestParam("petName") String name,
			@RequestParam("petDOB") String dob,
			@RequestParam("petSpecies") String species,
			@RequestParam("petDescription") String description,
			@RequestParam("email") User user,
			RedirectAttributes redir) {
		pRepo.save(new Pet(id, name, dob, species, description, user));
		redir.addFlashAttribute("success", String.format("%s updated successfully.", name));
		return new ModelAndView(String.format("redirect:/pet/view/%d", id));
	}
	
	@RequestMapping("/delete/{id}")
	public ModelAndView deletePet(@PathVariable("id") long id, RedirectAttributes redir) {
		// check if pet exists
		if(pRepo.existsById(id)) {
			// get pet name for success message
			String petName = pRepo.findById(id).orElse(null).getName();
			// delete
			pRepo.deleteById(id);
			redir.addFlashAttribute("success", String.format("%s was deleted.", petName));
		} else {
			// pet does not exist
			redir.addFlashAttribute("danger", String.format("Invalid Id: %d, please try again.", id));
		}
		// redirect
		return new ModelAndView("redirect:/user/lookup");
	}
	
}
