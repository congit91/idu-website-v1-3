package com.idu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.idu.dao.UserDao;
import com.idu.entities.User;
import com.idu.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;

	@Transactional
	public List<User> getListUser() {
		return userDao.getListUser();
	}

	@Override
	public User getUserById(int userId) {
		// TODO Auto-generated method stub
		return userDao.getUserById(userId);
	}
}
