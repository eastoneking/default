package com.neusoft.emanage.util.gen.entity;

import com.neusoft.sframe.util.mybatis.BaseEntity;

/**
 * 角色与权限中间表
 */
public class SysRolePermissionBean implements BaseEntity {
	private static final long serialVersionUID = 3989161838713849309L;

	/** ID */
	private Integer id;

	/** 角色ID */
	private Integer role_id;

	/** 权限ID */
	private Integer permission_id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRole_id() {
		return role_id;
	}

	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}

	public Integer getPermission_id() {
		return permission_id;
	}

	public void setPermission_id(Integer permission_id) {
		this.permission_id = permission_id;
	}

}