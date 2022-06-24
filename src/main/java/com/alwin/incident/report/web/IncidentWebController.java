/**
 * 
 */
package com.alwin.incident.report.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.alwin.incident.report.data.models.Incident;
import com.alwin.incident.report.service.IncidentReportService;

/**
 * @author anubi
 *
 */
@Controller
public class IncidentWebController {

	private IncidentReportService incidentReportService;
	
	//private StudentService studentService;

	public IncidentWebController(IncidentReportService incidentReportService) {
		super();
		this.incidentReportService = incidentReportService;
	}

	// handler method to handle list students and return mode and view
	@GetMapping("/index")
	public String listStudents(Model model) {
		model.addAttribute("incidents", incidentReportService.getAllIncidents());
		return "index";
	}

	/*
	 * @GetMapping("/students/new") public String createStudentForm(Model model) {
	 * // create student object to hold student form data Student student = new
	 * Student(); model.addAttribute("student", student); return "createincident";
	 * 
	 * }
	 * 
	 * @PostMapping("/incidents") public String
	 * saveIncident(@ModelAttribute("incident") Student student) {
	 * studentService.saveStudent(student); return "redirect:/incidents"; }
	 */

	/*
	 * @GetMapping("/students/edit/{id}") public String
	 * editIncidentForm(@PathVariable Long id, Model model) {
	 * model.addAttribute("student", studentService.getStudentById(id)); return
	 * "editincident"; }
	 * 
	 * @PostMapping("/students/{id}") public String updateIncident(@PathVariable
	 * Long id, @ModelAttribute("student") Student student, Model model) {
	 * 
	 * // get student from database by id Student existingStudent =
	 * studentService.getStudentById(id); existingStudent.setId(id);
	 * existingStudent.setFirstName(student.getFirstName());
	 * existingStudent.setLastName(student.getLastName());
	 * existingStudent.setEmail(student.getEmail());
	 * 
	 * // save updated student object studentService.updateStudent(existingStudent);
	 * return "redirect:/students"; }
	 * 
	 * // handler method to handle delete student request
	 * 
	 * @GetMapping("/students/{id}") public String deleteStudent(@PathVariable Long
	 * id) { studentService.deleteStudentById(id); return "redirect:/students"; }
	 */

}