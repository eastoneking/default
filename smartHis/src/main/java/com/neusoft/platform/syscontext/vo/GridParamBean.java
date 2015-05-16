// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   GridParamBean.java

package com.neusoft.platform.syscontext.vo;

import java.io.Serializable;

public class GridParamBean
	implements Serializable
{

	private static final long serialVersionUID = 0xa62086b3c914af0eL;
	private int pagesize;
	private int page;
	private String sortname;
	private String sortorder;

	public GridParamBean()
	{
		pagesize = 0;
		page = 0;
		sortname = "";
		sortorder = "asc";
	}

	public int getOffset()
	{
		int offset = (page - 1) * pagesize;
		offset = offset <= 0 ? 0 : offset;
		return offset;
	}

	public int getPagesize()
	{
		return pagesize <= 0 ? 15 : pagesize;
	}

	public void setPagesize(int pagesize)
	{
		this.pagesize = pagesize;
	}

	public int getPage()
	{
		return page;
	}

	public void setPage(int page)
	{
		this.page = page;
	}

	public String getSortname()
	{
		return sortname;
	}

	public void setSortname(String sortname)
	{
		this.sortname = sortname;
	}

	public String getSortorder()
	{
		return sortorder;
	}

	public void setSortorder(String sortorder)
	{
		this.sortorder = sortorder;
	}
}
