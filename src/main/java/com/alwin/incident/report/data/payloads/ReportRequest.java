package com.alwin.incident.report.data.payloads;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import com.alwin.incident.report.data.models.Status;

public class ReportRequest {
	
	private String creator;
	private String title;
	private String assignee;
	
	@Enumerated(EnumType.STRING)
	private Status status;

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
	
	

}
