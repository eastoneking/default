/*
 * @(#)DemoQueryBean.java
 * Copyright (c) 2007-2008 hirisun
 * All rights reserved.
 */
package com.neusoft.emanage.commonSelect.vo;

import com.neusoft.platform.syscontext.vo.GridParamBean;


/**
 * 
 * @author c
 * @version 1.0
 * @time 2014-5-21
 * @description
 */
public class KeshiQueryBean extends GridParamBean {
	private static final long serialVersionUID = 1L;
	/**
	 * 科室名字
	 */
	private String ksname;
	/**
	 * 科室编号
	 */
	private String ksnumbe;
	public String getKsname() {
		return ksname;
	}
	public void setKsname(String ksname) {
		this.ksname = ksname;
	}
	public String getKsnumbe() {
		return ksnumbe;
	}
	public void setKsnumbe(String ksnumbe) {
		this.ksnumbe = ksnumbe;
	}

}
