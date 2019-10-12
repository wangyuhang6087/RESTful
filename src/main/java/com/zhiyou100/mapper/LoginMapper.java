package com.zhiyou100.mapper;

import java.util.Map;

import com.zhiyou100.model.User;

public interface LoginMapper {

	User findUserByLogin(Map<String, String> map);

	User findUserByUsername(String username);

}
