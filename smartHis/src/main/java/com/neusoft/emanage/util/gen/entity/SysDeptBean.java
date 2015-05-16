package com.neusoft.emanage.util.gen.entity;

import com.neusoft.sframe.util.mybatis.BaseEntity;

/**
 * 部门表
 */
public class SysDeptBean implements BaseEntity {
	private static final long serialVersionUID = -307706009279871091L;

	/** ID */
	private Integer id;

	/** 部门名称 */
	private String name;

	/** 状态 */
	private Integer status;

	/** 上级部门 */
	private Integer parent_id;

	/** 顺序 */
	private Integer orders;

	/** 上级部门名称 */
	private String parent_dept_name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getParent_id() {
		return parent_id;
	}

	public void setParent_id(Integer parent_id) {
		this.parent_id = parent_id;
	}

	public Integer getOrders() {
		return orders;
	}

	public void setOrders(Integer orders) {
		this.orders = orders;
	}

	public String getParent_dept_name() {
		return parent_dept_name;
	}

	public void setParent_dept_name(String parent_dept_name) {
		this.parent_dept_name = parent_dept_name;
	}

}
