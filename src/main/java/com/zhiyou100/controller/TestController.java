package com.zhiyou100.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhiyou100.util.ResultObject;

@Controller
public class TestController {

	@RequestMapping(value="/test",method=RequestMethod.GET)
	@ResponseBody
	public ResultObject test() {
		System.out.println("//");
		return new ResultObject(200,"测试成功",null);
	}
	
//	@RequestMapping(value="/login",method=RequestMethod.POST)
//	@ResponseBody
//	public ResultObject login() {
//		System.out.println("//");
//		return new ResultObject(200,"测试成功",null);
//	}
	
	
}
