package com.neusoft.emanage.util.gen.entity;

import java.sql.Timestamp;

import com.neusoft.sframe.util.mybatis.BaseEntity;
/**
 * 金佳币用户造币
 * 对应sys_user,useraccess,gscmanagerhis数据库表
 * @author zhangshixi date : 2014年6月10日
 *
 */
public class CreateGSCCountBean implements BaseEntity{
	private static final long serialVersionUID = 1L;
	//自增长id便于查询修改
	private Integer creategsccount_id;
	//造币数量
	private Double creategsccount;
	//造币入库时间
	private Timestamp checkdate;
	//造币时间
	private Timestamp createdate;
	//造币日造币次数
	private Integer createcountnum;
	//造币日市价，
	private Double nowpirce;
	public Integer getCreategsccount_id() {
		return creategsccount_id;
	}
	public void setCreategsccount_id(Integer creategsccount_id) {
		this.creategsccount_id = creategsccount_id;
	}
	public Double getCreategsccount() {
		return creategsccount;
	}
	public void setCreategsccount(Double creategsccount) {
		this.creategsccount = creategsccount;
	}
	public Timestamp getCheckdate() {
		return checkdate;
	}
	public void setCheckdate(Timestamp checkdate) {
		this.checkdate = checkdate;
	}
	public Timestamp getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Timestamp createdate) {
		this.createdate = createdate;
	}
	public Integer getCreatecountnum() {
		return createcountnum;
	}
	public void setCreatecountnum(Integer createcountnum) {
		this.createcountnum = createcountnum;
	}
	public Double getNowpirce() {
		return nowpirce;
	}
	public void setNowpirce(Double nowpirce) {
		this.nowpirce = nowpirce;
	}

	
	
	
}
