package com.neusoft.emanage.util.gen.entity;

import java.sql.Timestamp;

public class GSCManagerBean {

	/**
	 * id
	 */
	private Integer gscmanagerhis_id;
	/**
	 * 系统GSC总量
	 */
	private Double sys_GSC_num;
	/**
	 * fkId
	 */
	private Integer fkId;
	/**
	 * fkid对应的表名称
	 */
	private String tableName;
	/**
	 * 用户持有量
	 */
	private Double user_gsc_num;
	/**
	 * 系统中可以卖出的量
	 */
	private Double trade_num;
	/**
	 * versionnum
	 */
	private Integer versionnum;
	/**
	 * 修改时间
	 */
	private Timestamp updateTime;
	/**
	 * 系统中CNC量
	 */
	private Double sys_CNC_Num;
	/**
	 * 变动类型type
	 */
	private String type;
	
	
	public Integer getGscmanagerhis_id() {
		return gscmanagerhis_id;
	}
	public void setGscmanagerhis_id(Integer gscmanagerhis_id) {
		this.gscmanagerhis_id = gscmanagerhis_id;
	}
	public Double getSys_GSC_num() {
		return sys_GSC_num;
	}
	public void setSys_GSC_num(Double sys_GSC_num) {
		this.sys_GSC_num = sys_GSC_num;
	}
	public Integer getFkId() {
		return fkId;
	}
	public void setFkId(Integer fkId) {
		this.fkId = fkId;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public Double getUser_gsc_num() {
		return user_gsc_num;
	}
	public void setUser_gsc_num(Double user_gsc_num) {
		this.user_gsc_num = user_gsc_num;
	}
	public Double getTrade_num() {
		return trade_num;
	}
	public void setTrade_num(Double trade_num) {
		this.trade_num = trade_num;
	}
	public Integer getVersionnum() {
		return versionnum;
	}
	public void setVersionnum(Integer versionnum) {
		this.versionnum = versionnum;
	}
	public Timestamp getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	public Double getSys_CNC_Num() {
		return sys_CNC_Num;
	}
	public void setSys_CNC_Num(Double sys_CNC_Num) {
		this.sys_CNC_Num = sys_CNC_Num;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
