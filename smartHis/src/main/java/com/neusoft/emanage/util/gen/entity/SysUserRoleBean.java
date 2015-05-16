package com.neusoft.emanage.util.gen.entity;

import com.neusoft.sframe.util.mybatis.BaseEntity;

/**
 * 用户与角色中间表
 */
public class SysUserRoleBean implements BaseEntity {
	private static final long serialVersionUID = 3989161838713849309L;

	/** ID */
	private Integer id;

	/** 用户ID */
	private Integer user_id;

	/** 角色ID */
	private Integer role_id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Integer getRole_id() {
		return role_id;
	}

	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}

}
