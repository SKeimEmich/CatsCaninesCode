package edu.emich.CatsCaninesCode.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.emich.CatsCaninesCode.entities.Appointment;
import edu.emich.CatsCaninesCode.entities.Pet;
import edu.emich.CatsCaninesCode.repos.AppointmentRepo;
import edu.emich.CatsCaninesCode.repos.PetRepo;
import edu.emich.CatsCaninesCode.repos.RecordRepo;
import edu.emich.CatsCaninesCode.repos.UserRepo;

@Controller
@RequestMapping("/appointment")
public class AppointmentController {

	@Autowired
	private PetRepo pRepo;
	
	@Autowired
	private UserRepo uRepo;
	
	@Autowired
	private AppointmentRepo aRepo;
	
	@Autowired
	private RecordRepo rRepo;
	
	
	
//****************create appointment controller********************************************
	@RequestMapping("/create/{id}")
	public ModelAndView createappointment(@PathVariable("id") Long id) {
		return new ModelAndView("/appointment/create");
	}
	
	@PostMapping("/create")
	public ModelAndView postNewAppointment(
			@RequestParam("date") String date,
			@RequestParam("amtOwed") String owed,
			@RequestParam("amtPaid") String paid,
			@RequestParam("petID") Pet pet
			) {

		Appointment appointment = new Appointment(date, owed, paid, pet);
		aRepo.save(appointment);
		return new ModelAndView("/appointment/create", "message", String.format("Appointment on %s registered successfully! Thank you!", date));
	}
	
//*****************************************************************************************
		
	@RequestMapping("/view/{id}")
	public ModelAndView viewAppointment(@PathVariable("id") Appointment appointment) {
		return new ModelAndView("todo");
	}
			
	@RequestMapping("/edit")
	public ModelAndView editAppointment() {
		return new ModelAndView("todo");
	}
	
	@PostMapping("/edit")
	public ModelAndView editAppointmentPost() {
		return new ModelAndView("todo");
	}
	
}
