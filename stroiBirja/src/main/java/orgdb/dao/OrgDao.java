package orgdb.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import entities.Organization;



public interface OrgDao extends CrudRepository <Organization, Integer>{
   @Query ("Select u From Organization u Where LOWER ( u.name) = LOWER (:name)")
   Organization loadOrgByOrgName( String name);
}
