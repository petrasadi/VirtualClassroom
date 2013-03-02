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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.TimeZone;

@Controller
@SessionAttributes
public class AvailableClassesController
{

    @RequestMapping(value = "/displayAvailableClasses", method = RequestMethod.GET)
    public ModelAndView displayAvailableClasses(HttpServletRequest request)
    {

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
        	
        	// if the class has ended, show as an available class.
        	 DateTime classEndTime = new DateTime(c.getClassEndTime(), DateTimeZone.forTimeZone(tz));
             if(DateTimeZone.getDefault().toString().equals("UTC")){
             	classEndTime = classEndTime.plusHours(6);
             }              

             if (!classEndTime.isAfter(now)) {
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
            cBean.setId(c.getId().getId());
            cBeanList.add(cBean);
        }
        
        ModelAndView view = new ModelAndView();
        view.setViewName("displayAvailableClasses");
        view.addObject("tab", "home");
        view.addObject("classes", cBeanList);
        return view;

    }

}
