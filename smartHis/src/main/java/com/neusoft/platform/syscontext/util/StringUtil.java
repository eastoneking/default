// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   StringUtil.java

package com.neusoft.platform.syscontext.util;

import java.io.UnsupportedEncodingException;


// Referenced classes of package com.goldcow.platform.syscontext.util:
//			CharUtil

public class StringUtil
{

	public StringUtil()
	{
	}

	public static String replace(String s, String sub, String with)
	{
		int c = 0;
		int i = s.indexOf(sub, c);
		if (i == -1)
			return s;
		int length = s.length();
		StringBuilder sb = new StringBuilder(length + with.length());
		do
		{
			sb.append(s.substring(c, i));
			sb.append(with);
			c = i + sub.length();
		} while ((i = s.indexOf(sub, c)) != -1);
		if (c < length)
			sb.append(s.substring(c, length));
		return sb.toString();
	}

	public static String replaceChar(String s, char sub, char with)
	{
		int startIndex = s.indexOf(sub);
		if (startIndex == -1)
			return s;
		char str[] = s.toCharArray();
		for (int i = startIndex; i < str.length; i++)
			if (str[i] == sub)
				str[i] = with;

		return new String(str);
	}

	public static String replaceChars(String s, char sub[], char with[])
	{
		char str[] = s.toCharArray();
		for (int i = 0; i < str.length; i++)
		{
			char c = str[i];
			for (int j = 0; j < sub.length; j++)
			{
				if (c != sub[j])
					continue;
				str[i] = with[j];
				break;
			}

		}

		return new String(str);
	}

	public static String replaceFirst(String s, String sub, String with)
	{
		int i = s.indexOf(sub);
		if (i == -1)
			return s;
		else
			return (new StringBuilder(String.valueOf(s.substring(0, i)))).append(with).append(s.substring(i + sub.length())).toString();
	}

	public static String replaceFirst(String s, char sub, char with)
	{
		int index = s.indexOf(sub);
		if (index == -1)
		{
			return s;
		} else
		{
			char str[] = s.toCharArray();
			str[index] = with;
			return new String(str);
		}
	}

	public static String replaceLast(String s, String sub, String with)
	{
		int i = s.lastIndexOf(sub);
		if (i == -1)
			return s;
		else
			return (new StringBuilder(String.valueOf(s.substring(0, i)))).append(with).append(s.substring(i + sub.length())).toString();
	}

	public static String replaceLast(String s, char sub, char with)
	{
		int index = s.lastIndexOf(sub);
		if (index == -1)
		{
			return s;
		} else
		{
			char str[] = s.toCharArray();
			str[index] = with;
			return new String(str);
		}
	}

	public static String remove(String s, String sub)
	{
		int c = 0;
		int sublen = sub.length();
		if (sublen == 0)
			return s;
		int i = s.indexOf(sub, c);
		if (i == -1)
			return s;
		StringBuilder sb = new StringBuilder(s.length());
		do
		{
			sb.append(s.substring(c, i));
			c = i + sublen;
		} while ((i = s.indexOf(sub, c)) != -1);
		if (c < s.length())
			sb.append(s.substring(c, s.length()));
		return sb.toString();
	}

	public static String removeChars(String src, String chars)
	{
		int i = src.length();
		StringBuilder sb = new StringBuilder(i);
		for (int j = 0; j < i; j++)
		{
			char c = src.charAt(j);
			if (chars.indexOf(c) == -1)
				sb.append(c);
		}

		return sb.toString();
	}

	public static String removeChars(String src, char chars[])
	{
		int i = src.length();
		StringBuilder sb = new StringBuilder(i);
label0:
		for (int j = 0; j < i; j++)
		{
			char c = src.charAt(j);
			char ac[];
			int l = (ac = chars).length;
			for (int k = 0; k < l; k++)
			{
				char aChar = ac[k];
				if (c == aChar)
					continue label0;
			}

			sb.append(c);
		}

		return sb.toString();
	}

	public static String remove(String string, char ch)
	{
		int stringLen = string.length();
		char result[] = new char[stringLen];
		int offset = 0;
		for (int i = 0; i < stringLen; i++)
		{
			char c = string.charAt(i);
			if (c != ch)
			{
				result[offset] = c;
				offset++;
			}
		}

		return new String(result, 0, offset);
	}

	public static boolean isEmpty(String string)
	{
		return string == null || string.length() == 0;
	}

	public static  boolean isAllEmpty(String strings[])
	{
		String as[];
		int j = (as = strings).length;
		for (int i = 0; i < j; i++)
		{
			String string = as[i];
			if (!isEmpty(string))
				return false;
		}

		return true;
	}

	public static boolean isBlank(String string)
	{
		return string == null || containsOnlyWhitespaces(string);
	}

	public static boolean isNotBlank(String string)
	{
		return string != null && !containsOnlyWhitespaces(string);
	}

	public static  boolean isAllBlank(String strings[])
	{
		String as[];
		int j = (as = strings).length;
		for (int i = 0; i < j; i++)
		{
			String string = as[i];
			if (!isBlank(string))
				return false;
		}

		return true;
	}

	public static boolean containsOnlyWhitespaces(String string)
	{
		int size = string.length();
		for (int i = 0; i < size; i++)
		{
			char c = string.charAt(i);
			if (!CharUtil.isWhitespace(c))
				return false;
		}

		return true;
	}

	public static boolean containsOnlyDigits(String string)
	{
		int size = string.length();
		for (int i = 0; i < size; i++)
		{
			char c = string.charAt(i);
			if (!CharUtil.isDigit(c))
				return false;
		}

		return true;
	}

	public static boolean isNotEmpty(String string)
	{
		return string != null && string.length() > 0;
	}

	public static String capitalize(String str)
	{
		return changeFirstCharacterCase(true, str);
	}

	public static String uncapitalize(String str)
	{
		return changeFirstCharacterCase(false, str);
	}

	private static String changeFirstCharacterCase(boolean capitalize, String string)
	{
		int strLen = string.length();
		if (strLen == 0)
			return string;
		char ch = string.charAt(0);
		char modifiedCh;
		if (capitalize)
			modifiedCh = Character.toUpperCase(ch);
		else
			modifiedCh = Character.toLowerCase(ch);
		if (modifiedCh == ch)
		{
			return string;
		} else
		{
			StringBuilder builder = new StringBuilder(strLen);
			builder.append(modifiedCh);
			builder.append(string.substring(1));
			return builder.toString();
		}
	}

	public static String title(String string)
	{
		char chars[] = string.toCharArray();
		boolean wasWhitespace = true;
		for (int i = 0; i < chars.length; i++)
		{
			char c = chars[i];
			if (CharUtil.isWhitespace(c))
			{
				wasWhitespace = true;
			} else
			{
				if (wasWhitespace)
					chars[i] = Character.toUpperCase(c);
				else
					chars[i] = Character.toLowerCase(c);
				wasWhitespace = false;
			}
		}

		return new String(chars);
	}

	public static String truncate(String string, int length)
	{
		if (string.length() > length)
			string = string.substring(0, length);
		return string;
	}

	public static String[] split(String src, String delimiter)
	{
		int maxparts = src.length() / delimiter.length() + 2;
		int positions[] = new int[maxparts];
		int dellen = delimiter.length();
		int j = 0;
		int count = 0;
		positions[0] = -dellen;
		int i;
		while ((i = src.indexOf(delimiter, j)) != -1) 
		{
			count++;
			positions[count] = i;
			j = i + dellen;
		}
		count++;
		positions[count] = src.length();
		String result[] = new String[count];
		for (i = 0; i < count; i++)
			result[i] = src.substring(positions[i] + dellen, positions[i + 1]);

		return result;
	}

	public static String[] splitc(String src, String d)
	{
		if (d.length() == 0 || src.length() == 0)
			return (new String[] {
				src
			});
		char delimiters[] = d.toCharArray();
		char srcc[] = src.toCharArray();
		int maxparts = srcc.length + 1;
		int start[] = new int[maxparts];
		int end[] = new int[maxparts];
		int count = 0;
		start[0] = 0;
		int s = 0;
		if (CharUtil.equalsOne(srcc[0], delimiters))
		{
			end[0] = 0;
			count++;
			s = CharUtil.findFirstDiff(srcc, 1, delimiters);
			if (s == -1)
				return (new String[] {
					"", ""
				});
			start[1] = s;
		}
		do
		{
			int e = CharUtil.findFirstEqual(srcc, s, delimiters);
			if (e == -1)
			{
				end[count] = srcc.length;
				break;
			}
			end[count] = e;
			count++;
			s = CharUtil.findFirstDiff(srcc, e, delimiters);
			if (s == -1)
			{
				start[count] = end[count] = srcc.length;
				break;
			}
			start[count] = s;
		} while (true);
		String result[] = new String[++count];
		for (int i = 0; i < count; i++)
			result[i] = src.substring(start[i], end[i]);

		return result;
	}

	public static String[] splitc(String src, char delimiter)
	{
		if (src.length() == 0)
			return (new String[] {
				""
			});
		char srcc[] = src.toCharArray();
		int maxparts = srcc.length + 1;
		int start[] = new int[maxparts];
		int end[] = new int[maxparts];
		int count = 0;
		start[0] = 0;
		int s = 0;
		if (srcc[0] == delimiter)
		{
			end[0] = 0;
			count++;
			s = CharUtil.findFirstDiff(srcc, 1, delimiter);
			if (s == -1)
				return (new String[] {
					"", ""
				});
			start[1] = s;
		}
		do
		{
			int e = CharUtil.findFirstEqual(srcc, s, delimiter);
			if (e == -1)
			{
				end[count] = srcc.length;
				break;
			}
			end[count] = e;
			count++;
			s = CharUtil.findFirstDiff(srcc, e, delimiter);
			if (s == -1)
			{
				start[count] = end[count] = srcc.length;
				break;
			}
			start[count] = s;
		} while (true);
		String result[] = new String[++count];
		for (int i = 0; i < count; i++)
			result[i] = src.substring(start[i], end[i]);

		return result;
	}

	public static String compressChars(String s, char c)
	{
		int len = s.length();
		StringBuilder sb = new StringBuilder(len);
		boolean wasChar = false;
		for (int i = 0; i < len; i++)
		{
			char c1 = s.charAt(i);
			if (c1 == c)
			{
				if (wasChar)
					continue;
				wasChar = true;
			} else
			{
				wasChar = false;
			}
			sb.append(c1);
		}

		if (sb.length() == len)
			return s;
		else
			return sb.toString();
	}

	public static int indexOf(String src, String sub, int startIndex, int endIndex)
	{
		if (startIndex < 0)
			startIndex = 0;
		int srclen = src.length();
		if (endIndex > srclen)
			endIndex = srclen;
		int sublen = sub.length();
		if (sublen == 0)
			return startIndex <= srclen ? startIndex : srclen;
		int total = (endIndex - sublen) + 1;
		char c = sub.charAt(0);
label0:
		for (int i = startIndex; i < total; i++)
		{
			if (src.charAt(i) != c)
				continue;
			int j = 1;
			for (int k = i + 1; j < sublen; k++)
			{
				if (sub.charAt(j) != src.charAt(k))
					continue label0;
				j++;
			}

			return i;
		}

		return -1;
	}

	public static int indexOf(String src, char c, int startIndex, int endIndex)
	{
		if (startIndex < 0)
			startIndex = 0;
		int srclen = src.length();
		if (endIndex > srclen)
			endIndex = srclen;
		for (int i = startIndex; i < endIndex; i++)
			if (src.charAt(i) == c)
				return i;

		return -1;
	}

	public static int indexOfIgnoreCase(String src, char c, int startIndex, int endIndex)
	{
		if (startIndex < 0)
			startIndex = 0;
		int srclen = src.length();
		if (endIndex > srclen)
			endIndex = srclen;
		c = Character.toLowerCase(c);
		for (int i = startIndex; i < endIndex; i++)
			if (Character.toLowerCase(src.charAt(i)) == c)
				return i;

		return -1;
	}

	public static int indexOfIgnoreCase(String src, String subS)
	{
		return indexOfIgnoreCase(src, subS, 0, src.length());
	}

	public static int indexOfIgnoreCase(String src, String subS, int startIndex)
	{
		return indexOfIgnoreCase(src, subS, startIndex, src.length());
	}

	public static int indexOfIgnoreCase(String src, String sub, int startIndex, int endIndex)
	{
		if (startIndex < 0)
			startIndex = 0;
		int srclen = src.length();
		if (endIndex > srclen)
			endIndex = srclen;
		int sublen = sub.length();
		if (sublen == 0)
			return startIndex <= srclen ? startIndex : srclen;
		sub = sub.toLowerCase();
		int total = (endIndex - sublen) + 1;
		char c = sub.charAt(0);
label0:
		for (int i = startIndex; i < total; i++)
		{
			if (Character.toLowerCase(src.charAt(i)) != c)
				continue;
			int j = 1;
			for (int k = i + 1; j < sublen; k++)
			{
				char source = Character.toLowerCase(src.charAt(k));
				if (sub.charAt(j) != source)
					continue label0;
				j++;
			}

			return i;
		}

		return -1;
	}

	public static int lastIndexOfIgnoreCase(String s, String subS)
	{
		return lastIndexOfIgnoreCase(s, subS, s.length(), 0);
	}

	public static int lastIndexOfIgnoreCase(String src, String subS, int startIndex)
	{
		return lastIndexOfIgnoreCase(src, subS, startIndex, 0);
	}

	public static int lastIndexOfIgnoreCase(String src, String sub, int startIndex, int endIndex)
	{
		int sublen = sub.length();
		int srclen = src.length();
		if (sublen == 0)
			return startIndex <= srclen ? startIndex >= -1 ? startIndex : -1 : srclen;
		sub = sub.toLowerCase();
		int total = srclen - sublen;
		if (total < 0)
			return -1;
		if (startIndex >= total)
			startIndex = total;
		if (endIndex < 0)
			endIndex = 0;
		char c = sub.charAt(0);
label0:
		for (int i = startIndex; i >= endIndex; i--)
		{
			if (Character.toLowerCase(src.charAt(i)) != c)
				continue;
			int j = 1;
			for (int k = i + 1; j < sublen; k++)
			{
				char source = Character.toLowerCase(src.charAt(k));
				if (sub.charAt(j) != source)
					continue label0;
				j++;
			}

			return i;
		}

		return -1;
	}

	public static int lastIndexOf(String src, String sub, int startIndex, int endIndex)
	{
		int sublen = sub.length();
		int srclen = src.length();
		if (sublen == 0)
			return startIndex <= srclen ? startIndex >= -1 ? startIndex : -1 : srclen;
		int total = srclen - sublen;
		if (total < 0)
			return -1;
		if (startIndex >= total)
			startIndex = total;
		if (endIndex < 0)
			endIndex = 0;
		char c = sub.charAt(0);
label0:
		for (int i = startIndex; i >= endIndex; i--)
		{
			if (src.charAt(i) != c)
				continue;
			int j = 1;
			for (int k = i + 1; j < sublen; k++)
			{
				if (sub.charAt(j) != src.charAt(k))
					continue label0;
				j++;
			}

			return i;
		}

		return -1;
	}

	public static int lastIndexOf(String src, char c, int startIndex, int endIndex)
	{
		int total = src.length() - 1;
		if (total < 0)
			return -1;
		if (startIndex >= total)
			startIndex = total;
		if (endIndex < 0)
			endIndex = 0;
		for (int i = startIndex; i >= endIndex; i--)
			if (src.charAt(i) == c)
				return i;

		return -1;
	}

	public static int lastIndexOfIgnoreCase(String src, char c, int startIndex, int endIndex)
	{
		int total = src.length() - 1;
		if (total < 0)
			return -1;
		if (startIndex >= total)
			startIndex = total;
		if (endIndex < 0)
			endIndex = 0;
		c = Character.toLowerCase(c);
		for (int i = startIndex; i >= endIndex; i--)
			if (Character.toLowerCase(src.charAt(i)) == c)
				return i;

		return -1;
	}

	public static int lastIndexOfWhitespace(String src)
	{
		return lastIndexOfWhitespace(src, src.length(), 0);
	}

	public static int lastIndexOfWhitespace(String src, int startIndex)
	{
		return lastIndexOfWhitespace(src, startIndex, 0);
	}

	public static int lastIndexOfWhitespace(String src, int startIndex, int endIndex)
	{
		int total = src.length() - 1;
		if (total < 0)
			return -1;
		if (startIndex >= total)
			startIndex = total;
		if (endIndex < 0)
			endIndex = 0;
		for (int i = startIndex; i >= endIndex; i--)
			if (Character.isWhitespace(src.charAt(i)))
				return i;

		return -1;
	}

	public static int lastIndexOfNonWhitespace(String src)
	{
		return lastIndexOfNonWhitespace(src, src.length(), 0);
	}

	public static int lastIndexOfNonWhitespace(String src, int startIndex)
	{
		return lastIndexOfNonWhitespace(src, startIndex, 0);
	}

	public static int lastIndexOfNonWhitespace(String src, int startIndex, int endIndex)
	{
		int total = src.length() - 1;
		if (total < 0)
			return -1;
		if (startIndex >= total)
			startIndex = total;
		if (endIndex < 0)
			endIndex = 0;
		for (int i = startIndex; i >= endIndex; i--)
			if (!Character.isWhitespace(src.charAt(i)))
				return i;

		return -1;
	}

	public static boolean startsWithIgnoreCase(String src, String subS)
	{
		return startsWithIgnoreCase(src, subS, 0);
	}

	public static boolean startsWithIgnoreCase(String src, String subS, int startIndex)
	{
		String sub = subS.toLowerCase();
		int sublen = sub.length();
		if (startIndex + sublen > src.length())
			return false;
		int j = 0;
		for (int i = startIndex; j < sublen; i++)
		{
			char source = Character.toLowerCase(src.charAt(i));
			if (sub.charAt(j) != source)
				return false;
			j++;
		}

		return true;
	}

	public static boolean endsWithIgnoreCase(String src, String subS)
	{
		String sub = subS.toLowerCase();
		int sublen = sub.length();
		int j = 0;
		int i = src.length() - sublen;
		if (i < 0)
			return false;
		while (j < sublen) 
		{
			char source = Character.toLowerCase(src.charAt(i));
			if (sub.charAt(j) != source)
				return false;
			j++;
			i++;
		}
		return true;
	}

	public static boolean startsWithChar(String s, char c)
	{
		if (s.length() == 0)
			return false;
		return s.charAt(0) == c;
	}

	public static boolean endsWithChar(String s, char c)
	{
		if (s.length() == 0)
			return false;
		return s.charAt(s.length() - 1) == c;
	}

	public static int count(String source, String sub)
	{
		return count(source, sub, 0);
	}

	public static int count(String source, String sub, int start)
	{
		int count = 0;
		int j = start;
		int sublen = sub.length();
		if (sublen == 0)
			return 0;
		do
		{
			int i = source.indexOf(sub, j);
			if (i != -1)
			{
				count++;
				j = i + sublen;
			} else
			{
				return count;
			}
		} while (true);
	}

	public static int count(String source, char c)
	{
		return count(source, c, 0);
	}

	public static int count(String source, char c, int start)
	{
		int count = 0;
		int j = start;
		do
		{
			int i = source.indexOf(c, j);
			if (i != -1)
			{
				count++;
				j = i + 1;
			} else
			{
				return count;
			}
		} while (true);
	}

	public static int countIgnoreCase(String source, String sub)
	{
		int count = 0;
		int j = 0;
		int sublen = sub.length();
		if (sublen == 0)
			return 0;
		do
		{
			int i = indexOfIgnoreCase(source, sub, j);
			if (i != -1)
			{
				count++;
				j = i + sublen;
			} else
			{
				return count;
			}
		} while (true);
	}

	public static int[] indexOf(String s, String arr[])
	{
		return indexOf(s, arr, 0);
	}

	public static int[] indexOf(String s, String arr[], int start)
	{
		int arrLen = arr.length;
		int index = 0x7fffffff;
		int last = -1;
		for (int j = 0; j < arrLen; j++)
		{
			int i = s.indexOf(arr[j], start);
			if (i != -1 && i < index)
			{
				index = i;
				last = j;
			}
		}

		return last != -1 ? (new int[] {
			last, index
		}) : null;
	}

	public static int[] indexOfIgnoreCase(String s, String arr[])
	{
		return indexOfIgnoreCase(s, arr, 0);
	}

	public static int[] indexOfIgnoreCase(String s, String arr[], int start)
	{
		int arrLen = arr.length;
		int index = 0x7fffffff;
		int last = -1;
		for (int j = 0; j < arrLen; j++)
		{
			int i = indexOfIgnoreCase(s, arr[j], start);
			if (i != -1 && i < index)
			{
				index = i;
				last = j;
			}
		}

		return last != -1 ? (new int[] {
			last, index
		}) : null;
	}

	public static int[] lastIndexOf(String s, String arr[])
	{
		return lastIndexOf(s, arr, s.length());
	}

	public static int[] lastIndexOf(String s, String arr[], int fromIndex)
	{
		int arrLen = arr.length;
		int index = -1;
		int last = -1;
		for (int j = 0; j < arrLen; j++)
		{
			int i = s.lastIndexOf(arr[j], fromIndex);
			if (i != -1 && i > index)
			{
				index = i;
				last = j;
			}
		}

		return last != -1 ? (new int[] {
			last, index
		}) : null;
	}

	public static int[] lastIndexOfIgnoreCase(String s, String arr[])
	{
		return lastIndexOfIgnoreCase(s, arr, s.length());
	}

	public static int[] lastIndexOfIgnoreCase(String s, String arr[], int fromIndex)
	{
		int arrLen = arr.length;
		int index = -1;
		int last = -1;
		for (int j = 0; j < arrLen; j++)
		{
			int i = lastIndexOfIgnoreCase(s, arr[j], fromIndex);
			if (i != -1 && i > index)
			{
				index = i;
				last = j;
			}
		}

		return last != -1 ? (new int[] {
			last, index
		}) : null;
	}

	public static boolean equals(String as[], String as1[])
	{
		if (as.length != as1.length)
			return false;
		for (int i = 0; i < as.length; i++)
			if (!as[i].equals(as1[i]))
				return false;

		return true;
	}

	public static boolean equalsIgnoreCase(String as[], String as1[])
	{
		if (as.length != as1.length)
			return false;
		for (int i = 0; i < as.length; i++)
			if (!as[i].equalsIgnoreCase(as1[i]))
				return false;

		return true;
	}

	public static String replace(String s, String sub[], String with[])
	{
		if (sub.length != with.length || sub.length == 0)
			return s;
		int start = 0;
		StringBuilder buf = new StringBuilder(s.length());
		do
		{
			int res[] = indexOf(s, sub, start);
			if (res != null)
			{
				int end = res[1];
				buf.append(s.substring(start, end));
				buf.append(with[res[0]]);
				start = end + sub[res[0]].length();
			} else
			{
				buf.append(s.substring(start));
				return buf.toString();
			}
		} while (true);
	}

	public static String replaceIgnoreCase(String s, String sub[], String with[])
	{
		if (sub.length != with.length || sub.length == 0)
			return s;
		int start = 0;
		StringBuilder buf = new StringBuilder(s.length());
		do
		{
			int res[] = indexOfIgnoreCase(s, sub, start);
			if (res != null)
			{
				int end = res[1];
				buf.append(s.substring(start, end));
				buf.append(with[res[0]]);
				start = end + sub[0].length();
			} else
			{
				buf.append(s.substring(start));
				return buf.toString();
			}
		} while (true);
	}

	public static int equalsOne(String src, String dest[])
	{
		for (int i = 0; i < dest.length; i++)
			if (src.equals(dest[i]))
				return i;

		return -1;
	}

	public static int equalsOneIgnoreCase(String src, String dest[])
	{
		for (int i = 0; i < dest.length; i++)
			if (src.equalsIgnoreCase(dest[i]))
				return i;

		return -1;
	}

	public static int startsWithOne(String src, String dest[])
	{
		for (int i = 0; i < dest.length; i++)
		{
			String m = dest[i];
			if (m != null && src.startsWith(m))
				return i;
		}

		return -1;
	}

	public static int startsWithOneIgnoreCase(String src, String dest[])
	{
		for (int i = 0; i < dest.length; i++)
		{
			String m = dest[i];
			if (m != null && startsWithIgnoreCase(src, m))
				return i;
		}

		return -1;
	}

	public static int endsWithOne(String src, String dest[])
	{
		for (int i = 0; i < dest.length; i++)
		{
			String m = dest[i];
			if (m != null && src.endsWith(m))
				return i;
		}

		return -1;
	}

	public static int endsWithOneIgnoreCase(String src, String dest[])
	{
		for (int i = 0; i < dest.length; i++)
		{
			String m = dest[i];
			if (m != null && endsWithIgnoreCase(src, m))
				return i;
		}

		return -1;
	}

	public static int indexOfChars(String string, String chars)
	{
		return indexOfChars(string, chars, 0);
	}

	public static int indexOfChars(String string, String chars, int startindex)
	{
		int stringLen = string.length();
		int charsLen = chars.length();
		if (startindex < 0)
			startindex = 0;
		for (int i = startindex; i < stringLen; i++)
		{
			char c = string.charAt(i);
			for (int j = 0; j < charsLen; j++)
				if (c == chars.charAt(j))
					return i;

		}

		return -1;
	}

	public static int indexOfChars(String string, char chars[])
	{
		return indexOfChars(string, chars, 0);
	}

	public static int indexOfChars(String string, char chars[], int startindex)
	{
		int stringLen = string.length();
		int charsLen = chars.length;
		for (int i = startindex; i < stringLen; i++)
		{
			char c = string.charAt(i);
			for (int j = 0; j < charsLen; j++)
				if (c == chars[j])
					return i;

		}

		return -1;
	}

	public static int indexOfWhitespace(String string)
	{
		return indexOfWhitespace(string, 0, string.length());
	}

	public static int indexOfWhitespace(String string, int startindex)
	{
		return indexOfWhitespace(string, startindex, string.length());
	}

	public static int indexOfWhitespace(String string, int startindex, int endindex)
	{
		for (int i = startindex; i < endindex; i++)
			if (CharUtil.isWhitespace(string.charAt(i)))
				return i;

		return -1;
	}

	public static int indexOfNonWhitespace(String string)
	{
		return indexOfNonWhitespace(string, 0, string.length());
	}

	public static int indexOfNonWhitespace(String string, int startindex)
	{
		return indexOfNonWhitespace(string, startindex, string.length());
	}

	public static int indexOfNonWhitespace(String string, int startindex, int endindex)
	{
		for (int i = startindex; i < endindex; i++)
			if (!CharUtil.isWhitespace(string.charAt(i)))
				return i;

		return -1;
	}

	public static String stripLeadingChar(String string, char c)
	{
		if (string.length() > 0 && string.charAt(0) == c)
			return string.substring(1);
		else
			return string;
	}

	public static String stripTrailingChar(String string, char c)
	{
		if (string.length() > 0 && string.charAt(string.length() - 1) == c)
			return string.substring(0, string.length() - 1);
		else
			return string;
	}

	public static void trimAll(String strings[])
	{
		for (int i = 0; i < strings.length; i++)
		{
			String string = strings[i];
			if (string != null)
				strings[i] = string.trim();
		}

	}

	public static void trimDownAll(String strings[])
	{
		for (int i = 0; i < strings.length; i++)
		{
			String string = strings[i];
			if (string != null)
				strings[i] = trimDown(string);
		}

	}

	public static String trimDown(String string)
	{
		string = string.trim();
		if (string.length() == 0)
			string = null;
		return string;
	}

	public static String crop(String string)
	{
		if (string.length() == 0)
			return null;
		else
			return string;
	}

	public static void cropAll(String strings[])
	{
		for (int i = 0; i < strings.length; i++)
		{
			String string = strings[i];
			if (string != null)
				string = crop(strings[i]);
			strings[i] = string;
		}

	}

	public static String trimLeft(String src)
	{
		int len = src.length();
		int st;
		for (st = 0; st < len && CharUtil.isWhitespace(src.charAt(st)); st++);
		return st <= 0 ? src : src.substring(st);
	}

	public static String trimRight(String src)
	{
		int len = src.length();
		int count = len;
		for (; len > 0 && CharUtil.isWhitespace(src.charAt(len - 1)); len--);
		return len >= count ? src : src.substring(0, len);
	}

	public static int[] indexOfRegion(String string, String leftBoundary, String rightBoundary)
	{
		return indexOfRegion(string, leftBoundary, rightBoundary, 0);
	}

	public static int[] indexOfRegion(String string, String leftBoundary, String rightBoundary, int offset)
	{
		int ndx = offset;
		int res[] = new int[4];
		ndx = string.indexOf(leftBoundary, ndx);
		if (ndx == -1)
			return null;
		res[0] = ndx;
		ndx += leftBoundary.length();
		res[1] = ndx;
		ndx = string.indexOf(rightBoundary, ndx);
		if (ndx == -1)
		{
			return null;
		} else
		{
			res[2] = ndx;
			res[3] = ndx + rightBoundary.length();
			return res;
		}
	}

	public static int[] indexOfRegion(String string, String leftBoundary, String rightBoundary, char escape)
	{
		return indexOfRegion(string, leftBoundary, rightBoundary, escape, 0);
	}

	public static int[] indexOfRegion(String string, String leftBoundary, String rightBoundary, char escape, int offset)
	{
		int ndx = offset;
		int res[] = new int[4];
		int leftBoundaryLen;
		do
		{
			ndx = string.indexOf(leftBoundary, ndx);
			if (ndx == -1)
				return null;
			leftBoundaryLen = leftBoundary.length();
			if (ndx <= 0 || string.charAt(ndx - 1) != escape)
				break;
			boolean cont = true;
			if (ndx > 1 && string.charAt(ndx - 2) == escape)
			{
				ndx--;
				leftBoundaryLen++;
				cont = false;
			}
			if (!cont)
				break;
			ndx += leftBoundaryLen;
		} while (true);
		res[0] = ndx;
		ndx += leftBoundaryLen;
		res[1] = ndx;
		do
		{
			ndx = string.indexOf(rightBoundary, ndx);
			if (ndx == -1)
				return null;
			if (ndx > 0 && string.charAt(ndx - 1) == escape)
			{
				ndx += rightBoundary.length();
			} else
			{
				res[2] = ndx;
				res[3] = ndx + rightBoundary.length();
				return res;
			}
		} while (true);
	}

	public static String convertCharset(String source, String srcCharsetName, String newCharsetName)
		throws UnsupportedEncodingException
	{
		return new String(source.getBytes(srcCharsetName), newCharsetName);
	}

	public static String escapeJava(String string)
	{
		int strLen = string.length();
		StringBuilder sb = new StringBuilder(strLen);
		for (int i = 0; i < strLen; i++)
		{
			char c = string.charAt(i);
			switch (c)
			{
			case 8: // '\b'
				sb.append("\\b");
				break;

			case 9: // '\t'
				sb.append("\\t");
				break;

			case 10: // '\n'
				sb.append("\\n");
				break;

			case 12: // '\f'
				sb.append("\\f");
				break;

			case 13: // '\r'
				sb.append("\\r");
				break;

			case 34: // '"'
				sb.append("\\\"");
				break;

			case 92: // '\\'
				sb.append("\\\\");
				break;

			default:
				if (c < ' ' || c > '\177')
				{
					String hex = Integer.toHexString(c);
					sb.append("\\u");
					for (int k = hex.length(); k < 4; k++)
						sb.append('0');

					sb.append(hex);
				} else
				{
					sb.append(c);
				}
				break;
			}
		}

		return sb.toString();
	}

	public static String unescapeJava(String str)
	{
		char chars[] = str.toCharArray();
		StringBuilder sb = new StringBuilder(str.length());
		for (int i = 0; i < chars.length; i++)
		{
			char c = chars[i];
			if (c != '\\')
			{
				sb.append(c);
			} else
			{
				i++;
				c = chars[i];
				switch (c)
				{
				case 98: // 'b'
					sb.append('\b');
					break;

				case 116: // 't'
					sb.append('\t');
					break;

				case 110: // 'n'
					sb.append('\n');
					break;

				case 102: // 'f'
					sb.append('\f');
					break;

				case 114: // 'r'
					sb.append('\r');
					break;

				case 34: // '"'
					sb.append('"');
					break;

				case 92: // '\\'
					sb.append('\\');
					break;

				case 117: // 'u'
					char hex = (char)Integer.parseInt(new String(chars, i + 1, 4), 16);
					sb.append(hex);
					i += 4;
					break;

				default:
					throw new IllegalArgumentException((new StringBuilder("Invalid escaping character: ")).append(c).toString());
				}
			}
		}

		return sb.toString();
	}

	public static boolean isCharAtEqual(String string, int index, char charToCompare)
	{
		if (index < 0 || index >= string.length())
			return false;
		return string.charAt(index) == charToCompare;
	}

	public static String surround(String string, String fix)
	{
		return surround(string, fix, fix);
	}

	public static String surround(String string, String prefix, String suffix)
	{
		if (!string.startsWith(prefix))
			string = (new StringBuilder(String.valueOf(prefix))).append(string).toString();
		if (!string.endsWith(suffix))
			string = (new StringBuilder(String.valueOf(string))).append(suffix).toString();
		return string;
	}

	public static String prefix(String string, String prefix)
	{
		if (!string.startsWith(prefix))
			string = (new StringBuilder(String.valueOf(prefix))).append(string).toString();
		return string;
	}

	public static String suffix(String string, String suffix)
	{
		if (!string.endsWith(suffix))
			string = (new StringBuilder(String.valueOf(string))).append(suffix).toString();
		return string;
	}

	public static String cutToIndexOf(String string, String substring)
	{
		int i = string.indexOf(substring);
		if (i != -1)
			string = string.substring(0, i);
		return string;
	}

	public static String cutToIndexOf(String string, char c)
	{
		int i = string.indexOf(c);
		if (i != -1)
			string = string.substring(0, i);
		return string;
	}

	public static String cutFromIndexOf(String string, String substring)
	{
		int i = string.indexOf(substring);
		if (i != -1)
			string = string.substring(i);
		return string;
	}

	public static String cutFromIndexOf(String string, char c)
	{
		int i = string.indexOf(c);
		if (i != -1)
			string = string.substring(i);
		return string;
	}

	public static String cutPrefix(String string, String prefix)
	{
		if (string.startsWith(prefix))
			string = string.substring(prefix.length());
		return string;
	}

	public static String cutSuffix(String string, String suffix)
	{
		if (string.endsWith(suffix))
			string = string.substring(0, string.length() - suffix.length());
		return string;
	}

	public static String cutSurrounding(String string, String fix)
	{
		return cutSurrounding(string, fix, fix);
	}

	public static String cutSurrounding(String string, String prefix, String suffix)
	{
		int start = 0;
		int end = string.length();
		if (string.startsWith(prefix))
			start = prefix.length();
		if (string.endsWith(suffix))
			end -= suffix.length();
		return string.substring(start, end);
	}

	public static boolean isCharAtEscaped(String src, int ndx, char escapeChar)
	{
		if (ndx == 0)
			return false;
		ndx--;
		return src.charAt(ndx) == escapeChar;
	}

	public static int indexOfUnescapedChar(String src, char sub, char escapeChar)
	{
		return indexOfUnescapedChar(src, sub, escapeChar, 0);
	}

	public static int indexOfUnescapedChar(String src, char sub, char escapeChar, int startIndex)
	{
		if (startIndex < 0)
			startIndex = 0;
		int srclen = src.length();
		char c = '\0';
		for (int i = startIndex; i < srclen; i++)
		{
			char previous = c;
			c = src.charAt(i);
			if (c == sub && (i <= startIndex || previous != escapeChar))
				return i;
		}

		return -1;
	}

	public static String insert(String src, String insert)
	{
		return insert(src, insert, 0);
	}

	public static String insert(String src, String insert, int offset)
	{
		if (offset < 0)
			offset = 0;
		if (offset > src.length())
			offset = src.length();
		StringBuilder sb = new StringBuilder(src);
		sb.insert(offset, insert);
		return sb.toString();
	}

	public static String repeat(char c, int count)
	{
		char result[] = new char[count];
		for (int i = 0; i < count; i++)
			result[i] = c;

		return new String(result);
	}

	public static String reverse(String s)
	{
		StringBuilder result = new StringBuilder(s.length());
		for (int i = s.length() - 1; i >= 0; i--)
			result.append(s.charAt(i));

		return result.toString();
	}

	public static String maxCommonPrefix(String one, String two)
	{
		int minLength = Math.min(one.length(), two.length());
		StringBuilder sb = new StringBuilder(minLength);
		for (int pos = 0; pos < minLength; pos++)
		{
			char currentChar = one.charAt(pos);
			if (currentChar != two.charAt(pos))
				break;
			sb.append(currentChar);
		}

		return sb.toString();
	}

	public static String fromCamelCase(String input, char separator)
	{
		int length = input.length();
		StringBuilder result = new StringBuilder(length * 2);
		int resultLength = 0;
		boolean prevTranslated = false;
		for (int i = 0; i < length; i++)
		{
			char c = input.charAt(i);
			if (i > 0 || c != separator)
			{
				if (Character.isUpperCase(c))
				{
					if (!prevTranslated && resultLength > 0 && result.charAt(resultLength - 1) != separator)
					{
						result.append(separator);
						resultLength++;
					}
					c = Character.toLowerCase(c);
					prevTranslated = true;
				} else
				{
					prevTranslated = false;
				}
				result.append(c);
				resultLength++;
			}
		}

		return resultLength <= 0 ? input : result.toString();
	}

	public static String toCamelCase(String input, boolean firstCharUppercase, char separator)
	{
		int length = input.length();
		StringBuilder sb = new StringBuilder(length);
		boolean upperCase = firstCharUppercase;
		for (int i = 0; i < length; i++)
		{
			char ch = input.charAt(i);
			if (ch == separator)
				upperCase = true;
			else
			if (upperCase)
			{
				sb.append(Character.toUpperCase(ch));
				upperCase = false;
			} else
			{
				sb.append(ch);
			}
		}

		return sb.toString();
	}

	public static  String findCommonPrefix(String strings[])
	{
		StringBuilder prefix = new StringBuilder();
		int index = 0;
		char c = '\0';
		label0:
		do
		{
			for (int i = 0; i < strings.length; i++)
			{
				String s = strings[i];
				if (index == s.length())
					break label0;
				if (i == 0)
				{
					c = s.charAt(index);
					continue;
				}
				if (s.charAt(index) != c)
					break label0;
			}

			index++;
			prefix.append(c);
		} while (true);
		return prefix.length() != 0 ? prefix.toString() : "";
	}

	public static String shorten(String s, int length, String suffix)
	{
		length -= suffix.length();
		if (s.length() > length)
		{
			for (int j = length; j >= 0; j--)
			{
				if (!CharUtil.isWhitespace(s.charAt(j)))
					continue;
				length = j;
				break;
			}

			String temp = s.substring(0, length);
			s = temp.concat(suffix);
		}
		return s;
	}
}
