package edu.emich.CatsCaninesCode.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public ModelAndView createrecord(@PathVariable("appointmentId") long appointmentId, RedirectAttributes redir) {
		// get record
		Appointment appointment = aRepo.findById(appointmentId).orElse(null);
		
		// check if id is valid
		if(appointment == null) {
			redir.addFlashAttribute("danger", String.format("Invalid record Id %d.", appointmentId));
			return new ModelAndView("redirect:/user/lookup");
		}
		return new ModelAndView("/record/create", "appointment", appointment);
	}
	
	
	@PostMapping("/create/{appointmentId}")
	public ModelAndView postNewRecord(
			@RequestParam("serviceCode") String code,
			@RequestParam("renewalDate") String date,
			@RequestParam("cost") String cost,
			@RequestParam("description") String description,
			@PathVariable("appointmentId") Appointment appointment,
			RedirectAttributes redir
			) {
		
		Record record = new Record(code, date, cost, description, appointment);
		rRepo.save(record);
		redir.addFlashAttribute("success", String.format("%s record registered successfully! Thank you!", description));
		return new ModelAndView(String.format("redirect:/appointment/view/%d", appointment.getId()));
	}
	
//*****************************************************************************************

	@RequestMapping("/edit/{id}")
	public ModelAndView editRecord(@PathVariable("id") long id, RedirectAttributes redir) {
		Record record = rRepo.findById(id).orElse(null);
		if(record == null) {
			redir.addFlashAttribute("danger", String.format("Record id %d is invalid, please try again.", id));
			return new ModelAndView("redirect:/user/lookup");
		}
		return new ModelAndView("record/edit", "record", record);
	}
	
	@PostMapping("/edit/{id}")
	public ModelAndView editRecordPost(
			@PathVariable("id") long id,
			@RequestParam("serviceCode") String code,
			@RequestParam("renewalDate") String date,
			@RequestParam("cost") String cost,
			@RequestParam("description") String description,
			@RequestParam("appointmentId") Appointment appointment,
			RedirectAttributes redir
			) {
		rRepo.save(new Record(id, code, date, cost, description, appointment));
		redir.addFlashAttribute("success", String.format("Record %d updated successfully.", id));
		return new ModelAndView(String.format("redirect:/appointment/view/%d", appointment.getId()));
	}

	@RequestMapping("/delete/{id}")
	public ModelAndView deleteRecord(@PathVariable("id") long id, RedirectAttributes redir) {
		// get Appointment Id
		if(rRepo.existsById(id)) {
			long appointmentId = rRepo.findById(id).orElse(null).getAppointment().getId();
			// delete
			rRepo.deleteById(id);
			redir.addFlashAttribute("success", "Record deleted successfully.");
			return new ModelAndView(String.format("redirect:/appointment/view/%d", appointmentId));
		} else {
			// record not found
			redir.addFlashAttribute("danger", "Record not found");
			return new ModelAndView("redirect:/user/lookup");
		}
	}
}
