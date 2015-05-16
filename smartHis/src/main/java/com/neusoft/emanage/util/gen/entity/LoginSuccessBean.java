package com.neusoft.emanage.util.gen.entity;

import com.neusoft.sframe.util.mybatis.BaseEntity;

public class LoginSuccessBean implements BaseEntity{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
/**
 * 陈伟雷
 * 2014-6-11
 * 用户登录成功后获取用用户的信息
 * 
 */
	private String user_code;
	private Double RMB;
	private Double GSC;
	private String phone;
	private String email;
	public String getUser_code() {
		return user_code;
	}
	public void setUser_code(String user_code) {
		this.user_code = user_code;
	}
	public Double getRMB() {
		return RMB;
	}
	public void setRMB(Double rMB) {
		RMB = rMB;
	}
	public Double getGSC() {
		return GSC;
	}
	public void setGSC(Double gSC) {
		GSC = gSC;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
