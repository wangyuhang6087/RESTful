package com.zhiyou100.service;

import java.util.List;
import java.util.Map;

import com.zhiyou100.model.User;

public interface UserService {

	List<User> findAll(Map<String, Object> map);

	boolean addUser(User user);

	int count(Map<String, Object> map);

	User findUserById(int id);

	List<Integer> findAllIds();

	void deleteUserById(int id);

	void updateUser(User user);

}
