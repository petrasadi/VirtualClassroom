package edu.depaul.se491.controllers;

import edu.depaul.se491.formBeans.ClassRegistrationListBean;
import edu.depaul.se491.josqlCmds.DaoCmds;
import edu.depaul.se491.model.Classes;
import edu.depaul.se491.model.Person;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.TimeZone;

@Controller
@SessionAttributes
public class TeacherInformationController
{

    @RequestMapping(value = "/displayTeacherInformation", method = RequestMethod.GET)
    public ModelAndView displayStudentSchedule(@RequestParam(value = "openId") String openId, HttpServletRequest request)
    {


        SimpleDateFormat timeFmt = new SimpleDateFormat("hh:mm aa");
        SimpleDateFormat dateFmt = new SimpleDateFormat("MM/dd/yyyy");
        String classStartTimeStr;
        String classEndTimeStr;
        String classStartDayStr;
        String classEndDayStr;

        Person teacher = DaoCmds.getPersonByOpenId(openId);
        Person vcUser = (Person) request.getSession().getAttribute("vcUser");
        LinkedList<Classes> clist = (LinkedList<Classes>) DaoCmds.getTeacherClasses(openId);
        LinkedList<ClassRegistrationListBean> cCurrentBeanList = new LinkedList<ClassRegistrationListBean>();
        LinkedList<ClassRegistrationListBean> cHistoryBeanList = new LinkedList<ClassRegistrationListBean>();

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
            
            
            DateTime classEndTime = new DateTime(c.getClassEndTime(), DateTimeZone.forTimeZone(tz));
            if(DateTimeZone.getDefault().toString().equals("UTC")){
            	classEndTime = classEndTime.plusHours(6);
            }
            classEndTime = classEndTime.plusMinutes(60);      

            if (classEndTime.isAfter(now)) {
            	cCurrentBeanList.add(cBean);
            } else {
                cHistoryBeanList.add(cBean);
            }


        }

        ModelAndView view = new ModelAndView();
        view.setViewName("displayTeacherInformation");
        view.addObject("tab", "student");
        view.addObject("scheduledclasses", cCurrentBeanList);
        view.addObject("historyclasses", cHistoryBeanList);
        view.addObject("teachername", teacher.getFirstName() + " " + teacher.getLastName());
        view.addObject("teacheremail", teacher.getEmail());
        return view;
    }

    boolean canJoinClass(final Date classStartTime, final Date classEndTime)
    {
    	  TimeZone tz = TimeZone.getTimeZone("US/Central");
          DateTime now = new DateTime(DateTimeZone.forTimeZone(tz));
                 
          DateTime timeToEnterClass = new DateTime(classStartTime, DateTimeZone.forTimeZone(tz));          
          DateTime timeToEndClass = new DateTime(classEndTime, DateTimeZone.forTimeZone(tz));
          
          if(DateTimeZone.getDefault().toString().equals("UTC")){
        	  timeToEnterClass = timeToEnterClass.plusHours(6);
              timeToEndClass = timeToEndClass.plusHours(6);          	
          }         
         
          timeToEnterClass = timeToEnterClass.minusMinutes(30);
          timeToEndClass = timeToEndClass.plusMinutes(60);
    
          return now.isAfter(timeToEnterClass) && now.isBefore(timeToEndClass);
    }
}
