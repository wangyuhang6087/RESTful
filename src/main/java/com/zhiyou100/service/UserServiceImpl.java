package com.zhiyou100.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.mapper.UserMapper;
import com.zhiyou100.model.User;
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper mapper;
	
	@Override
	public List<User> findAll(Map<String, Object> map) {
		return mapper.findAll(map);
	}

	@Override
	public boolean addUser(User user) {
		
		int rowNum = mapper.addUser(user);
		if(rowNum >0) {
			// 插入成功
			return true;
		}
		if(user.getBirthday() == null || user.getName() == "" || user.getPassword()=="") {
			return false;
		}
		return false;
	}

	@Override
	public int count(Map<String, Object> map) {
		return mapper.count(map);
	}

	@Override
	public User findUserById(int id) {
		return mapper.findUserById(id);
	}

	@Override
	public List<Integer> findAllIds() {
		return mapper.findAllIds();
	}

	@Override
	public void deleteUserById(int id) {
		mapper.deleteUserById(id);
	}

	@Override
	public void updateUser(User user) {
		mapper.updateUser(user);
	}

	
	
}
