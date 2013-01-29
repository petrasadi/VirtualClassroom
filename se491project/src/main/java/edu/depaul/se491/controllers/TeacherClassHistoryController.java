package edu.depaul.se491.controllers;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.ListIterator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.google.appengine.api.datastore.Key;

import edu.depaul.se491.formBeans.ClassRegistrationListBean;
import edu.depaul.se491.josqlCmds.DaoCmds;
import edu.depaul.se491.model.Classes;
import edu.depaul.se491.model.Person;

@Controller
@SessionAttributes
public class TeacherClassHistoryController {

	@RequestMapping(value = "/displayTeacherHistoryClasses", method = RequestMethod.GET)
	public ModelAndView displayTeacherListCurrentClasses(
			HttpServletRequest request) {

		Person vcUser = (Person) request.getSession().getAttribute("vcUser");
		if (vcUser == null) {
			return new ModelAndView("displayLoginPage", "command", new Object())
					.addObject("tab", "login");
		}
		SimpleDateFormat timeFmt = new SimpleDateFormat("hh:mm aa");
		SimpleDateFormat dateFmt = new SimpleDateFormat("MM/dd/yyyy");
		String classStartTimeStr;
		String classEndTimeStr;
		String classStartDayStr;
		String classEndDayStr;

		LinkedList<Classes> clist = (LinkedList<Classes>) DaoCmds
				.getTeacherClasses(vcUser.getOpenid());
		LinkedList<ClassRegistrationListBean> cCurrentBeanList = new LinkedList<ClassRegistrationListBean>();

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
				classStartTimeStr = "unavailable";
				classStartDayStr = "unavailable";
			}
			try {
				classEndDayStr = dateFmt.format(c.getClassEndTime());
				classEndTimeStr = timeFmt.format(c.getClassEndTime());

			} catch (Exception e) {
				classEndDayStr = "unavailable";
				classEndTimeStr = "unavailable";
			}

			cBean.setName(c.getClassName());
		//	cBean.setCategory((String) DaoCmds.getCategoryByKey(c.getId())
		//			.getProperty("name"));
			cBean.setCategory("test");
			cBean.setClassEndDay(classEndDayStr);
			cBean.setClassEndTime(classEndTimeStr);
			cBean.setClassStartDay(classStartDayStr);
			cBean.setClassStartTime(classStartTimeStr);

			cBean.setId(c.getId().getId());

			if (today.after(c.getClassStartTime())) {
				cCurrentBeanList.add(cBean);
			} else {
				continue;
			}
		}

		ModelAndView view = new ModelAndView();
		view.setViewName("displayTeacherHistoryClasses");
		view.addObject("tab", "teacher");
		view.addObject("scheduledclasses", cCurrentBeanList);
		return view;
	}
}
