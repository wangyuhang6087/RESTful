package com.zhiyou100.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhiyou100.model.User;
import com.zhiyou100.service.LoginService;
import com.zhiyou100.service.UserService;
import com.zhiyou100.util.ResultObject;

@Controller
public class RestController {

	@Autowired
	LoginService loginService;
	
	@Autowired
	UserService userService;
	/**
	 * @param username
	 * @param password
	 * @return
	 * 登录
	 */
	@RequestMapping(value="/login",method=RequestMethod.POST)
	@ResponseBody
	public ResultObject login(String username,String password) {
		User user = loginService.findUserByLogin(username, password);
		System.out.println("登录 : "+user);
		if(user != null) {
			return new ResultObject(200,"成功",null);
		}
		return new ResultObject(404,"失败",null);
		
	}
	/**
	 * @param username
	 * @param password
	 * @return
	 *  查询全部
	 */
	@RequestMapping(value="/user/list",method=RequestMethod.GET)
	@ResponseBody
	public ResultObject list() {
		List<User> users = userService.findAll(null);
		System.out.println("查询全部 : "+users);
		if(users == null || users.size()==0){
			return new ResultObject(404,"失败",null);
		}
		return new ResultObject(200,"成功",users);
		
	}
	/**
	 * @return
	 * 执行添加  /user    post
	 * 前端请求方式 post,参数是表单提交形式
	 * 后台Controller 参数User 可以直接封装成功
	 */
	@RequestMapping(value="/user",method=RequestMethod.POST)
	@ResponseBody
	public ResultObject add(User user) {
		System.out.println("Controller add 接收的user: "+user);
		
		boolean result = userService.addUser(user);
		if(result){
			System.out.println("添加结果 : "+result);
			return new ResultObject(200,"成功",null);
		}
		return new ResultObject(404,"失败",null);
	}
	
	/**
	 * 
	 * @param user
	 * @return
	 * 删除
	 * /user/{id}   DELETE
	 */
	@RequestMapping(value="/user/{id}",method=RequestMethod.DELETE)
	@ResponseBody
	public ResultObject delete(@PathVariable("id") int id) {
		System.out.println("Controller delete 接收的id: "+id);
		
		userService.deleteUserById(id);
		return new ResultObject(200,"成功",null);
	}
	/**
	 * @param id
	 * @return
	 * 更新回显  /user/{id}   get
	 */
	@RequestMapping(value="/user/{id}",method=RequestMethod.GET)
	@ResponseBody
	public ResultObject find(@PathVariable("id") int id) {
		System.out.println("Controller find 接收的id: "+id);
		
		User user = userService.findUserById(id);
		return new ResultObject(200,"成功",user);
	}
	
	/**
	 *  更新
	 *  /user  put
	 *  参数 前端发送的json数据,想要直接封装到对应的user对象,需要解析
	 *  @RequestBody 将页面的json解析为对应的javabean
	 */
	@RequestMapping(value="/user",method=RequestMethod.PUT)
	@ResponseBody
	public ResultObject update(@RequestBody User user) {
		System.out.println("Controller update 接收的user: "+user);
		userService.updateUser(user);
		return new ResultObject(200,"成功",user);
	}
	
	
}





