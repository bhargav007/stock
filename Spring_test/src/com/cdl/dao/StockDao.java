package com.cdl.dao;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository("stockdao")
public class StockDao {
	
	private static final Logger logger = Logger.getLogger(StockDao.class);
	@Autowired
	private SessionFactory sessionFactory;

	
/*	public Map<Integer,String> getCategory(Category category)
	{
		logger.info("::: STARTING  Of getCategory(DAO) :::");
		Map<Integer,String>map=new TreeMap<Integer, String>();
		String cat_name=null,cat_code=null,cat_description=null,is_active=null;
		Session session= sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Category> cat=session.createQuery("From Category").list();
		if(cat.size()>0){
			logger.info("Size of Category list is :- "+cat.size());
			for(Category c:cat){
				if(c.getCat_name()!=null && !c.getCat_name().equalsIgnoreCase(""))
					cat_name=c.getCat_name();
				else
					cat_name="-";
				
				if(c.getCat_code()!=null && !c.getCat_code().equalsIgnoreCase(""))
					cat_code=c.getCat_code();
				else
					cat_code="-";
				
				if(c.getCat_description()!=null && !c.getCat_description().equalsIgnoreCase(""))
					cat_description=c.getCat_description();
				else
					cat_description="-";
				
				if(c.getIs_delete()!=null)
					is_active=c.getIs_delete().toString();
				else
					is_active="-";
				
				map.put(c.getCat_id(),cat_name+"@@"+cat_code+"@@"+cat_description+"@@"+"@@"+is_active);
			}
		}else
			logger.info("Size of Category list is Zero or may be empty..!");
		logger.info("::: ENDING Of getCategory(DAO) :::");
		return map;
	}
	
	public ModelAndView selectCategoryForEdit(Category category)
	{
		logger.info("::: STARING Of selectCategoryForEdit(DAO) :::");
		
		ModelAndView model=new ModelAndView();
		Session session=sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Category> add_category=session.createQuery("select new Category(cat_name,cat_code,cat_description,created_date,modified_date,created_user,modified_user,is_delete) " +
															" from Category where cat_id='"+category.getCat_id()+"'").list();
		if(add_category.size()>0){
			logger.info("Size of add_category list is :- "+add_category.size());
			
			category.setCat_name(add_category.get(0).getCat_name());
			category.setCat_code(add_category.get(0).getCat_code());
			category.setCat_description(add_category.get(0).getCat_description());
			category.setIs_delete(add_category.get(0).getIs_delete());
		}else
			logger.info("Size of add_category  list is Zero or may be empty..!");
			
		logger.info("::: ENDING Of selectCategoryForEdit(DAO) :::");
		model.setViewName("category_child");
		return model;
	}
	
	public ModelAndView updateAndSaveCategory(Category cat,int userid)
	{
		logger.info("::: STARING Of updateAndSaveCategory(DAO) :::");
		
		ModelAndView model=new ModelAndView();
		String msg=null;
		
		cat.setModified_user(userid);
		cat.setModified_date(DateTimeFormater.getCurrentDatetime());
		
		logger.info("id :- "+cat.getCat_id());
		
		if(cat!=null && cat.getCat_id()!=0){
			logger.info("id :- "+cat.getCat_id());	
			logger.info("Record Found For Id :- "+cat.getCat_id()+".. So Going to Update the Record..!");
			//cat_name,cat_code,cat_description,created_date,modified_date,created_user,modified_user,is_delete
			logger.info("Existing id :- "+cat.getCat_id());
			logger.info("Existing Category Name :- "+cat.getCat_name());
			logger.info("Existing Category code :- "+cat.getCat_code());
			logger.info("Existing Category description :- "+cat.getCat_description());
			logger.info("Existing Modified User :-"+cat.getModified_user());
			logger.info("Existing Modified Date:- "+cat.getModified_date());
			logger.info("Existing Created User :-"+cat.getCreated_user());
			logger.info("Existing Is Delete:- "+cat.getIs_delete());
			
			Query q = sessionFactory.getCurrentSession().createQuery("update Category set cat_name='"+cat.getCat_name()+"', " +
					"	cat_code='"+cat.getCat_code()+"',cat_description='"+cat.getCat_description()+"'," +
					"	modified_user="+cat.getModified_user()+",modified_date='"+cat.getModified_date()+"',is_delete=:IS_DELETE where cat_id="+cat.getCat_id()+" ");
			q.setParameter("IS_DELETE",Boolean.parseBoolean(cat.getIs_delete().toString()));	
			q.executeUpdate();
					msg=cat.getCat_name()+" :  Updated Successfully..!!";	
					logger.info(" ::: UPDATED Info with  Name :-"+cat.getCat_name()+" :: Id:-"+cat.getCat_id());
		}else{
			cat.setCreated_user(userid);
			cat.setCreated_date(DateTimeFormater.getCurrentDatetime());
			logger.info("Going To Insert New Record..!!");
			logger.info("Existing id :- "+cat.getCat_id());
			logger.info("Existing Category Name :- "+cat.getCat_name());
			logger.info("Existing Category code :- "+cat.getCat_code());
			logger.info("Existing Category description :- "+cat.getCat_description());
			logger.info("Existing Modified User :-"+cat.getModified_user());
			logger.info("Existing Modified Date:- "+cat.getModified_date());
			logger.info("Existing Created User :-"+cat.getCreated_user());
			logger.info("Existing Is Delete:- "+cat.getIs_delete());
			
			sessionFactory.getCurrentSession().save(cat);
			msg=cat.getCat_name()+" :  Inserted Successfully..!!";
			logger.info(" ::: INSERTED Info with  Name :-"+cat.getCat_name()+" :: Id:-"+cat.getCat_id());
			
		}
		
		model.addObject("msg",msg);
		model.addObject("clr","green");
		
		logger.info("::: ENDING Of updateAndSaveCategory(DAO) :::");
		return model;
	}*/
}
