package edu.depaul.se491.controllers;

import edu.depaul.se491.formBeans.ClassRegistrationListBean;
import edu.depaul.se491.josqlCmds.DaoCmds;
import edu.depaul.se491.model.Classes;
import edu.depaul.se491.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;

@Controller
@SessionAttributes
public class StudentScheduleController
{

    @RequestMapping(value = "/displayStudentClassSchedule", method = RequestMethod.GET)
    public ModelAndView displayStudentSchedule(HttpServletRequest request)
    {
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
                // if the end date has past do not add this class to the current schedule
                if (!c.getClassEndTime().after(today)) {
                    continue;
                }

            } catch (Exception e) {
                classEndDayStr = "unavailable";
                classEndTimeStr = "unavailable";
            }

            cBean.setName(c.getClassName());
            //	cBean.setCategory((String) DaoCmds.getCategoryByKey(c.getId()).getProperty("name"));		
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
            cBeanList.add(cBean);

        }

        ModelAndView view = new ModelAndView();
        view.setViewName("displayStudentSchedule");
        view.addObject("tab", "student");
        view.addObject("classes", cBeanList);
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
