package com.neusoft.emanage.util.gen.entity;

import com.neusoft.sframe.util.mybatis.BaseEntity;

public class ContactsNetBean implements BaseEntity {
	private static final long serialVersionUID = 1L;

	/** 员工ID */
	private int user_id;
	/** 员工姓名 */
	private String user_name;
	/** 员工性别 */
	private int user_sex;
	/** 员工职务ID */
	private int user_position_id;
	/** 员工职务名称 */
	private String user_position;
	/** 员工职务级别 */
	private String user_position_level;
	/** 员工部门ID */
	private int user_dept_id;
	/** 员工部门名称 */
	private String user_dept;
	/** 员工部门级别 */
	private String user_dept_level;
	/** 员工手机号 */
	private String user_phone_number;
	/** 员工分机号 */
	private String user_extension_number;
	/** 员工工作邮箱 */
	private String user_email;
	/** 员工工作地点 */
	private String user_workplace;
	/** 员工状态 */
	private int user_status;
	
	/**  ----------------------本地信息表数据*/
	
	/** 员工手机号 */
	private String user_phone_number_native;
	/** 员工分机号 */
	private String user_extension_number_native;
	/** 员工工作QQ */
	private String user_qq_number;
	/** 员工备注 */
	private String user_note;
	
	
	/** -----------------------字典表*/
	/** 性别名称*/
	private String user_sex_name;
	

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public int getUser_sex() {
		return user_sex;
	}

	public void setUser_sex(int user_sex) {
		this.user_sex = user_sex;
	}

	public int getUser_position_id() {
		return user_position_id;
	}

	public void setUser_position_id(int user_position_id) {
		this.user_position_id = user_position_id;
	}


	public String getUser_position() {
		return user_position;
	}

	public void setUser_position(String user_position) {
		this.user_position = user_position;
	}

	public String getUser_position_level() {
		return user_position_level;
	}

	public void setUser_position_level(String user_position_level) {
		this.user_position_level = user_position_level;
	}

	public int getUser_dept_id() {
		return user_dept_id;
	}

	public void setUser_dept_id(int user_dept_id) {
		this.user_dept_id = user_dept_id;
	}



	public String getUser_dept() {
		return user_dept;
	}

	public void setUser_dept(String user_dept) {
		this.user_dept = user_dept;
	}

	public String getUser_dept_level() {
		return user_dept_level;
	}

	public void setUser_dept_level(String user_dept_level) {
		this.user_dept_level = user_dept_level;
	}

	public String getUser_phone_number() {
		return user_phone_number;
	}

	public void setUser_phone_number(String user_phone_number) {
		this.user_phone_number = user_phone_number;
	}

	public String getUser_extension_number() {
		return user_extension_number;
	}

	public void setUser_extension_number(String user_extension_number) {
		this.user_extension_number = user_extension_number;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_workplace() {
		return user_workplace;
	}

	public void setUser_workplace(String user_workplace) {
		this.user_workplace = user_workplace;
	}

	public void setUser_status(int user_status) {
		this.user_status = user_status;
	}

	public int getUser_status() {
		return user_status;
	}

	public String getUser_phone_number_native() {
		return user_phone_number_native;
	}

	public void setUser_phone_number_native(String user_phone_number_native) {
		this.user_phone_number_native = user_phone_number_native;
	}

	public String getUser_extension_number_native() {
		return user_extension_number_native;
	}

	public void setUser_extension_number_native(String user_extension_number_native) {
		this.user_extension_number_native = user_extension_number_native;
	}

	public String getUser_qq_number() {
		return user_qq_number;
	}

	public void setUser_qq_number(String user_qq_number) {
		this.user_qq_number = user_qq_number;
	}

	public String getUser_note() {
		return user_note;
	}

	public void setUser_note(String user_note) {
		this.user_note = user_note;
	}

	public String getUser_sex_name() {
		return user_sex_name;
	}

	public void setUser_sex_name(String user_sex_name) {
		this.user_sex_name = user_sex_name;
	}
	
}
