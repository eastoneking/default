package com.neusoft.emanage.util.gen.entity;
import com.neusoft.sframe.util.mybatis.BaseEntity;

/**
 * 
 * @author zhangshixi date:2014年6月20日
 * 
 */
public class YaopinLirunBean implements BaseEntity {

	private static final long serialVersionUID = 1L;
	/**
	 * id
	 */
	private Integer id;
	/**
	 * 出库ID
	 */
	private Integer ckid;
	/**
	 * 库存ID
	 */
	private Integer kcid;
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
	private String zdyp_danxiangjine;

	/**
	 * 科室顺序
	 */
	private String zd_yishengid;
	/**
	 * 科室顺序
	 */
	private String zd_yishengname;
	/**
	 * 科室顺序
	 */
	private String zd_ghks;
	/**
	 * 科室顺序
	 */
	private String zd_status;
	/**
	 * 科室顺序
	 */
	private String zd_fystatus;
	/**
	 * 科室顺序
	 */
	private String kc_yppihao;
	/**
	 * 科室顺序
	 */
	private String kc_scpici;
	/**
	 * 科室顺序
	 */
	private String kc_scriqi;
	/**
	 * 科室顺序
	 */
	private String tongjishuliang;
	/**
	 * 科室顺序
	 */
	private String tongjichengben;
	/**
	 * 科室顺序
	 */
	private String tongjixiaoshou;
	/**
	 * 科室顺序
	 */
	private String tongjilirun;
	/**
	 * 科室顺序
	 */
	private String tongjitimestart;	
	/**
	 * 科室顺序
	 */
	private String tongjitimeend;
	
	/***** getter   setter *************/
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
	public String getZdyp_danxiangjine() {
		return zdyp_danxiangjine;
	}
	public void setZdyp_danxiangjine(String zdyp_danxiangjine) {
		this.zdyp_danxiangjine = zdyp_danxiangjine;
	}
	public String getZd_yishengid() {
		return zd_yishengid;
	}
	public void setZd_yishengid(String zd_yishengid) {
		this.zd_yishengid = zd_yishengid;
	}
	public String getZd_yishengname() {
		return zd_yishengname;
	}
	public void setZd_yishengname(String zd_yishengname) {
		this.zd_yishengname = zd_yishengname;
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
	public String getZd_fystatus() {
		return zd_fystatus;
	}
	public void setZd_fystatus(String zd_fystatus) {
		this.zd_fystatus = zd_fystatus;
	}
	public String getKc_yppihao() {
		return kc_yppihao;
	}
	public void setKc_yppihao(String kc_yppihao) {
		this.kc_yppihao = kc_yppihao;
	}
	public String getKc_scpici() {
		return kc_scpici;
	}
	public void setKc_scpici(String kc_scpici) {
		this.kc_scpici = kc_scpici;
	}
	public String getKc_scriqi() {
		return kc_scriqi;
	}
	public void setKc_scriqi(String kc_scriqi) {
		this.kc_scriqi = kc_scriqi;
	}
	public String getTongjishuliang() {
		return tongjishuliang;
	}
	public void setTongjishuliang(String tongjishuliang) {
		this.tongjishuliang = tongjishuliang;
	}
	public String getTongjichengben() {
		return tongjichengben;
	}
	public void setTongjichengben(String tongjichengben) {
		this.tongjichengben = tongjichengben;
	}
	public String getTongjixiaoshou() {
		return tongjixiaoshou;
	}
	public void setTongjixiaoshou(String tongjixiaoshou) {
		this.tongjixiaoshou = tongjixiaoshou;
	}
	public String getTongjilirun() {
		return tongjilirun;
	}
	public void setTongjilirun(String tongjilirun) {
		this.tongjilirun = tongjilirun;
	}
	public Integer getCkid() {
		return ckid;
	}
	public void setCkid(Integer ckid) {
		this.ckid = ckid;
	}
	public Integer getKcid() {
		return kcid;
	}
	public void setKcid(Integer kcid) {
		this.kcid = kcid;
	}
	public String getTongjitimestart() {
		return tongjitimestart;
	}
	public void setTongjitimestart(String tongjitimestart) {
		this.tongjitimestart = tongjitimestart;
	}
	public String getTongjitimeend() {
		return tongjitimeend;
	}
	public void setTongjitimeend(String tongjitimeend) {
		this.tongjitimeend = tongjitimeend;
	}
	
	
	
}
