package com.idu.dao;

import java.util.List;

import com.idu.entities.User;

public interface UserDao {
	List<User> getListUser();
	User getUserById(int userId);
}
