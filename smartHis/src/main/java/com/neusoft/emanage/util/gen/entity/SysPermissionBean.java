package com.neusoft.emanage.util.gen.entity;

import com.neusoft.sframe.util.mybatis.BaseEntity;

/**
 * 权限表
 */
public class SysPermissionBean implements BaseEntity {
	private static final long serialVersionUID = 8162501029698214504L;

	/** ID */
	private Integer id;

	/** 权限名称 */
	private String permission_name;

	/** 权限标识 */
	private String permission;

	/** 状态 */
	private Integer status;

	/** 上级权限ID */
	private Integer parent_id;

	/** 顺序 */
	private Integer orders;

	/** 上级权限名称 */
	private String parent_name;
	
	/** 非实体属性——角色ID */
	private String role_id;

	public String getRole_id() {
		return role_id;
	}

	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}
	
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

	public Integer getOrders() {
		return orders;
	}

	public void setOrders(Integer orders) {
		this.orders = orders;
	}

	public String getParent_name() {
		return parent_name;
	}

	public void setParent_name(String parent_name) {
		this.parent_name = parent_name;
	}

	public Integer getParent_id() {
		return parent_id;
	}

	public void setParent_id(Integer parent_id) {
		this.parent_id = parent_id;
	}

}