package com.neusoft.emanage.util.gen.entity;
import com.neusoft.sframe.util.mybatis.BaseEntity;
/**
 * 
 * @author zhangshixi date:2014年6月20日
 * 
 */
public class ZhenduanBean implements BaseEntity {

	private static final long serialVersionUID = 1L;
	/**
	 * id
	 */
	private Integer id;
	/**
	 * 科室名字
	 */
	private Integer zd_yishengid;
	/**
	 * 科室名字
	 */
	private Integer zd_ghid;
	/**
	 * 科室编号
	 */
	private String zd_yishengname;
	/**
	 * 科室地址
	 */
	private String zd_riqi;
	/**
	 * 科室顺序
	 */
	private String zd_ghnumber;
	/**
	 * 科室顺序
	 */
	private String zd_ghname;
	/**
	 * 科室顺序
	 */
	private String zd_ghsex;
	/**
	 * 科室顺序
	 */
	private String zd_ghage;
	/**
	 * 科室顺序
	 */
	private String zd_ghks;
	/**
	 * 科室顺序
	 */
	private String zd_status;
	/**
	 * 付药状态
	 */
	private String zd_fystatus;
	/**
	 * 科室顺序
	 */
	private String zd_ghtype;
	/**
	 * 科室顺序
	 */
	private String zd_ghriqi;
	/**
	 * 科室顺序
	 */
	private String zd_version;
	/**
	 * 科室顺序
	 */
	private String zd_version_old;
	/********getter  setter**************************/
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getZd_yishengid() {
		return zd_yishengid;
	}

	public void setZd_yishengid(Integer zd_yishengid) {
		this.zd_yishengid = zd_yishengid;
	}

	public Integer getZd_ghid() {
		return zd_ghid;
	}

	public void setZd_ghid(Integer zd_ghid) {
		this.zd_ghid = zd_ghid;
	}

	public String getZd_yishengname() {
		return zd_yishengname;
	}

	public void setZd_yishengname(String zd_yishengname) {
		this.zd_yishengname = zd_yishengname;
	}

	public String getZd_riqi() {
		return zd_riqi;
	}

	public void setZd_riqi(String zd_riqi) {
		this.zd_riqi = zd_riqi;
	}

	public String getZd_ghnumber() {
		return zd_ghnumber;
	}

	public void setZd_ghnumber(String zd_ghnumber) {
		this.zd_ghnumber = zd_ghnumber;
	}

	public String getZd_ghname() {
		return zd_ghname;
	}

	public void setZd_ghname(String zd_ghname) {
		this.zd_ghname = zd_ghname;
	}

	public String getZd_ghsex() {
		return zd_ghsex;
	}

	public void setZd_ghsex(String zd_ghsex) {
		this.zd_ghsex = zd_ghsex;
	}

	public String getZd_ghage() {
		return zd_ghage;
	}

	public void setZd_ghage(String zd_ghage) {
		this.zd_ghage = zd_ghage;
	}

	public String getZd_ghks() {
		return zd_ghks;
	}

	public void setZd_ghks(String zd_ghks) {
		this.zd_ghks = zd_ghks;
	}

	public String getZd_status() {
		return zd_status;
	}

	public void setZd_status(String zd_status) {
		this.zd_status = zd_status;
	}

	public String getZd_ghtype() {
		return zd_ghtype;
	}

	public void setZd_ghtype(String zd_ghtype) {
		this.zd_ghtype = zd_ghtype;
	}

	public String getZd_ghriqi() {
		return zd_ghriqi;
	}

	public void setZd_ghriqi(String zd_ghriqi) {
		this.zd_ghriqi = zd_ghriqi;
	}

	public String getZd_fystatus() {
		return zd_fystatus;
	}

	public void setZd_fystatus(String zd_fystatus) {
		this.zd_fystatus = zd_fystatus;
	}

	public String getZd_version() {
		return zd_version;
	}

	public void setZd_version(String zd_version) {
		this.zd_version = zd_version;
	}

	public String getZd_version_old() {
		return zd_version_old;
	}

	public void setZd_version_old(String zd_version_old) {
		this.zd_version_old = zd_version_old;
	}
	
}
