package com.zhiyou100.util;

/**
 * @author Qiushiju
 * @date  2019年9月30日
 * @desc  
 */
public class ResultObject {
	private int code;
	private String msg;
	private Object data;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "ResultObject [code=" + code + ", msg=" + msg + ", data=" + data + "]";
	}
	public ResultObject(int code, String msg, Object data) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
	}
	public ResultObject() {
		super();
	}
	
	
}
