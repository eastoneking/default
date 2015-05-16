package com.neusoft.emanage.util.gen.entity;

import java.sql.Timestamp;
import java.util.Date;

import com.neusoft.emanage.baseEasyUi.vo.EasyUiBaseBean;
import com.neusoft.sframe.util.mybatis.BaseEntity;

public class AccountManagementBean extends EasyUiBaseBean {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 陈伟雷 2014-6-13 对表rechargerecord操作
	 */
	private Integer rechargerecord_id;
	//useraccess表中的id
	private Integer userAccessId;
	//充值或提现金额
	private Double rechatgeNum;
	//1：充值，2：提现
	private String type;
	//日期
	private Date date;
	//充值前RMB数
	private Double afterRechargeNum;
	//充值记录编号
	private String rechargecode;
	//银行类型
	private Integer bankType;
	//银行账号
	private String bankaccess;
	
	private Timestamp startdate;
	private Timestamp enddate;
	private String user_code;
	
	public Integer getRechargerecord_id() {
		return rechargerecord_id;
	}
	public void setRechargerecord_id(Integer rechargerecord_id) {
		this.rechargerecord_id = rechargerecord_id;
	}
	public Integer getUserAccessId() {
		return userAccessId;
	}
	public void setUserAccessId(Integer userAccessId) {
		this.userAccessId = userAccessId;
	}
	public Double getRechatgeNum() {
		return rechatgeNum;
	}
	public void setRechatgeNum(Double rechatgeNum) {
		this.rechatgeNum = rechatgeNum;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Double getAfterRechargeNum() {
		return afterRechargeNum;
	}
	public void setAfterRechargeNum(Double afterRechargeNum) {
		this.afterRechargeNum = afterRechargeNum;
	}
	public String getRechargecode() {
		return rechargecode;
	}
	public void setRechargecode(String rechargecode) {
		this.rechargecode = rechargecode;
	}
	public Integer getBankType() {
		return bankType;
	}
	public void setBankType(Integer bankType) {
		this.bankType = bankType;
	}
	public String getBankaccess() {
		return bankaccess;
	}
	public void setBankaccess(String bankaccess) {
		this.bankaccess = bankaccess;
	}
	public Timestamp getStartdate() {
		return startdate;
	}
	public void setStartdate(Timestamp startdate) {
		this.startdate = startdate;
	}
	public Timestamp getEnddate() {
		return enddate;
	}
	public void setEnddate(Timestamp enddate) {
		this.enddate = enddate;
	}
	public String getUser_code() {
		return user_code;
	}
	public void setUser_code(String user_code) {
		this.user_code = user_code;
	}
	

}
