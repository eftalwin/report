/**
 * 
 */
package com.alwin.incident.report.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.alwin.incident.report.data.models.Incident;
import com.alwin.incident.report.data.payloads.ReportRequest;
import com.alwin.incident.report.data.payloads.Response;

/**
 * @author anubi
 *
 */
@Component
public interface IncidentReportService {
	Response createIncident(ReportRequest reportRequest);

	List<Incident> getAllIncidents();

	Response updateIncident(Integer id, ReportRequest request);

	List<Incident> getIncidentByCreatorName(String creator);

	Response deleteIncident(Integer id);

	Incident getASingleIncident(Integer id);
	
	Incident saveIncident(Incident incident);
	
	Incident updateIncident(Incident incident);
	

}
