/**
 * 
 */
package com.alwin.incident.report.data.models;

import javax.persistence.*;
import javax.validation.constraints.*;

/**
 * @author anubi
 *
 */
@Entity
public class Incident {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@NotBlank(message = " And Creator Field not be empty")
	@NotNull(message = " 'creator' is mandatory")
	private String creator;

	@NotBlank(message = " And Title Field not be empty")
	@NotNull(message = " 'title' is mandatory")
	private String title;

	@NotBlank(message = " And Assignee Field not be empty")
	@NotNull(message = " 'assignee' is mandatory")
	private String assignee;

	@Enumerated(EnumType.STRING)
	private Status status;

	public Incident() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAssignee() {
		return assignee;
	}

	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Incident{" + "id=" + id + ", creator='" + creator + '\'' + ", title='" + title + '\'' + ", assignee='"
				+ assignee + '\'' + ", status='" + status + '}';
	}

}
