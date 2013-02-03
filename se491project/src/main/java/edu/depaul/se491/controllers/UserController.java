package edu.depaul.se491.controllers;

import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import edu.depaul.se491.formBeans.UserRegistrationFormBean;
import edu.depaul.se491.josql.IPersonDAO;
import edu.depaul.se491.josql.PersonDAO;
import edu.depaul.se491.josql.PersonException;
import edu.depaul.se491.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

@Controller
@SessionAttributes
public class UserController
{

    @RequestMapping("/displayUserInformationPage")
    public ModelAndView displayUserInformationPage(HttpServletRequest request)
    {
        return new ModelAndView("displayUserInformationPage", "command", new Object()).addObject("tab", "userinformation");
    }

    @RequestMapping("/editUserInformationPage")
    public ModelAndView editUserInformationPage(HttpServletRequest request)
    {
        UserRegistrationFormBean uf = new UserRegistrationFormBean();
        ModelAndView view = new ModelAndView();
        Person vcUser = (Person) request.getSession().getAttribute("vcUser");

        uf.setFirstName(vcUser.getFirstName());
        uf.setMiddleName(vcUser.getMiddleName());
        uf.setLastName(vcUser.getLastName());
        uf.setAddress(vcUser.getAddress());
        uf.setAddress2(vcUser.getAddress2());
        uf.setCity(vcUser.getCity());
        uf.setState(vcUser.getState());
        uf.setZip(vcUser.getZip());
        uf.setCountry(vcUser.getCountry());
        uf.setEmail(vcUser.getEmail());
        uf.setPhone(vcUser.getPhone());
        uf.setPhone2(vcUser.getPhone2());
        uf.setStudent(vcUser.isStudent());
        uf.setTeacher(vcUser.isTeacher());
        view.setViewName("editUserInformationPage");
        view.addObject("stateList", createStateMap());
        view.addObject("countryList", createCountryMap());
        view.addObject("userRegistrationFormBean", uf);
        view.addObject("tab", "userinformation");

        return view;
    }


    @RequestMapping(value = "/editUser", method = RequestMethod.POST)
    public ModelAndView editUser(@Valid UserRegistrationFormBean userRegistrationFormBean, BindingResult result, HttpServletRequest request)
    {

        ModelAndView view = new ModelAndView();

        if (result.hasErrors()) {
            view.addObject("stateList", createStateMap());
            view.addObject("countryList", createCountryMap());
            view.setViewName("editUserInformationPage");
            view.addObject("userRegistrationFormBean", userRegistrationFormBean);
            view.addObject("tab", "userinformation");
            return view;
        }


        Person vcUser = (Person) request.getSession().getAttribute("vcUser");

        vcUser.setFirstName(userRegistrationFormBean.getFirstName());
        vcUser.setMiddleName(userRegistrationFormBean.getMiddleName());
        vcUser.setLastName(userRegistrationFormBean.getLastName());
        vcUser.setAddress(userRegistrationFormBean.getAddress());
        vcUser.setAddress2(userRegistrationFormBean.getAddress2());
        vcUser.setCity(userRegistrationFormBean.getCity());
        vcUser.setState(userRegistrationFormBean.getState());
        vcUser.setZip(userRegistrationFormBean.getZip());
        vcUser.setCountry(userRegistrationFormBean.getCountry());
        vcUser.setEmail(userRegistrationFormBean.getEmail());
        vcUser.setPhone(userRegistrationFormBean.getPhone());
        vcUser.setPhone2(userRegistrationFormBean.getPhone2());
        vcUser.setTeacher(userRegistrationFormBean.isTeacher());
        vcUser.setStudent(userRegistrationFormBean.isStudent());

        request.getSession().setAttribute("vcUser", vcUser);
        view.setViewName("displayUserInformationPage");
        view.addObject("tab", "userinformation");

        return view;
    }


    @RequestMapping(value = "/checkRegistration", method = RequestMethod.GET)
    public ModelAndView checkRegistration(HttpServletRequest request)
    {

        UserService userService = UserServiceFactory.getUserService();
        IPersonDAO personDAO = new PersonDAO();
        ModelAndView view = new ModelAndView();

        if (!userService.isUserLoggedIn()) {
            return new ModelAndView("displayLoginPage", "command", new Object()).addObject("tab", "login");
        }

        try {
            createCountryMap();
            Person vcUser = personDAO.getPersonByOpenId(userService.getCurrentUser().getUserId());

            if (vcUser == null) {
                view.setViewName("displayUserRegistrationPage");
                view.addObject("stateList", createStateMap());
                view.addObject("countryList", createCountryMap());
                view.addObject("userRegistrationFormBean", new UserRegistrationFormBean());
                view.addObject("tab", "login");
                return view;
            } else {
                request.getSession().setAttribute("vcUser", vcUser);

            }
        } catch (PersonException e) {
            view.setViewName("displayUserRegistrationPage");
            view.addObject("stateList", createStateMap());
            view.addObject("countryList", createCountryMap());
            view.addObject("userRegistrationFormBean", new UserRegistrationFormBean());
            view.addObject("tab", "login");
            return view;
        }

        return new ModelAndView("displayUserLoggedInPage", "command", new UserRegistrationFormBean()).addObject("tab", "about");
    }


    @RequestMapping(value = "/registerUser", method = RequestMethod.POST)
    public ModelAndView registerUser(@Valid UserRegistrationFormBean userRegistrationFormBean, BindingResult result, HttpServletRequest request)
    {

        ModelAndView view = new ModelAndView();
        IPersonDAO personDAO = new PersonDAO();

        if (result.hasErrors()) {
            view.addObject("stateList", createStateMap());
            view.addObject("countryList", createCountryMap());
            view.setViewName("displayUserRegistrationPage");
            view.addObject("userRegistrationFormBean", userRegistrationFormBean);
            view.addObject("tab", "login");
            return view;
        }

        Person person = new Person(userRegistrationFormBean.getFirstName(), userRegistrationFormBean.getLastName(), userRegistrationFormBean.getMiddleName(), userRegistrationFormBean.getAddress(), userRegistrationFormBean.getAddress2(), userRegistrationFormBean.getCity(), userRegistrationFormBean.getZip(), userRegistrationFormBean.getCountry(), userRegistrationFormBean.getEmail(), userRegistrationFormBean.getPhone(), userRegistrationFormBean.getPhone2(), userRegistrationFormBean.getState());
        person.setOpenid(userRegistrationFormBean.getOpenid());
        person.setTeacher(userRegistrationFormBean.isTeacher());
        person.setStudent(userRegistrationFormBean.isStudent());

        try {
            Key personKey;
            personKey = personDAO.savePerson(person);
            person.setId(personKey);
        } catch (PersonException e) {
            // need to figure out what to do with error.
        } catch (EntityNotFoundException e) {

        }
        request.getSession().setAttribute("vcUser", person);
        view.setViewName("displayUserLoggedInPage");
        view.addObject("tab", "login");
        return view;
    }


    private Map<String, String> createStateMap()
    {

        Map<String, String> state = new LinkedHashMap<String, String>();

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
        state.put("NE", "Nebraska");
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
        state.put("TX", "Texas");
        state.put("UT", "Utah");
        state.put("VT", "Vermont");
        state.put("VA", "Virginia");
        state.put("WA", "Washington");
        state.put("WV", "West Virginia");
        state.put("WI", "Wisconsin");
        state.put("WY", "Wyoming");

        return state;
    }


    private Map<String, String> createCountryMap()
    {

        Map<String, String> countries = new LinkedHashMap<String, String>();

        String[] isoCountries = Locale.getISOCountries();
        String[] fullnamecountries = new String[isoCountries.length];


        int x = 0;
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
