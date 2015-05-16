// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   CharUtil.java

package com.neusoft.platform.syscontext.util;

import java.io.UnsupportedEncodingException;

public class CharUtil
{

	public CharUtil()
	{
	}

	public static char toChar(byte b)
	{
		return (char)(b & 0xff);
	}

	public static byte[] toSimpleByteArray(char carr[])
	{
		byte barr[] = new byte[carr.length];
		for (int i = 0; i < carr.length; i++)
			barr[i] = (byte)carr[i];

		return barr;
	}

	public static byte[] toSimpleByteArray(CharSequence charSequence)
	{
		byte barr[] = new byte[charSequence.length()];
		for (int i = 0; i < barr.length; i++)
			barr[i] = (byte)charSequence.charAt(i);

		return barr;
	}

	public static char[] toSimpleCharArray(byte barr[])
	{
		char carr[] = new char[barr.length];
		for (int i = 0; i < barr.length; i++)
			carr[i] = (char)(barr[i] & 0xff);

		return carr;
	}

	public static int toAscii(char c)
	{
		if (c <= '\377')
			return c;
		else
			return 63;
	}

	public static byte[] toAsciiByteArray(char carr[])
	{
		byte barr[] = new byte[carr.length];
		for (int i = 0; i < carr.length; i++)
			barr[i] = (byte)(carr[i] > '\377' ? 63 : carr[i]);

		return barr;
	}

	public static byte[] toAsciiByteArray(CharSequence charSequence)
	{
		byte barr[] = new byte[charSequence.length()];
		for (int i = 0; i < barr.length; i++)
		{
			char c = charSequence.charAt(i);
			barr[i] = (byte)(c > '\377' ? 63 : c);
		}

		return barr;
	}

	public static byte[] toRawByteArray(char carr[])
	{
		byte barr[] = new byte[carr.length << 1];
		int i = 0;
		int bpos = 0;
		for (; i < carr.length; i++)
		{
			char c = carr[i];
			barr[bpos++] = (byte)((c & 0xff00) >> 8);
			barr[bpos++] = (byte)(c & 0xff);
		}

		return barr;
	}

	public static char[] toRawCharArray(byte barr[])
	{
		int carrLen = barr.length >> 1;
		if (carrLen << 1 < barr.length)
			carrLen++;
		char carr[] = new char[carrLen];
		int i = 0;
		int j = 0;
		while (i < barr.length) 
		{
			char c = (char)(barr[i] << 8);
			if (++i != barr.length)
			{
				c += barr[i] & 0xff;
				i++;
			}
			carr[j++] = c;
		}
		return carr;
	}

	public static byte[] toByteArray(char carr[])
		throws UnsupportedEncodingException
	{
		return (new String(carr)).getBytes("UTF-8");
	}

	public static byte[] toByteArray(char carr[], String charset)
		throws UnsupportedEncodingException
	{
		return (new String(carr)).getBytes(charset);
	}

	public static char[] toCharArray(byte barr[])
		throws UnsupportedEncodingException
	{
		return (new String(barr, "UTF-8")).toCharArray();
	}

	public static char[] toCharArray(byte barr[], String charset)
		throws UnsupportedEncodingException
	{
		return (new String(barr, charset)).toCharArray();
	}

	public static boolean equalsOne(char c, char match[])
	{
		char ac[];
		int j = (ac = match).length;
		for (int i = 0; i < j; i++)
		{
			char aMatch = ac[i];
			if (c == aMatch)
				return true;
		}

		return false;
	}

	public static int findFirstEqual(char source[], int index, char match[])
	{
		for (int i = index; i < source.length; i++)
			if (equalsOne(source[i], match))
				return i;

		return -1;
	}

	public static int findFirstEqual(char source[], int index, char match)
	{
		for (int i = index; i < source.length; i++)
			if (source[i] == match)
				return i;

		return -1;
	}

	public static int findFirstDiff(char source[], int index, char match[])
	{
		for (int i = index; i < source.length; i++)
			if (!equalsOne(source[i], match))
				return i;

		return -1;
	}

	public static int findFirstDiff(char source[], int index, char match)
	{
		for (int i = index; i < source.length; i++)
			if (source[i] != match)
				return i;

		return -1;
	}

	public static boolean isWhitespace(char c)
	{
		return c <= ' ';
	}

	public static boolean isLowercaseLetter(char c)
	{
		return c >= 'a' && c <= 'z';
	}

	public static boolean isUppercaseLetter(char c)
	{
		return c >= 'A' && c <= 'Z';
	}

	public static boolean isLetter(char c)
	{
		return c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z';
	}

	public static boolean isDigit(char c)
	{
		return c >= '0' && c <= '9';
	}

	public static boolean isLetterOrDigit(char c)
	{
		return isDigit(c) || isLetter(c);
	}

	public static boolean isWordChar(char c)
	{
		return isDigit(c) || isLetter(c) || c == '_';
	}

	public static boolean isPropertyNameChar(char c)
	{
		return isDigit(c) || isLetter(c) || c == '_' || c == '.' || c == '[' || c == ']';
	}

	public static char toUpperAscii(char c)
	{
		if (isLowercaseLetter(c))
			c -= ' ';
		return c;
	}

	public static char toLowerAscii(char c)
	{
		if (isUppercaseLetter(c))
			c += ' ';
		return c;
	}
}
