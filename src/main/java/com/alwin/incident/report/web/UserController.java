/**
 * 
 */
package com.alwin.incident.report.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.alwin.incident.report.service.IncidentReportService;

/**
 * @author anubi
 *
 */
@Controller
public class UserController {

	private IncidentReportService incidentReportService;

	public UserController(IncidentReportService incidentReportService) {
		super();
		this.incidentReportService = incidentReportService;
	}

	@GetMapping("/home")
	public String listAllIncidents(Model model) {
		model.addAttribute("incidents", incidentReportService.getAllIncidents());
		return "home";
	}


	
	
	

}
