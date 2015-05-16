package com.neusoft.emanage.util.gen.entity;
import com.neusoft.sframe.util.mybatis.BaseEntity;
/**
 * 金佳币实时行情 对应subscription数据库表的实体类
 * 
 * @author zhangshixi date:2014年6月20日
 * 
 */
public class GuaHaoBean implements BaseEntity {

	private static final long serialVersionUID = 1L;
	/**
	 * id
	 */
	private Integer id;
	/**
	 * 病历号
	 */
	private String ghnumber;
	/**
	 * 挂号患者姓名
	 */
	private String ghname;
	/**
	 * 挂号患者性别
	 */
	private String ghsex;
	/**
	 * 挂号患者年龄
	 */
	private String ghage;
	/**
	 * 挂号科室ID
	 */
	private String ghkeshiid;
	/**
	 * 挂号科室名字
	 */
	private String ghkeshiname;
	/**
	 * 挂号类别
	 */
	private String ghtype;
	/**
	 * 挂号状态
	 */
	private String ghstatus;
	/**
	 * 主治医生
	 */
	private String ghyisheng;
	/**
	 * 主治医生ID
	 */
	private String ghyishengid;
	/**
	 * 挂号日期
	 */
	private String ghriqi;
	/**
	 * 挂号费用
	 */
	private String ghfeiyong;
	/**
	 * 挂号药品费用
	 */
	private String ghypfeiyong;
	/********getter  setter**************************/
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getGhname() {
		return ghname;
	}
	public void setGhname(String ghname) {
		this.ghname = ghname;
	}
	public String getGhsex() {
		return ghsex;
	}
	public void setGhsex(String ghsex) {
		this.ghsex = ghsex;
	}
	public String getGhage() {
		return ghage;
	}
	public void setGhage(String ghage) {
		this.ghage = ghage;
	}
	public String getGhkeshiid() {
		return ghkeshiid;
	}
	public void setGhkeshiid(String ghkeshiid) {
		this.ghkeshiid = ghkeshiid;
	}
	public String getGhkeshiname() {
		return ghkeshiname;
	}
	public void setGhkeshiname(String ghkeshiname) {
		this.ghkeshiname = ghkeshiname;
	}
	public String getGhtype() {
		return ghtype;
	}
	public void setGhtype(String ghtype) {
		this.ghtype = ghtype;
	}
	public String getGhstatus() {
		return ghstatus;
	}
	public void setGhstatus(String ghstatus) {
		this.ghstatus = ghstatus;
	}
	public String getGhyisheng() {
		return ghyisheng;
	}
	public void setGhyisheng(String ghyisheng) {
		this.ghyisheng = ghyisheng;
	}
	public String getGhyishengid() {
		return ghyishengid;
	}
	public void setGhyishengid(String ghyishengid) {
		this.ghyishengid = ghyishengid;
	}
	public String getGhriqi() {
		return ghriqi;
	}
	public void setGhriqi(String ghriqi) {
		this.ghriqi = ghriqi;
	}
	public String getGhfeiyong() {
		return ghfeiyong;
	}
	public void setGhfeiyong(String ghfeiyong) {
		this.ghfeiyong = ghfeiyong;
	}
	public String getGhypfeiyong() {
		return ghypfeiyong;
	}
	public void setGhypfeiyong(String ghypfeiyong) {
		this.ghypfeiyong = ghypfeiyong;
	}
	public String getGhnumber() {
		return ghnumber;
	}
	public void setGhnumber(String ghnumber) {
		this.ghnumber = ghnumber;
	}
	
	
	
}
