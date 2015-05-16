package com.neusoft.emanage.util.gen.entity;
import java.sql.Timestamp;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import com.neusoft.emanage.util.gen.bean.CustomDateSerializer;
import com.neusoft.sframe.util.mybatis.BaseEntity;
/**
 * 金佳币实时行情 对应subscription数据库表的实体类
 * 
 * @author zhangshixi date:2014年6月20日
 * 
 */
public class ShenGouBean implements BaseEntity {

	private static final long serialVersionUID = 1L;
	// 对应subscription数据库表中的自增长id便于查询修改
	private Integer subscriptionManager_id;
	// 数量
	private Double subscriptionnum;
	// 委托开始时间
	@JsonSerialize(using = CustomDateSerializer.class)
	private Timestamp starttime;
	// 委托结束时间
	@JsonSerialize(using = CustomDateSerializer.class)
	private Timestamp endTime;
	// 申购价格
	private Double pirce;
	// 最小申购数量maxnum
	private Double minnum;
	// 最大申购数量
	private Double maxnum;	
	// 已经完成申购数量
	private Double alreadynum;
	// 数据锁标志
	private Integer versionNum;
	// 发布人ID
	private Integer option_id;
	// 发布人姓名
	private String option_name;
	// 操作时间subscriptionManage_status
	@JsonSerialize(using = CustomDateSerializer.class)
	private Timestamp release_time;
	// 状态 0 未发布 1已发布 2已封存
	private String subscriptionManage_status;
	//封存时间
	@JsonSerialize(using = CustomDateSerializer.class)
	private Timestamp forbidden_time;
	//封存人id
	private Integer forbidden_id;
	//封存人姓名
	private String  forbidden_name;
	//开始付款时间
	@JsonSerialize(using = CustomDateSerializer.class)
	private Timestamp playallstarttime;
	//结束付款时间
	@JsonSerialize(using = CustomDateSerializer.class)
	private Timestamp playallendtime;
	public Integer getSubscriptionManager_id() {
		return subscriptionManager_id;
	}
	public void setSubscriptionManager_id(Integer subscriptionManager_id) {
		this.subscriptionManager_id = subscriptionManager_id;
	}
	public Double getSubscriptionnum() {
		return subscriptionnum;
	}
	public void setSubscriptionnum(Double subscriptionnum) {
		this.subscriptionnum = subscriptionnum;
	}
	public Timestamp getStarttime() {
		return starttime;
	}
	public void setStarttime(Timestamp starttime) {
		this.starttime = starttime;
	}
	public Timestamp getEndTime() {
		return endTime;
	}
	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}
	public Double getPirce() {
		return pirce;
	}
	
	public Timestamp getPlayallstarttime() {
		return playallstarttime;
	}
	public void setPlayallstarttime(Timestamp playallstarttime) {
		this.playallstarttime = playallstarttime;
	}
	public Timestamp getPlayallendtime() {
		return playallendtime;
	}
	public void setPlayallendtime(Timestamp playallendtime) {
		this.playallendtime = playallendtime;
	}
	public void setPirce(Double pirce) {
		this.pirce = pirce;
	}
	public Double getMinnum() {
		return minnum;
	}
	public void setMinnum(Double minnum) {
		this.minnum = minnum;
	}
	public Double getMaxnum() {
		return maxnum;
	}
	public void setMaxnum(Double maxnum) {
		this.maxnum = maxnum;
	}
	public Double getAlreadynum() {
		return alreadynum;
	}
	public void setAlreadynum(Double alreadynum) {
		this.alreadynum = alreadynum;
	}
	public Integer getVersionNum() {
		return versionNum;
	}
	public void setVersionNum(Integer versionNum) {
		this.versionNum = versionNum;
	}
	public Integer getOption_id() {
		return option_id;
	}
	public void setOption_id(Integer option_id) {
		this.option_id = option_id;
	}
	public String getOption_name() {
		return option_name;
	}
	public void setOption_name(String option_name) {
		this.option_name = option_name;
	}
	public Timestamp getRelease_time() {
		return release_time;
	}
	public void setRelease_time(Timestamp release_time) {
		this.release_time = release_time;
	}
	public String getSubscriptionManage_status() {
		return subscriptionManage_status;
	}
	public void setSubscriptionManage_status(String subscriptionManage_status) {
		this.subscriptionManage_status = subscriptionManage_status;
	}
	public Timestamp getForbidden_time() {
		return forbidden_time;
	}
	public void setForbidden_time(Timestamp forbidden_time) {
		this.forbidden_time = forbidden_time;
	}
	public Integer getForbidden_id() {
		return forbidden_id;
	}
	public void setForbidden_id(Integer forbidden_id) {
		this.forbidden_id = forbidden_id;
	}
	public String getForbidden_name() {
		return forbidden_name;
	}
	public void setForbidden_name(String forbidden_name) {
		this.forbidden_name = forbidden_name;
	}
	

	
}
