package com.idu.service;

import java.util.List;

import com.idu.entities.Category;

public interface CategoryService {
	List<Category> getListCategory();
	Category getCategoryById(int categoryId);
}
