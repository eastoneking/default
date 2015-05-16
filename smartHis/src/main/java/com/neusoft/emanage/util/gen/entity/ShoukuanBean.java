package com.neusoft.emanage.util.gen.entity;
import com.neusoft.sframe.util.mybatis.BaseEntity;
/**
 * 
 * @author zhangshixi date:2014年6月20日
 * 
 */
public class ShoukuanBean implements BaseEntity {

	private static final long serialVersionUID = 1L;
	/**
	 * id
	 */
	private Integer id;
	/**
	 * 挂号患者年龄
	 */
	private String ghsf_zdid;
	/**
	 * 挂号患者年龄
	 */
	private String ghsf_ghid;
	/**
	 * 挂号患者年龄
	 */
	private String ghsf_ghnumber;

	/**
	 * 病历号
	 */
	private String ghsf_ysjine;
	/**
	 * 挂号患者姓名
	 */
	private String ghsf_ssjine;
	/**
	 * 挂号患者性别
	 */
	private String ghsf_zljine;
	/**
	 * 挂号科室ID
	 */
	private String ghsf_heji;
	/**
	 * 挂号科室名字
	 */
	private String ghsf_sktime;
	/**
	 * 挂号类别
	 */
	private String ghsf_skpersonid;
	/**
	 * 挂号状态
	 */
	private String ghsf_skperson;
	/**
	 * 挂号状态
	 */
	private String zd_version;
	/********getter  setter**************************/
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getGhsf_ysjine() {
		return ghsf_ysjine;
	}
	public void setGhsf_ysjine(String ghsf_ysjine) {
		this.ghsf_ysjine = ghsf_ysjine;
	}
	public String getGhsf_ssjine() {
		return ghsf_ssjine;
	}
	public void setGhsf_ssjine(String ghsf_ssjine) {
		this.ghsf_ssjine = ghsf_ssjine;
	}
	public String getGhsf_zljine() {
		return ghsf_zljine;
	}
	public void setGhsf_zljine(String ghsf_zljine) {
		this.ghsf_zljine = ghsf_zljine;
	}
	public String getGhsf_zdid() {
		return ghsf_zdid;
	}
	public void setGhsf_zdid(String ghsf_zdid) {
		this.ghsf_zdid = ghsf_zdid;
	}
	public String getGhsf_heji() {
		return ghsf_heji;
	}
	public void setGhsf_heji(String ghsf_heji) {
		this.ghsf_heji = ghsf_heji;
	}
	public String getGhsf_sktime() {
		return ghsf_sktime;
	}
	public void setGhsf_sktime(String ghsf_sktime) {
		this.ghsf_sktime = ghsf_sktime;
	}
	public String getGhsf_skpersonid() {
		return ghsf_skpersonid;
	}
	public void setGhsf_skpersonid(String ghsf_skpersonid) {
		this.ghsf_skpersonid = ghsf_skpersonid;
	}
	public String getGhsf_skperson() {
		return ghsf_skperson;
	}
	public void setGhsf_skperson(String ghsf_skperson) {
		this.ghsf_skperson = ghsf_skperson;
	}
	public String getGhsf_ghid() {
		return ghsf_ghid;
	}
	public void setGhsf_ghid(String ghsf_ghid) {
		this.ghsf_ghid = ghsf_ghid;
	}
	public String getGhsf_ghnumber() {
		return ghsf_ghnumber;
	}
	public void setGhsf_ghnumber(String ghsf_ghnumber) {
		this.ghsf_ghnumber = ghsf_ghnumber;
	}
	public String getZd_version() {
		return zd_version;
	}
	public void setZd_version(String zd_version) {
		this.zd_version = zd_version;
	}
	
	
	
}
