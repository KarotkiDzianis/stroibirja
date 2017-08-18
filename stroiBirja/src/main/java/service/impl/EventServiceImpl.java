package service.impl;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import beans.EventBean;
import entities.Event;
import orgdb.dao.EventDao;
import service.EntityBeanConverter;
import service.EventService;



@Service
@Transactional
public class EventServiceImpl implements EventService {
	  
	@Autowired
	private EventDao eventDao;

	
	@Autowired
	private EntityBeanConverter converter;
	
	
	
	@Override
	public Iterable<EventBean> getAllEvents() {
		Iterable <Event> events =  eventDao.findAll();
		 List <EventBean> beanList = converter.convertToBeanList(events, EventBean.class);
		 return beanList;
 	}

	@Override
	public EventBean getEventById(Integer eventId) {
		Event event = eventDao.findOne(eventId);
		EventBean bean = converter.convertToBean(event,EventBean.class);
		
		return bean;
	}

	@Override
	public void saveEvent(EventBean event) {
		Event eventEntity = converter.convertToEntity(event, Event.class);
		eventDao.save(eventEntity);
		
	}

	@Override
	public void deleteEvent(Integer eventId) {
		eventDao.delete(eventId);
		
	}

	
				
		
	}
	
	
	
	

