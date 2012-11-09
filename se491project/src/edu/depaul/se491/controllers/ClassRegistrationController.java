package edu.depaul.se491.controllers;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import edu.depaul.se491.formBeans.ClassRegistrationListBean;
import edu.depaul.se491.josqlCmds.DaoCmds;
import edu.depaul.se491.model.Classes;
import edu.depaul.se491.model.Person;

@Controller
@SessionAttributes
public class ClassRegistrationController {
	@RequestMapping(value = "/displayClassRegistration", method = RequestMethod.GET)
	public ModelAndView displayClassRegistration(HttpServletRequest request) {
		
		//Person vcUser = (Person) request.getSession().getAttribute("vcUser");
		
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
			cBean.setCategory("category"); /* Todo: needs to be updated */
			cBean.setStartDate("start");
			cBean.setEndDate("end");
			
			/*if(DaoCmds.isStudent(vcUser.getOpenid(), c.getId().getId()) && (c.getClassStartTime().compareTo(today) == 0)) {
				cBean.setRegistration("Join");
			} else if(DaoCmds.isStudent(vcUser.getOpenid(), c.getId().getId())) {
				cBean.setRegistration("Registered");
			} else if(!DaoCmds.isClassFull(c.getId())) {
				cBean.setRegistration("Register");
			} else {
				cBean.setRegistration("Full");
			}*/
			cBean.setRegistration("Register");
			cBeanList.add(cBean);
		}
		ModelAndView view = new ModelAndView();
		view.setViewName("displayClassRegistration");
		view.addObject("tab","student");
		view.addObject("classes", cBeanList);
	    return view;	
	}
}
