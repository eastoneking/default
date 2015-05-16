package com.neusoft.emanage.util.gen.entity;

import com.neusoft.emanage.baseEasyUi.vo.EasyUiBaseBean;
import com.neusoft.sframe.util.mybatis.BaseEntity;

public class DemoBean extends EasyUiBaseBean implements BaseEntity{

	private Integer id;
	private String demoname;
	private String demoage;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDemoname() {
		return demoname;
	}
	public void setDemoname(String demoname) {
		this.demoname = demoname;
	}
	public String getDemoage() {
		return demoage;
	}
	public void setDemoage(String demoage) {
		this.demoage = demoage;
	}
	
	
}
