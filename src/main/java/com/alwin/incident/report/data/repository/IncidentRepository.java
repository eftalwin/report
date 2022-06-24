/**
 * 
 */
package com.alwin.incident.report.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alwin.incident.report.data.models.Incident;

/**
 * @author anubi
 *
 */
@Repository
public interface IncidentRepository extends JpaRepository<Incident, Integer>{
	
	List<Incident> findByCreator(String creator);
	List<Incident> findByAssignee(String assignee);
	List<Incident> findByStatus(String status);
	
}
