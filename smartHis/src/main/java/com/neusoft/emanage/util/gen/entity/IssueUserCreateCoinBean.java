package com.neusoft.emanage.util.gen.entity;

import java.sql.Timestamp;

import com.neusoft.sframe.util.mybatis.BaseEntity;
/**
 * 金佳币用户造币
 * 对应sys_user,useraccess,gscmanagerhis数据库表
 * @author zhangshixi date : 2014年6月10日
 *
 */
public class IssueUserCreateCoinBean implements BaseEntity{
	private static final long serialVersionUID = 1L;
	//自增长id便于查询修改
	private Integer creategsc_id;
	//造币开始时间
	private Timestamp createGSCStartDate;
	//造币结束时间
	private Timestamp createGSCendDate;
	//造币数量
	private Double GSCNum;
	//用户ID
	private Integer userAccessid;
	//记录此次造币是否生效，
   // 1：已经生效（即已经添加到用户账户）2：待审核（即造币完成，待第二日的合法性验证）3：非法造币
	private String status;
	//生效时间
	private Timestamp checkDate;

	
	
	
	public Integer getCreategsc_id() {
		return creategsc_id;
	}
	public void setCreategsc_id(Integer creategsc_id) {
		this.creategsc_id = creategsc_id;
	}
	public Timestamp getCreateGSCStartDate() {
		return createGSCStartDate;
	}
	public void setCreateGSCStartDate(Timestamp createGSCStartDate) {
		this.createGSCStartDate = createGSCStartDate;
	}
	public Timestamp getCreateGSCendDate() {
		return createGSCendDate;
	}
	public void setCreateGSCendDate(Timestamp createGSCendDate) {
		this.createGSCendDate = createGSCendDate;
	}
	public Double getGSCNum() {
		return GSCNum;
	}
	public void setGSCNum(Double gSCNum) {
		GSCNum = gSCNum;
	}
	public Integer getUserAccessid() {
		return userAccessid;
	}
	public void setUserAccessid(Integer userAccessid) {
		this.userAccessid = userAccessid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Timestamp getCheckDate() {
		return checkDate;
	}
	public void setCheckDate(Timestamp checkDate) {
		this.checkDate = checkDate;
	}


	
	
}
