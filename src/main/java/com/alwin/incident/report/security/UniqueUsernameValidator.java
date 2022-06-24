/**
 * 
 */
package com.alwin.incident.report.security;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

/**
 * @author anubi
 *
 */
@Component
public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String>{

	
	
	@Override
	public boolean isValid(String arg0, ConstraintValidatorContext arg1) {
		// TODO Auto-generated method stub
		return false;
	}

}
