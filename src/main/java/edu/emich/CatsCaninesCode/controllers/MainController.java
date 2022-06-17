package edu.emich.CatsCaninesCode.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	
	@RequestMapping("/")
	public ModelAndView index() {
		return new ModelAndView("home/index");
	}

	//	Path Variable Example
//	@RequestMapping("/{email}/pets")
//	public ModelAndView editTask(@PathVariable("email") User user) {
//		List<Pet> petList = pRepo.findByUserEmailIgnoreCase(user.getEmail());
//		return new ModelAndView("lookup/petlookup", "pets", petList);
//	}
}