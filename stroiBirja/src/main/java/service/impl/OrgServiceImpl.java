package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import beans.OrganizationBean;
import service.OrganizationService;

@Service
public class OrgServiceImpl implements OrganizationService {
   
	
	
	public OrganizationBean getOrgById(Integer orgId) {
		return null;
	}
	
	public OrganizationBean getOrgByName(String name) {
		return null;
	}
	
	public Integer saveOrg(OrganizationBean org) {
		return null;
	}
	
	public void deleteOrg(Integer orgId) {
		
	}
	
	public List<OrganizationBean> getAllOrganization() {

		return null;
	}

}
