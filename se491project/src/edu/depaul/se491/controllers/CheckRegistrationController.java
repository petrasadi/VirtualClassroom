package edu.depaul.se491.controllers;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import edu.depaul.se491.formBeans.UserRegistrationFormBean;
import edu.depaul.se491.josql.IPersonDAO;
import edu.depaul.se491.josql.IRoleDAO;
import edu.depaul.se491.josql.PersonDAO;
import edu.depaul.se491.josql.PersonException;
import edu.depaul.se491.josql.RoleDAO;
import edu.depaul.se491.model.Person;

@Controller
@SessionAttributes
public class CheckRegistrationController {

	@RequestMapping("/checkRegistration")
	public  ModelAndView checkRegistration(HttpServletRequest request) {
		
		 UserService userService = UserServiceFactory.getUserService();
		 IPersonDAO personDAO = new PersonDAO();
		 ModelAndView view = new ModelAndView();
		  
		  if(!userService.isUserLoggedIn()){
			  return new ModelAndView("displayLoginPage", "command", new Object());
		  }
		  
		  try {
			    createCountryMap();
				Person vcUser = personDAO.getPersonByOpenId(userService.getCurrentUser().getUserId());
				if(vcUser == null){
					  view.setViewName("displayUserRegistrationPage");
					  view.addObject("stateList",  createStateMap());
					  view.addObject("countryList",  createCountryMap());
					  view.addObject("userRegistrationFormBean", new UserRegistrationFormBean());
					  return view;
				}else{
					
					request.getSession().setAttribute("vcUser", vcUser);
				}
			} catch (PersonException e) {
				 view.setViewName("displayUserRegistrationPage");
				 view.addObject("stateList",  createStateMap());
				 view.addObject("countryList",  createCountryMap());
				 view.addObject("userRegistrationFormBean", new UserRegistrationFormBean());
				 return view;
			}
		  	  	
		    return new ModelAndView("displayUserLoggedInPage", "command", new UserRegistrationFormBean());
	}
	
	
	
	

	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public ModelAndView  registerUser(@Valid UserRegistrationFormBean userRegistrationFormBean, BindingResult result, HttpServletRequest request) {
		  
		ModelAndView view = new ModelAndView();
		IPersonDAO personDAO = new PersonDAO();
		IRoleDAO roleDAO = new RoleDAO();

	    if (result.hasErrors()) {
	    	  view.setViewName("displayUserRegistrationPage");
	          view.addObject("userRegistrationFormBean", userRegistrationFormBean);
	          return view;
	    }
	   
	    Person person = new Person(userRegistrationFormBean.getFirstName(), userRegistrationFormBean.getLastName(), userRegistrationFormBean.getMiddleName(), userRegistrationFormBean.getAddress(), userRegistrationFormBean.getAddress2(), userRegistrationFormBean.getCity(), userRegistrationFormBean.getZip(), userRegistrationFormBean.getCountry(), userRegistrationFormBean.getEmail(), userRegistrationFormBean.getPhone(), userRegistrationFormBean.getPhone2(), userRegistrationFormBean.getState());
	    person.setOpenid(userRegistrationFormBean.getOpenid());
	   
	    try {
	    	 Key personKey = personDAO.savePerson(person);
	    	 person.setId(personKey);
	    	    	
	    	 if(userRegistrationFormBean.isTeacher()){
	    		personDAO.setPersonAsTeacher(personKey);
	    	 }
	    	 if(userRegistrationFormBean.isStudent()){
	    		personDAO.setPersonAsStudent(personKey);
	    	 }	    	 
		} catch (PersonException e) {
			// need to figure out what to do with error.
		}
	    request.getSession().setAttribute("vcUser", person);
        view.setViewName("displayUserLoggedInPage");
	    return view;
	}
	
	
	
	
	private Map  <String, String> createStateMap(){		
		
		Map<String,String> state = new LinkedHashMap<String,String>();
		
		state.put("AL", "Alabama");
		state.put("AK", "Alaska");
		state.put("AZ", "Arizona");
		state.put("AR", "Arkansas");
		state.put("CA", "California");
		state.put("CO", "Colorado");
		state.put("CT", "Connecticut");
		state.put("DE", "Delaware");
		state.put("DC", "District of Columbia");
		state.put("FL", "Florida");
		state.put("GA", "Georgia");
		state.put("ID", "Idaho");
		state.put("IL", "Illinois");
		state.put("IN", "Indiana");
		state.put("IA", "Iowa");
		state.put("KS", "Kansas");
		state.put("KY", "Kentucky");
		state.put("LA", "Louisiana");
		state.put("ME", "Maine");
		state.put("MD", "Maryland");
		state.put("MA", "Massachusetts");
		state.put("MI", "Michigan");
		state.put("MN", "Minnesota");
		state.put("MS", "Mississippi");
		state.put("MO", "Missouri");
		state.put("MT", "Montana");
		state.put("ME", "Nebraska");
		state.put("NV", "Nevada");
		state.put("MH", "New Hampshire");
		state.put("NJ", "New Jersey");
		state.put("NM", "New Mexico");
		state.put("NY", "New York");
		state.put("NC", "North Carolina");
		state.put("ND", "North Dakota<");
		state.put("OH", "Ohio");
		state.put("OK", "Oklahoma");
		state.put("OR", "Oregon");
		state.put("PA", "Pennsylvania");
		state.put("RI", "Rhode Island");
		state.put("SC", "South Carolina");
		state.put("SD", "South Dakota");
		state.put("TN", "Tennessee");
		state.put("MY", "Texas");
		state.put("TX", "Arkansas");
		state.put("UT", "Utah");
		state.put("VT", "Vermont");
		state.put("VA", "Virginia");
		state.put("WA", "Washington");
		state.put("WV", "West Virginia");
		state.put("WI", "Wisconsin");
		state.put("WY", "Wyoming");
		
		return state;
	}
	
	
	
	
	private Map  <String, String> createCountryMap(){
		
		Map<String,String> countries = new LinkedHashMap<String,String>();
		
		 String[] isoCountries = Locale.getISOCountries();
		 String[] fullnamecountries = new String[isoCountries.length];
		
		
		 int x=0;
	     for (String isoCountry : isoCountries) {
	        Locale locale = new Locale("en", isoCountry);
	        fullnamecountries[x++] = locale.getDisplayCountry();
	     }		        
	     java.util.Arrays.sort(fullnamecountries);
	     for (String country : fullnamecountries) {
	    	 countries.put(country, country);		   
		 }	
	        
		return countries;		
	}
}
