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
import edu.emich.CatsCaninesCode.entities.Record;
import edu.emich.CatsCaninesCode.repos.AppointmentRepo;
import edu.emich.CatsCaninesCode.repos.PetRepo;
import edu.emich.CatsCaninesCode.repos.RecordRepo;

@Controller
@RequestMapping("/appointment")
public class AppointmentController {

	@Autowired
	private PetRepo pRepo;
	
	@Autowired
	private AppointmentRepo aRepo;
	
	@Autowired
	private RecordRepo rRepo;
	
	
	
//****************create appointment controller********************************************
	@RequestMapping("/create/{petId}")
	public ModelAndView createappointment(@PathVariable("petId") Long petId) {
		// get pet
		Pet pet = pRepo.findById(petId).orElse(null);

		// check if id is valid
		if(pet == null) {
			return new ModelAndView("/appointment/create", "danger", "Invalid pet ID, please try again.");
		}
		
		return new ModelAndView("/appointment/create", "pet", pet);
	}
	
	@PostMapping("/create/{petId}")
	public ModelAndView postNewAppointment(
			@RequestParam("date") String date,
			@RequestParam("amtOwed") String owed,
			@RequestParam("amtPaid") String paid,
			@PathVariable("petId") Pet pet
			) {
		aRepo.save(new Appointment(date, owed, paid, pet));
		ModelAndView returnView = new ModelAndView("/appointment/create");
		returnView.addObject("pet", pet);
		returnView.addObject("message", String.format("Appointment on %s registered successfully! Thank you!", date));
		return returnView;
	}
	
//*****************************************************************************************
		
	@RequestMapping("/view/{id}")
	public ModelAndView viewAppointment(@PathVariable("id") long appointmentId) {
		// get appointment
		Appointment appointment = aRepo.findById(appointmentId).orElse(null);
		if(appointment == null) {
			return new ModelAndView("appointment/view", "danger", "Appointment not found, please try again.");
		}
		
		// get records
		List<Record> records = rRepo.findByAppointmentId(appointmentId);
		
		ModelAndView returnView = new ModelAndView("appointment/view");
		returnView.addObject("appointment", appointment);
		if(!records.isEmpty()) {
			returnView.addObject("records", records);		
		}
		return returnView;
	}
			
	@RequestMapping("/edit/{id}")
	public ModelAndView editAppointment(@PathVariable("id") long id, RedirectAttributes redir) {
		Appointment appointment = aRepo.findById(id).orElse(null);
		// check if id is valid
		if(appointment == null) {
			redir.addFlashAttribute("danger", String.format("Invalid appointment id: %d. Please try again.", id));
			return new ModelAndView("redirect:/user/lookup");
		}
		return new ModelAndView("appointment/edit", "appointment", appointment);
	}
	
	@PostMapping("/edit/{id}")
	public ModelAndView editAppointmentPost(
			@PathVariable("id") long id,
			@RequestParam("date") String date,
			@RequestParam("amtOwed") String owed,
			@RequestParam("amtPaid") String paid,
			@RequestParam("petId") Pet pet,
			RedirectAttributes redir) {
		aRepo.save(new Appointment(id, date, owed, paid, pet));
		redir.addFlashAttribute("success", String.format("Appointment on %s updated successfully.", date));
		return new ModelAndView(String.format("redirect:/appointment/view/%d", id));
	}
	
}
