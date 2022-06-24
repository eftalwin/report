/**
 * 
 */
package com.alwin.incident.report.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.alwin.incident.report.data.models.Incident;
import com.alwin.incident.report.data.models.Status;
import com.alwin.incident.report.data.models.User;
import com.alwin.incident.report.data.payloads.ReportRequest;
import com.alwin.incident.report.data.payloads.Response;
import com.alwin.incident.report.data.repository.IncidentRepository;
import com.alwin.incident.report.exception.ResourceNotFoundException;

/**
 * @author anubi
 *
 */
@Service
public class IncidentReportServiceImpl implements IncidentReportService {

	@Autowired
	IncidentRepository incidentRepository;

	@Autowired
	private Validator validator;

	public IncidentReportServiceImpl(IncidentRepository incidentRepository) {
		super();
		this.incidentRepository = incidentRepository;
	}

	@Override
	public Response createIncident(ReportRequest reportRequest) {
		Incident incident = new Incident();
		incident.setCreator(reportRequest.getCreator());
		incident.setTitle(reportRequest.getTitle());
		incident.setAssignee(reportRequest.getAssignee());
		System.out.println("Status is " + reportRequest.getStatus());
		if (reportRequest.getStatus() == null)
			incident.setStatus(Status.NEW);
		else
			incident.setStatus(reportRequest.getStatus());
		String message = incidentValidations(incident);
		if (incident.getCreator().equals(incident.getAssignee()))
			incident.setStatus(Status.ASSIGNED);
		incidentRepository.save(incident);
		return new Response(message);

	}

	@Override
	public List<Incident> getAllIncidents() {
		return incidentRepository.findAll();
	}

	@Override
	public Response updateIncident(Integer id, ReportRequest request) {
		Optional<Incident> incident = incidentRepository.findById(id);
		if (incident.isEmpty()) {
			throw new ResourceNotFoundException("Incident is not Found");
		} else {
			incident.get().setCreator(request.getCreator());
			incident.get().setTitle(request.getTitle());
			incident.get().setAssignee(request.getAssignee());
			incident.get().setStatus(request.getStatus());
			incidentRepository.save(incident.get());
		}
		return new Response("Incident updated Successfully");
	}

	public String incidentValidations(Incident incident) {

		Set<ConstraintViolation<Incident>> violations = validator.validate(incident);
		if (!violations.isEmpty()) {
			StringBuilder sb = new StringBuilder();
			for (ConstraintViolation<Incident> constraintViolation : violations) {
				sb.append(constraintViolation.getMessage());
			}
			throw new ConstraintViolationException("Error occurred: " + sb.toString(), violations);
		}

		return "Incident Created by : " + incident.getCreator() + " is successfully added!";

	}

	@Override
	public List<Incident> getIncidentByCreatorName(String creator) {
		List<Incident> incident = incidentRepository.findByCreator(creator);
		if (incident.isEmpty())
			throw new ResourceNotFoundException("Incident is not Found");
		else
			return incident;
	}

	@Override
	public Response deleteIncident(Integer id) {
		if (incidentRepository.getReferenceById(id).getId().equals(id))
			incidentRepository.deleteById(id);
		else
			throw new ResourceNotFoundException("Incident is not Found");
		return new Response("Incident " + id + " deleted Successfully");
	}

	@Override
	public Incident getASingleIncident(Integer id) {
		Incident incident = incidentRepository.findById(id).get();
		if (incident.getId() == null)
			throw new ResourceNotFoundException("Incident is not found");
		return incident;
	}

	@Override
	public Incident saveIncident(Incident incident) {
		return incidentRepository.save(incident);
	}

	@Override
	public Incident updateIncident(Incident incident) {
		return incidentRepository.save(incident);
	}

	

	
}
