package com.idu.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.idu.dao.CategoryDao;
import com.idu.entities.Category;

@Repository
public class CategoryDaoImpl implements CategoryDao{

	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public List<Category> getListCategory() {
		
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		List<Category> listCategory= null;
		try {
			listCategory = new ArrayList<>();
			transaction = session.beginTransaction();

			String hsql = "FROM Category";
			Query query = session.createQuery(hsql);
			listCategory = query.list();
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			if(session.isOpen())
				session.close();
		}
		return listCategory;
	}

	@Override
	public Category getCategoryById(int categoryId) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		Category category = null;
		try {
			transaction = session.beginTransaction();
			category = (Category) session.get(Category.class, categoryId);
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			if(session.isOpen())
				session.close();
		}
		return category;
	}

}
