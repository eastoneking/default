// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   FileUtil.java

package com.neusoft.platform.syscontext.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtil
{

	public FileUtil()
	{
	}

	public static String[] readLines(File file)
		throws Exception
	{
		String encoding;
		List list;
		FileInputStream in;
		encoding = "UTF-8";
		if (!file.exists())
			throw new FileNotFoundException((new StringBuilder("未找到: ")).append(file).toString());
		if (!file.isFile())
			throw new IOException((new StringBuilder("不是一个文件: ")).append(file).toString());
		list = new ArrayList();
		in = null;
		in = new FileInputStream(file);
		BufferedReader br = new BufferedReader(new InputStreamReader(in, encoding));
		String strLine;
		while ((strLine = br.readLine()) != null) 
			list.add(strLine);
		Exception exception = null;
		if (in != null)
			try
			{
				in.close();
			}
			catch (IOException ioexception) {
				throw ioexception;
			}

		if (in != null)
			try
			{
				in.close();
			}
			catch (IOException ioexception1) { 
				throw ioexception1;
			}
		return (String[])list.toArray(new String[list.size()]);
	}
}
