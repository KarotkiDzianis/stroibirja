package service.impl.dozer;

import org.dozer.DozerConverter;
import org.springframework.beans.factory.annotation.Autowired;




import entities.Organization;
import orgdb.dao.OrgDao;

public class EventCreatorConverter extends DozerConverter<Organization, String> {

	@Autowired
	private OrgDao orgDao;

	public EventCreatorConverter() {
		super(Organization.class, String.class);
	}

	@Override
	public String convertTo(Organization source, String destination) {
		return source.getName();
	}

	@Override
	public Organization convertFrom(String source, Organization destination) {
		Organization org = orgDao.loadOrgByOrgName(source);
		return org;
	}

	


}
