package service;

import beans.EventBean;

public interface EventService {
	
	Iterable <EventBean> getAllEvents();
	
	EventBean getEventById( Integer eventId);
	
	void saveEvent(EventBean event);
	
	void deleteEvent(Integer eventid);
	


}
