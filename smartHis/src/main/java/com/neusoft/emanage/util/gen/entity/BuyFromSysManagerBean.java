package com.neusoft.emanage.util.gen.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import com.neusoft.emanage.baseEasyUi.vo.EasyUiBaseBean;

/**
 * 金佳币实时行情 对应sys_sell_manager数据库表的实体类
 * 
 * @author lukai  date:2014年6月20日
 * 
 */
public class BuyFromSysManagerBean extends EasyUiBaseBean implements Serializable {

	private static final long serialVersionUID = 1L;
	// 对应subscription数据库表中的自增长id便于查询修改
	private Integer sys_sell_manager_id;
	// 本次可卖出的总数量
	private Double sellCountnum;
	// 卖出开始时间
	private Timestamp sellstarttime;
	// 卖出结束时间
	private Timestamp sellendtime;
	// 卖出价格
	private Double pirce;
	// 单笔最小数量maxnum
	private Double dealsellmin;
	// 单笔最大数量
	private Double dealsellMax;
	// 当前剩余的量
	private Double nowSurplusNum;
	// 数据锁标志
	private Double versionNum;
	// 发布人ID
	private Integer optionId;
	// 发布人姓名
	private String optionName;
	// 发布时间
	private Timestamp releaseTime;
	// 状态 ，1 未发布 2已发布3卖出结束，4，停止卖出
	private String sellstatus;
	private Integer stopsellOptionid;
	private String stopsellOptionName;
	private Timestamp nowdata;
	
	public Integer getSys_sell_manager_id() {
		return sys_sell_manager_id;
	}
	public void setSys_sell_manager_id(Integer sys_sell_manager_id) {
		this.sys_sell_manager_id = sys_sell_manager_id;
	}
	public Double getSellCountnum() {
		return sellCountnum;
	}
	public void setSellCountnum(Double sellCountnum) {
		this.sellCountnum = sellCountnum;
	}
	public Timestamp getSellstarttime() {
		return sellstarttime;
	}
	public void setSellstarttime(Timestamp sellstarttime) {
		this.sellstarttime = sellstarttime;
	}
	public Timestamp getSellendtime() {
		return sellendtime;
	}
	public void setSellendtime(Timestamp sellendtime) {
		this.sellendtime = sellendtime;
	}
	public Double getPirce() {
		return pirce;
	}
	public void setPirce(Double pirce) {
		this.pirce = pirce;
	}
	public Double getDealsellmin() {
		return dealsellmin;
	}
	public void setDealsellmin(Double dealsellmin) {
		this.dealsellmin = dealsellmin;
	}
	public Double getDealsellMax() {
		return dealsellMax;
	}
	public void setDealsellMax(Double dealsellMax) {
		this.dealsellMax = dealsellMax;
	}
	public Double getNowSurplusNum() {
		return nowSurplusNum;
	}
	public void setNowSurplusNum(Double nowSurplusNum) {
		this.nowSurplusNum = nowSurplusNum;
	}
	public Double getVersionNum() {
		return versionNum;
	}
	public void setVersionNum(Double versionNum) {
		this.versionNum = versionNum;
	}
	public Integer getOptionId() {
		return optionId;
	}
	public void setOptionId(Integer optionId) {
		this.optionId = optionId;
	}
	public String getOptionName() {
		return optionName;
	}
	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}
	public Timestamp getReleaseTime() {
		return releaseTime;
	}
	public void setReleaseTime(Timestamp releaseTime) {
		this.releaseTime = releaseTime;
	}
	public String getSellstatus() {
		return sellstatus;
	}
	public void setSellstatus(String sellstatus) {
		this.sellstatus = sellstatus;
	}
	public Integer getStopsellOptionid() {
		return stopsellOptionid;
	}
	public void setStopsellOptionid(Integer stopsellOptionid) {
		this.stopsellOptionid = stopsellOptionid;
	}
	public String getStopsellOptionName() {
		return stopsellOptionName;
	}
	public void setStopsellOptionName(String stopsellOptionName) {
		this.stopsellOptionName = stopsellOptionName;
	}
	public Timestamp getNowdata() {
		return nowdata;
	}
	public void setNowdata(Timestamp nowdata) {
		this.nowdata = nowdata;
	}
	
}
