package com.cdl.dao;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.ModelAndView;

import com.cdl.entity.Add_Worker;
import com.cdl.entity.Add_Worker_Detail;
import com.cdl.entity.Users;
import com.cdl.utility.DateTimeFormater;


@Repository("logindao")
public class LoginDao {
	
	private static final Logger logger = Logger.getLogger(LoginDao.class);
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public boolean checkAuthentication(String uname,String pswd,HttpServletRequest request){
		boolean flage=false;
		List<Users> u=sessionFactory.getCurrentSession().createQuery("From Users us where us.username='"+uname+"' and us.password='"+pswd+"' ").list();
		if(u.size()>0){
			flage=true;
			HttpSession session=request.getSession();
			session.setAttribute("username",u.get(0).getUsername());
			session.setAttribute("userid",u.get(0).getId());
			//this.working_detail("02-01-2014", 1);
		}
		return flage;
	}
	
	public Map<Integer,String> getWorkerDetails(Add_Worker add_worker)
	{
		logger.info("::: STARTING  Of getWorkerDetails(DAO) :::");
		Map<Integer,String>map=new TreeMap<Integer, String>();
		String worker_name=null,address=null,contact=null,licenceNo=null,is_active=null;
		float salary_per_day=0;
		Session session= sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Add_Worker> add=session.createQuery("From Add_Worker").list();
		if(add.size()>0){
			logger.info("Size of Add Worker list is :- "+add.size());
			for(Add_Worker d:add){
				if(d.getWorker_name()!=null && !d.getWorker_name().equalsIgnoreCase(""))
					worker_name=d.getWorker_name();
				else
					worker_name="-";
				
				if(d.getAddress()!=null && !d.getAddress().equalsIgnoreCase(""))
					address=d.getAddress();
				else
					address="-";
				
				if(d.getContact()!=null && !d.getContact().equalsIgnoreCase(""))
					contact=d.getContact();
				else
					contact="-";
				
				if(d.getLicenceNo()!=null && !d.getLicenceNo().equalsIgnoreCase(""))
					licenceNo=d.getLicenceNo();
				else
					licenceNo="-";
				
				if(d.getSalary_per_day()!= 0)
					salary_per_day=d.getSalary_per_day();
				else
					salary_per_day=0;
				
				if(d.getIs_delete()!=null)
					is_active=d.getIs_delete().toString();
				else
					is_active="-";
				
				map.put(d.getWorker_id(),worker_name+"@@"+address+"@@"+contact+"@@"+licenceNo+"@@"+salary_per_day+"@@"+is_active);
			}
		}else
			logger.info("Size of Add Worker  list is Zero or may be empty..!");
		logger.info("::: ENDING Of getWorkerDetails(DAO) :::");
		return map;
	}
	
	public ModelAndView selectWorkerForEdit(Add_Worker add)
	{
		logger.info("::: STARING Of selectWorkerForEdit(DAO) :::");
		
		ModelAndView model=new ModelAndView();
		Session session=sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Add_Worker> add_worker=session.createQuery("select new Add_Worker(worker_name,address,contact,licenceNo, " +
															"salary_per_day,created_date,modified_date,created_user,is_delete) " +
															"from Add_Worker where worker_id='"+add.getWorker_id()+"'").list();
		if(add_worker.size()>0){
			logger.info("Size of add_worker list is :- "+add_worker.size());
			
			add.setWorker_name(add_worker.get(0).getWorker_name());
			add.setAddress(add_worker.get(0).getAddress());
			add.setContact(add_worker.get(0).getContact());
			add.setLicenceNo(add_worker.get(0).getLicenceNo());
			add.setSalary_per_day(add_worker.get(0).getSalary_per_day());
			add.setIs_delete(add_worker.get(0).getIs_delete());
		}else
			logger.info("Size of add_worker  list is Zero or may be empty..!");
			
		logger.info("::: ENDING Of selectWorkerForEdit(DAO) :::");
		model.setViewName("add_worker_child");
		return model;
	}
	
	public ModelAndView updateAndSaveWorker(Add_Worker add,int userid)
	{
		logger.info("::: STARING Of updateAndSaveWorker(DAO) :::");
		
		ModelAndView model=new ModelAndView();
		String msg=null;
		
		add.setModified_user(userid);
		add.setModified_date(DateTimeFormater.getCurrentDatetime());
		
		logger.info("id :- "+add.getWorker_id());
		
		if(add!=null && add.getWorker_id()!=0){
			logger.info("id :- "+add.getWorker_id());	
			logger.info("Record Found For Id :- "+add.getWorker_id()+".. So Going to Update the Record..!");
			//worker_id,worker_name,address,contact,licenceNo,salary_per_day,created_date,modified_date,created_user,modified_user
			logger.info("Existing id :- "+add.getWorker_id());
			logger.info("Existing Worker Name :- "+add.getWorker_name());
			logger.info("Existing Address :- "+add.getAddress());
			logger.info("Existing Contact :- "+add.getContact());
			logger.info("Existing licenceNo :- "+add.getLicenceNo());
			logger.info("Existing Salary per day:- "+add.getSalary_per_day());
			logger.info("Existing Modified User :-"+add.getModified_user());
			logger.info("Existing Modified Date:- "+add.getModified_date());
			logger.info("Existing Created User :-"+add.getCreated_user());
			logger.info("Existing Is Delete:- "+add.getIs_delete());
			
			Query q = sessionFactory.getCurrentSession().createQuery("update Add_Worker set worker_name='"+add.getWorker_name()+"', " +
					"	address='"+add.getAddress()+"',contact='"+add.getContact()+"',licenceNo='"+add.getLicenceNo()+"',salary_per_day='"+add.getSalary_per_day()+"'," +
					"	modified_user="+add.getModified_user()+",modified_date='"+add.getModified_date()+"',is_delete=:IS_DELETE where worker_id="+add.getWorker_id()+" ");
			q.setParameter("IS_DELETE",Boolean.parseBoolean(add.getIs_delete().toString()));	
			q.executeUpdate();
					msg=add.getWorker_name()+" :  Updated Successfully..!!";	
					logger.info(" ::: UPDATED Info with  Name :-"+add.getWorker_name()+" :: Id:-"+add.getWorker_id());
		}else{
			add.setCreated_user(userid);
			add.setCreated_date(DateTimeFormater.getCurrentDatetime());
			logger.info("Going To Insert New Record..!!");
			logger.info("New id :- "+add.getWorker_id());
			logger.info("Existing Worker Name :- "+add.getWorker_name());
			logger.info("Existing Address :- "+add.getAddress());
			logger.info("Existing Contact :- "+add.getContact());
			logger.info("Existing licenceNo :- "+add.getLicenceNo());
			logger.info("Existing Salary per day:- "+add.getSalary_per_day());
			logger.info("Existing Modified User :-"+add.getModified_user());
			logger.info("Existing Modified Date:- "+add.getModified_date());
			logger.info("Existing Created User :-"+add.getCreated_user());
			logger.info("Existing Is Delete:- "+add.getIs_delete());
			
			sessionFactory.getCurrentSession().save(add);
			msg=add.getWorker_name()+" :  Inserted Successfully..!!";
			logger.info(" ::: INSERTED Info with  Name :-"+add.getWorker_name()+" :: Id:-"+add.getWorker_id());
			
		}
		
		model.addObject("msg",msg);
		model.addObject("clr","green");
		
		logger.info("::: ENDING Of updateAndSaveWorker(DAO) :::");
		return model;
	}

	public Map<String,Add_Worker_Detail> working_detail(String dateOfWorking,int userid){
		logger.info("::: STARTING Of working_detail(DAO) :::");
		System.out.println("dateOfWorking : - " + dateOfWorking);
		Map<String,Add_Worker_Detail> total_detail_map=new TreeMap<String, Add_Worker_Detail>();
		Add_Worker_Detail temp=new Add_Worker_Detail();
		
		Session session=sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Add_Worker> add_worker=session.createQuery("select new Add_Worker(worker_id,worker_name,salary_per_day) from Add_Worker where is_delete=1 ").list();
		if(add_worker.size()>0){
			for(Add_Worker w:add_worker){
				System.out.println("worker_id :- "+w.getWorker_id());
				System.out.println("worker_name :- "+w.getWorker_name());
				@SuppressWarnings("unchecked")
				List<Add_Worker_Detail> worker_detail=session.createQuery("select new Add_Worker_Detail(worker_id,working_date,fullday,halfday,hour, " +
																		  " calculated_salary,deduction,created_date,modified_date,created_user,     " +
																		  " modified_user) from Add_Worker_Detail awd where awd.worker_id="+w.getWorker_id()+" and " +
																		  " UNIX_TIMESTAMP(str_to_date(working_date, '%d-%m-%Y')) =UNIX_TIMESTAMP(str_to_date('"+dateOfWorking+"', '%d-%m-%Y')) ").list();
				if(worker_detail.size()>0){
					System.out.println("worker_id :- "+worker_detail.get(0).getWorker_id());
					
					total_detail_map.put(w.getWorker_id()+"@@"+w.getWorker_name()+"@@"+w.getSalary_per_day(), worker_detail.get(0));
				}else{
					total_detail_map.put(w.getWorker_id()+"@@"+w.getWorker_name()+"@@"+w.getSalary_per_day(),new Add_Worker_Detail(w.getWorker_id(), dateOfWorking,"false","false","false",0,0,null,null,userid,userid));
					logger.info("::: Size of worker_detail list is Zero or may be its Empty :::");
				}
			}
		}else{
			logger.info("::: Size of Add_Worker list is Zero or may be its Empty :::");
		}
		
		System.out.println(" Map : - "+total_detail_map);
		logger.info("::: ENDING Of working_detail(DAO) :::");
		return total_detail_map;
	}
	public String save_working_detail(Add_Worker_Detail awd){
		logger.info("::: STARTING Of save_working_detail(DAO) :::");
		String msg="";
		String worker_name=this.getWorkernameFromId(awd.getWorker_id());
		Session session=sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Add_Worker_Detail> workerdetail=session.createQuery("From Add_Worker_Detail where worker_id="+awd.getWorker_id()+" " +
				" and UNIX_TIMESTAMP(str_to_date(working_date, '%d-%m-%Y')) =UNIX_TIMESTAMP(str_to_date('"+awd.getWorking_date()+"', '%d-%m-%Y'))").list();
		if(workerdetail.size()>0){
			//worker_detail_id,worker_id,working_date,fullday,halfday,`hour`,calculated_salary,
			//deduction,created_date,modified_date,created_user,modified_user
			Query q = sessionFactory.getCurrentSession().createQuery("update Add_Worker_Detail set fullday='"+awd.getFullday()+"'," +
					" 	halfday='"+awd.getHalfday()+"',hour='"+awd.getHour()+"',  calculated_salary="+awd.getCalculated_salary()+",deduction="+awd.getDeduction()+",					" +
					"	modified_date='"+awd.getModified_date()+"' ,modified_user="+awd.getModified_user()+ 
					"	where worker_id="+awd.getWorker_id()+" and " +
					"	UNIX_TIMESTAMP(str_to_date(working_date, '%d-%m-%Y')) =UNIX_TIMESTAMP(str_to_date('"+awd.getWorking_date()+"', '%d-%m-%Y'))");
					q.executeUpdate();
					msg=worker_name + " :Attendance Details Updated Successfully..!!";
					System.out.println(" worker detail Updated");
		
		}else{
			awd.setCreated_date(DateTimeFormater.getCurrentDatetime());
			awd.setCreated_user(awd.getModified_user());
			session.save(awd);
			msg=worker_name + " :Attendance Details Added Successfully..!!";
			System.out.println(" worker detail Inserted");
		}
		logger.info("::: ENDING Of save_working_detail(DAO) :::");
		return msg;
	}
	
	public String getWorkernameFromId(Integer worker_id){
		logger.info("::: STARTING Of getWorkernameFromId(DAO) :::");
		String worker_name="";
		Session session=sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Add_Worker> workerdetail=session.createQuery("From Add_Worker where worker_id="+worker_id).list();
		if(workerdetail.size()>0){
			worker_name=workerdetail.get(0).getWorker_name();
		}else{
			logger.info("::: Worker name not found :::");
		}
		logger.info("::: ENDING Of getWorkernameFromId(DAO) :::");
		return worker_name;
	}
}
