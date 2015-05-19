package com.neusoft.emanage.kaiyao.vo;
import com.neusoft.emanage.baseEasyUi.vo.EasyUiBaseBean;
/**
 * 
 * @author zhangshixi date:2014年6月20日
 * 
 */
public class ZhenduanQueryBean extends EasyUiBaseBean  {

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
	private String sel_zd_status;
	/**
	 * 科室顺序
	 */
	private String sel_zd_ghnumber;
	/**
	 * 科室顺序
	 */
	private String sel_zd_ghname;
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
	 * 诊断状态
	 */
	private String zd_status;
	/**
	 * 付药状态
	 */
	private String zd_fystatus;
	/**
	 * 挂号类别
	 */
	private String zd_ghtype;
	/**
	 * 科室顺序
	 */
	private String zd_ghriqi;
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



	public String getSel_zd_ghnumber() {
		return sel_zd_ghnumber;
	}

	public void setSel_zd_ghnumber(String sel_zd_ghnumber) {
		this.sel_zd_ghnumber = sel_zd_ghnumber;
	}

	public String getSel_zd_ghname() {
		return sel_zd_ghname;
	}

	public void setSel_zd_ghname(String sel_zd_ghname) {
		this.sel_zd_ghname = sel_zd_ghname;
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

	public String getSel_zd_status() {
		return sel_zd_status;
	}

	public void setSel_zd_status(String sel_zd_status) {
		this.sel_zd_status = sel_zd_status;
	}
	
	private String zdContent;
	/**
     * The setter method of the property zdContent.
     * @param thezdContent the zdContent to set
     * @author wangds 2015年5月19日 下午6:42:52.
     */
    public void setZdContent(String zdContent) {
        this.zdContent = zdContent;
    }
    /**
     * The getter method of the property zdContent.
     * @author wangds 2015年5月19日 下午6:42:56.
     * @return the zdContent.
     */
    public String getZdContent() {
        return zdContent;
    }
}
