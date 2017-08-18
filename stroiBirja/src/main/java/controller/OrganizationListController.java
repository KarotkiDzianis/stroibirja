package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import beans.OrganizationBean;
import service.OrganizationService;


@Controller
public class OrganizationListController {

	@Autowired
	private OrganizationService organizationService;
	
	@RequestMapping ("/org.html") 
	  public ModelAndView showOrgPage() {
	  ModelAndView modelAndView = new ModelAndView ("org");
	return modelAndView;
}
	@RequestMapping ("/update-org.html")
	public ModelAndView updateOrg (@RequestParam (name = "org_id") Integer orgId) {
		ModelAndView modelAndView = new ModelAndView ("org");
		
		OrganizationBean org = organizationService.getOrgById(orgId);
		modelAndView.addObject("org", org) ;
		return modelAndView;
	}
		 
	@RequestMapping (value= "/save-org.html", method = RequestMethod.POST)
	public ModelAndView saveOrg (OrganizationBean org) {
		organizationService.saveOrg(org);
		
		ModelAndView modelAndView = new ModelAndView ("redirect:org.html");
		return modelAndView;
	}
	
	@ModelAttribute (name = "orgList")
	private Iterable<OrganizationBean> getOrgList(){
		Iterable <OrganizationBean> orgList = organizationService.getAllOrganization();
		return orgList;
	}

	@ModelAttribute(name = "org")
	private OrganizationBean getEmptyOrg() {
		return new OrganizationBean();
	}
}


	
	
	
	
	
	
	/*@ModelAttribute("all_org_attr")
	public List<Organization> getOrganizationList() {
		List<Organization> allOrganization = organizationService.getAllOrganization();
		return allOrganization;
	}

	@ModelAttribute("org")
	  private Organization getOrganization () {
		return new Organization();}
		
		@RequestMapping ("/save-org.html")
		 public ModelAndView saveOrg (@Validated Organization org) {
			organizationService.saveOrg(org);
			ModelAndView modelAndView = new ModelAndView ("redirect:organization.html");
			return modelAndView;
		}
		
		public ModelAndView saveOrg (
				     @RequestParam ("hdn_org_id") Integer orgId,
				     @RequestParam ("txt_login") String name,
				     @RequestParam ("txt_password") String password
				
				) {
			Organization org = new Organization();
			org.setOrgId(orgId);
			org.setName(name);
			org.setPassword(password);
			
			organizationService.saveOrg(org);
			
			ModelAndView modelAndView = new ModelAndView ("redirect:org.html");
			
			return modelAndView;
		}
		
		@RequestMapping ("/org.html")
		public ModelAndView showOrgPage(){
			ModelAndView modelAndView = new ModelAndView ("orgList");
			
			return modelAndView;
		}
		
		 @RequestMapping("/update-org.html") 
		    public ModelAndView updateOrg(@RequestParam("org_id") Integer orgId){
			 Organization org = organizationService.getOrgById(orgId);
			 Map<String,Object> map = new HashMap<String, Object>();
			 map.put ("current_org", org);
			 ModelAndView modelAndView = new ModelAndView ("orgList", map);
			 return modelAndView;
	}
         @RequestMapping("/delete-org.html")
         public ModelAndView deleteOrg(@RequestParam("org_id") Integer orgId) {
        	 organizationService.deleteOrganization(orgId);
        	 ModelAndView modelAndView = new ModelAndView("redirect:org.html");
        	 
        	 return modelAndView;
         }*/



