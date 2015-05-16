package com.neusoft.emanage.util.gen.entity;

import com.neusoft.emanage.baseEasyUi.vo.EasyUiBaseBean;
import com.neusoft.sframe.util.mybatis.BaseEntity;

/**
 * 帮助中心
 * @author xuxiaohua
 *
 */
public class HelpInfoBean extends EasyUiBaseBean implements BaseEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer helpinfo_id;
	private String helpask;
	private String helpcontext;
	private String helpType;
	
	private String order;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	/**
	 * 排序方式
	 * @return
	 */
	public String getOrder() {
		return order;
	}
	public Integer getHelpinfo_id() {
		return helpinfo_id;
	}
	public void setHelpinfo_id(Integer helpinfo_id) {
		this.helpinfo_id = helpinfo_id;
	}
	/**
	 * 排序方式
	 * @return
	 */
	public void setOrder(String order) {
		this.order = order;
	}

	/**
	 * 帮助的问题
	 */
	public String getHelpask() {
		return helpask;
	}
	/**
	 * 帮助的问题
	 */
	public void setHelpask(String helpask) {
		this.helpask = helpask;
	}
	/**
	 * 帮助的答案
	 */
	public String getHelpcontext() {
		return helpcontext;
	}
	/**
	 * 帮助的答案
	 */
	public void setHelpcontext(String helpcontext) {
		this.helpcontext = helpcontext;
	}
	/**
	 * 帮助的类型
	 */
	public String getHelpType() {
		return helpType;
	}
	/**
	 * 帮助的类型
	 */
	public void setHelpType(String helpType) {
		this.helpType = helpType;
	}
	

}
