package com.neusoft.emanage.util.gen.entity;

import com.neusoft.sframe.util.mybatis.BaseEntity;

public class SearchUserBean implements BaseEntity {
/**
	 * 2014-7-8
	 * 用于管理员查询所有用户
	 */
	private static final long serialVersionUID = 1L;
private String user_name;
private String display_name;
private String idcard;
private String phone;
private String email;
public String getUser_name() {
	return user_name;
}
public void setUser_name(String user_name) {
	this.user_name = user_name;
}
public String getDisplay_name() {
	return display_name;
}
public void setDisplay_name(String display_name) {
	this.display_name = display_name;
}
public String getIdcard() {
	return idcard;
}
public void setIdcard(String idcard) {
	this.idcard = idcard;
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
