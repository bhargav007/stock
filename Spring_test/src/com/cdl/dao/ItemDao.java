package com.cdl.dao;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.ModelAndView;

import com.cdl.entity.Category;
import com.cdl.entity.Items;
import com.cdl.utility.DateTimeFormater;
import com.sun.org.apache.bcel.internal.generic.RETURN;


@Repository("itemdao")
public class ItemDao {
	
	private static final Logger logger = Logger.getLogger(ItemDao.class);
	@Autowired
	private SessionFactory sessionFactory;

	
	public Map<Integer,String> getItem(Items item)
	{
		logger.info("::: STARTING  Of getItem(DAO) :::");
		Map<Integer,String>map=new TreeMap<Integer, String>();
		String item_name="-",cat_name="-",item_code="-",item_description="-",is_active=null;
		Session session= sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Items> i=session.createQuery("From Items").list();
		if(i.size()>0){
			logger.info("Size of item list is :- "+i.size());
			for(Items c:i){
				if(c.getItem_name()!=null && !c.getItem_name().equalsIgnoreCase(""))
					item_name=c.getItem_name();
				else
					item_name="-";
				
				if(c.getItem_code()!=null && !c.getItem_code().equalsIgnoreCase(""))
					item_code=c.getItem_code();
				else
					item_code="-";
				
				if(c.getCat_id()!=0){
					cat_name=this.getCategoryName(c.getCat_id());
				}
				
				if(c.getItem_description()!=null && !c.getItem_description().equalsIgnoreCase(""))
					item_description=c.getItem_description();
				else
					item_description="-";
				
				if(c.getIs_delete()!=null)
					is_active=c.getIs_delete().toString();
				else
					is_active="-";
				
				map.put(c.getItem_id(),item_name+"@@"+item_code+"@@"+cat_name+"@@"+item_description+"@@"+is_active);
			}
		}else
			logger.info("Size of item list is Zero or may be empty..!");
		logger.info("::: ENDING Of getItem(DAO) :::");
		return map;
	}
	
	public ModelAndView selectItemForEdit(Items item)
	{
		logger.info("::: STARING Of selectItemForEdit(DAO) :::");
		
		ModelAndView model=new ModelAndView();
		Session session=sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Items> i=session.createQuery("select new Items(cat_id,item_name,item_code,item_description,created_date,modified_date,created_user,modified_user,is_delete) " +
															" from Items where item_id='"+item.getItem_id()+"'").list();
		if(i.size()>0){
			logger.info("Size of item list is :- "+i.size());
			
			item.setItem_code(i.get(0).getItem_name());
			item.setItem_name(i.get(0).getItem_name());
			item.setItem_description(i.get(0).getItem_description());
			item.setCat_id(i.get(0).getCat_id());
			item.setIs_delete(i.get(0).getIs_delete());
		}else
			logger.info("Size of item  list is Zero or may be empty..!");
			
		logger.info("::: ENDING Of selectItemForEdit(DAO) :::");
		model.setViewName("item_child");
		return model;
	}
	
	public ModelAndView updateAndSaveItem(Items item,int userid)
	{
		logger.info("::: STARING Of updateAndSaveItem(DAO) :::");
		
		ModelAndView model=new ModelAndView();
		String msg=null;
		
		item.setModified_user(userid);
		item.setModified_date(DateTimeFormater.getCurrentDatetime());
		
		logger.info("id :- "+item.getItem_id());
		
		if(item!=null && item.getItem_id()!=0){
			logger.info("id :- "+item.getItem_id());	
			logger.info("Record Found For Id :- "+item.getItem_id()+".. So Going to Update the Record..!");
			//cat_name,cat_code,cat_description,created_date,modified_date,created_user,modified_user,is_delete
			logger.info("Existing id :- "+item.getItem_id());
			logger.info("Existing Item Name :- "+item.getItem_name());
			logger.info("Existing Item code :- "+item.getItem_code());
			logger.info("Existing Item description :- "+item.getItem_description());
			logger.info("Existing Modified User :-"+item.getModified_user());
			logger.info("Existing Modified Date:- "+item.getModified_date());
			logger.info("Existing Created User :-"+item.getCreated_user());
			logger.info("Existing Is Delete:- "+item.getIs_delete());
			
			Query q = sessionFactory.getCurrentSession().createQuery("update Items set item_name='"+item.getItem_name()+"', " +
					"	item_code='"+item.getItem_code()+"',cat_id="+item.getCat_id()+", item_description='"+item.getItem_description()+"'," +
					"	modified_user="+item.getModified_user()+",modified_date='"+item.getModified_date()+"',is_delete=:IS_DELETE where item_id="+item.getItem_id()+" ");
			q.setParameter("IS_DELETE",Boolean.parseBoolean(item.getIs_delete().toString()));	
			q.executeUpdate();
					msg=item.getItem_name()+" :  Updated Successfully..!!";	
					logger.info(" ::: UPDATED Info with  Name :-"+item.getItem_name()+" :: Id:-"+item.getItem_id());
		}else{
			item.setCreated_user(userid);
			item.setCreated_date(DateTimeFormater.getCurrentDatetime());
			logger.info("Going To Insert New Record..!!");
			logger.info("Existing id :- "+item.getItem_id());
			logger.info("Existing Item Name :- "+item.getItem_name());
			logger.info("Existing Item code :- "+item.getItem_code());
			logger.info("Existing Item description :- "+item.getItem_description());
			logger.info("Existing Modified User :-"+item.getModified_user());
			logger.info("Existing Modified Date:- "+item.getModified_date());
			logger.info("Existing Created User :-"+item.getCreated_user());
			logger.info("Existing Is Delete:- "+item.getIs_delete());
			
			sessionFactory.getCurrentSession().save(item);
			msg=item.getItem_name()+" :  Inserted Successfully..!!";
			logger.info(" ::: UPDATED Info with  Name :-"+item.getItem_name()+" :: Id:-"+item.getItem_id());
			
		}
		
		model.addObject("msg",msg);
		model.addObject("clr","green");
		
		logger.info("::: ENDING Of updateAndSaveItem(DAO) :::");
		return model;
	}
	
	
	public String getCategoryName(int catid){
		String category_name="-";
		if(catid!=0){
			@SuppressWarnings({ "unchecked" })
			List<Category> category=sessionFactory.getCurrentSession().createQuery("from Category where cat_id="+catid+"").list();
			if(category.size()>0){
				if(category.get(0).getCat_name()!=null)
					category_name=category.get(0).getCat_name();
			}
		}
		return category_name;
	}
	
	public Map<Integer,String> getCategoryMap(){
		Map<Integer,String> map=new TreeMap<Integer, String>();
		map.put(0,"- select category -");
		@SuppressWarnings({ "unchecked" })
		List<Category> category=sessionFactory.getCurrentSession().createQuery("from Category").list();
			if(category.size()>0){
				for(Category c:category)
					map.put(c.getCat_id(),c.getCat_name());
			}
	return map;		
	}
}
