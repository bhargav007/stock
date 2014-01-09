package com.cdl.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import com.cdl.dao.CategoryDao;
import com.cdl.entity.Category;

@Service("categoryservice")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class CategoryService {
	
	@Autowired
	private CategoryDao categorydao;
	
	
	public Map<Integer,String> getCategory(Category category){
		return categorydao.getCategory(category);
	}
	
	public ModelAndView selectCategoryForEdit(Category category){
		return categorydao.selectCategoryForEdit(category);
	}
	
	public ModelAndView updateAndSaveCategory(Category cat,int userid){
		return categorydao.updateAndSaveCategory(cat, userid);
	}
}
