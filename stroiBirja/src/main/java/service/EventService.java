package service;

import beans.EventBean;

public interface EventService {
	
	Iterable <EventBean> getAllEvents();
	
	EventBean getEventById( Integer eventId);
	
	void saveEvent(EventBean eventBean);
	
	void deleteEvent(Integer eventid);
	
	/*void updateEvent(Integer eventId);*/

}
