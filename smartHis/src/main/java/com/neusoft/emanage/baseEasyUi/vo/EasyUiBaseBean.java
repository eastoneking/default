package com.neusoft.emanage.baseEasyUi.vo;

public class EasyUiBaseBean {
	//order排序方式
	private String sort; 
	//sort排序字段
	private String order;
	//页码
	private Integer page;
	//每页显示的行数
	private Integer rows;


	
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
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	
}
