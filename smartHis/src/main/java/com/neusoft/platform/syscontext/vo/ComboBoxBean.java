// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   ComboBoxBean.java

package com.neusoft.platform.syscontext.vo;

import java.io.Serializable;

public class ComboBoxBean
	implements Serializable
{

	private static final long serialVersionUID = 0x331e86a9306086daL;
	private String id;
	private String text;
	private String pid;

	public ComboBoxBean()
	{
		id = "";
		text = "";
		pid = "";
	}

	public ComboBoxBean(String id, String text)
	{
		this.id = "";
		this.text = "";
		pid = "";
		this.id = id;
		this.text = text;
	}

	public ComboBoxBean(String id, String text, String pid)
	{
		this.id = "";
		this.text = "";
		this.pid = "";
		this.id = id;
		this.text = text;
		this.pid = pid;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getText()
	{
		return text;
	}

	public void setText(String text)
	{
		this.text = text;
	}

	public String getPid()
	{
		return pid;
	}

	public void setPid(String pid)
	{
		this.pid = pid;
	}
}
