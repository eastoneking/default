package com.neusoft.emanage.util.gen.entity;

import java.util.Date;

import com.neusoft.sframe.util.mybatis.BaseEntity;

public class UserRegsistBean implements BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 * 注册界面实体
	 * 陈伟雷
	 * 2014-6-10
	 */
	private Integer useraccess_id;
	//用户名
	private String user_code;
	//用户密码
	private String user_password;
	//用户电话
	private String phone;
	//用户邮箱
	private String email;
	//真实姓名
	private	String user_realname;
	//创建人
	private String create_user;
	//用户id
	private Integer userid;
	//人民币
	private Double RMB;
	//金佳币
	private Double GSC;
	//用户状态
	private String status;
	//创建时间
	private Date create_timestamp;
	//
	private Integer dept_id;
	//身份证号
	private String idCard;
	//支付密码
	private String accessPassword;
	//版本号
	private Integer versionNum;

	public Integer getUseraccess_id() {
		return useraccess_id;
	}
	public void setUseraccess_id(Integer useraccess_id) {
		this.useraccess_id = useraccess_id;
	}
	public String getUser_code() {
		return user_code;
	}
	public void setUser_code(String user_code) {
		this.user_code = user_code;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUser_realname() {
		return user_realname;
	}
	public void setUser_realname(String user_realname) {
		this.user_realname = user_realname;
	}
	public String getCreate_user() {
		return create_user;
	}
	public void setCreate_user(String create_user) {
		this.create_user = create_user;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public Double getRMB() {
		return RMB;
	}
	public void setRMB(Double rMB) {
		RMB = rMB;
	}
	public Double getGSC() {
		return GSC;
	}
	public void setGSC(Double gSC) {
		GSC = gSC;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getCreate_timestamp() {
		return create_timestamp;
	}
	public void setCreate_timestamp(Date create_timestamp) {
		this.create_timestamp = create_timestamp;
	}
	public Integer getDept_id() {
		return dept_id;
	}
	public void setDept_id(Integer dept_id) {
		this.dept_id = dept_id;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getAccessPassword() {
		return accessPassword;
	}
	public void setAccessPassword(String accessPassword) {
		this.accessPassword = accessPassword;
	}
	public Integer getVersionNum() {
		return versionNum;
	}
	public void setVersionNum(Integer versionNum) {
		this.versionNum = versionNum;
	}

}
