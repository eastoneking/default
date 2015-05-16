package com.neusoft.sframe.util;

import java.util.Map;

import com.neusoft.platform.syscontext.util.StringUtil;
import com.neusoft.platform.syscontext.vo.GridParamBean;


public class DataGridModel implements java.io.Serializable {

	private static final long serialVersionUID = 7232798260610351343L;
	private int page; // 当前页,名字必须为page
	private int rows; // 每页大小,名字必须为rows
	private String sort; // 排序字段
	private String order; // 排序规则

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public boolean isInit() {
		return StringUtil.isNotEmpty(this.sort);
	}

	public void copyValues(GridParamBean queryBean) {
		if (isInit()) {
			queryBean.setSortname(this.getSort());
			queryBean.setSortorder(this.getOrder());
			queryBean.setPagesize(this.getRows());
			queryBean.setPage(this.getPage());
		}
	}

	public Map<String, Object> convertMap(Map<String, Object> result) {
		if (isInit()) {
			result.put("total", result.get("Total"));
			result.put("rows", result.get("Rows"));
			result.remove("Total");
			result.remove("Rows");
		}
		return result;
	}
}