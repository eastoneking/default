/*
 * @(#)DemoQueryBean.java
 * Copyright (c) 2007-2008 hirisun
 * All rights reserved.
 */
package com.neusoft.emanage.system.vo;

import com.neusoft.platform.syscontext.vo.GridParamBean;


/**
 * 
 * @author c
 * @version 1.0
 * @time 2014-5-21
 * @description
 */
public class SysParameterQueryBean extends GridParamBean {
	private static final long serialVersionUID = 1L;

	/** 类别 */
	private String type;

	/** 类别代码*/
	private String typeCode;
	
	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
