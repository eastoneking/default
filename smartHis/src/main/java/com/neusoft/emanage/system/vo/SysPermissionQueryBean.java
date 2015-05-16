/*
 * @(#)DemoQueryBean.java
 * Copyright (c) 2007-2008 hirisun
 * All rights reserved.
 */
package com.neusoft.emanage.system.vo;

import com.neusoft.platform.syscontext.vo.GridParamBean;


public class SysPermissionQueryBean extends GridParamBean {
	private static final long serialVersionUID = 1L;

	/** ID */
	private Integer id;

	/** 权限名称 */
	private String permission_name;

	/** 权限标识 */
	private String permission;

	/** 状态 */
	private Integer status;

	/** 上级权限ID */
	private Integer parentId;

	/** 顺序 */
	private Integer orders;

	/** 角色ID */
	private Integer roleId;

	/** 部门ID */
	private Integer deptId;

	/** 上级权限名称 */
	private String parent_name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPermission_name() {
		return permission_name;
	}

	public void setPermission_name(String permission_name) {
		this.permission_name = permission_name;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Integer getOrders() {
		return orders;
	}

	public void setOrders(Integer orders) {
		this.orders = orders;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getParent_name() {
		return parent_name;
	}

	public void setParent_name(String parent_name) {
		this.parent_name = parent_name;
	}

}
