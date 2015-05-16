package com.neusoft.emanage.util.gen.entity;
import java.io.Serializable;
import java.sql.Timestamp;

import com.neusoft.emanage.baseEasyUi.vo.EasyUiBaseBean;

/**
 * 查询赠送分发历史记录
 * @author xuxiaohua
 *
 */
public class GiveAwayBean extends EasyUiBaseBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer useraccesschangerecord_id;
	//谁赠送的
	private String optionname;
	//赠送给谁的
	private String user_code;
	//改变日期
	private Timestamp changeDate;
	//赠送数量
	private Double gscnum;
	private String changeDateStrat;
	private String changeDateEnd;
	public Integer getUseraccesschangerecord_id() {
		return useraccesschangerecord_id;
	}
	public void setUseraccesschangerecord_id(Integer useraccesschangerecord_id) {
		this.useraccesschangerecord_id = useraccesschangerecord_id;
	}
	public String getChangeDateStrat() {
		return changeDateStrat;
	}
	public void setChangeDateStrat(String changeDateStrat) {
		this.changeDateStrat = changeDateStrat;
	}
	public String getChangeDateEnd() {
		return changeDateEnd;
	}
	public void setChangeDateEnd(String changeDateEnd) {
		this.changeDateEnd = changeDateEnd;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getOptionname() {
		return optionname;
	}
	public void setOptionname(String optionname) {
		this.optionname = optionname;
	}
	public String getUser_code() {
		return user_code;
	}
	public void setUser_code(String user_code) {
		this.user_code = user_code;
	}
	public Timestamp getChangeDate() {
		return changeDate;
	}
	public void setChangeDate(Timestamp changeDate) {
		this.changeDate = changeDate;
	}
	public Double getGscnum() {
		return gscnum;
	}
	public void setGscnum(Double gscnum) {
		this.gscnum = gscnum;
	}

}
