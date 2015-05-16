package com.neusoft.emanage.util.gen.entity;

import com.neusoft.sframe.util.mybatis.BaseEntity;

public class QueryReturnBean implements BaseEntity{

	/**
	 * 陈伟雷
	 * 2014-6-12
	 * 接收数据库查询返回
	 */
	private static final long serialVersionUID = 1L;
	private Integer useraccess_id;
	private Integer userid;
	private String user_name;
	private Double RMB;
	private Double GSC;
	private String idcard;
	private String phone;
	public Integer getUseraccess_id() {
		return useraccess_id;
	}
	public void setUseraccess_id(Integer useraccess_id) {
		this.useraccess_id = useraccess_id;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public Double getRMB() {
		return RMB;
	}
	public void setRMB(Double rMB) {
		RMB = rMB;
	}
	public Double getGSC() {
		return GSC;
	}
	public void setGSC(Double gSC) {
		GSC = gSC;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	

}
