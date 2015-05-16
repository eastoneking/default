// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   KeyValue.java

package com.neusoft.platform.syscontext.util;


public class KeyValue
{

	protected Object key;
	protected Object value;

	public KeyValue()
	{
	}

	public KeyValue(Object key, Object value)
	{
		this.key = key;
		this.value = value;
	}

	public void setKey(Object key)
	{
		this.key = key;
	}

	public Object getKey()
	{
		return key;
	}

	public Object getValue()
	{
		return value;
	}

	public void setValue(Object value)
	{
		this.value = value;
	}

	public boolean equals(Object o)
	{
		if (!(o instanceof KeyValue))
			return false;
		KeyValue that = (KeyValue)o;
		Object k1 = getKey();
		Object k2 = that.getKey();
		if (k1 == k2 || k1 != null && k1.equals(k2))
		{
			Object v1 = getValue();
			Object v2 = that.getValue();
			if (v1 == v2 || v1 != null && v1.equals(v2))
				return true;
		}
		return false;
	}

	public int hashCode()
	{
		return (key != null ? key.hashCode() : 0) ^ (value != null ? value.hashCode() : 0);
	}
}
