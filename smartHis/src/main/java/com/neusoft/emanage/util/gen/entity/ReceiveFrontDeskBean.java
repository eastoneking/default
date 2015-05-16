package com.neusoft.emanage.util.gen.entity;

import com.neusoft.sframe.util.mybatis.BaseEntity;

public class ReceiveFrontDeskBean implements BaseEntity {

	/**
	 * 陈伟雷
	 * 2014-6-12
	 * 接收前台数据
	 */
	private static final long serialVersionUID = 1L;
	
	private String user_name;
	//前台传过来的rmb数量
	private Double amount;
	//银行卡号
	private String number;
	
	
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
}
