package com.neusoft.emanage.util.gen.entity;

import com.neusoft.sframe.util.mybatis.BaseEntity;

/**
 * 赠送分发记录表
 * @author xuxiaohua
 *
 */
public class PresentRecordBean implements BaseEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6352792624014119410L;
	/**赠送记录表分发自增长*/
	private Integer present_record_id;
	/**类型，可以有赠送或者分发*/
	private String type;
	/**人民币币数量*/
	private Double cncnum;
	/**外键用户表的id*/
	private Integer userAccessId;
	/**描述*/
	private String description;
	/**操作员id*/
	private Integer optionId;
	/**操作员名称*/
	private String optionname;
	/**记录金佳币的数量*/
	private Double gscnum;
	
	public Integer getPresent_record_id() {
		return present_record_id;
	}
	public void setPresent_record_id(Integer present_record_id) {
		this.present_record_id = present_record_id;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Double getCncnum() {
		return cncnum;
	}
	public void setCncnum(Double cncnum) {
		this.cncnum = cncnum;
	}
	public Integer getUserAccessId() {
		return userAccessId;
	}
	public void setUserAccessId(Integer userAccessId) {
		this.userAccessId = userAccessId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getOptionId() {
		return optionId;
	}
	public void setOptionId(Integer optionId) {
		this.optionId = optionId;
	}
	public String getOptionname() {
		return optionname;
	}
	public void setOptionname(String optionname) {
		this.optionname = optionname;
	}
	public Double getGscnum() {
		return gscnum;
	}
	public void setGscnum(Double gscnum) {
		this.gscnum = gscnum;
	}

}
