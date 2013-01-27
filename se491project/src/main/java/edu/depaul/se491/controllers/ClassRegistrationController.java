package edu.depaul.se491.controllers;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import edu.depaul.se491.formBeans.ClassRegistrationListBean;
import edu.depaul.se491.josqlCmds.DaoCmds;
import edu.depaul.se491.model.Classes;
import edu.depaul.se491.model.Person;

@Controller
@SessionAttributes
public class ClassRegistrationController {
	@RequestMapping(value = "/displayClassRegistration", method = RequestMethod.GET)
	public ModelAndView displayClassRegistration(HttpServletRequest request) {
		Person vcUser = (Person) request.getSession().getAttribute("vcUser");
		
		LinkedList<Classes> clist = (LinkedList<Classes>) DaoCmds.getClasses();
		LinkedList<ClassRegistrationListBean> cBeanList = new LinkedList<ClassRegistrationListBean>();
		
		Calendar cd = Calendar.getInstance();
		
		cd.set(Calendar.HOUR, 0);
		cd.set(Calendar.MINUTE, 0);
		cd.set(Calendar.SECOND, 0);
		
		Date today = cd.getTime();

		for (Classes c : clist) {
			ClassRegistrationListBean cBean = new ClassRegistrationListBean();
			cBean.setName(c.getClassName());
			cBean.setCategory((String) DaoCmds.getCategoryByKey(c.getId()).getProperty("name"));
			cBean.setStartDate(c.getClassStartTime().toString());
			cBean.setEndDate(c.getClassEndTime().toString());
	
			if(DaoCmds.isStudentByKey(vcUser.getId(), c.getId()) && (c.getClassStartTime().compareTo(today) == 0)) {
				cBean.setRegistration("Join");
			} else if(DaoCmds.isStudentByKey(vcUser.getId(), c.getId())) {
				cBean.setRegistration("Join");
			} else if(!DaoCmds.isClassFull(c.getId()) && !DaoCmds.isStudentByKey(vcUser.getId(), c.getId())) {
				cBean.setRegistration("Register");
			} else {
				cBean.setRegistration("Full");
			}
			cBean.setId(c.getId().getId());
			cBeanList.add(cBean);
		
			List<Person> plist = DaoCmds.getClassRegistration(c.getId());
			if(plist != null) {
				for(Person pe : plist) {
					System.out.println(pe.getEmail());
				}
			}
		}
		ModelAndView view = new ModelAndView();
		view.setViewName("displayClassRegistration");
		view.addObject("tab","student");
		view.addObject("classes", cBeanList);
	    return view;	
	}

	@RequestMapping(value = "/registerStudentForClass")
	public ModelAndView registerStudentForClass(@ModelAttribute("classId") long val, HttpServletRequest request) {
		Person vcUser = (Person) request.getSession().getAttribute("vcUser");

		Key n = KeyFactory.createKey("Classes", val);
		DaoCmds.addStudentCmd(vcUser.getId(), n).toString();
		
		ModelAndView view = new ModelAndView();
		view.setViewName("displayClassRegistration");
		return view;
	}
	
	@RequestMapping(value = "/joinClass")
	public ModelAndView joinClass(@ModelAttribute("classId") long id, HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		session.setAttribute("classId", id);
		
		ModelAndView view = new ModelAndView();
		view.setViewName("displayStudentViewClassPage");
		return view;
	}
}
