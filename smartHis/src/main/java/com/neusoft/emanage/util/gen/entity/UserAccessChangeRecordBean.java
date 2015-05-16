package com.neusoft.emanage.util.gen.entity;
import java.sql.Timestamp;

import com.neusoft.sframe.util.mybatis.BaseEntity;

/**
 * useraccesschangerecord 用户帐户变更记录表（所有用户账户的变动都必须记录，方便排查历史记录）
 * @author xuxiaohua
 *
 */
public class UserAccessChangeRecordBean implements BaseEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5116686966211213060L;
	/** * 用户账户记录表id 自增长 */
	private Integer useraccesschangerecord_id;
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
	private Integer fkid;
	/**赠送和分发，记录表 */
	private String fktable;
	/**变动前账户金佳币数量 */
	private Double beforeAccessGSCNum;
	/**变动前账户人民币余额 */
	private Double beforeAccessRMBNum;
	public Integer getFkid() {
		return fkid;
	}
	public void setFkid(Integer fkid) {
		this.fkid = fkid;
	}
	public Integer getUseraccesschangerecord_id() {
		return useraccesschangerecord_id;
	}
	public void setUseraccesschangerecord_id(Integer useraccesschangerecord_id) {
		this.useraccesschangerecord_id = useraccesschangerecord_id;
	}
	public Integer getUserAccessId() {
		return userAccessId;
	}
	public void setUserAccessId(Integer userAccessId) {
		this.userAccessId = userAccessId;
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
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public String getFktable() {
		return fktable;
	}
	public void setFktable(String fktable) {
		this.fktable = fktable;
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
	public Timestamp getChangeDate() {
		return changeDate;
	}
	public void setChangeDate(Timestamp changeDate) {
		this.changeDate = changeDate;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
