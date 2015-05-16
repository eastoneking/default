// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   TreeBean.java

package com.neusoft.platform.syscontext.vo;

import java.io.Serializable;
import java.util.*;

public class TreeBean
	implements Serializable
{

	private static final long serialVersionUID = 0x3a82e5822f55f9c9L;
	private String text;
	private String url;
	private String id;
	private boolean isexpand;
	private List children;
	private int level;
	private int type;
	private boolean isdisable;
	private boolean isnoncheck;
	private String remark;

	public TreeBean()
	{
		text = "";
		url = "";
		id = "";
		isexpand = false;
		level = 0;
		isdisable = false;
		isnoncheck = false;
		remark = "";
	}

	public TreeBean(String text, String url)
	{
		this.text = "";
		this.url = "";
		id = "";
		isexpand = false;
		level = 0;
		isdisable = false;
		isnoncheck = false;
		remark = "";
		this.text = text;
		this.url = url;
		id = UUID.randomUUID().toString();
	}

	public String getRemark()
	{
		return remark;
	}

	public void setRemark(String remark)
	{
		this.remark = remark;
	}

	public boolean isIsdisable()
	{
		return isdisable;
	}

	public void setIsdisable(boolean isdisable)
	{
		this.isdisable = isdisable;
	}

	public boolean isIsnoncheck()
	{
		return isnoncheck;
	}

	public void setIsnoncheck(boolean isnoncheck)
	{
		this.isnoncheck = isnoncheck;
	}

	public int getType()
	{
		return type;
	}

	public void setType(int type)
	{
		this.type = type;
	}

	public int getLevel()
	{
		return level;
	}

	public void setLevel(int level)
	{
		this.level = level;
	}

	public String getText()
	{
		return text;
	}

	public void setText(String text)
	{
		this.text = text;
	}

	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public boolean isIsexpand()
	{
		return isexpand;
	}

	public TreeBean setIsexpand(boolean isexpand)
	{
		this.isexpand = isexpand;
		return this;
	}

	public List getChildren()
	{
		return children;
	}

	public void setChildren(List children)
	{
		this.children = children;
	}

	public TreeBean addChild(TreeBean child)
	{
		if (children == null)
			children = new ArrayList();
		children.add(child);
		return this;
	}
}
