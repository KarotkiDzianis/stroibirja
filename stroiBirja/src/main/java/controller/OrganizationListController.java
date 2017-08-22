package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import Security.SecurityService;
import beans.OrganizationBean;
import entities.Organization;
import service.OrganizationService;
import validator.OrgValidator;

@Controller
public class OrganizationListController {

	@Autowired
	private OrganizationService orgService;
	@Autowired
	private SecurityService securityService;
	@Autowired
	private OrgValidator orgValidator;

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registration(Model model) {
		model.addAttribute("orgForm", new OrganizationBean());
		return "registration";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registration(@ModelAttribute("orgForm") OrganizationBean orgForm, BindingResult bindingResult,
			Model model) {
		orgValidator.validate(orgForm, bindingResult);

		if (bindingResult.hasErrors()) {
			return "registration";
		}

		orgService.saveOrg(orgForm);
		securityService.autoLogin(orgForm.getName(), orgForm.getPassword());

		return "redirect: /welcome";

	}
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login(Model model, String error,String logout) {
		if( error!= null){
			model.addAttribute("error", "Name or password is incorrect.");
		}
   if (logout != null){
	   model.addAttribute("message", "Logout successfully.");
	   }
	return "login";
   
	}
	
	@RequestMapping (value = {"/", "welcome"}, method=RequestMethod.GET)
	public String  welcome(Model model) {
		return "welcome";
	}
	
	@RequestMapping (value = "/admin", method=RequestMethod.GET)
	public String admin(Model model){
		return "admin";
	}
	

	@RequestMapping("/org.html")
	public ModelAndView showOrgPage() {
		ModelAndView modelAndView = new ModelAndView("org");
		return modelAndView;
	}

	@RequestMapping("/update-org.html")
	public ModelAndView updateOrg(@RequestParam(name = "org_id") Integer orgId) {
		ModelAndView modelAndView = new ModelAndView("org");

		OrganizationBean org = orgService.getOrgById(orgId);
		modelAndView.addObject("org", org);
		return modelAndView;
	}

	@RequestMapping(value = "/save-org.html", method = RequestMethod.POST)
	public ModelAndView saveOrg(OrganizationBean org) {
		orgService.saveOrg(org);

		ModelAndView modelAndView = new ModelAndView("redirect:org.html");
		return modelAndView;
	}

	@ModelAttribute(name = "orgList")
	private Iterable<OrganizationBean> getOrgList() {
		Iterable<OrganizationBean> orgList = orgService.getAllOrganization();
		return orgList;
	}

	@ModelAttribute(name = "org")
	private OrganizationBean getEmptyOrg() {
		return new OrganizationBean();
	}
}

/*
 * @ModelAttribute("all_org_attr") public List<Organization>
 * getOrganizationList() { List<Organization> allOrganization =
 * organizationService.getAllOrganization(); return allOrganization; }
 * 
 * @ModelAttribute("org") private Organization getOrganization () { return new
 * Organization();}
 * 
 * @RequestMapping ("/save-org.html") public ModelAndView saveOrg (@Validated
 * Organization org) { organizationService.saveOrg(org); ModelAndView
 * modelAndView = new ModelAndView ("redirect:organization.html"); return
 * modelAndView; }
 * 
 * public ModelAndView saveOrg (
 * 
 * @RequestParam ("hdn_org_id") Integer orgId,
 * 
 * @RequestParam ("txt_login") String name,
 * 
 * @RequestParam ("txt_password") String password
 * 
 * ) { Organization org = new Organization(); org.setOrgId(orgId);
 * org.setName(name); org.setPassword(password);
 * 
 * organizationService.saveOrg(org);
 * 
 * ModelAndView modelAndView = new ModelAndView ("redirect:org.html");
 * 
 * return modelAndView; }
 * 
 * @RequestMapping ("/org.html") public ModelAndView showOrgPage(){ ModelAndView
 * modelAndView = new ModelAndView ("orgList");
 * 
 * return modelAndView; }
 * 
 * @RequestMapping("/update-org.html") public ModelAndView
 * updateOrg(@RequestParam("org_id") Integer orgId){ Organization org =
 * organizationService.getOrgById(orgId); Map<String,Object> map = new
 * HashMap<String, Object>(); map.put ("current_org", org); ModelAndView
 * modelAndView = new ModelAndView ("orgList", map); return modelAndView; }
 * 
 * @RequestMapping("/delete-org.html") public ModelAndView
 * deleteOrg(@RequestParam("org_id") Integer orgId) {
 * organizationService.deleteOrganization(orgId); ModelAndView modelAndView =
 * new ModelAndView("redirect:org.html");
 * 
 * return modelAndView; }
 */
