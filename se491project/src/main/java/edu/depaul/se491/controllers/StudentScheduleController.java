package edu.depaul.se491.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
public class StudentScheduleController {

	@RequestMapping(value = "/displayStudentClassSchedule", method = RequestMethod.GET)
	public ModelAndView displayStudentSchedule(HttpServletRequest request) {
		SimpleDateFormat timeFmt = new SimpleDateFormat("hh:mm aa");
		SimpleDateFormat dateFmt = new SimpleDateFormat("MM/dd/yyyy");
		String classStartTimeStr;
		String classEndTimeStr;
		String classStartDayStr;
		String classEndDayStr;

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
		
			
			try {
				classStartDayStr = dateFmt.format(c.getClassStartTime());
				classStartTimeStr = timeFmt.format(c.getClassStartTime());				
			} catch (Exception e) {
				classStartTimeStr="unavailable";
				classStartDayStr="unavailable";
			}
			try {
				classEndDayStr = dateFmt.format(c.getClassEndTime());
				classEndTimeStr = timeFmt.format(c.getClassEndTime());			
				// if the end date has past do not add this class to the current schedule
				if(today.after(c.getClassEndTime())){
					continue;
				}
				
			} catch (Exception e) {
				classEndDayStr="unavailable";
				classEndTimeStr="unavailable";
			}
			
			cBean.setName(c.getClassName());
			cBean.setCategory((String) DaoCmds.getCategoryByKey(c.getId()).getProperty("name"));		
			cBean.setClassEndDay(classEndDayStr);
			cBean.setClassEndTime(classEndTimeStr);
			cBean.setClassStartDay(classStartDayStr);
			cBean.setClassStartTime(classStartTimeStr);
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
