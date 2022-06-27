/**
 * 
 */
package com.alwin.incident.report.service;

import java.util.List;

import com.alwin.incident.report.data.models.Incident;
import com.alwin.incident.report.data.models.User;
import com.alwin.incident.report.data.payloads.ReportRequest;
import com.alwin.incident.report.data.payloads.Response;

/**
 * @author anubi
 *
 */
public interface UserService {
	
	Response saveUser(User user);

	List<User> getAllUsers();
	
	public boolean isUserNameAlreadyInUse(String userName);
	
	User updateUser(User user);
	
	Response deleteUser(Integer id);

	User getASingleUser(Integer id);
	
	Response updateUser(Integer id, User user);
	
	

}
