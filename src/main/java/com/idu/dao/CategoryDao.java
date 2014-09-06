package com.idu.dao;

import java.util.List;

import com.idu.entities.Category;

public interface CategoryDao {
	List<Category> getListCategory();
	Category getCategoryById(int categoryId);
}
