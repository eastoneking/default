// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   PlatformGlobalVar.java

package com.neusoft.platform.syscontext;

import java.util.*;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import com.neusoft.platform.syscontext.lifecycle.BundleLife;
import com.neusoft.platform.syscontext.util.ExceptionUtil;
import com.neusoft.platform.syscontext.util.KeyValue;
import com.neusoft.platform.syscontext.util.ReflectUtil;

public class PlatformGlobalVar
{

	private static Logger logger = LoggerFactory.getLogger(PlatformGlobalVar.class);
	public static ServletContext SERVLET_CONTEXT;
	public static ApplicationContext APPLICATION_CONTEXT;
	public static Map<String,String> SYS_PROPERTIES = new Hashtable();
	public static List SYS_PROPERTIES_WITH_ORDER = new Vector();
	public static List BUNDLE_CONTEXT_LIST = new Vector();
	public static Map SYS_DB_PROPERTIES = new Hashtable();
	private static Map CONTEXT_CACHE = new Hashtable();

	public PlatformGlobalVar()
	{
	}

	public static String getRealPath(String path)
	{
		return SERVLET_CONTEXT.getRealPath(path);
	}

	public static void registContext(String name, Object context)
	{
		if (CONTEXT_CACHE == null)
			CONTEXT_CACHE = new Hashtable();
		CONTEXT_CACHE.put(name, context);
	}

	public static Object getContextByName(String name)
	{
		if (!CONTEXT_CACHE.containsKey(name))
			return null;
		else
			return CONTEXT_CACHE.get(name);
	}

	public static void refreshComponent()
	{
		destroyComponent();
		initComponent();
	}

	public static void destroyComponent()
	{
		int size = BUNDLE_CONTEXT_LIST.size();
		if (size > 0)
		{
			for (int i = size - 1; i >= 0; i--)
			{
				BundleLife obj = (BundleLife)BUNDLE_CONTEXT_LIST.get(i);
				obj.destroy();
			}

			BUNDLE_CONTEXT_LIST.clear();
		}
	}

	public static void initComponent()
	{
		if (BUNDLE_CONTEXT_LIST.size() > 0)
			BUNDLE_CONTEXT_LIST.clear();
		List list = SYS_PROPERTIES_WITH_ORDER;
		for (int i = 0; i < list.size(); i++)
		{
			KeyValue keyValue = (KeyValue)list.get(i);
			String key = (String)keyValue.getKey();
			String value = (String)keyValue.getValue();
			if (key != null && (value != null) & key.startsWith("com.neusoft.platform.") && "true".equals(value.toLowerCase()))
			{
				logger.debug((new StringBuilder("开始调用组件【")).append(key).append("】中的BundleLife方法！").toString());
				Class clazz = null;
				try
				{
					clazz = Class.forName(key);
				}
				catch (ClassNotFoundException e)
				{
					logger.error((new StringBuilder("系统启动失败！Properties中配置的启动组件类未找到，请确定该组件已经包含在项目中。【组件名字：")).append(key).append("】").toString());
					ExceptionUtil.throwException(e);
				}
				if (ReflectUtil.isInterfaceImpl(clazz, BundleLife.class))
				{
					try
					{
						BundleLife obj = (BundleLife)ReflectUtil.newInstance(clazz);
						obj.init();
						BUNDLE_CONTEXT_LIST.add(obj);
					}
					catch (IllegalAccessException e)
					{
						logger.error((new StringBuilder("系统启动失败！无法创建组件中启动类对象。【组件名字：")).append(key).append("】").toString(), e);
						ExceptionUtil.throwException(e);
					}
					catch (InstantiationException e)
					{
						logger.error((new StringBuilder("系统启动失败！无法创建组件中启动类对象。【组件名字：")).append(key).append("】").toString(), e);
						ExceptionUtil.throwException(e);
					}
				} else
				{
					logger.error((new StringBuilder("系统启动失败！组件启动类没有实现组件平台规定的com.neusoft.platform.syscontext.BundleLife接口。【组件名字：")).append(key).append("】").toString());
					throw new RuntimeException((new StringBuilder("系统启动失败！组件启动类没有实现组件平台规定的com.neusoft.platform.syscontext.BundleLife接口。【组件名字：")).append(key).append("】").toString());
				}
			}
		}

	}

}
