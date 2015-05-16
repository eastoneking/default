/*
 * @(#)DemoQueryBean.java
 * Copyright (c) 2007-2008 hirisun
 * All rights reserved.
 */
package com.neusoft.emanage.system.vo;

import com.neusoft.platform.syscontext.vo.GridParamBean;


//import com.goldcow.platform.syscontext.vo.GridParamBean;

public class SysMenuQueryBean extends GridParamBean {
	private static final long serialVersionUID = 1L;

	/** 菜单名称 */
	private String text;

	/** 状态 */
	private Integer status;


	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
