/**
 * 
 */
package com.alwin.incident.report.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.alwin.incident.report.data.models.User;
import com.alwin.incident.report.service.IncidentReportService;
import com.alwin.incident.report.service.UserService;

/**
 * @author anubi
 *
 */
@Controller
public class UserController {

	private String loginName;

	@Autowired
	UserService userService;

	private IncidentReportService incidentReportService;

	@PostMapping("/login")
	public String loginProcess(Model model) {
		return "redirect:/users";
	}

	@GetMapping("/login")
	public String viewLoginPage() {
		return "login";
	}

	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		model.addAttribute("user", new User());
		return "signup_form";
	}

	@PostMapping("/process_register")
	public String processRegister(User user) {
		userService.saveUser(user);
		return "register_success";
	}

	@GetMapping("/users")
	public String listUsers(Model model) {
		List<User> listUsers = userService.getAllUsers();
		model.addAttribute("listUsers", listUsers);
		return "users";
	}

	public UserController(IncidentReportService incidentReportService) {
		super();
		this.incidentReportService = incidentReportService;
	}

	@GetMapping("/home")
	public String listAllIncidents(Model model) {
		model.addAttribute("incidents", incidentReportService.getAllIncidents());
		return "home";
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

}
