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
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cdl.entity.Add_Worker;
import com.cdl.entity.Add_Worker_Detail;
import com.cdl.entity.Users;
import com.cdl.service.LoginService;
import com.cdl.utility.DateTimeFormater;


@Controller
public class LoginController {
	
	private static final Logger logger = Logger.getLogger(LoginController.class);
	@Autowired
	private LoginService loginservice;
	
	@RequestMapping(value="/logout")
	public ModelAndView loadLogOutPage(HttpServletRequest request,HttpServletResponse response,@ModelAttribute("Users") Users user,BindingResult result ){
		HttpSession session = request.getSession(false);
		if(session != null){
			session.invalidate();
			System.out.println("session Invalidated successfully..!!");
		}
		return new ModelAndView("login");
	}
	
	@RequestMapping(value="/login")
	public ModelAndView loadLoginPage(HttpServletRequest request,HttpServletResponse response,@ModelAttribute("Users")Users user){
		System.out.println(" page loading Value of ujsername: - "+user.getUsername());
		System.out.println(" page loading Value of Paswd : - "+user.getPassword());
		System.out.println("Loading Login page");
		ModelAndView model=new ModelAndView();
		model.setViewName("login");
		return model;
	}

	@RequestMapping(value="/save")
	public ModelAndView save(HttpServletRequest request,HttpServletResponse response,@Valid @ModelAttribute("Users")Users user,BindingResult result){
		System.out.println("Loading Login page");
		ModelAndView model=new ModelAndView();
		
		if(result.hasErrors())
		{
			if(result.getFieldErrors().size()>0){
				for(FieldError s : result.getFieldErrors()){
					if(s.getField().equalsIgnoreCase("password")){
						model.addObject("password_field","password");
					}else{
						model.addObject("user_field","user");
					}
				}
			}
			model.setViewName("login");
		}
		else
		{
			boolean flage=loginservice.checkAuthentication(user.getUsername(),user.getPassword(),request);
			if(flage){
				
				System.out.println("Successfull...!");
				model.setViewName("dashboard");
			}else{
				model.addObject("msg","Your Login Detail is Invalid..!");
				model.setViewName("login");
			}
		}
		return model;
	}
	
	@RequestMapping(value="/add_worker")
	public ModelAndView add_worker(HttpServletRequest request,HttpServletResponse response,@ModelAttribute("Add_Worker")Add_Worker add_worker){
		System.out.println(" page loading Value of add_worker");
		HttpSession session=request.getSession(true);
		String currentuser=session.getAttribute("username").toString();
		ModelAndView model=new ModelAndView();
		
		Map<Integer,String> AddWorker=loginservice.getWorkerDetails(add_worker);
		if(AddWorker.size()<1){
			logger.info("::: AddWorker Map size is Zero :::");
			model.addObject("addWorker_map","There is no Worker Available..!");
			model.addObject("clr","red");
		}
		System.out.println("map : - "+AddWorker);
		model.addObject("Worker",AddWorker);
		model.setViewName("add_worker");
		return model;
	}
	
	@RequestMapping(value="/selectWorkerForEdit",method=RequestMethod.POST)
	public ModelAndView selectdailyscheduleForEdit(@ModelAttribute("Add_Worker")Add_Worker add_worker,BindingResult result){
		ModelAndView model=new ModelAndView();
		model=loginservice.selectWorkerForEdit(add_worker);
		return model;
	}
	
	
	@RequestMapping(value="/saveWorker")
	public ModelAndView saveWorker(HttpServletRequest request,HttpServletResponse response,@ModelAttribute("Add_Worker")@Valid Add_Worker add_worker,BindingResult result){
	ModelAndView model=new ModelAndView();
	HttpSession session=request.getSession(true);
	String userid=session.getAttribute("userid").toString();
	Map<Integer,String> AddWorker=new TreeMap<Integer, String>();
	
	System.out.println("value : - "+add_worker.getSalary_per_day());
	
	if (result.hasErrors()){
		/*if(result.getFieldErrors().size()>0){
			for(FieldError s : result.getFieldErrors()){
				if(s.getField().equalsIgnoreCase("salary_per_day")){
					result.rejectValue("salary_per_day","error.salary_per_day","Please Enter Salary Per day..Thank You.!");
				}
			}
		}*/
		logger.info("...Error Occure.. :- "+result);
		AddWorker=loginservice.getWorkerDetails(add_worker);
		if(AddWorker.size()<1){
			logger.info("::: AddWorker Map size is Zero :::");
			model.addObject("addWorker_map","There is no Worker Available..!");
			model.addObject("clr","red");
		}
		System.out.println("map : - "+AddWorker);
		model.addObject("Worker",AddWorker);
		model.setViewName("add_worker");
	}else{
		model=loginservice.updateAndSaveWorker(add_worker,Integer.valueOf(userid));
		AddWorker=loginservice.getWorkerDetails(add_worker);
		if(AddWorker.size()<1){
			logger.info("::: AddWorker Map size is Zero :::");
			model.addObject("addWorker_map","There is no Worker Available..!");
			model.addObject("clr","red");
		}
		System.out.println("map : - "+AddWorker);
		model.addObject("Worker",AddWorker);
		model.setViewName("add_worker");
	}
	
	return model;
}
	
	@RequestMapping(value="/add_worker_detail")
	public ModelAndView add_worker_detail(HttpServletRequest request,HttpServletResponse response,@ModelAttribute("Add_Worker_Detail")Add_Worker_Detail add_worker_detail){
		System.out.println(" page loading Value of add_worker_detail");
		HttpSession session=request.getSession(true);
		String currentuser=session.getAttribute("username").toString();
		ModelAndView model=new ModelAndView();
		model.setViewName("worker_detail");
		return model;
	}	
	
	
	@RequestMapping(value="/generate_working_detail")
	public ModelAndView generate_working_detail(HttpServletRequest request,HttpServletResponse response,@ModelAttribute("Add_Worker_Detail")Add_Worker_Detail add_worker_detail){
		System.out.println(" page loading Value of generate_working_detail");
		HttpSession session=request.getSession(true);
		String currentuser=session.getAttribute("username").toString();
		ModelAndView model=new ModelAndView();
		
		String working_date=add_worker_detail.getWorking_date();
		System.out.println("working_date : - "+working_date);
		
		Map<String, Add_Worker_Detail> detail_map= loginservice.working_detail(working_date, 1); 
		model.addObject("detail_map", detail_map);
		model.setViewName("worker_detail_response");
		return model;
	}	
	
	@RequestMapping("/save_working_detail")
	public @ResponseBody String save_working_detail(HttpServletRequest request, HttpServletResponse response,@RequestParam("worker_id")String worker_id,@RequestParam("working_date")String working_date,@RequestParam("fullday")String fullday,
			@RequestParam("halfday")String halfday,@RequestParam("hour")String hour,@RequestParam("calculated_salary")String calculated_salary,@RequestParam("deduction")String deduction){
		System.out.println(" page loading Value of save_working_detail");
		HttpSession session=request.getSession(true);
		String currentuser=session.getAttribute("username").toString();
		String currentuserid=session.getAttribute("userid").toString();
		System.out.println("currentuser : - "+currentuser);
		System.out.println("currentuserid : - "+currentuserid);
		
		System.out.println("worker_id : - "+worker_id);
		System.out.println("working_date : - "+working_date);
		System.out.println("fullday : - "+fullday);
		System.out.println("halfday : - "+halfday);
		System.out.println("calculated_salary : - "+calculated_salary);
		System.out.println("deduction : - "+deduction);
		
		Add_Worker_Detail awd=new Add_Worker_Detail();
		awd.setWorker_id(Integer.parseInt(worker_id));
		awd.setWorking_date(working_date);
		//awd.setFullday(Integer.parseInt(fullday));
		//awd.setHalfday(Integer.parseInt(halfday));
		//awd.setHour(Float.parseFloat(hour));
		awd.setFullday(fullday);
		awd.setHalfday(halfday);
		awd.setHour(hour);
		awd.setCalculated_salary(Float.parseFloat(calculated_salary));
		awd.setDeduction(Float.parseFloat(deduction));
		awd.setModified_user(Integer.parseInt(currentuserid));
		awd.setModified_date(DateTimeFormater.getCurrentDatetime());
		
		String msg=loginservice.save_working_detail(awd);
		return msg;
	}
}
