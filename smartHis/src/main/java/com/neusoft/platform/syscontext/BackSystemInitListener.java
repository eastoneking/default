// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   BackSystemInitListener.java

package com.neusoft.platform.syscontext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.neusoft.platform.syscontext.propint.ReadSysProps;

// Referenced classes of package com.goldcow.platform.syscontext:
//			PlatformGlobalVar

public class BackSystemInitListener
	implements ServletContextListener
{

	private static final Logger logger = LoggerFactory.getLogger(BackSystemInitListener.class);

	public BackSystemInitListener()
	{
	}

	public void contextDestroyed(ServletContextEvent arg0)
	{
		logger.debug("开始销毁各个组件......");
		PlatformGlobalVar.destroyComponent();
		logger.debug("销毁各个组件结束......");
	}

	public void contextInitialized(ServletContextEvent sce)
	{
		logger.debug("保存Servlet上下文对象....");
		javax.servlet.ServletContext sc = sce.getServletContext();
		PlatformGlobalVar.SERVLET_CONTEXT = sc;
		logger.debug("Servlet上下文保存到全局常量PlatformContext.SERVLET_CONTEXT中....");
		logger.debug("开始初始化Spring上下文对象......");
		org.springframework.web.context.WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(sc);
		PlatformGlobalVar.APPLICATION_CONTEXT = ctx;
		logger.debug("Spring上下文对象初始化完成......");
		logger.debug("开始读取Classpath根目录下的properties文件，并加载到全局......");
		ReadSysProps.init();
		logger.debug("读取Classpath根目录下的properties文件，并加载到全局结束......");
		logger.debug("开始初始化各个组件......");
		PlatformGlobalVar.initComponent();
		logger.debug("初始化各个组件结束......");
	}

}
