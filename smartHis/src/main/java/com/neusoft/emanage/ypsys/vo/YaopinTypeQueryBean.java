package com.neusoft.emanage.ypsys.vo;
import com.neusoft.emanage.baseEasyUi.vo.EasyUiBaseBean;
/**
 * 金佳币实时行情 对应subscription数据库表的实体类
 * 
 * @author zhangshixi date:2014年6月20日
 * 
 */
public class YaopinTypeQueryBean   extends EasyUiBaseBean  {

	private static final long serialVersionUID = 1L;
	/**
	 * id
	 */
	private Integer id;
	/**
	 * 类别名字
	 */
	private String yplbname;
	/**
	 * 类别编号
	 */
	private String yplbnumber;
	/**
	 * 类别顺序
	 */
	private String yplborder;
	/**
	 * 顺序状态
	 */
	private String yplbstatus;
	/********getter  setter**************************/
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getYplbname() {
		return yplbname;
	}
	public void setYplbname(String yplbname) {
		this.yplbname = yplbname;
	}
	public String getYplbnumber() {
		return yplbnumber;
	}
	public void setYplbnumber(String yplbnumber) {
		this.yplbnumber = yplbnumber;
	}
	public String getYplborder() {
		return yplborder;
	}
	public void setYplborder(String yplborder) {
		this.yplborder = yplborder;
	}
	public String getYplbstatus() {
		return yplbstatus;
	}
	public void setYplbstatus(String yplbstatus) {
		this.yplbstatus = yplbstatus;
	}
	
	
	
}
