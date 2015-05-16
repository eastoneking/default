// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   GridDataBean.java

package com.neusoft.platform.syscontext.vo;

import java.io.Serializable;
import java.util.*;

public class GridDataBean
	implements Serializable
{

	private static final long serialVersionUID = 0x8c0390c51f215489L;
	private Map resMap;

	public GridDataBean()
	{
		resMap = new HashMap();
	}

	public GridDataBean(int page, int total, List listmap)
	{
		resMap = new HashMap();
		setPageNum(page);
		setTotal(total);
		setRows(listmap);
	}

	public void setPageNum(int page)
	{
		resMap.put("page", Integer.valueOf(page));
	}

	public void setTotal(int total)
	{
		resMap.put("Total", Integer.valueOf(total));
	}

	public void setRows(List listmap)
	{
		resMap.put("Rows", listmap);
	}

	public List getRows()
	{
		Object o = resMap.get("Rows");
		if (o == null)
			return null;
		else
			return (List)o;
	}

	public Map getGridData()
	{
		return resMap;
	}
}
