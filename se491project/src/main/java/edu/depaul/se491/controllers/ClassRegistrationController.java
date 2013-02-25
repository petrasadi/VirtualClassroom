package edu.depaul.se491.controllers;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
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
public class ClassRegistrationController
{
    @RequestMapping(value = "/displayClassRegistration", method = RequestMethod.GET)
    public ModelAndView displayClassRegistration(HttpServletRequest request)
    {
        Person vcUser = (Person) request.getSession().getAttribute("vcUser");
        if (vcUser == null) {
          return new ModelAndView("displayLoginPage", "command", new Object()).addObject("tab", "home");
        }
        SimpleDateFormat timeFmt = new SimpleDateFormat("hh:mm aa");
        SimpleDateFormat dateFmt = new SimpleDateFormat("MM/dd/yyyy");
        String classStartTimeStr;
        String classEndTimeStr;
        String classStartDayStr;
        String classEndDayStr;

        LinkedList<Classes> clist = (LinkedList<Classes>) DaoCmds.getClasses();
        LinkedList<ClassRegistrationListBean> cBeanList = new LinkedList<ClassRegistrationListBean>();

        TimeZone tz = TimeZone.getTimeZone("US/Central");
        DateTime now = new DateTime(DateTimeZone.forTimeZone(tz));


        for (Classes c : clist) {
        	
        	// if the class has ended, do no let a student register.
        	 DateTime classEndTime = new DateTime(c.getClassEndTime(), DateTimeZone.forTimeZone(tz));
             if(DateTimeZone.getDefault().toString().equals("UTC")){
             	classEndTime = classEndTime.plusHours(6);
             }
             classEndTime = classEndTime.plusMinutes(60);      

             if (!classEndTime.isAfter(now)) {
             	continue;
             }
        	
        	// If you are the teacher of the class, you can not register for it.
        	if(c.getTeacher().equals(vcUser.getId())){
        		 continue;
        	}
        	
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
        	
            ClassRegistrationListBean cBean = new ClassRegistrationListBean();
            cBean.setName(c.getClassName());
            cBean.setCategory((String) DaoCmds.getCategoryByKey(c.getId()).getProperty("name"));
            cBean.setClassEndDay(classEndDayStr);
            cBean.setClassEndTime(classEndTimeStr);
            cBean.setClassStartDay(classStartDayStr);
            cBean.setClassStartTime(classStartTimeStr);           
            cBean.setOpenId(DaoCmds.getTeacherCmd(c.getId()).getOpenid());
            cBean.setTeacherName(DaoCmds.getTeacherCmd(c.getId()).getFirstName() + " " + DaoCmds.getTeacherCmd(c.getId()).getLastName());


            if (DaoCmds.isStudentByKey(vcUser.getId(), c.getId()) && canJoinClass(c.getClassStartTime(), c.getClassEndTime())) {
          		cBean.setRegistration("Join");
            } else if (DaoCmds.isStudentByKey(vcUser.getId(), c.getId()))  {
          		cBean.setRegistration("Not Time To Join");
            } else if (!DaoCmds.isClassFull(c.getId()) && !DaoCmds.isStudentByKey(vcUser.getId(), c.getId())) {
                cBean.setRegistration("Register");
            } else {
                cBean.setRegistration("Full");
            }
            cBean.setId(c.getId().getId());
            cBeanList.add(cBean);

            List<Person> plist = DaoCmds.getClassRegistration(c.getId());
            if (plist != null) {
                for (Person pe : plist) {
                    System.out.println(pe.getEmail());
                }
            }
        }
        ModelAndView view = new ModelAndView();
        view.setViewName("displayClassRegistration");
        view.addObject("tab", "student");
        view.addObject("classes", cBeanList);

        
        return view;
    }

    @RequestMapping(value = "/registerStudentForClass")
    public ModelAndView registerStudentForClass(@ModelAttribute("classId") long val, HttpServletRequest request)
    {
    	Person vcUser = (Person) request.getSession().getAttribute("vcUser");
        if (vcUser == null) {
          return new ModelAndView("displayLoginPage", "command", new Object()).addObject("tab", "login");
        }
        Key n = KeyFactory.createKey("Classes", val);
        DaoCmds.addStudentCmd(vcUser.getId(), n).toString();

        return displayClassRegistration(request);
    }

    @RequestMapping(value = "/joinClass")
    public ModelAndView joinClass(@ModelAttribute("classId") long id, HttpServletRequest request)
    {
    	
    	Person vcUser = (Person) request.getSession().getAttribute("vcUser");
        if (vcUser == null) {
          return new ModelAndView("displayLoginPage", "command", new Object()).addObject("tab", "login");
        }
    	
        HttpSession session = request.getSession(true);
        session.setAttribute("classId", id);

        ModelAndView view = new ModelAndView();
        view.setViewName("displayStudentViewClassPage");
        return view;
    }
    
    
    
    boolean canJoinClass(final Date classStartTime, final Date classEndTime)
    {
    	Calendar cal = Calendar.getInstance();
    	cal.setTime(classStartTime);
        cal.add(Calendar.MINUTE, -30);
        
    	Date timeToEnterClass = cal.getTime();   	
        final Date now = new Date();
        return now.after(timeToEnterClass) && now.before(classEndTime);
    }
    
}
