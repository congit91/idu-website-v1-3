package com.idu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.idu.dao.CategoryDao;
import com.idu.entities.Category;
import com.idu.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Transactional
	public List<Category> getListCategory() {
		// TODO Auto-generated method stub
		return categoryDao.getListCategory();
	}

	@Transactional
	public Category getCategoryById(int categoryId) {
		// TODO Auto-generated method stub
		return categoryDao.getCategoryById(categoryId);
	}
	
}
