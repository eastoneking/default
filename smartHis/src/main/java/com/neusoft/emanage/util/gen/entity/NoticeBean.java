package com.neusoft.emanage.util.gen.entity;

import java.sql.Timestamp;

import com.neusoft.emanage.baseEasyUi.vo.EasyUiBaseBean;
import com.neusoft.sframe.util.mybatis.BaseEntity;

/**
 * 对应notice数据库表实体类
 * @author Administrator
 *
 */
public class NoticeBean extends EasyUiBaseBean implements BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 主键id
	 */
	private Integer notice_id;
	/**
	 * 公告内容
	 */
	private String notice_content;
	/**
	 * 开始时间
	 */
	private Timestamp startTime;
	/**
	 * 结束时间
	 */
	private Timestamp endtime;
	public Integer getNotice_id() {
		return notice_id;
	}
	public void setNotice_id(Integer notice_id) {
		this.notice_id = notice_id;
	}
	public String getNotice_content() {
		return notice_content;
	}
	public void setNotice_content(String notice_content) {
		this.notice_content = notice_content;
	}
	public Timestamp getStartTime() {
		return startTime;
	}
	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}
	public Timestamp getEndtime() {
		return endtime;
	}
	public void setEndtime(Timestamp endtime) {
		this.endtime = endtime;
	}
	
}
