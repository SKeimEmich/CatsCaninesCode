package edu.emich.CatsCaninesCode.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.emich.CatsCaninesCode.entities.Appointment;
import edu.emich.CatsCaninesCode.entities.Record;
import edu.emich.CatsCaninesCode.repos.AppointmentRepo;
import edu.emich.CatsCaninesCode.repos.RecordRepo;

@Controller
@RequestMapping("/record")
public class RecordController {

	@Autowired
	private RecordRepo rRepo;

	@Autowired
	private AppointmentRepo aRepo;

//****************create record controller*************************************************
	@RequestMapping("/create/{appointmentId}")
	public ModelAndView createrecord(@PathVariable("appointmentId") long appointmentId) {
		// get record
		Appointment appointment = aRepo.findById(appointmentId).orElse(null);
		
		// check if id is valid
		if(appointment == null) {
			return new ModelAndView("/record/create", "danger", "Invalid record Id");
		}

		return new ModelAndView("/record/create", "appointment", appointment);
	}
	
	
	@PostMapping("/create/{appointmentId}")
	public ModelAndView postNewRecord(
			@RequestParam("serviceCode") String code,
			@RequestParam("renewalDate") String date,
			@RequestParam("cost") String cost,
			@RequestParam("description") String description,
			@PathVariable("appointmentId") Appointment appointment
			) {
		
		Record record = new Record(code, date, cost, description, appointment);
		rRepo.save(record);
		return new ModelAndView("/record/create", "message", String.format("%s record registered successfully! Thank you!", description));
	}
	
//*****************************************************************************************

	@RequestMapping("/edit")
	public ModelAndView editRecord() {
		return new ModelAndView("todo");
	}
	
	@PostMapping("/edit")
	public ModelAndView editRecordPost() {
		return new ModelAndView("todo");
	}
}
