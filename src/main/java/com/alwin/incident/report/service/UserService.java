/**
 * 
 */
package com.alwin.incident.report.service;

import java.util.List;

import com.alwin.incident.report.data.models.User;

/**
 * @author anubi
 *
 */
public interface UserService {
	
	User saveUser(User user);

	List<User> getAllUsers();
	
	public boolean isUserNameAlreadyInUse(String userName);
	
	

}
