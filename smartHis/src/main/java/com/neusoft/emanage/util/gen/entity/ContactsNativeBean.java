package com.neusoft.emanage.util.gen.entity;

import com.neusoft.sframe.util.mybatis.BaseEntity;

public class ContactsNativeBean implements BaseEntity {
	private static final long serialVersionUID = 1L;

	/** 员工ID */
	private int user_id;
	/** 员工手机号 */
	private String user_phone_number_native;
	/** 员工分机号 */
	private String user_extension_number_native;
	/** 员工工作QQ */
	private String user_qq_number;
	/** 员工备注 */
	private String user_note;

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
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

}
