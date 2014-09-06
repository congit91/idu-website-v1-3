package com.idu.converter;

import javax.annotation.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.springframework.beans.factory.annotation.Autowired;

import com.idu.entities.Category;
import com.idu.service.CategoryService;

@ManagedBean
@RequestScoped
public class CategoryConverter implements Converter {
	
	@Autowired
	private CategoryService categoryService;
	
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		return categoryService.getCategoryById(Integer.valueOf(arg2));
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		try {
			Category category =(Category)arg2;
			return category.getCategoryId()+"";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
