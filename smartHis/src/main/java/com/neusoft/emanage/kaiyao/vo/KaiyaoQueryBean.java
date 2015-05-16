package com.neusoft.emanage.kaiyao.vo;
import com.neusoft.emanage.baseEasyUi.vo.EasyUiBaseBean;
import com.neusoft.sframe.util.mybatis.BaseEntity;
/**
 * 
 * @author zhangshixi date:2014年6月20日
 * 
 */
public class KaiyaoQueryBean extends EasyUiBaseBean  {

	private static final long serialVersionUID = 1L;
	/**
	 * id
	 */
	private Integer id;
	/**
	 * 科室名字
	 */
	private Integer zdyp_zdid;
	/**
	 * 科室名字
	 */
	private Integer zdyp_ypid;
	/**
	 * 科室编号
	 */
	private String zdyp_ghid;
	/**
	 * 科室地址  
	 */
	private String zdyp_ghnumber;
	/**
	 * 科室顺序
	 */
	private String zdyp_ypbcxsjiage;
	/**
	 * 科室顺序
	 */
	private String zdyp_ypbmnumber;
	/**
	 * 科室顺序
	 */
	private String zdyp_ypname;
	/**
	 * 科室顺序
	 */
	private String zdyp_ypshuliang;
	/**
	 * 科室顺序
	 */
	private String zdyp_ypdanwei;
	/**
	 * 诊断状态
	 */
	private String zdyp_ypshengchanshang;
	/**
	 * 挂号类别
	 */
	private String zdyp_ypleibie;
	/**
	 * 科室顺序
	 */
	private String zdyp_ypcbjiage;
	/**
	 * 科室顺序
	 */
	private String zdyp_yplsjiage;
	/**
	 * 科室顺序
	 */
	private String zdyp_ypzdjiage;
	/**
	 * 科室顺序
	 */
	private String zdyp_ypbmid;

	/**
	 * 科室顺序
	 */
	private String sel_zd_yishengname;
	/**
	 * 科室顺序
	 */
	private String sel_zd_ghks;
	/**
	 * 科室顺序
	 */
	private String sel_zdyp_ypbmnumber;
	/**
	 * 科室顺序
	 */
	private String sel_zdyp_ypname;
	
	/********getter  setter**************************/
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getZdyp_zdid() {
		return zdyp_zdid;
	}
	public void setZdyp_zdid(Integer zdyp_zdid) {
		this.zdyp_zdid = zdyp_zdid;
	}
	public Integer getZdyp_ypid() {
		return zdyp_ypid;
	}
	public void setZdyp_ypid(Integer zdyp_ypid) {
		this.zdyp_ypid = zdyp_ypid;
	}
	public String getZdyp_ghid() {
		return zdyp_ghid;
	}
	public void setZdyp_ghid(String zdyp_ghid) {
		this.zdyp_ghid = zdyp_ghid;
	}
	public String getZdyp_ghnumber() {
		return zdyp_ghnumber;
	}
	public void setZdyp_ghnumber(String zdyp_ghnumber) {
		this.zdyp_ghnumber = zdyp_ghnumber;
	}
	public String getZdyp_ypbcxsjiage() {
		return zdyp_ypbcxsjiage;
	}
	public void setZdyp_ypbcxsjiage(String zdyp_ypbcxsjiage) {
		this.zdyp_ypbcxsjiage = zdyp_ypbcxsjiage;
	}
	public String getZdyp_ypbmnumber() {
		return zdyp_ypbmnumber;
	}
	public void setZdyp_ypbmnumber(String zdyp_ypbmnumber) {
		this.zdyp_ypbmnumber = zdyp_ypbmnumber;
	}
	public String getZdyp_ypname() {
		return zdyp_ypname;
	}
	public void setZdyp_ypname(String zdyp_ypname) {
		this.zdyp_ypname = zdyp_ypname;
	}
	public String getZdyp_ypshuliang() {
		return zdyp_ypshuliang;
	}
	public void setZdyp_ypshuliang(String zdyp_ypshuliang) {
		this.zdyp_ypshuliang = zdyp_ypshuliang;
	}
	public String getZdyp_ypdanwei() {
		return zdyp_ypdanwei;
	}
	public void setZdyp_ypdanwei(String zdyp_ypdanwei) {
		this.zdyp_ypdanwei = zdyp_ypdanwei;
	}
	public String getZdyp_ypshengchanshang() {
		return zdyp_ypshengchanshang;
	}
	public void setZdyp_ypshengchanshang(String zdyp_ypshengchanshang) {
		this.zdyp_ypshengchanshang = zdyp_ypshengchanshang;
	}
	public String getZdyp_ypleibie() {
		return zdyp_ypleibie;
	}
	public void setZdyp_ypleibie(String zdyp_ypleibie) {
		this.zdyp_ypleibie = zdyp_ypleibie;
	}
	public String getZdyp_ypcbjiage() {
		return zdyp_ypcbjiage;
	}
	public void setZdyp_ypcbjiage(String zdyp_ypcbjiage) {
		this.zdyp_ypcbjiage = zdyp_ypcbjiage;
	}

	public String getZdyp_yplsjiage() {
		return zdyp_yplsjiage;
	}
	public void setZdyp_yplsjiage(String zdyp_yplsjiage) {
		this.zdyp_yplsjiage = zdyp_yplsjiage;
	}
	public String getZdyp_ypzdjiage() {
		return zdyp_ypzdjiage;
	}
	public void setZdyp_ypzdjiage(String zdyp_ypzdjiage) {
		this.zdyp_ypzdjiage = zdyp_ypzdjiage;
	}
	public String getZdyp_ypbmid() {
		return zdyp_ypbmid;
	}
	public void setZdyp_ypbmid(String zdyp_ypbmid) {
		this.zdyp_ypbmid = zdyp_ypbmid;
	}
	public String getSel_zd_yishengname() {
		return sel_zd_yishengname;
	}
	public void setSel_zd_yishengname(String sel_zd_yishengname) {
		this.sel_zd_yishengname = sel_zd_yishengname;
	}
	public String getSel_zd_ghks() {
		return sel_zd_ghks;
	}
	public void setSel_zd_ghks(String sel_zd_ghks) {
		this.sel_zd_ghks = sel_zd_ghks;
	}
	public String getSel_zdyp_ypbmnumber() {
		return sel_zdyp_ypbmnumber;
	}
	public void setSel_zdyp_ypbmnumber(String sel_zdyp_ypbmnumber) {
		this.sel_zdyp_ypbmnumber = sel_zdyp_ypbmnumber;
	}
	public String getSel_zdyp_ypname() {
		return sel_zdyp_ypname;
	}
	public void setSel_zdyp_ypname(String sel_zdyp_ypname) {
		this.sel_zdyp_ypname = sel_zdyp_ypname;
	}
	
	
	
}
