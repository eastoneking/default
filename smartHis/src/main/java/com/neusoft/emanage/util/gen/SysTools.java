package com.neusoft.emanage.util.gen;

import java.beans.PropertyDescriptor;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.neusoft.sframe.util.GlobalVal;
import com.neusoft.sframe.util.vo.UserBean;


/**
 * @author gx 描述：是系统管理模块的工具类
 * */
public class SysTools {
	private static Logger log = LoggerFactory.getLogger(SysTools.class);

	public static String getIP(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (!checkIP(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (!checkIP(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (!checkIP(ip)) {
			ip = request.getRemoteAddr();
		}
		if("0:0:0:0:0:0:0:1".equals(ip)){
			ip = "127.0.0.1";
		}
		return ip;
	}

	private static boolean checkIP(String ip) {
		if (ip == null || ip.length() == 0 || "unkown".equalsIgnoreCase(ip)
				|| ip.split("\\.").length != 4) {
			return false;
		}
		return true;
	}

	/**
	 * 模糊匹配时将传入的参数的特殊字符(%\_)进行转义，并将前后增加通配符%
	 * 
	 * @param sqlParam
	 * @return
	 */
	public static String getSqlLikeParam(String sqlParam) {
		sqlParam = sqlParam.replace("\\", "\\\\");
		sqlParam = sqlParam.replace("%", "\\%");
		sqlParam = sqlParam.replace("_", "\\_");
		return "%" + sqlParam + "%";
	}




}
