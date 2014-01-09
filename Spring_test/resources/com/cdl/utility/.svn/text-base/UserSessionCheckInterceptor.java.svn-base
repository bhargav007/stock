package com.cdl.utility;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class UserSessionCheckInterceptor extends HandlerInterceptorAdapter {

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("*************After Completion**************");
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		System.out.println("*********Post-handle************");

	}

	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2) throws Exception {
		System.out.println("********Pre-handle************");
		String classname = arg2.getClass().getSimpleName();
		
		System.out.println("classname "+classname);
		HttpSession session=arg0.getSession();
		if(!classname.equals("LoginController")){
			if(session.getAttribute("user")==null)
			{
				System.out.println("User is null");
				new ModelAndView("login");
				return true;
			
			}else if(session.getMaxInactiveInterval() > 1800)
			{
				System.out.println("Max session interval exceeds");
				new ModelAndView("login");
				return false;
			}
		}
			return true;
		/*else if(classname.equals("LoginController"))
		{
			System.out.println("in else if of interceptor");
			//arg1.sendRedirect(arg0.getContextPath()+"/login.action");
			new ModelAndView("login");
			return false;
		}else{
			System.out.println("in else of interceptor");
			return false;
		}*/
	}
	


}
