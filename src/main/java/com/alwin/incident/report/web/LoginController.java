/**
 * 
 */
package com.alwin.incident.report.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alwin.incident.report.data.models.Incident;
import com.alwin.incident.report.data.models.User;
import com.alwin.incident.report.data.payloads.ReportRequest;
import com.alwin.incident.report.data.repository.UserRepository;
import com.alwin.incident.report.security.CustomUserDetails;
import com.alwin.incident.report.security.CustomUserDetailsService;
import com.alwin.incident.report.service.IncidentReportService;
import com.alwin.incident.report.service.UserService;

/**
 * @author anubi
 *
 */
@Controller
public class LoginController {

	@Autowired
	UserService userService;

	@Autowired
	IncidentReportService incidentReportService;

	private String loginName;

	@GetMapping("")
	public String viewHomePage() {
		return "index";
	}

	@PostMapping("/login")
	public String loginProcess(@ModelAttribute("userInfo") User user) {
		loginName = user.getUserName();
		return "redirect:/users";
	}

	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		model.addAttribute("user", new User());
		return "signup_form";
	}

	@GetMapping("/all")
	public String listIncidents(Model model) {
		model.addAttribute("incidents", incidentReportService.getAllIncidents());
		return "incidents";
	}

	@GetMapping("/myincidents")
	public String listMyIncidents(Model model) {
		System.out.println("******************" + loginName);
		model.addAttribute("incidents", incidentReportService.getAllIncidents());
		return "myincidents";
	}

	@GetMapping("/newincident")
	public String showAddIncidentForm(Model model) {
		model.addAttribute("incident", new Incident());
		return "addincident_form";
	}

	@PostMapping("/add")
	public String saveStudent(@ModelAttribute("incident") ReportRequest incident) {
		incidentReportService.createIncident(incident);
		/* return "redirect:/all"; */
		return "incidentreport_success";
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

	@GetMapping("/delete/{id}")
	public String deleteIncident(@PathVariable("id") Integer id) {
		incidentReportService.deleteIncident(id);
		return "redirect:/myincidents";
	}

	@GetMapping("/update/{id}")
	public String updateIncident(@PathVariable Integer id, Model model) {
		model.addAttribute("incident", incidentReportService.getASingleIncident(id));
		return "editincident";
	}
	
	@PostMapping("/update/{id}")
	public String updateIncident(@PathVariable Integer id,
			@ModelAttribute("incident") ReportRequest report,
			Model model) {
		incidentReportService.updateIncident(id, report);
		return "redirect:/myincidents";		
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

}
