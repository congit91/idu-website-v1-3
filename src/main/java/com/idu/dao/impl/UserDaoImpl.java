package com.idu.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.idu.dao.UserDao;
import com.idu.entities.News;
import com.idu.entities.User;

@Repository
public class UserDaoImpl implements UserDao{
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public List<User> getListUser() {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		List<User> listUser = null;
		try {
			listUser = new ArrayList<>();
			transaction = session.beginTransaction();

			String hsql = "FROM User";
			Query query = session.createQuery(hsql);
			listUser = query.list();
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			if(session.isOpen())
				session.close();
		}
		return listUser;
	}
	@Override
	public User getUserById(int userId) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		User user = null;
		try {
			transaction = session.beginTransaction();
			System.out.println("id:" + userId);
			Criteria criteria = session.createCriteria(User.class);
			criteria.add(Restrictions.eq("userId", userId));
			user =(User)criteria.uniqueResult();
			System.out.println("dao:" + user.getUserId());
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
		return user;
	}

}
