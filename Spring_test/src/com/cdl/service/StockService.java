package com.cdl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cdl.dao.StockDao;

@Service("stockservice")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class StockService {
	
	@Autowired
	private StockDao stockdao;
	
	
	/*public Map<Integer,String> getCategory(Category category){
		return stockdao.getCategory(category);
	}
	
	public ModelAndView selectCategoryForEdit(Category category){
		return stockdao.selectCategoryForEdit(category);
	}
	
	public ModelAndView updateAndSaveCategory(Category cat,int userid){
		return stockdao.updateAndSaveCategory(cat, userid);
	}*/
}
