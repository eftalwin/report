/**
 * 
 */
package com.alwin.incident.report.web;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alwin.incident.report.data.models.Incident;
import com.alwin.incident.report.data.payloads.ReportRequest;
import com.alwin.incident.report.data.payloads.Response;
import com.alwin.incident.report.service.IncidentReportService;

/**
 * @author anubi
 *
 */
@RestController
@RequestMapping("/report")
public class IncidentController {

	@Autowired
	IncidentReportService incidentReportService;

	@PostMapping("/add")
	public ResponseEntity<Response> addIncident(@Valid @RequestBody ReportRequest report) {
		Response response = incidentReportService.createIncident(report);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@GetMapping("/all")
	public ResponseEntity<List<Incident>> getAllIncidents() {
		List<Incident> incident = incidentReportService.getAllIncidents();
		return new ResponseEntity<>(incident, HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Response> updateIncidentById(@PathVariable Integer id, @RequestBody ReportRequest request) {
		Response updateIncident = incidentReportService.updateIncident(id, request);
		return new ResponseEntity<>(updateIncident, HttpStatus.OK);
	}

	@GetMapping("/creator/{name}")
	public ResponseEntity<List<Incident>> getAllIncidentsByCreator(@PathVariable String name) {
		List<Incident> incident = incidentReportService.getIncidentByCreatorName(name);
		return new ResponseEntity<>(incident, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteIncident(@PathVariable("id") Integer id) {
		Response response = incidentReportService.deleteIncident(id);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<Incident> getIncidentById(@PathVariable("id") Integer id) {
		Incident incident = incidentReportService.getASingleIncident(id);
		return new ResponseEntity<>(incident, HttpStatus.OK);
	}
	/*
	 * @ResponseStatus(HttpStatus.BAD_REQUEST)
	 * 
	 * @ExceptionHandler(MethodArgumentNotValidException.class) public Map<String,
	 * String> handleValidationExceptions(MethodArgumentNotValidException ex) {
	 * Map<String, String> errors = new HashMap<>();
	 * ex.getBindingResult().getAllErrors().forEach((error) -> { String fieldName =
	 * ((FieldError) error).getField(); String errorMessage =
	 * error.getDefaultMessage(); errors.put(fieldName, errorMessage); }); return
	 * errors; }
	 */
}
