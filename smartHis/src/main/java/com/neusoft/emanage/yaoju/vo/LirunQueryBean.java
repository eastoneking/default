package com.neusoft.emanage.yaoju.vo;
import com.neusoft.emanage.baseEasyUi.vo.EasyUiBaseBean;
import com.neusoft.sframe.util.mybatis.BaseEntity;
/**
 * 
 * @author zhangshixi date:2014年6月20日
 * 诊断开药表
 */
public class LirunQueryBean extends EasyUiBaseBean  {

	private static final long serialVersionUID = 1L;
	
	
	private String zdyp_ypbmnumber;
	private String zd_yishengname;
	private String sel_time_start;
	private String sel_time_end;
	private String zd_yishengid;
	
	public String getSel_time_start() {
		return sel_time_start;
	}
	public void setSel_time_start(String sel_time_start) {
		this.sel_time_start = sel_time_start;
	}
	public String getSel_time_end() {
		return sel_time_end;
	}
	public void setSel_time_end(String sel_time_end) {
		this.sel_time_end = sel_time_end;
	}
	public String getZd_yishengid() {
		return zd_yishengid;
	}
	public void setZd_yishengid(String zd_yishengid) {
		this.zd_yishengid = zd_yishengid;
	}
	public String getZdyp_ypbmnumber() {
		return zdyp_ypbmnumber;
	}
	public void setZdyp_ypbmnumber(String zdyp_ypbmnumber) {
		this.zdyp_ypbmnumber = zdyp_ypbmnumber;
	}
	public String getZd_yishengname() {
		return zd_yishengname;
	}
	public void setZd_yishengname(String zd_yishengname) {
		this.zd_yishengname = zd_yishengname;
	}
	
	
}
