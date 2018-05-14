<<<<<<< HEAD
package validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import entities.Organization;
import service.OrganizationService;

@Component
public class OrgValidator  implements Validator{
	
	@Autowired
	private OrganizationService orgService; 
	
	
	
	

	@Override
	public boolean supports(Class<?> aClass) {
		
		return Organization.class.equals(aClass);
	}

	@Override
	public void validate(Object o, Errors errors) {
		Organization org =(Organization) o;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "Required");
		if (org.getName().length() < 6 || org.getName().length()>32) {
			errors.rejectValue("name", "Size.loginForm.userName");
		}
		
		if (orgService.findByOrgName(org.getName()) != null ){
        errors.rejectValue("name", "Duplicate.userForm.userName");			
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Required");
		if (org.getPassword().length() <6 || org.getPassword().length()>32) {
			errors.rejectValue("password", "Size.userForm.password");
		}
	
	
	}
}

=======
package validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import entities.Organization;
import service.OrganizationService;

@Component
public class OrgValidator  implements Validator{
	
	@Autowired
	private OrganizationService orgService; 
	
	
	
	

	@Override
	public boolean supports(Class<?> aClass) {
		
		return Organization.class.equals(aClass);
	}

	@Override
	public void validate(Object o, Errors errors) {
		Organization org =(Organization) o;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "Required");
		if (org.getName().length() < 6 || org.getName().length()>32) {
			errors.rejectValue("name", "Size.loginForm.userName");
		}
		
		if (orgService.findByOrgName(org.getName()) != null ){
        errors.rejectValue("name", "Duplicate.userForm.userName");			
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Required");
		if (org.getPassword().length() <6 || org.getPassword().length()>32) {
			errors.rejectValue("password", "Size.userForm.password");
		}
	
	
	}
}

>>>>>>> N commit from master
