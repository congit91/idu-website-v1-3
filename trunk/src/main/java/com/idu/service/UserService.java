package com.idu.service;

import java.util.List;

import com.idu.entities.User;

public interface UserService {
	List<User> getListUser();
	User getUserById(int userId);
}
