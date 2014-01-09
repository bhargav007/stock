package com.cdl.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import com.cdl.dao.ItemDao;
import com.cdl.entity.Items;

@Service("itemservice")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class ItemService {
	
	@Autowired
	private ItemDao itemdao;
	
	
	public Map<Integer,String> getCategoryMap(){
		return itemdao.getCategoryMap();
	}
	public Map<Integer,String> getItem(Items i){
		return itemdao.getItem(i);
	}
	public ModelAndView selectItemForEdit(Items item){
		return itemdao.selectItemForEdit(item);
	}
	public ModelAndView updateAndSaveItem(Items item,int userid){
		return itemdao.updateAndSaveItem(item, userid);
	}
	
	/*public Map<Integer,String> getCategory(Category category){
		return categorydao.getCategory(category);
	}
	
	public ModelAndView selectCategoryForEdit(Category category){
		return categorydao.selectCategoryForEdit(category);
	}
	
	public ModelAndView updateAndSaveCategory(Category cat,int userid){
		return categorydao.updateAndSaveCategory(cat, userid);
	}*/
}
