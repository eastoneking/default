package com.neusoft.emanage.util.gen.entity;

import java.util.Date;

import com.neusoft.sframe.util.mybatis.BaseEntity;

/**
 * 用户表
 */
public class SysUserBean implements BaseEntity {
	private static final long serialVersionUID = 7582395595110065273L;

	/** ID */
	private Integer id;

	/** 登录名 */
	private String user_name;

	/** 密码 */
	private String password;
	/**修改密码时的新密码 */
    private String newpassword; 
	/** 显示名称 */
	private String display_name;

	/** 性别 */
	private Integer sex;

	/** 电话 */
	private String phone_number;

	/** 邮箱地址 */
	private String email;

	/** 备注 */
	private String note;

	/** 状态 */
	private Integer status;

	/** SALT */
	private String salt;

	/** 创建时间 */
	private Date create_time;

	/** 部门 */
	private Integer dept_id;
	/**身份证*/
	private String idcard;
	/**角色*/
	private Integer deptid;
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDisplay_name() {
		return display_name;
	}

	public void setDisplay_name(String display_name) {
		this.display_name = display_name;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public Integer getDept_id() {
		return dept_id;
	}

	public void setDept_id(Integer dept_id) {
		this.dept_id = dept_id;
	}

	public String getNewpassword() {
		return newpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}
	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public Integer getDeptid() {
		return deptid;
	}

	public void setDeptid(Integer deptid) {
		this.deptid = deptid;
	}

	
}