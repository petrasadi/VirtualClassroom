package edu.depaul.se491.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
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
public class StudentScheduleController
{

    @RequestMapping(value = "/displayStudentClassSchedule", method = RequestMethod.GET)
    public ModelAndView displayStudentSchedule(HttpServletRequest request)
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

        String openId = vcUser.getOpenid();

        LinkedList<Classes> clist = (LinkedList<Classes>) DaoCmds
                .getStudentClasses(openId);
        LinkedList<ClassRegistrationListBean> cBeanList = new LinkedList<ClassRegistrationListBean>();

        TimeZone tz = TimeZone.getTimeZone("US/Central");
        DateTime now = new DateTime(DateTimeZone.forTimeZone(tz));

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
            cBean.setCategory((String) DaoCmds.getCategoryByKey(c.getId()).getProperty("name"));		
            cBean.setClassEndDay(classEndDayStr);
            cBean.setClassEndTime(classEndTimeStr);
            cBean.setClassStartDay(classStartDayStr);
            cBean.setClassStartTime(classStartTimeStr);
            if (canJoinClass(c.getClassStartTime(), c.getClassEndTime())) {
          		cBean.setRegistration("Join");
            } else  {
          		cBean.setRegistration("Not Time To Join");
            } 
            cBean.setId(c.getId().getId());

            cBean.setOpenId(DaoCmds.getTeacherCmd(c.getId()).getOpenid());
            cBean.setTeacherName(DaoCmds.getTeacherCmd(c.getId()).getFirstName() + " " + DaoCmds.getTeacherCmd(c.getId()).getLastName());
          
            
            DateTime classEndTime = new DateTime(c.getClassEndTime(), DateTimeZone.forTimeZone(tz));
            if(DateTimeZone.getDefault().toString().equals("UTC")){
            	classEndTime = classEndTime.plusHours(5);
            }
            classEndTime = classEndTime.plusMinutes(60);      

            if (classEndTime.isAfter(now)) {
            	cBeanList.add(cBean);
            }
            

        }

        ModelAndView view = new ModelAndView();
        view.setViewName("displayStudentSchedule");
        view.addObject("tab", "student");
        view.addObject("classes", cBeanList);
        return view;
    }
    
    boolean canJoinClass(final Date classStartTime, final Date classEndTime)
    {
    	  TimeZone tz = TimeZone.getTimeZone("US/Central");
          DateTime now = new DateTime(DateTimeZone.forTimeZone(tz));
                 
          DateTime timeToEnterClass = new DateTime(classStartTime, DateTimeZone.forTimeZone(tz));          
          DateTime timeToEndClass = new DateTime(classEndTime, DateTimeZone.forTimeZone(tz));
          
          if(DateTimeZone.getDefault().toString().equals("UTC")){
        	  timeToEnterClass = timeToEnterClass.plusHours(5);
              timeToEndClass = timeToEndClass.plusHours(5);          	
          }         
         
          timeToEnterClass = timeToEnterClass.minusMinutes(30);
          timeToEndClass = timeToEndClass.plusMinutes(60);
    
          return now.isAfter(timeToEnterClass) && now.isBefore(timeToEndClass);
    }

}
