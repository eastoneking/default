// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MenuBean.java

package com.neusoft.platform.syscontext.vo;

import java.io.Serializable;
import java.util.*;

// Referenced classes of package com.goldcow.platform.syscontext.vo:
//			TreeBean

public class MenuBean
	implements Serializable
{

	private static final long serialVersionUID = 0xb58734150d7f1e04L;
	private String id;
	private String text;
	private String url;
	private boolean line;
	private int icon;
	private List children;
	private List childrenTree;
	private String remark;

	public MenuBean()
	{
		id = "";
		text = "";
		url = "";
		line = false;
		icon = 1;
		remark = "";
	}

	public MenuBean(String text, String url)
	{
		id = "";
		this.text = "";
		this.url = "";
		line = false;
		icon = 1;
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

	public int getIcon()
	{
		return icon;
	}

	public void setIcon(int icon)
	{
		this.icon = icon;
	}

	public List getChildrenTree()
	{
		return childrenTree;
	}

	public void setChildrenTree(List childrenTree)
	{
		this.childrenTree = childrenTree;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public boolean isLine()
	{
		return line;
	}

	public MenuBean setLine(boolean line)
	{
		this.line = line;
		return this;
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

	public List getChildren()
	{
		return children;
	}

	public void setChildren(List children)
	{
		this.children = children;
	}

	public MenuBean addChild(MenuBean child)
	{
		if (children == null)
			children = new ArrayList();
		children.add(child);
		return this;
	}

	public MenuBean addChildTree(TreeBean childTree)
	{
		if (childrenTree == null)
			childrenTree = new ArrayList();
		childrenTree.add(childTree);
		return this;
	}
}
