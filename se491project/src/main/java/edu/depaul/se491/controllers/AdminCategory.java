package edu.depaul.se491.controllers;

import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import edu.depaul.se491.josqlCmds.DaoCmds;
import edu.depaul.se491.model.Category;
import edu.depaul.se491.model.Person;

@Controller
@SessionAttributes
public class AdminCategory
{

    @RequestMapping(value = "/displayAdminCategoriesPage.do", method = RequestMethod.GET)
    public ModelAndView displayCategories(HttpServletRequest request)
    {
      

        ModelAndView view = new ModelAndView();
        
        LinkedList<Category> categoryList = (LinkedList<Category>) DaoCmds.getCategories();
        
        view.setViewName("displayAdminCategories");
        view.addObject("categoryList", categoryList);
        view.addObject("tab", "admin");

        return view;
    }
    
    
    
    @RequestMapping(value = "/createCategory.do", method = RequestMethod.POST)
    public ModelAndView createCategory(HttpServletRequest request,  @RequestParam(value = "category", required=false) String category)
    {
      

        ModelAndView view = new ModelAndView();
        
        if(category!=null && !category.trim().equals("")){
        	DaoCmds.createCategoryCmd( category, "decrip"); 
        }
        
        LinkedList<Category> categoryList = (LinkedList<Category>) DaoCmds.getCategories();
        
        view.setViewName("displayAdminCategories");
        view.addObject("categoryList", categoryList);
        view.addObject("tab", "admin");

        return view;
    }

}
