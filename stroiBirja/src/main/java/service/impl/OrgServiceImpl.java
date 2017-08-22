package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import beans.OrganizationBean;
import entities.Organization;
import orgdb.dao.OrgDao;
import service.EntityBeanConverter;
import service.OrganizationService;

@Service
@Transactional
public class OrgServiceImpl implements OrganizationService {

	@Autowired
	private OrgDao orgDao;

	/*private BCryptPasswordEncoder bCryptPasswordEncoder;*/
	
	private EntityBeanConverter converter;

	@Override
	public List<OrganizationBean> getAllOrganization() {
		Iterable<Organization> org = orgDao.findAll();
		List<OrganizationBean> beanList = converter.convertToBeanList(org, OrganizationBean.class);

		return beanList;
	}

	@Override
	public OrganizationBean getOrgById(Integer orgId) {
		Organization org = orgDao.findOne(orgId);
		OrganizationBean bean = converter.convertToBean(org, OrganizationBean.class);
		return bean;
	}
	
	@Override
	public OrganizationBean findByOrgName(String name) {
		Organization org = orgDao.loadOrgByOrgName(name);
		OrganizationBean beanName = converter.convertToBean(org, OrganizationBean.class);
		return beanName;
	}
	 
	@Override
	public void saveOrg(OrganizationBean org) {
		Organization orgEntity = converter.convertToEntity(org, Organization.class);
		orgDao.save(orgEntity);
	}

	public void deleteOrg(Integer orgId) {
		orgDao.delete(orgId);

	}

	

}
