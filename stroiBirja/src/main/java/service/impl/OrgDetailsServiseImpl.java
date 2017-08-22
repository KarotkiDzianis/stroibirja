/*package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import entities.Organization;
import orgdb.dao.OrgDao;

public class OrgDetailsServiseImpl implements UserDetailsService () 

	
	@Autowired
  private OrgDao orgDao;

  @Override
  @Transactional (readOnly= true)
public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
	 Organization org = orgDao.
	  return null;
}

*/