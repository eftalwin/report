/**
 * 
 */
package com.alwin.incident.report.data.payloads;

/**
 * @author anubi
 *
 */
public class Response {

	private String message;

	public Response(String message) {
		this.message = message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
