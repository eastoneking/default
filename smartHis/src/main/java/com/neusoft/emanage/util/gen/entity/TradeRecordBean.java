package com.neusoft.emanage.util.gen.entity;

import java.sql.Timestamp;

import com.neusoft.emanage.baseEasyUi.vo.EasyUiBaseBean;
import com.neusoft.sframe.util.mybatis.BaseEntity;

/**
 * 委托单
 * @author lukai
 *
 */
public class TradeRecordBean extends EasyUiBaseBean implements BaseEntity {
	/**后台交易中心 时间段查询开始时间*/
	private Timestamp startTime;
	/**后台交易中心 时间段查询 结束时间*/
	private Timestamp endTime;
	public Timestamp getStartTime() {
		return startTime;
	}
	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}
	public Timestamp getEndTime() {
		return endTime;
	}
	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}
	/**
	 * id 主键
	 */
	private Integer traderecord_id;
	/**
	 *  委托买入id
	 */
	private Integer deputeid;
	/**
	 * 帐户id
	 */
	private Integer userAccessId;
	/**
	 * 交易中GSC
	 */
	private Double tradeGSCNum;
	/**
	 * 交易中人民
	 */
	private Double tradeRMBNum;
	/**
	 * 交易发起类型 ，1：买入，2：卖出
	 */
	private String tardetype;
	/**
	 * 交易时间
	 */
	private Timestamp tardedate;
	/**
	 * 交易单价
	 */
	private Double pirce;
	/**
	 * 委托卖出id
	 */
	private Integer deputesellid;
	
	public Integer getTraderecord_id() {
		return traderecord_id;
	}
	public void setTraderecord_id(Integer traderecord_id) {
		this.traderecord_id = traderecord_id;
	}
	public Integer getDeputeid() {
		return deputeid;
	}
	public void setDeputeid(Integer deputeid) {
		this.deputeid = deputeid;
	}
	public Integer getUserAccessId() {
		return userAccessId;
	}
	public void setUserAccessId(Integer userAccessId) {
		this.userAccessId = userAccessId;
	}
	
	public Double getTradeGSCNum() {
		return tradeGSCNum;
	}
	public void setTradeGSCNum(Double tradeGSCNum) {
		this.tradeGSCNum = tradeGSCNum;
	}
	public Double getTradeRMBNum() {
		return tradeRMBNum;
	}
	public void setTradeRMBNum(Double tradeRMBNum) {
		this.tradeRMBNum = tradeRMBNum;
	}
	public String getTardetype() {
		return tardetype;
	}
	public void setTardetype(String tardetype) {
		this.tardetype = tardetype;
	}
	public Timestamp getTardedate() {
		return tardedate;
	}
	public void setTardedate(Timestamp tardedate) {
		this.tardedate = tardedate;
	}
	public Double getPirce() {
		return pirce;
	}
	public void setPirce(Double pirce) {
		this.pirce = pirce;
	}
	public Integer getDeputesellid() {
		return deputesellid;
	}
	public void setDeputesellid(Integer deputesellid) {
		this.deputesellid = deputesellid;
	}
	
	
}
