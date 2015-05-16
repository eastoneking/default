package com.neusoft.emanage.util.gen.entity;

import com.neusoft.sframe.util.mybatis.BaseEntity;

/**
 * 角色表
 */
public class SysRoleBean implements BaseEntity {
	private static final long serialVersionUID = 4723381387825206891L;

	/** ID */
	private Integer id;

	/** 角色名称 */
	private String name;

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
}
