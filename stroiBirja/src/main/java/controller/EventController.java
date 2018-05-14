<<<<<<< HEAD
package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import beans.EventBean;
import beans.OrganizationBean;
import service.EventService;
import service.OrganizationService;

@Controller
public class EventController {

	@Autowired
	private EventService eventService;

	@Autowired
	private OrganizationService organizationService;

	@RequestMapping ("event.html")
	public ModelAndView showEvntPage() { 
	ModelAndView modelAndView = new ModelAndView ("events");
	return modelAndView;
	}

	@RequestMapping("/update-event.html")
	public ModelAndView updateEvent (@RequestParam (name = "event_id") Integer eventId){
		ModelAndView modelAndView = new ModelAndView ("events");
		EventBean eventBean = eventService.getEventById(eventId);
		modelAndView.addObject("event", eventBean);
		return modelAndView;
	}
	@RequestMapping ("/delete-event.html")
	 public ModelAndView deleteEvent (@RequestParam (name = "event_id")Integer eventId) {
		eventService.deleteEvent(eventId);
		ModelAndView modelAndView = new ModelAndView ("redirect:events.html");
		return modelAndView;
	}
	@RequestMapping (value = "/save-event.html", method = RequestMethod.POST)
	public ModelAndView saveEvent(EventBean eventBean) {
		eventService.saveEvent(eventBean);
		ModelAndView modelAndView = new ModelAndView ("redirect:events.html");
		return modelAndView;
	}

	@ModelAttribute (name = "orgList")
	private Iterable <OrganizationBean> getOrgList() {
		Iterable <OrganizationBean> orgList = organizationService.getAllOrganization();
		return orgList;
	}
	
	@ModelAttribute (name = "eventList")
	private Iterable <EventBean> getEventList() {
		Iterable <EventBean> eventList = eventService.getAllEvents();
		return eventList;
	}
	
	@ModelAttribute (name = "event")
	private EventBean getEmptyEvent(){
		return new EventBean();
	}
	
	
	
	
	
}
=======
package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import beans.EventBean;
import beans.OrganizationBean;
import service.EventService;
import service.OrganizationService;

@Controller
public class EventController {

	@Autowired
	private EventService eventService;

	@Autowired
	private OrganizationService organizationService;

	@RequestMapping ("event.html")
	public ModelAndView showEvntPage() { 
	ModelAndView modelAndView = new ModelAndView ("events");
	return modelAndView;
	}

	@RequestMapping("/update-event.html")
	public ModelAndView updateEvent (@RequestParam (name = "event_id") Integer eventId){
		ModelAndView modelAndView = new ModelAndView ("events");
		EventBean eventBean = eventService.getEventById(eventId);
		modelAndView.addObject("event", eventBean);
		return modelAndView;
	}
	@RequestMapping ("/delete-event.html")
	 public ModelAndView deleteEvent (@RequestParam (name = "event_id")Integer eventId) {
		eventService.deleteEvent(eventId);
		ModelAndView modelAndView = new ModelAndView ("redirect:events.html");
		return modelAndView;
	}
	@RequestMapping (value = "/save-event.html", method = RequestMethod.POST)
	public ModelAndView saveEvent(EventBean eventBean) {
		eventService.saveEvent(eventBean);
		ModelAndView modelAndView = new ModelAndView ("redirect:events.html");
		return modelAndView;
	}

	@ModelAttribute (name = "orgList")
	private Iterable <OrganizationBean> getOrgList() {
		Iterable <OrganizationBean> orgList = organizationService.getAllOrganization();
		return orgList;
	}
	
	@ModelAttribute (name = "eventList")
	private Iterable <EventBean> getEventList() {
		Iterable <EventBean> eventList = eventService.getAllEvents();
		return eventList;
	}
	
	@ModelAttribute (name = "event")
	private EventBean getEmptyEvent(){
		return new EventBean();
	}
	
	
	
	
	
}
>>>>>>> N commit from master
