package edu.emich.CatsCaninesCode.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.emich.CatsCaninesCode.entities.Appointment;
import edu.emich.CatsCaninesCode.entities.Record;
import edu.emich.CatsCaninesCode.repos.AppointmentRepo;
import edu.emich.CatsCaninesCode.repos.PetRepo;
import edu.emich.CatsCaninesCode.repos.RecordRepo;
import edu.emich.CatsCaninesCode.repos.UserRepo;

@Controller
@RequestMapping("/record")
public class RecordController {

	@Autowired
	private PetRepo pRepo;
	
	@Autowired
	private UserRepo uRepo;
	
	@Autowired
	private AppointmentRepo aRepo;
	
	@Autowired
	private RecordRepo rRepo;
	
//****************create record controller*************************************************
	@RequestMapping("/create")
	public ModelAndView createrecord() {
		return new ModelAndView("/record/create");
	}
	
	
	@PostMapping("/create")
	public ModelAndView postNewRecord(
			@RequestParam("serviceCode") String code,
			@RequestParam("renewalDate") String date,
			@RequestParam("appointmentID") Appointment appointment,
			@RequestParam("cost") String cost,
			@RequestParam("description") String description
			) {
		
//			List<User> petList = pRepo.findByIDIgnoreCase(petID);
//			if(userList.size() == 0) {
//				// no user found with this email, abort
//				System.exit(0);
//			}
//			User user = userList.get(0);
		Record record = new Record(code, date, cost, description, appointment);
		rRepo.save(record);
		return new ModelAndView("/record/create", "message", String.format("%s record registered successfully! Thank you!", description));
	}
	
//*****************************************************************************************
	@RequestMapping("/view")
	public ModelAndView viewRecord() {
		return new ModelAndView("todo");
	}
			
	@RequestMapping("/edit")
	public ModelAndView editRecord() {
		return new ModelAndView("todo");
	}
	
	@PostMapping("/edit")
	public ModelAndView editRecordPost() {
		return new ModelAndView("todo");
	}
}
