/**
 * 
 */
package com.alwin.incident.report.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.alwin.incident.report.data.models.Incident;
import com.alwin.incident.report.data.models.User;
import com.alwin.incident.report.data.payloads.ReportRequest;
import com.alwin.incident.report.data.payloads.Response;
import com.alwin.incident.report.data.repository.UserRepository;
import com.alwin.incident.report.exception.ResourceNotFoundException;

/**
 * @author anubi
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public Response saveUser(User user) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		userRepository.save(user);
		return new Response("User is created Successfully");
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public boolean isUserNameAlreadyInUse(String userName) {
		return userRepository.existsUserByUserName(userName);
	}

	@Override
	public Response updateUser(Integer id, User user) {
		Optional<User> userlist = userRepository.findById(id);
		if (userlist.isEmpty()) {
			throw new ResourceNotFoundException("User is not Found");
		} else {
			userlist.get().setUserName(user.getUserName());
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String encodedPassword = passwordEncoder.encode(user.getPassword());
			userlist.get().setPassword(encodedPassword);
			userRepository.save(userlist.get());
		}
		return new Response("User updated Successfully");
	}

	@Override
	public Response deleteUser(Integer id) {
		if (userRepository.getReferenceById(id).getId().equals(id))
			userRepository.deleteById(id);
		else
			throw new ResourceNotFoundException("User is not Found");
		return new Response("User " + id + " deleted Successfully");
	}

	@Override
	public User getASingleUser(Integer id) {
		User user = userRepository.findById(id).get();
		if (user.getId() == null)
			throw new ResourceNotFoundException("user is not found");
		return user;
	}

	@Override
	public User updateUser(User user) {
		return userRepository.save(user);
	}

}
