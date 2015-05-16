/*
 * @(#)DemoQueryBean.java
 * Copyright (c) 2007-2008 hirisun
 * All rights reserved.
 */
package com.neusoft.emanage.system.vo;

import java.util.Date;

import com.neusoft.emanage.baseEasyUi.vo.EasyUiBaseBean;

public class SysUserQueryBean extends EasyUiBaseBean {
	private static final long serialVersionUID = 1L;

	/** ID */
	private Integer id;

	/** 登录名 */
	private String user_name;

	/** 密码 */
	private String password;

	/** 显示名称 */
	private String display_name;

	/** 性别 */
	private Integer sex;

	/** 电话 */
	private String phone_number;

	/** 邮箱地址 */
	private String email;

	/** 备注 */
	private String note;

	/** 状态 */
	private Integer status;

	/** SALT */
	private String salt;

	/** 创建时间 */
	private Date create_time;

	/** 部门 */
	private Integer dept_id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDisplay_name() {
		return display_name;
	}

	public void setDisplay_name(String display_name) {
		this.display_name = display_name;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public Integer getDept_id() {
		return dept_id;
	}

	public void setDept_id(Integer dept_id) {
		this.dept_id = dept_id;
	}


}
