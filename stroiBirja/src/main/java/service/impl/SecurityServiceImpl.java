<<<<<<< HEAD
package service.impl;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import Security.SecurityService;

public class SecurityServiceImpl implements SecurityService{
	
	private static final Logger logger = (Logger) LoggerFactory.getLogger(SecurityServiceImpl.class);
	
	@Autowired
  private AuthenticationManager  aurhenticationManager;
	
	@Autowired
	private UserDetailsService  userDetailsService;

	
	@Override
	public String findLoggedInOrgName() {
		Object userDetails = SecurityContextHolder.getContext().getAuthentication().getDetails();
		if (userDetails instanceof UserDetails){
			return ((UserDetails) userDetails).getUsername();
		}
		return null;
	}

	@Override
	public void autoLogin(String name, String password) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(name);
		UsernamePasswordAuthenticationToken authenticationToken = 
				new UsernamePasswordAuthenticationToken (userDetails, password, userDetails.getAuthorities());
		
		aurhenticationManager.authenticate(authenticationToken);
		
		if (authenticationToken.isAuthenticated()){
			SecurityContextHolder.getContext().setAuthentication(authenticationToken);
			
			 logger.debug(String.format("Successfully %s auto logged in", userDetails));
			
			
			
			
			
			
		}
		
	}
	
  
}
=======
package service.impl;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import Security.SecurityService;

public class SecurityServiceImpl implements SecurityService{
	
	private static final Logger logger = (Logger) LoggerFactory.getLogger(SecurityServiceImpl.class);
	
	@Autowired
  private AuthenticationManager  aurhenticationManager;
	
	@Autowired
	private UserDetailsService  userDetailsService;

	
	@Override
	public String findLoggedInOrgName() {
		Object userDetails = SecurityContextHolder.getContext().getAuthentication().getDetails();
		if (userDetails instanceof UserDetails){
			return ((UserDetails) userDetails).getUsername();
		}
		return null;
	}

	@Override
	public void autoLogin(String name, String password) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(name);
		UsernamePasswordAuthenticationToken authenticationToken = 
				new UsernamePasswordAuthenticationToken (userDetails, password, userDetails.getAuthorities());
		
		aurhenticationManager.authenticate(authenticationToken);
		
		if (authenticationToken.isAuthenticated()){
			SecurityContextHolder.getContext().setAuthentication(authenticationToken);
			
			 logger.debug(String.format("Successfully %s auto logged in", userDetails));
			
			
			
			
			
			
		}
		
	}
	
  
}
>>>>>>> N commit from master
