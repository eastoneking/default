package com.neusoft.emanage.util.gen.entity;

import java.sql.Timestamp;

import com.neusoft.sframe.util.mybatis.BaseEntity;

public class TradBean implements BaseEntity {
	/**
	 * 陈伟雷 2014-6-11 首页数据展示
	 */
	private String tardetype;
	private Double tradeGSCNum;
	private Timestamp tardedate;

	public String getTardetype() {
		return tardetype;
	}

	public void setTardetype(String tardetype) {
		this.tardetype = tardetype;
	}

	public double getTradeGSCNum() {
		return tradeGSCNum;
	}

	public void setTradeGSCNum(double tradeGSCNum) {
		this.tradeGSCNum = tradeGSCNum;
	}

	public Timestamp getTardedate() {
		return tardedate;
	}

	public void setTardedate(Timestamp tardedate) {
		this.tardedate = tardedate;
	}

	
}
