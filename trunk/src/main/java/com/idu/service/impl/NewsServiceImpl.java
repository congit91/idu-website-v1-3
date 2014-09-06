package com.idu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.idu.dao.NewsDao;
import com.idu.entities.News;
import com.idu.service.NewsService;

@Service
public class NewsServiceImpl implements NewsService{
	
	@Autowired
	private NewsDao newsDao;
	
	@Transactional
	public List<News> getListNews() {
		// TODO Auto-generated method stub
		return newsDao.getListNews();
	}

	@Transactional
	public boolean insert(News news) {
		// TODO Auto-generated method stub
		return newsDao.insert(news);
	}

	@Transactional
	public boolean update(News news) {
		// TODO Auto-generated method stub
		return newsDao.update(news);
	}

	@Transactional
	public boolean delete(int newsId) {
		// TODO Auto-generated method stub
		return newsDao.delete(newsId);
	}

	@Transactional
	public News getNewsById(int newsId) {
		// TODO Auto-generated method stub
		return newsDao.getNewsById(newsId);
	}

	@Transactional
	public boolean active(int newsId, boolean isActive) {
		return newsDao.active(newsId, isActive);
	}

	@Transactional
	public boolean exitNews(News news) {
		// TODO Auto-generated method stub
		return newsDao.exitNews(news);
	}

	@Transactional
	public News getNewsByTitle(String title) {
		// TODO Auto-generated method stub
		return newsDao.getNewsByTitle(title);
	}

}
