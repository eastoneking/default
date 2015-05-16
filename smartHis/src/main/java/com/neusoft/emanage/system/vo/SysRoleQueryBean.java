/*
 * @(#)DemoQueryBean.java
 * Copyright (c) 2007-2008 hirisun
 * All rights reserved.
 */
package com.neusoft.emanage.system.vo;

import com.neusoft.emanage.baseEasyUi.vo.EasyUiBaseBean;

public class SysRoleQueryBean extends EasyUiBaseBean {
	private static final long serialVersionUID = 1L;

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
