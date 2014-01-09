package com.cdl.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.cdl.service.StockService;


@Controller
public class StockController {
	
	private static final Logger logger = Logger.getLogger(StockController.class);
	@Autowired
	private StockService stockservice;

	
	
/*	@RequestMapping(value="/onloadcategory")
	public ModelAndView onloadcategory(HttpServletRequest request,HttpServletResponse response,@ModelAttribute("Category")Category category){
		logger.info(" page loading Value of category");
		HttpSession session=request.getSession(true);
		String currentuser=session.getAttribute("username").toString();
		logger.info("currentuser : -  "+currentuser);
		ModelAndView model=new ModelAndView();
		
		Map<Integer,String> cat_map=stockservice.getCategory(category);
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
		model=stockservice.selectCategoryForEdit(category);
		return model;
	}

	@RequestMapping(value="/saveCategory")
	public ModelAndView saveCategory(HttpServletRequest request,HttpServletResponse response,@ModelAttribute("Category")@Valid Category cat,BindingResult result){
	ModelAndView model=new ModelAndView();
	HttpSession session=request.getSession(true);
	String userid=session.getAttribute("userid").toString();
	Map<Integer,String> cat_map=new TreeMap<Integer, String>();
	
	
	if (result.hasErrors()){
		if(result.getFieldErrors().size()>0){
			for(FieldError s : result.getFieldErrors()){
				if(s.getField().equalsIgnoreCase("salary_per_day")){
					result.rejectValue("salary_per_day","error.salary_per_day","Please Enter Salary Per day..Thank You.!");
				}
			}
		}
		logger.info("...Error Occure.. :- "+result);
		cat_map=stockservice.getCategory(cat);
		if(cat_map.size()<1){
			logger.info("::: category Map size is Zero :::");
			model.addObject("category_map","There is no Category Available..!");
			model.addObject("clr","red");
		}
		System.out.println("map : - "+cat_map);
		model.addObject("cat",cat_map);
		model.setViewName("category");
	}else{
		model=stockservice.updateAndSaveCategory(cat,Integer.parseInt(userid));
		cat_map=stockservice.getCategory(cat);
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
}*/

}
