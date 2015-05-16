package com.neusoft.emanage.util.gen.entity;

import com.neusoft.emanage.baseEasyUi.vo.EasyUiBaseBean;
import com.neusoft.sframe.util.mybatis.BaseEntity;

/**
 * 客户中心实体bean
 * @author xuxiaohua
 *
 */
public class CustomCenterBean extends EasyUiBaseBean implements BaseEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer custom_center_id;
	private String custom_name;
	private String custom_code;
	private String coustom_phone;
	
	/**
	 * 客户中心的客户姓名
	 * @return
	 */
	public String getCustom_name() {
		return custom_name;
	}
	/**
	 * 客户中心的客户姓名
	 * @return
	 */
	public void setCustom_name(String custom_name) {
		this.custom_name = custom_name;
	}
	/**
	 * 客户中心的客户编码
	 * @return
	 */
	public String getCustom_code() {
		return custom_code;
	}
	/**
	 * 客户中心的客户编码
	 * @return
	 */
	public void setCustom_code(String custom_code) {
		this.custom_code = custom_code;
	}
	/**
	 * 客户中心的客户电话
	 * @return
	 */
	public String getCoustom_phone() {
		return coustom_phone;
	}
	/**
	 * 客户中心的客户电话
	 * @return
	 */
	public void setCoustom_phone(String coustom_phone) {
		this.coustom_phone = coustom_phone;
	}
	/**
	 * 客户中心的id
	 * @return
	 */
	
	public Integer getCustom_center_id() {
		return custom_center_id;
	}
	/**
	 * 客户中心的id
	 * @return
	 */
	
	public void setCustom_center_id(Integer custom_center_id) {
		this.custom_center_id = custom_center_id;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
