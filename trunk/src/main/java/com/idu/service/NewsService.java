package com.idu.service;

import java.util.List;

import com.idu.entities.News;

public interface NewsService {
	boolean active(int newsId,boolean isActive);
	boolean insert(News news);
	boolean update(News news);
	boolean delete(int newsId);
	boolean exitNews(News news);
	News getNewsByTitle(String title);
	News getNewsById(int newsId);
	List<News> getListNews();
}
