package service;

import java.util.List;

import beans.OrganizationBean;



public interface OrganizationService {
	List <OrganizationBean> getAllOrganization();
	
	OrganizationBean getOrgById(Integer orgId);
	
	OrganizationBean getOrgByName (String name);
	
	Integer saveOrg (OrganizationBean org);
	
	void  deleteOrg (Integer orgId);
}
	 
	
	
