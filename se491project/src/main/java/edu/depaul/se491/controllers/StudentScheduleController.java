package edu.depaul.se491.controllers;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

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
public class StudentScheduleController {

	@RequestMapping(value = "/displayClassSchedule", method = RequestMethod.GET)
	public ModelAndView displayStudentSchedule(HttpServletRequest request) {

		Person vcUser = (Person) request.getSession().getAttribute("vcUser");
		String openId = vcUser.getOpenid();

		LinkedList<Classes> clist = (LinkedList<Classes>) DaoCmds
				.getStudentClasses(openId);
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
			cBean.setRegistration("Join");			
			cBean.setId(c.getId().getId());
			cBeanList.add(cBean);

		}

		ModelAndView view = new ModelAndView();
		view.setViewName("displayStudentSchedule");
		view.addObject("tab", "student");
		view.addObject("classes", cBeanList);
		return view;
	}

}
