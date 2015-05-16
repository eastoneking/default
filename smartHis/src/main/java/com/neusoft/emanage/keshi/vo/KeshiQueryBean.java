/*
 * @(#)DemoQueryBean.java
 * Copyright (c) 2007-2008 hirisun
 * All rights reserved.
 */
package com.neusoft.emanage.keshi.vo;

import com.neusoft.emanage.baseEasyUi.vo.EasyUiBaseBean;

/**
 * 
 * @author c
 * @version 1.0
 * @time 2014-5-21
 * @description
 */
public class KeshiQueryBean extends EasyUiBaseBean {
	private static final long serialVersionUID = 1L;
	/**
	 * 科室名字
	 */
	private String ksname;
	/**
	 * 科室编号
	 */
	private String ksnumber;
	public String getKsname() {
		return ksname;
	}
	public void setKsname(String ksname) {
		this.ksname = ksname;
	}
	public String getKsnumber() {
		return ksnumber;
	}
	public void setKsnumber(String ksnumber) {
		this.ksnumber = ksnumber;
	}

}
