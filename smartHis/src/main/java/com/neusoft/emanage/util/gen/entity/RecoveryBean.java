package com.neusoft.emanage.util.gen.entity;

import java.sql.Timestamp;

import com.neusoft.emanage.baseEasyUi.vo.EasyUiBaseBean;

public class RecoveryBean extends EasyUiBaseBean{
	
	/**
	 * 主键
	 */
	private Integer recovery_id;
	/**
	 * 回收数量
	 */
	private Double   recoverynum;
	/**
	 * 回收时间
	 */
	private Timestamp   recoverydate;
	/**
	 * 帐户id
	 */
	private Integer   useraccessid;
	/**
	 * 用户id
	 */
	private Integer   userid;
	/**
	 * 用户账户
	 */
	private String   user_code;
	private Timestamp startdate;
	private Timestamp enddate;
	
	public Integer getRecovery_id() {
		return recovery_id;
	}
	public void setRecovery_id(Integer recovery_id) {
		this.recovery_id = recovery_id;
	}
	public Double getRecoverynum() {
		return recoverynum;
	}
	public void setRecoverynum(Double recoverynum) {
		this.recoverynum = recoverynum;
	}
	public Timestamp getRecoverydate() {
		return recoverydate;
	}
	public void setRecoverydate(Timestamp recoverydate) {
		this.recoverydate = recoverydate;
	}
	public Integer getUseraccessid() {
		return useraccessid;
	}
	public void setUseraccessid(Integer useraccessid) {
		this.useraccessid = useraccessid;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getUser_code() {
		return user_code;
	}
	public void setUser_code(String user_code) {
		this.user_code = user_code;
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
	
}
