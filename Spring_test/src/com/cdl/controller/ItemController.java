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

import com.cdl.entity.Items;
import com.cdl.service.ItemService;


@Controller
public class ItemController {
	
	private static final Logger logger = Logger.getLogger(ItemController.class);
	@Autowired
	private ItemService itemservice;

	
	
	@RequestMapping(value="/onloaditem")
	public ModelAndView onloaditem(HttpServletRequest request,HttpServletResponse response,@ModelAttribute("Item")Items item){
		logger.info(" page loading Value of category");
		HttpSession session=request.getSession(true);
		String currentuser=session.getAttribute("username").toString();
		logger.info("currentuser : -  "+currentuser);
		ModelAndView model=new ModelAndView();
		Map<Integer,String> item_map=itemservice.getItem(item);
		if(item_map.size()<1){
			logger.info("::: item Map size is Zero :::");
			model.addObject("item_map","There is no Category Available..!");
			model.addObject("clr","red");
		}
		System.out.println("map : - "+item_map);
		model.addObject("imap",item_map);
		model.addObject("cmap",itemservice.getCategoryMap());
		model.setViewName("item");
		return model;
	}
	
	
	@RequestMapping(value="/selectItemForEdit",method=RequestMethod.POST)
	public ModelAndView selectCategoryForEdit(@ModelAttribute("Item")Items item,BindingResult result){
		ModelAndView model=new ModelAndView();
		model=itemservice.selectItemForEdit(item);
		model.addObject("cmap",itemservice.getCategoryMap());
		return model;
	}

	@RequestMapping(value="/saveItem")
	public ModelAndView saveItem(HttpServletRequest request,HttpServletResponse response,@ModelAttribute("Item")@Valid Items item,BindingResult result){
	ModelAndView model=new ModelAndView();
	HttpSession session=request.getSession(true);
	String userid=session.getAttribute("userid").toString();
	System.out.println("cat id : - "+ item.getCat_id());
	if(item.getCat_id()==0){
		model.addObject("msg","Please select Category..Thank You");
		Map<Integer,String> item_map=itemservice.getItem(item);
		if(item_map.size()<1){
			logger.info("::: item Map size is Zero :::");
			model.addObject("item_map","There is no Category Available..!");
			
		}
		model.addObject("clr","red");
		System.out.println("map : - "+item_map);
		model.addObject("imap",item_map);
		model.addObject("cmap",itemservice.getCategoryMap());
		model.setViewName("item");
	}else if (result.hasErrors()){
		Map<Integer,String> item_map=itemservice.getItem(item);
		if(item_map.size()<1){
			logger.info("::: item Map size is Zero :::");
			model.addObject("item_map","There is no Category Available..!");
			model.addObject("clr","red");
		}
		System.out.println("map : - "+item_map);
		model.addObject("imap",item_map);
		model.addObject("cmap",itemservice.getCategoryMap());
		model.setViewName("item");
	}else{
		model=itemservice.updateAndSaveItem(item, Integer.parseInt(userid));
		Map<Integer,String> item_map=itemservice.getItem(item);
		if(item_map.size()<1){
			logger.info("::: item Map size is Zero :::");
			model.addObject("item_map","There is no Category Available..!");
			model.addObject("clr","red");
		}
		System.out.println("map : - "+item_map);
		model.addObject("imap",item_map);
		model.addObject("cmap",itemservice.getCategoryMap());
		model.setViewName("item");
	}
	
	return model;
}

}
