package com.neusoft.emanage.util.gen.entity;

import com.neusoft.sframe.util.mybatis.BaseEntity;

public class SysMenuBean implements BaseEntity {
	private static final long serialVersionUID = -7201138565082638625L;

	/** ID */
	private Integer id;

	/** 菜单名称 */
	private String text;

	/** 菜单链接 */
	private String url;

	/** 权限 */
	private Integer permission_id;

	/** 状态 */
	private Integer status;

	/** 上级菜单 */
	private Integer parent_id;

	/** 顺序 */
	private Integer orders;

	/** 图标 */
	private String icon;

	/** 上级菜单名称 */
	private String parentText;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getPermission_id() {
		return permission_id;
	}

	public void setPermission_id(Integer permission_id) {
		this.permission_id = permission_id;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getParent_id() {
		return parent_id;
	}

	public void setParent_id(Integer parent_id) {
		this.parent_id = parent_id;
	}

	public Integer getOrders() {
		return orders;
	}

	public void setOrders(Integer orders) {
		this.orders = orders;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getParentText() {
		return parentText;
	}

	public void setParentText(String parentText) {
		this.parentText = parentText;
	}
}