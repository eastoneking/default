package com.neusoft.emanage.util.gen.entity;
import com.neusoft.sframe.util.mybatis.BaseEntity;
/**
 * 
 * @author zhangshixi date:2014年6月20日
 * 
 */
public class YaopinCKBean implements BaseEntity {

	private static final long serialVersionUID = 1L;
	/**
	 * id
	 */
	private Integer id;
	/**
	 * 药品编码id
	 */
	private String kc_ypbmid;
	/**
	 * 药品编码
	 */
	private String kc_ypbmnumber;
	/**
	 * 药品类别
	 */
	private String kc_ypleibie;
	/**
	 * 药品名称
	 */
	private String kc_ypname;
	/**
	 * 生产批号
	 */
	private String kc_yppihao;
	/**
	 * 生产批次
	 */
	private String kc_scpici;
	/**
	 * 生产日期
	 */
	private String kc_scriqi;
	/**
	 * 有效日期
	 */
	private String kc_yxriqi;
	/**
	 * 成本价格
	 */
	private String kc_cbjiage;
	/**
	 *最低价格
	 */
	private String kc_zdjiage;
	/**
	 *零售价格
	 */
	private String kc_lsjiage;
	/**
	 * 入库日期
	 */
	private String kc_rkriqi;
	/**
	 * 药品来源
	 */
	private String kc_laiyuan;
	/**
	 * 状态
	 */
	private String kc_status;
	
	private String kc_shengchanshang;
	
	private String kc_danwei;
	
	private String kc_shuliang;
	/********getter  setter**************************/

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getKc_ypbmid() {
		return kc_ypbmid;
	}
	public void setKc_ypbmid(String kc_ypbmid) {
		this.kc_ypbmid = kc_ypbmid;
	}
	public String getKc_ypbmnumber() {
		return kc_ypbmnumber;
	}
	public void setKc_ypbmnumber(String kc_ypbmnumber) {
		this.kc_ypbmnumber = kc_ypbmnumber;
	}
	public String getKc_ypleibie() {
		return kc_ypleibie;
	}
	public void setKc_ypleibie(String kc_ypleibie) {
		this.kc_ypleibie = kc_ypleibie;
	}
	public String getKc_ypname() {
		return kc_ypname;
	}
	public void setKc_ypname(String kc_ypname) {
		this.kc_ypname = kc_ypname;
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
	public String getKc_yxriqi() {
		return kc_yxriqi;
	}
	public void setKc_yxriqi(String kc_yxriqi) {
		this.kc_yxriqi = kc_yxriqi;
	}
	public String getKc_cbjiage() {
		return kc_cbjiage;
	}
	public void setKc_cbjiage(String kc_cbjiage) {
		this.kc_cbjiage = kc_cbjiage;
	}
	public String getKc_zdjiage() {
		return kc_zdjiage;
	}
	public void setKc_zdjiage(String kc_zdjiage) {
		this.kc_zdjiage = kc_zdjiage;
	}
	public String getKc_rkriqi() {
		return kc_rkriqi;
	}
	public void setKc_rkriqi(String kc_rkriqi) {
		this.kc_rkriqi = kc_rkriqi;
	}
	public String getKc_laiyuan() {
		return kc_laiyuan;
	}
	public void setKc_laiyuan(String kc_laiyuan) {
		this.kc_laiyuan = kc_laiyuan;
	}
	public String getKc_status() {
		return kc_status;
	}
	public void setKc_status(String kc_status) {
		this.kc_status = kc_status;
	}
	public String getKc_danwei() {
		return kc_danwei;
	}
	public void setKc_danwei(String kc_danwei) {
		this.kc_danwei = kc_danwei;
	}
	public String getKc_shuliang() {
		return kc_shuliang;
	}
	public void setKc_shuliang(String kc_shuliang) {
		this.kc_shuliang = kc_shuliang;
	}
	public String getKc_shengchanshang() {
		return kc_shengchanshang;
	}
	public void setKc_shengchanshang(String kc_shengchanshang) {
		this.kc_shengchanshang = kc_shengchanshang;
	}
	public String getKc_lsjiage() {
		return kc_lsjiage;
	}
	public void setKc_lsjiage(String kc_lsjiage) {
		this.kc_lsjiage = kc_lsjiage;
	}
	
	
	
}
