package edu.depaul.se491.controllers;

import com.google.appengine.api.datastore.KeyFactory;
import edu.depaul.se491.josqlCmds.DaoCmds;
import edu.depaul.se491.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@SessionAttributes
public class StudentsInClassController
{

    @RequestMapping(value = "/displayStudentInClass", method = RequestMethod.GET)
    public ModelAndView displayTeacherListCurrentClasses(@RequestParam(value = "classId") String classId,
                                                         HttpServletRequest request)
    {

        Person vcUser = (Person) request.getSession().getAttribute("vcUser");
        if (vcUser == null) {
            return new ModelAndView("displayLoginPage", "command", new Object())
                    .addObject("tab", "login");
        }


        List<Person> slist = DaoCmds.getStudentsInClass(KeyFactory.createKey("Classes", Long.parseLong(classId)));
      
        ModelAndView view = new ModelAndView();
        view.setViewName("displayStudentsInClass");
        view.addObject("tab", "teacher");
        view.addObject("studentList", slist);

        return view;
    }
}
