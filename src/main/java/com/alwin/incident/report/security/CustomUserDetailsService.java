package com.alwin.incident.report.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.alwin.incident.report.data.models.User;
import com.alwin.incident.report.data.repository.UserRepository;

public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.findByUserName(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found");
		}
		return new CustomUserDetails(user);
	}
	
	public UserDetails getdetailsByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.findByUserName(username);
		boolean value = userRepo.existsUserByUserName(user.getUserName());
		if (value) {
			throw new UsernameNotFoundException("User is already found");
		}
		return new CustomUserDetails(user);
	}
}
