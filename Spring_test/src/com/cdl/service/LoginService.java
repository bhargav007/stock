package com.cdl.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import com.cdl.dao.LoginDao;
import com.cdl.entity.Add_Worker;
import com.cdl.entity.Add_Worker_Detail;

@Service("loginservice")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class LoginService {
	
	@Autowired
	private LoginDao logindao;
	
	
	
	public boolean checkAuthentication(String uname,String pswd,HttpServletRequest request){
		boolean flag=logindao.checkAuthentication(uname, pswd,request);
		
		return flag;
	}
	
	public Map<Integer,String> getWorkerDetails(Add_Worker add_worker){
		return logindao.getWorkerDetails(add_worker);
	}
	public ModelAndView selectWorkerForEdit(Add_Worker add){
		return logindao.selectWorkerForEdit(add);
	}
	public ModelAndView updateAndSaveWorker(Add_Worker add,int userid){
		return logindao.updateAndSaveWorker(add, userid);
	}
	public Map<String,Add_Worker_Detail> working_detail(String dateOfWorking,int userid){
		return logindao.working_detail(dateOfWorking, userid);
	}
	public String save_working_detail(Add_Worker_Detail awd){
		return logindao.save_working_detail(awd);
	}
}
