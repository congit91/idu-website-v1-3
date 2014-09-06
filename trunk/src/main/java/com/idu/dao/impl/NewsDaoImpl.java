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

import com.idu.dao.NewsDao;
import com.idu.entities.News;

@Repository
public class NewsDaoImpl implements NewsDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<News> getListNews() {

		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		List<News> listNews= null;
		try {
			listNews = new ArrayList<>();
			transaction = session.beginTransaction();

			String hsql = "FROM News";
			Query query = session.createQuery(hsql);
			listNews = query.list();
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			if(session.isOpen())
				session.close();
		}
		return listNews;
	}

	@Override
	public boolean insert(News news) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {	
			transaction = session.beginTransaction();
			session.save(news);
			transaction.commit();
			return true;
		} catch (HibernateException e) {
			if (transaction != null) {
				transaction.rollback();
			}
			 e.printStackTrace();
			return false;
		} finally {
			if(session.isOpen())
				session.close();
		}
	}

	@Override
	public boolean update(News news) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {	
			transaction = session.beginTransaction();
			session.update(news);
			transaction.commit();
			return true;
		} catch (HibernateException e) {
			if (transaction != null) {
				transaction.rollback();
			}
			 e.printStackTrace();
			return false;
		} finally {
			if(session.isOpen())
				session.close();
		}
	}

	@Override
	public boolean delete(int newsId) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			News news = getNewsById(newsId);
			session.delete(news);
			transaction.commit();
			return true;
		} catch (HibernateException e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			return false;
		} finally {
			if(session.isOpen())
				session.close();
		}
	}

	@Override
	public News getNewsById(int newsId) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		News news = null;
		try {
			transaction = session.beginTransaction();
			news = (News) session.get(News.class, newsId);
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
		return news;
	}

	@Override
	public boolean active(int newsId, boolean isActive) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		News news = null;
		try {
			transaction = session.beginTransaction();
			news = (News) session.get(News.class, newsId);
			news.setActive(isActive);
			session.update(news);
			transaction.commit();
			return true;
		} catch (HibernateException e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			return false;
		} finally {
			if(session.isOpen())
				session.close();
		}
	}

	@Override
	public boolean exitNews(News news) {
		
		return getNewsByTitle(news.getTitle()) != null;
	}

	@Override
	public News getNewsByTitle(String title) {
		Session session = sessionFactory.openSession();
		//Transaction transaction = null;
		
		try {
			//transaction = session.beginTransaction();
			String sql ="FROM News n WHERE n.title = :title ";
			Query query = session.createQuery(sql);
			query.setParameter("title", title);
			return (News) query.uniqueResult();
			
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		} finally {
			if(session.isOpen())
				session.close();
		}
		
	}
}
