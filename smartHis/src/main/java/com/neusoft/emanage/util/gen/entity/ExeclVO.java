package com.neusoft.emanage.util.gen.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

import com.neusoft.sframe.util.mybatis.BaseEntity;
//import com.sun.jmx.snmp.Timestamp;

public class ExeclVO implements BaseEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/** * 用户账户记录表id 自增长 */
	private Integer id;
	/*** 用户表的外键id*/
	private Integer userAccessId;
	/*** 变动类型*/
	private String changeType;
	/**变动前账户金佳币余额 */
	private Double afterAccessGSCNum;
	/**变动前账户人民币余额 */
	private Double afterAccessRMBNum;
	/**交易金佳币数量 */
	private Double changeGSCNum;
	/** 交易人民币数量*/
	private Double changeRMBNum;
	/**交易时间 */
	private Timestamp changeDate;
	/** 交易描述*/
	private String description;
	/**交易引起的原因id */
	private String fkid;
	/**赠送和分发，记录表 */
	private String fktable;
	/**变动前账户金佳币数量 */
	private Double beforeAccessGSCNum;
	/**变动前账户人民币余额 */
	private Double beforeAccessRMBNum;
	
	/**
	 * 用户帐户中的人民币数量
	 */
	private BigDecimal RMB;
	/**
	 * 用户帐户中的金佳币数量
	 */
	private BigDecimal GSC;
	/**用户的id*/
	private Integer userId;
	
	private String type;
	/**人民币币数量*/
	private Double cncnum;
	/**交易金佳币数量*/
	private Double GSCNum;
	/**交易人民币数量*/
	private Double RMBNum;
	
	public Integer getUserAccessId() {
		return userAccessId;
	}
	public String getChangeType() {
		return changeType;
	}
	public void setChangeType(String changeType) {
		this.changeType = changeType;
	}
	public Double getAfterAccessGSCNum() {
		return afterAccessGSCNum;
	}
	public void setAfterAccessGSCNum(Double afterAccessGSCNum) {
		this.afterAccessGSCNum = afterAccessGSCNum;
	}
	public Double getAfterAccessRMBNum() {
		return afterAccessRMBNum;
	}
	public void setAfterAccessRMBNum(Double afterAccessRMBNum) {
		this.afterAccessRMBNum = afterAccessRMBNum;
	}
	public Double getChangeGSCNum() {
		return changeGSCNum;
	}
	public void setChangeGSCNum(Double changeGSCNum) {
		this.changeGSCNum = changeGSCNum;
	}
	public Double getChangeRMBNum() {
		return changeRMBNum;
	}
	public void setChangeRMBNum(Double changeRMBNum) {
		this.changeRMBNum = changeRMBNum;
	}
	public Timestamp getChangeDate() {
		return changeDate;
	}
	public void setChangeDate(Timestamp changeDate) {
		this.changeDate = changeDate;
	}
	public void setUserAccessId(Integer userAccessId) {
		this.userAccessId = userAccessId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public BigDecimal getRMB() {
		return RMB;
	}
	public void setRMB(BigDecimal rMB) {
		RMB = rMB;
	}
	public BigDecimal getGSC() {
		return GSC;
	}
	public void setGSC(BigDecimal gSC) {
		GSC = gSC;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Double getCncnum() {
		return cncnum;
	}
	public void setCncnum(Double cncnum) {
		this.cncnum = cncnum;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getBeforeAccessGSCNum() {
		return beforeAccessGSCNum;
	}
	public void setBeforeAccessGSCNum(Double beforeAccessGSCNum) {
		this.beforeAccessGSCNum = beforeAccessGSCNum;
	}
	public Double getBeforeAccessRMBNum() {
		return beforeAccessRMBNum;
	}
	public void setBeforeAccessRMBNum(Double beforeAccessRMBNum) {
		this.beforeAccessRMBNum = beforeAccessRMBNum;
	}
	public Double getGSCNum() {
		return GSCNum;
	}
	public void setGSCNum(Double gSCNum) {
		GSCNum = gSCNum;
	}
	public Double getRMBNum() {
		return RMBNum;
	}
	public void setRMBNum(Double rMBNum) {
		RMBNum = rMBNum;
	}
	public String getFkid() {
		return fkid;
	}
	public void setFkid(String fkid) {
		this.fkid = fkid;
	}
	public String getFktable() {
		return fktable;
	}
	public void setFktable(String fktable) {
		this.fktable = fktable;
	}
	
}
