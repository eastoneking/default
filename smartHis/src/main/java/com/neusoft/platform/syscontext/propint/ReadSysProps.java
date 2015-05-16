// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   ReadSysProps.java

package com.neusoft.platform.syscontext.propint;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.neusoft.platform.syscontext.PlatformGlobalVar;
import com.neusoft.platform.syscontext.util.FileUtil;
import com.neusoft.platform.syscontext.util.KeyValue;

public class ReadSysProps
{

	private static Logger log = LoggerFactory.getLogger(ReadSysProps.class);

	public ReadSysProps()
	{
	}

	public static void init()
	{
	}

	private static void readFileProperties()
	{
		File dir = new File(Thread.currentThread().getContextClassLoader().getResource("").getFile());
		if (dir.isDirectory())
		{
			File afile[];
			int j = (afile = dir.listFiles()).length;
			for (int i = 0; i < j; i++)
			{
				File file = afile[i];
				if (file.isFile())
				{
					String name = file.getName();
					String temp[] = name.split("\\.");
					log.debug((new StringBuilder("File name is ")).append(temp[0]).toString());
					if (temp != null && temp.length >= 2)
					{
						log.debug((new StringBuilder("File extenstion is ")).append(temp[1]).toString());
						if ("properties".equals(temp[1].toLowerCase()))
						{
							String lines[] = null;
							try
							{
								lines = FileUtil.readLines(file);
							}
							catch (Exception e)
							{
								log.error("prperties文件读取失败！", e);
							}
							if (lines != null)
							{
								String as[];
								int l = (as = lines).length;
								for (int k = 0; k < l; k++)
								{
									String s = as[k];
									if (s.contains("="))
									{
										String sss[] = s.split("=");
										KeyValue pair = new KeyValue(sss[0], sss[1]);
										PlatformGlobalVar.SYS_PROPERTIES_WITH_ORDER.add(pair);
										PlatformGlobalVar.SYS_PROPERTIES.put(sss[0], sss[1]);
										log.debug((new StringBuilder("读取到Properties中的名值对：")).append(sss[0]).append("=").append(sss[1]).toString());
									}
								}

							}
						}
					}
				}
			}

		}
	}

	static 
	{
		readFileProperties();
	}
}
