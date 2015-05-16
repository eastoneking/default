package com.neusoft.emanage.util.gen.entity;
import com.neusoft.sframe.util.mybatis.BaseEntity;
/**
 * 金佳币实时行情 对应subscription数据库表的实体类
 * 
 * @author zhangshixi date:2014年6月20日
 * 
 */
public class KeshiBean implements BaseEntity {

	private static final long serialVersionUID = 1L;
	/**
	 * id
	 */
	private Integer id;
	/**
	 * 科室名字
	 */
	private String ksname;
	/**
	 * 科室编号
	 */
	private String ksnumber;
	/**
	 * 科室地址
	 */
	private String ksaddress;
	/**
	 * 科室顺序
	 */
	private String ksorder;
	/********getter  setter**************************/
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getKsname() {
		return ksname;
	}

	public void setKsname(String ksname) {
		this.ksname = ksname;
	}

	public String getKsnumber() {
		return ksnumber;
	}

	public void setKsnumber(String ksnumber) {
		this.ksnumber = ksnumber;
	}

	public String getKsaddress() {
		return ksaddress;
	}

	public void setKsaddress(String ksaddress) {
		this.ksaddress = ksaddress;
	}

	public String getKsorder() {
		return ksorder;
	}

	public void setKsorder(String ksorder) {
		this.ksorder = ksorder;
	}
	
	
}
