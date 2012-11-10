package edu.depaul.se491.controllers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
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

import edu.depaul.se491.formBeans.CreateClassFormBean;
import edu.depaul.se491.josql.CategoryDAO;
import edu.depaul.se491.josql.ClassesDAO;
import edu.depaul.se491.josql.ClassesException;
import edu.depaul.se491.josql.ICategoryDAO;
import edu.depaul.se491.josql.IClassesDAO;
import edu.depaul.se491.josql.IPersonDAO;
import edu.depaul.se491.josql.PersonDAO;
import edu.depaul.se491.josql.PersonException;
import edu.depaul.se491.josqlCmds.DaoCmds;
import edu.depaul.se491.model.Category;
import edu.depaul.se491.model.Classes;
import edu.depaul.se491.model.Person;

@Controller
@SessionAttributes
public class CreateClassFormController {

	@RequestMapping(value = "/classCreate", method = RequestMethod.POST)
	public ModelAndView classCreate(
			@Valid CreateClassFormBean createClassFormBean,
			BindingResult result, HttpServletRequest request) {

		ModelAndView view = new ModelAndView();
		// validator.validate(createClassFormBean, result);
		if (result.hasErrors()) {
			view.setViewName("displayCreateClassPage");
			view.addObject("timeList", createTimeMap());
			view.addObject("createClassFormBean", createClassFormBean);
			view.addObject("tab", "teacher");
			return view;
		}

		DateFormat dateFmt;
		String classStartStr, classEndStr;
		Date classStartDate = null;
		Date classEndDate = null;

		Classes clazz = new Classes();
		IClassesDAO clazzDAO = new ClassesDAO();
		Key clazzKey;
		/*
		* ICategoryDAO catDAO = new CategoryDAO();
		* Category category = new Category();
		*/
		Key catKey;

	
		Person vcUser = (Person) request.getSession().getAttribute("vcUser");
		if(vcUser == null){
			 return new ModelAndView("displayLoginPage", "command", new Object()).addObject("tab", "login");
		}
		
		/*
		 * category.setName(formBean.getClassCategory());
		 * category.setDescription("to be written");
		 * System.out.println("setCategoryName");
		 * System.out.println("CategoryID: " + category.getId().toString());
		 * catDAO.saveCategory(category); catKey =
		 * catDAO.saveCategory(category); System.out.println("saved Category");
		 */

		clazz.setTeacher(vcUser.getId());
		clazz.setClassName(createClassFormBean.getClassTitle());
		clazz.setDescription(createClassFormBean.getClassDescription());
		clazz.setCategory((Key) DaoCmds.createCategoryCmd(createClassFormBean.getClassCategory(),
				"decrip")); 
		/*
		 * System.out.println("setting class Category");
		 * clazz.setCategory(catKey); System.out.println("class Category set");
		 */
		clazz.setMinStudents(Integer.parseInt(createClassFormBean
				.getMinStudents()));
		clazz.setMaxStudents(Integer.parseInt(createClassFormBean
				.getMaxStudents()));

		dateFmt = new SimpleDateFormat("MM/dd/yyyy HH:mm a");
		classStartStr = createClassFormBean.getClassDate() + " "
				+ createClassFormBean.getClassStartTime();
		classEndStr = createClassFormBean.getClassDate() + " "
				+ createClassFormBean.getClassEndTime();

		try {
			classStartDate = dateFmt.parse(classStartStr);
			classEndDate = dateFmt.parse(classEndStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		clazz.setClassStartTime(classStartDate);
		clazz.setClassEndTime(classEndDate);
		try {
			clazzKey = clazzDAO.saveClasses(clazz);
		} catch (ClassesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		view = new ModelAndView();
		view.setViewName("displayClassCreatedPage");
		view.addObject("tab", "teacher");
		return view;
	}

	@RequestMapping("/displayCreateClassPage")
	public ModelAndView displayCreateClassPage(HttpServletRequest request) {
		ModelAndView view = new ModelAndView();
		Person vcUser = (Person)request.getSession().getAttribute("vcUser");
		if(vcUser == null){
			 return new ModelAndView("displayLoginPage", "command", new Object()).addObject("tab", "login");
		}

		CreateClassFormBean createClassFormBean = new CreateClassFormBean();
		createClassFormBean.setClassLevel("beginner");
		createClassFormBean.setClassStartTime("5:00 PM");
		createClassFormBean.setClassEndTime("9:30 PM");

		view.setViewName("displayCreateClassPage");
		view.addObject("tab", "teacher");
		view.addObject("createClassFormBean", createClassFormBean);
		view.addObject("timeList", createTimeMap());
		return view;
	}

	private Map<String, String> createTimeMap() {

		Map<String, String> time = new LinkedHashMap<String, String>();

		time.put("1:00 AM", "1:00 AM");
		time.put("1:30 AM", "1:30 AM");
		time.put("2:00 AM", "2:00 AM");
		time.put("2:30 AM", "2:30 AM");
		time.put("3:00 AM", "3:00 AM");
		time.put("3:30 AM", "3:30 AM");
		time.put("4:00 AM", "4:00 AM");
		time.put("4:30 AM", "4:30 AM");
		time.put("5:00 AM", "5:00 AM");
		time.put("5:30 AM", "5:30 AM");
		time.put("6:00 AM", "6:00 AM");
		time.put("6:30 AM", "6:30 AM");
		time.put("7:00 AM", "7:00 AM");
		time.put("7:30 AM", "7:30 AM");
		time.put("8:00 AM", "8:00 AM");
		time.put("8:30 AM", "8:30 AM");
		time.put("9:00 AM", "9:00 AM");
		time.put("9:30 AM", "9:30 AM");
		time.put("10:00 AM", "10:00 AM");
		time.put("10:30 AM", "10:30 AM");
		time.put("11:00 AM", "11:00 AM");
		time.put("11:30 AM", "11:30 AM");
		time.put("12:00 AM", "12:00 AM");
		time.put("12:30 AM", "12:30 AM");

		time.put("1:00 PM", "1:00 PM");
		time.put("1:30 PM", "1:30 PM");
		time.put("2:00 PM", "2:00 PM");
		time.put("2:30 PM", "2:30 PM");
		time.put("3:00 PM", "3:00 PM");
		time.put("3:30 PM", "3:30 PM");
		time.put("4:00 PM", "4:00 PM");
		time.put("4:30 PM", "4:30 PM");
		time.put("5:00 PM", "5:00 PM");
		time.put("5:30 PM", "5:30 PM");
		time.put("6:00 PM", "6:00 PM");
		time.put("6:30 PM", "6:30 PM");
		time.put("7:00 PM", "7:00 PM");
		time.put("7:30 PM", "7:30 PM");
		time.put("8:00 PM", "8:00 PM");
		time.put("8:30 PM", "8:30 PM");
		time.put("9:00 PM", "9:00 PM");
		time.put("9:30 PM", "9:30 PM");
		time.put("10:00 PM", "10:00 PM");
		time.put("10:30 PM", "10:30 PM");
		time.put("11:00 PM", "11:00 PM");
		time.put("11:30 PM", "11:30 PM");
		time.put("12:00 PM", "12:00 PM");
		time.put("12:30 PM", "12:30 PM");

		return time;
	}

}
