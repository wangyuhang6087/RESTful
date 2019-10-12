package com.zhiyou100.mapper;

import java.util.List;
import java.util.Map;

import com.zhiyou100.model.User;

public interface UserMapper {

	List<User> findAll(Map<String, Object> map);

	int addUser(User user);

	int count(Map<String, Object> map);

	User findUserById(int id);

	List<Integer> findAllIds();

	void deleteUserById(int id);

	void updateUser(User user);

}
