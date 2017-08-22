package service;

import java.util.List;

import beans.OrganizationBean;
import entities.Organization;



public interface OrganizationService {
	List <OrganizationBean> getAllOrganization();
	
	OrganizationBean findByOrgName (String name);
	
	OrganizationBean getOrgById(Integer orgId);
	
	void saveOrg (OrganizationBean org);
	
	void  deleteOrg (Integer orgId);
}
	 
	
	
