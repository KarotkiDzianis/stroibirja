package orgdb.dao;

import org.springframework.data.repository.CrudRepository;

import entities.Event;



public interface EventDao extends CrudRepository <Event, Integer> {
 
}
