package edu.emich.CatsCaninesCode.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	@RequestMapping("/")
	public ModelAndView index() {
		return new ModelAndView("index", "message", "Hello World!");
	}
	@RequestMapping("/register")
	public ModelAndView register() {
		return new ModelAndView("register");
	}
	@RequestMapping("/adminlogin.html")
	public ModelAndView adminLogin() {
		return new ModelAndView("adminlogin");
	}
	@RequestMapping("/admin")
	public ModelAndView adminHome() {
		return new ModelAndView("admin");
	}
}
