package edu.depaul.se491.controllers;

import edu.depaul.se491.formBeans.ClassRegistrationListBean;
import edu.depaul.se491.josqlCmds.DaoCmds;
import edu.depaul.se491.model.Classes;
import edu.depaul.se491.model.Person;
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
            cBean.setCategory((String) DaoCmds.getCategoryByKey(c.getId()).getProperty("name"));
            cBean.setClassEndDay(classEndDayStr);
            cBean.setClassEndTime(classEndTimeStr);
            cBean.setClassStartDay(classStartDayStr);
            cBean.setClassStartTime(classStartTimeStr);
            if (DaoCmds.isStudentByKey(vcUser.getId(), c.getId()) && (c.getClassStartTime().compareTo(today) == 0)) {
                cBean.setRegistration("Join");
            } else if (DaoCmds.isStudentByKey(vcUser.getId(), c.getId())) {
                cBean.setRegistration("Join");
            } else if (!DaoCmds.isClassFull(c.getId()) && !DaoCmds.isStudentByKey(vcUser.getId(), c.getId())) {
                cBean.setRegistration("Register");
            } else {
                cBean.setRegistration("Full");
            }
            cBean.setId(c.getId().getId());

            if (today.before(c.getClassStartTime())) {
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

}
