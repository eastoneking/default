package com.neusoft.emanage.util.gen.entity;

import java.sql.Timestamp;

import com.neusoft.emanage.baseEasyUi.vo.EasyUiBaseBean;
import com.neusoft.sframe.util.mybatis.BaseEntity;

/**
 * 委托单
 * @author lukai
 *
 */
public class DeputeBean extends EasyUiBaseBean implements BaseEntity {
	/**
	 * id 主键
	 */
	private Integer deputebuy_id;
	
	private Integer deputesell_id;
	/**
	 *  委托编号
	 */
	private String deputecode;
	/**
	 * 委托数量
	 */
	private Double deputeNum;
	/**
	 * 委托时间
	 */
	private Timestamp deputeDate;
	/**
	 * 用户帐户id  外键
	 */
	private Integer userAccessId;
	/**
	 * 委托状态 ，0：委托中，1：委托完成，2：委托取消（可能会有交易记录）
	 */
	private String deputeStatus;
	/**
	 * 单价
	 */
	private Double pirce;
	/**
	 * 委托类型，1：买入，2：卖出
	 */
	private String deputeType;
	/**
	 * 用户id用来临时保存用户信息
	 */
	private Integer userId;
	
	private Double countNum;
	/**
	 * 委托买入的委托单id
	 */
	private Integer deputebuyid;
	/**
	 * 委托卖出的委托单id
	 */
	private Integer deputesellid;
	/**
	 * 版本字段用来控制跟新异常的问题
	 */
	private String countNums;
	private String deputeNums;
	private String pirces;
	
	public String getCountNums() {
		return countNums;
	}
	public void setCountNums(String countNums) {
		this.countNums = countNums;
	}
	public String getDeputeNums() {
		return deputeNums;
	}
	public void setDeputeNums(String deputeNums) {
		this.deputeNums = deputeNums;
	}
	public String getPirces() {
		return pirces;
	}
	public void setPirces(String pirces) {
		this.pirces = pirces;
	}
	private Integer version;
	
	private Integer deputebuyhis_id;
	
	private Integer deputesellhis_id;
	
	
	
	public Integer getDeputebuyhis_id() {
		return deputebuyhis_id;
	}
	public void setDeputebuyhis_id(Integer deputebuyhis_id) {
		this.deputebuyhis_id = deputebuyhis_id;
	}
	public Integer getDeputesellhis_id() {
		return deputesellhis_id;
	}
	public void setDeputesellhis_id(Integer deputesellhis_id) {
		this.deputesellhis_id = deputesellhis_id;
	}
	public String getDeputecode() {
		return deputecode;
	}
	public void setDeputecode(String deputecode) {
		this.deputecode = deputecode;
	}
	public Double getDeputeNum() {
		return deputeNum;
	}
	public void setDeputeNum(Double deputeNum) {
		this.deputeNum = deputeNum;
	}
	public Timestamp getDeputeDate() {
		return deputeDate;
	}
	public void setDeputeDate(Timestamp deputeDate) {
		this.deputeDate = deputeDate;
	}
	public Integer getUserAccessId() {
		return userAccessId;
	}
	public void setUserAccessId(Integer userAccessId) {
		this.userAccessId = userAccessId;
	}
	public String getDeputeStatus() {
		return deputeStatus;
	}
	public void setDeputeStatus(String deputeStatus) {
		this.deputeStatus = deputeStatus;
	}
	public Double getPirce() {
		return pirce;
	}
	public void setPirce(Double pirce) {
		this.pirce = pirce;
	}
	public String getDeputeType() {
		return deputeType;
	}
	public void setDeputeType(String deputeType) {
		this.deputeType = deputeType;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getDeputebuyid() {
		return deputebuyid;
	}
	public void setDeputebuyid(Integer deputebuyid) {
		this.deputebuyid = deputebuyid;
	}
	public Integer getDeputesellid() {
		return deputesellid;
	}
	public void setDeputesellid(Integer deputesellid) {
		this.deputesellid = deputesellid;
	}
	public Double getCountNum() {
		return countNum;
	}
	public void setCountNum(Double countNum) {
		this.countNum = countNum;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public Integer getDeputebuy_id() {
		return deputebuy_id;
	}
	public void setDeputebuy_id(Integer deputebuy_id) {
		this.deputebuy_id = deputebuy_id;
	}
	public Integer getDeputesell_id() {
		return deputesell_id;
	}
	public void setDeputesell_id(Integer deputesell_id) {
		this.deputesell_id = deputesell_id;
	}
	
}
