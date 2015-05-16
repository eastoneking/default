package com.neusoft.emanage.util.gen.entity;
import java.sql.Timestamp;
import com.neusoft.emanage.baseEasyUi.vo.EasyUiBaseBean;
import com.neusoft.sframe.util.mybatis.BaseEntity;
public class UserAccessHisBean extends EasyUiBaseBean implements BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
//	账户id
	private Integer userAccessId;
//	变更类型
	private String changeType;
//	变更前的GSC数量
	private Double afterAccessGSCNum;
//	变更前的人民币数量
	private Double afterAccessRMBNum;
//	变更后的金佳币数量
	private Double beforeAccessGSCNum;
//	变更后的人民币数量
	private Double beforeAccessRMBNum;
//	变更的Gsc数量
	private Double changeGSCNum;
//	变更的人民币数量
	private Double changeRMBNum;
//	变更时间
	private Timestamp changeDate;
	//默认与交易类型匹配
	private String description;
//	引起改变的交易id，如交易id，委托id
	private Integer fkid;
	//记录表名称
	private String fktable;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public Timestamp getChangeDate() {
		return changeDate;
	}
	public void setChangeDate(Timestamp changeDate) {
		this.changeDate = changeDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getFkid() {
		return fkid;
	}
	public void setFkid(Integer fkid) {
		this.fkid = fkid;
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
	
}
