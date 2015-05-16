package com.neusoft.emanage.util.gen.entity;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.io.Serializable;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.math.BigDecimal;

import com.neusoft.sframe.util.mybatis.BaseEntity;

/*
 * @version 2.0
 */

public class SysUser1 implements BaseEntity {
	private static final long serialVersionUID = 1L;
	
	/** ID */
	
	private Integer user_id;

	/** 姓名 */

	private String user_name;

	/** 性别 */

	private String sex;

	/** 职位ID */

	private Integer position_id;

	/** 部门ID */

	private Integer dept_id;

	/** 电话 */

	private String phone_number;

	/** email */

	private String email;

	/** 工作地点 */

	private String workplace;

	/** 状态 */

	private String status;

	/** 短号码 */

	private String extension_number;

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getPosition_id() {
		return position_id;
	}

	public void setPosition_id(Integer position_id) {
		this.position_id = position_id;
	}

	public Integer getDept_id() {
		return dept_id;
	}

	public void setDept_id(Integer dept_id) {
		this.dept_id = dept_id;
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

	public String getWorkplace() {
		return workplace;
	}

	public void setWorkplace(String workplace) {
		this.workplace = workplace;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getExtension_number() {
		return extension_number;
	}

	public void setExtension_number(String extension_number) {
		this.extension_number = extension_number;
	}

}