/**
 * 
 */
package com.alwin.incident.report.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.alwin.incident.report.data.models.User;

/**
 * @author anubi
 *
 */
public interface UserRepository extends JpaRepository<User, Integer> {
	
	public User findByUserName(String userName);
	
	boolean existsUserByUserName(String userName);

}
