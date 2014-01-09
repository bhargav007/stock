package com.cdl.controller;

import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cdl.entity.Category;
import com.cdl.service.CategoryService;


@Controller
public class CategoryController {
	
	private static final Logger logger = Logger.getLogger(CategoryController.class);
	@Autowired
	private CategoryService categoryservice;

	
	
	@RequestMapping(value="/onloadcategory")
	public ModelAndView onloadcategory(HttpServletRequest request,HttpServletResponse response,@ModelAttribute("Category")Category category){
		logger.info(" page loading Value of category");
		HttpSession session=request.getSession(true);
		String currentuser=session.getAttribute("username").toString();
		logger.info("currentuser : -  "+currentuser);
		ModelAndView model=new ModelAndView();
		
		Map<Integer,String> cat_map=categoryservice.getCategory(category);
		if(cat_map.size()<1){
			logger.info("::: category Map size is Zero :::");
			model.addObject("category_map","There is no Category Available..!");
			model.addObject("clr","red");
		}
		System.out.println("map : - "+cat_map);
		model.addObject("cat",cat_map);
		model.setViewName("category");
		return model;
	}
	
	@RequestMapping(value="/selectCategoryForEdit",method=RequestMethod.POST)
	public ModelAndView selectCategoryForEdit(@ModelAttribute("Category")Category category,BindingResult result){
		ModelAndView model=new ModelAndView();
		model=categoryservice.selectCategoryForEdit(category);
		return model;
	}

	@RequestMapping(value="/saveCategory")
	public ModelAndView saveCategory(HttpServletRequest request,HttpServletResponse response,@ModelAttribute("Category")@Valid Category cat,BindingResult result){
	ModelAndView model=new ModelAndView();
	HttpSession session=request.getSession(true);
	String userid=session.getAttribute("userid").toString();
	Map<Integer,String> cat_map=new TreeMap<Integer, String>();
	
	
	if (result.hasErrors()){
		/*if(result.getFieldErrors().size()>0){
			for(FieldError s : result.getFieldErrors()){
				if(s.getField().equalsIgnoreCase("salary_per_day")){
					result.rejectValue("salary_per_day","error.salary_per_day","Please Enter Salary Per day..Thank You.!");
				}
			}
		}*/
		logger.info("...Error Occure.. :- "+result);
		cat_map=categoryservice.getCategory(cat);
		if(cat_map.size()<1){
			logger.info("::: category Map size is Zero :::");
			model.addObject("category_map","There is no Category Available..!");
			model.addObject("clr","red");
		}
		System.out.println("map : - "+cat_map);
		model.addObject("cat",cat_map);
		model.setViewName("category");
	}else{
		model=categoryservice.updateAndSaveCategory(cat,Integer.parseInt(userid));
		cat_map=categoryservice.getCategory(cat);
		if(cat_map.size()<1){
			logger.info("::: category Map size is Zero :::");
			model.addObject("category_map","There is no Category Available..!");
			model.addObject("clr","red");
		}
		System.out.println("map : - "+cat_map);
		model.addObject("cat",cat_map);
		model.setViewName("category");
	}
	
	return model;
}

}
