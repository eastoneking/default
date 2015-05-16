// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   ExceptionUtil.java

package com.neusoft.platform.syscontext.util;



public class ExceptionUtil
{
	private static class ThrowableThrower
	{

		private static Throwable throwable;
		ThrowableThrower()  throws Throwable{
			throw throwable;
		}
	}
	public static void throwException(Throwable throwable)
	{
		if (throwable instanceof RuntimeException)
			throw (RuntimeException)throwable;
		if ((throwable instanceof IllegalAccessException) || (throwable instanceof InstantiationException))
			throw new IllegalArgumentException(throwable);
		try
		{
			synchronized (ThrowableThrower.class)
			{
				ThrowableThrower.throwable = throwable;
				ThrowableThrower.class.newInstance();
			}
		}
		catch (InstantiationException iex)
		{
			throw new RuntimeException(iex);
		}
		catch (IllegalAccessException iex)
		{
			throw new RuntimeException(iex);
		}finally{
			ThrowableThrower.throwable = null;
		}
	}
}
