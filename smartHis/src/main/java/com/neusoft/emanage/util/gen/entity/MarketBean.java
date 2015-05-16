package com.neusoft.emanage.util.gen.entity;

import java.sql.Timestamp;

import com.neusoft.sframe.util.mybatis.BaseEntity;

/**
 * 金佳币实时行情 对应depute,traderecord,realtimemarket数据库表的实体类
 * 
 * @author jichuang date:2014年6月10日
 * 
 */
public class MarketBean implements BaseEntity {

	private static final long serialVersionUID = 1L;
	// 对应depute数据库表中的自增长id便于查询修改
	private Integer id;
	// 委托单编号
	private String deputecode;
	// 委托数量
	private Double deputeNum;
	// 委托时间
	private Timestamp deputeDate;
	// 委托帐户
	private Integer userAccessId;
	// 委托状态，0：委托中，1：委托完成，2：委托取消（可能会有交易记录）
	private String deputeStatus;
	// 委托单价
	private Double pirce;
	// 委托类型1：买入，2：卖出
	private String deputeType;
	// 委托买入记录id
	private Integer deputeid;
	// 交易的金佳币数量
	private Double tradeGSCNum;
	// 交易人民币数量
	private Double tradeRMBNum;
	// 交易时间
	private Timestamp tardedate;
	// 交易类型：1：买入GSC，2：卖出GSC
	private String tardetype;
	// 总价格
	private Double countCNC;
	// 开盘时间
	private Timestamp startdate;
	private String startdates;
	// 开盘价
	private Double firstPrice;
	// 最高价
	private Double maxPrice;
	// 最低价
	private Double minPrice;
	// 收盘价
	private Double lastPrice;
	// 成交量
	private Double gscNumber;
	//成交量百分比
	private String temp;
	
	

	public String getTemp() {
		return temp;
	}

	public void setTemp(String temp) {
		this.temp = temp;
	}

	public String getStartdates() {
		return startdates;
	}

	public void setStartdates(String startdates) {
		this.startdates = startdates;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getDeputeStatus() {
		return deputeStatus;
	}

	public void setDeputeStatus(String deputeStatus) {
		this.deputeStatus = deputeStatus;
	}

	public Integer getDeputeid() {
		return deputeid;
	}

	public void setDeputeid(Integer deputeid) {
		this.deputeid = deputeid;
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

	public Timestamp getTardedate() {
		return tardedate;
	}

	public void setTardedate(Timestamp tardedate) {
		this.tardedate = tardedate;
	}

	public String getTardetype() {
		return tardetype;
	}

	public void setTardetype(String tardetype) {
		this.tardetype = tardetype;
	}

	public Double getCountCNC() {
		return countCNC;
	}

	public void setCountCNC(Double countCNC) {
		this.countCNC = countCNC;
	}

	public Timestamp getStartdate() {
		return startdate;
	}

	public void setStartdate(Timestamp startdate) {
		this.startdate = startdate;
	}

	public Double getFirstPrice() {
		return firstPrice;
	}

	public void setFirstPrice(Double firstPrice) {
		this.firstPrice = firstPrice;
	}

	public Double getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(Double maxPrice) {
		this.maxPrice = maxPrice;
	}

	public Double getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(Double minPrice) {
		this.minPrice = minPrice;
	}

	public Double getLastPrice() {
		return lastPrice;
	}

	public void setLastPrice(Double lastPrice) {
		this.lastPrice = lastPrice;
	}

	public Double getGscNumber() {
		return gscNumber;
	}

	public void setGscNumber(Double gscNumber) {
		this.gscNumber = gscNumber;
	}
}
