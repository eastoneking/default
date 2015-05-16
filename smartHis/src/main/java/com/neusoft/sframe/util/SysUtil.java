package com.neusoft.sframe.util;

import java.beans.PropertyDescriptor;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.neusoft.emanage.util.gen.entity.SysUserBean;
import com.neusoft.platform.syscontext.util.StringUtil;
import com.neusoft.sframe.util.vo.UserBean;
import com.google.gson.Gson;

public class SysUtil {
	/**
	 * 获取List中指定属性的值为propertyVal的列表
	 * 
	 * @param List
	 * @param propertyName
	 * @param propertyVal
	 */
	public static List<Map<String, Object>> getSamePropertyList(
			List<Map<String, Object>> list, String propertyName,
			String propertyVal) {
		if (list == null || list.size() == 0) {
			return null;
		}
		List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
		for (Map<String, Object> map : list) {
			String val = map.get(propertyName).toString();
			if (val == null) {
				continue;
			}
			if (val.equals(propertyVal)) {
				resultList.add(map);
			}
		}
		if (resultList.size() == 0) {
			return null;
		}
		return resultList;
	}

	/**
	 * 根据传入的属性名称、遍历list返回属性值与propertyVal相等的记录
	 * 
	 * @param list
	 * @param propertyName
	 * @param propertyVal
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static <T> List<T> getSamePropertyListBean(Collection<T> list,
			String propertyName, Object propertyVal) {
		if (list == null || list.size() == 0) {
			return null;
		}
		List<T> resultList = new ArrayList<T>();
		for (T bean : list) {
			Object val = null;
			try {
				if (bean instanceof java.util.Map) {
					val = ((java.util.Map) bean).get(propertyName);
				} else {
					PropertyDescriptor p = new PropertyDescriptor(propertyName,
							bean.getClass());
					val = p.getReadMethod().invoke(bean);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (val == null) {
				continue;
			}
			if (val.equals(propertyVal)) {
				resultList.add(bean);
			}
		}
		if (resultList.size() == 0) {
			return null;
		}
		return resultList;
	}

	/**
	 * 返回与传入属性propertyName值相同的一个对象
	 * 
	 * @param list
	 * @param propertyName
	 * @param propertyVal
	 * @return
	 */
	public static <T> T getSamePropertyBean(Collection<T> list,
			String propertyName, Object propertyVal) {
		if (list == null || list.size() == 0) {
			return null;
		}
		for (T bean : list) {
			Object val = null;
			try {
				if (bean instanceof java.util.Map) {
					val = ((java.util.Map) bean).get(propertyName);
				} else {
					PropertyDescriptor p = new PropertyDescriptor(propertyName,
							bean.getClass());
					val = p.getReadMethod().invoke(bean);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (val == null) {
				continue;
			}
			if (val.equals(propertyVal)) {
				return bean;
			}
		}
		return null;
	}

	/**
	 * 获取浏览器的ip地址
	 * @param request
	 * @return
	 */
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
	
	/**
	 * 获取用户对象
	 * @param request
	 * @return
	 */
	public static UserBean getUser(HttpServletRequest request) {
		HttpSession session = request.getSession();
		UserBean user = (UserBean) session.getAttribute(GlobalVal.USER_SESSION);
		return user;
	}
	
	/**
	 * 获取浏览器类型
	 * @param request
	 * @return
	 */
	public static String getUserAgent(HttpServletRequest request) {
		String agent = request.getHeader("User-Agent");
		return agent;
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
	
	public static String ajaxFileTextEncoding(String srcStr, HttpServletRequest request){
		String res;
		String agent = request.getHeader("User-Agent").toLowerCase();
		if(agent.indexOf("firefox") > 0 || agent.indexOf("msie 10") > 0 || agent.indexOf("msie 9") > 0 || agent.indexOf("chrome") > 0){
			try {
				res = new String(srcStr.getBytes("UTF-8"), "ISO8859-1");
				return res;
			} catch (UnsupportedEncodingException e) {
				//log.error(e.getMessage());
			} 
		}else if(agent.indexOf("msie 8") > 0){
			return srcStr;
		}
		
		return srcStr;
	}
	
	/**
	 * 比较传入的两个javaBean内容是否一致，不比较last_update_user_id,last_update_timestamp
	 * @param obj1
	 * @param obj2
	 * @return
	 */
	public static <T> String checkBean(T obj1,T obj2){
		Class clazz = obj1.getClass();
		Field[] fields = clazz.getDeclaredFields();
		Map<String,String> map = new HashMap<String, String>();
		for(Field field:fields){
			try {
				PropertyDescriptor pd = new PropertyDescriptor(field.getName(),  
				        clazz);
				 Method getMethod = pd.getReadMethod();//获得get方法  
				 Object o1 = getMethod.invoke(obj1);
				 Object o2 = getMethod.invoke(obj2);
				 if((o1 == null && o2 == null)){
					 continue;
				 }
				 if((o1 == null || o2 == null)){
					 map.put(field.getName(), ":"+o1+"--》"+o2);
					 continue;
				 }
				 if(o1 instanceof String){
					 if(!o1.equals(o2)){
						 map.put(field.getName(), ":"+o1+"--》"+o2);
					 }
				 }else if(o1 instanceof BigDecimal){
					 if(((BigDecimal) o1).compareTo((BigDecimal) o2) != 0){
						 map.put(field.getName(), ":"+o1+"--》"+o2);
					 }
				 }else if(o1 instanceof Timestamp){
					if(((Timestamp) o1).getTime() != ((Timestamp) o2).getTime()){
						 map.put(field.getName(), ":"+o1+"--》"+o2);
					 }
				 }else if(o1 instanceof Date){
					 if(((Date) o1).getTime() != ((Date) o2).getTime()){
						 map.put(field.getName(), ":"+o1+"--》"+o2);
					 }
				 }else if(o1 instanceof Integer){
					 if(((Integer) o1).intValue() == ((Integer) o2).intValue() ){
						 map.put(field.getName(), ":"+o1+"--》"+o2);
					 }
				 }else{
					 if(!o1.toString().equals(o2.toString()) ){
						 map.put(field.getName(), ":"+o1+"--》"+o2);
					 }
				 }
			} catch (Exception e) {
				e.printStackTrace();
			} 
			
		}
		if(map.size() > 0){
			return new Gson().toJson(map);
		}else{
			return "";
		}
	}
	
	/**
	 * 当obj值存在时向map中插入<key, obj>的键值对，主要用于向查询功能添加参数
	 * 
	 * @param map map对象
	 * @param key key值
	 * @param obj value值
	 * @param fixed 自动加前缀后缀，用于模糊查询
	 */
	public static void putInMapWhenExists(Map<String, Object> map, String key, Object obj, boolean fixed) {
		// obj为空或空字符串时，不向map中添加值
		if (obj == null || obj instanceof String && StringUtil.isEmpty((String) obj)) {
			return;
		}
		// 模糊查询时自动添加【%】
		if (fixed) {
			obj = "%" + String.valueOf(obj) + "%";
		}
		map.put(key, obj);
	}

	/**
	 * 取得登录用户
	 * 		// 准备创建时间
		Date date = new Date();
		issueUserCreateCoinBean.setCreateGSCStartDate(new Timestamp(date.getTime()));
	 * @param request HttpServletRequest
	 * @return SysUserBean
	 */
	public static SysUserBean getLoginUser(HttpServletRequest request) {
		if (request != null && request.getSession() != null) {
			return (SysUserBean) request.getSession().getAttribute(GlobalVal.USER_SESSION);
		} else {
			return null;
		}
	}
	/**
	 * copyBean对象，复制一个bean对象
	 * @author lukai
	 * @param bean
	 * @return
	 */
	public static <T> T copyBean(T bean) {
		Class<T> beanClass = (Class<T>) bean.getClass();
		T resultBean = null;
		try {
			resultBean = beanClass.newInstance();//创建需要返回的bean
			Class<T> resultClass = (Class<T>) resultBean.getClass();//获取需要返回的bean的class对象
			Field[] resultFields = resultClass.getDeclaredFields();//获取需要返回的bean的所有字段
			
			Field[] fields = beanClass.getDeclaredFields();//获取所有字段
			for (int i = 0; i < fields.length; i++) {
				String fieldName = fields[i].getName();//获取所有字段名称
				Object filedValue=null;
				int typeInt= fields[i].getModifiers();//获取字段的类型
				//获取字段的类型申明表，8静态，2私有，16final  =26，类型26为静态常量不做处理 如:serialVersionUID
				if(typeInt!=26){
					fields[i].setAccessible(true);//设置访问权限
					filedValue = fields[i].get(bean);//获取所有字段的值
					resultFields[i].setAccessible(true);//设置访问权限
					resultFields[i].set(resultBean,filedValue);//设置返对象中的字段的值
				}
			}
			
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return resultBean;
	}
	
	/**
	 * 将map转为bean对象
	 * @author lukai
	 * @param paramap  需要转换的map
	 * @param beanclass  bean的class类型
	 * @return
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	public static <T> T mapToBean(Map<String, Object> paramap,Class<T> beanclass) throws IllegalArgumentException, IllegalAccessException, InstantiationException{
		T bean = beanclass.newInstance();
		//		Class<T> beanClass = (Class<T>) bean.getClass();
		Field[] fields = beanclass.getDeclaredFields();//获取所有字段
		for (int i = 0; i < fields.length; i++) {
			String fieldName = fields[i].getName();//获取所有字段名称
			int typeInt= fields[i].getModifiers();//获取字段的类型
			//获取字段的类型申明表，8静态，2私有，16final  =26，类型26为静态常量不做处理 如:serialVersionUID
			if(typeInt!=26){
				fields[i].setAccessible(true);//设置访问权限
				if(paramap.get(fieldName)!=null){
					fields[i].set(bean,paramap.get(fieldName));//设置bean对象的值
				}
			}
			
		}
		
		return bean;
	}
	
	/**
	 * 取得登录用户
	 * 		// 准备创建时间

	 * @param request HttpServletRequest
	 * @return SysUserBean
	 */
	public static Timestamp getNowTime() {
		Date date = new Date();
		return new Timestamp(date.getTime());
	}
	/**
	 * double科学记数法
	 * @param value
	 * @return
	 */
	  public static String formatNum(double value)
	     {
	         String retValue = null;
	         DecimalFormat df = new DecimalFormat();
	         df.setMinimumFractionDigits(0);
	         df.setMaximumFractionDigits(6);
	         retValue = df.format(value);
	         retValue = retValue.replaceAll(",", "");
	         return retValue;  
	    }
	  /**
	   * double类的精度处理
	   * @author lukai 
	   * @param value double数据. 
	   * @param scale 精度位数(保留的小数位数).  
	   * @param roundingMode  精度取值方式.  
	   * @return
	   */
	  public static double round(double value, int scale, int roundingMode) {   
	        BigDecimal bd = new BigDecimal(Double.toString(value));   
	        bd = bd.setScale(scale, roundingMode);   
	        double d = bd.doubleValue();   
	        bd = null;   
	        return d;   
	  }   
	  /**
	   * double 相加
	   * @author lukai
	   * @param d1
	   * @param d2
	   * @return
	   */
	  public static double sum(double d1,double d2){ 
	        BigDecimal bd1 = new BigDecimal(Double.toString(d1)); 
	        BigDecimal bd2 = new BigDecimal(Double.toString(d2)); 
	        return bd1.add(bd2).doubleValue(); 
	  } 
	  /**
	   * double相减
	   * @author lukai
	   * @param d1
	   * @param d2
	   * @return
	   */
	  public static double sub(double d1,double d2){ 
	        BigDecimal bd1 = new BigDecimal(Double.toString(d1)); 
	        BigDecimal bd2 = new BigDecimal(Double.toString(d2)); 
	        return bd1.subtract(bd2).doubleValue(); 
	  } 
	  /**
	   * 相乘
	   * @author lukai
	   * @param d1
	   * @param d2
	   * @return
	   */
	  public static double mul(double d1,double d2){ 
	        BigDecimal bd1 = new BigDecimal(Double.toString(d1)); 
	        BigDecimal bd2 = new BigDecimal(Double.toString(d2)); 
	        return bd1.multiply(bd2).doubleValue(); 
	  } 
	  /**
	   * 除法
	   * @author lukai
	   * @param d1
	   * @param d2
	   * @param scale  四舍五入后保留的小数位
	   * @return
	   */
	  public static double div(double d1,double d2,int scale){ 
	        //  当然在此之前，你要判断分母是否为0，   
	        //  为0你可以根据实际需求做相应的处理 

	        BigDecimal bd1 = new BigDecimal(Double.toString(d1)); 
	        BigDecimal bd2 = new BigDecimal(Double.toString(d2)); 
	        return bd1.divide 
	               (bd2,scale,BigDecimal.ROUND_DOWN).doubleValue(); 
	   } 

	  
	  
	  private static boolean isMatch(String regex, String orginal){
			if (orginal == null || orginal.trim().equals("")) {
	            return false;
	        }
			Pattern pattern = Pattern.compile(regex);
			Matcher isNum = pattern.matcher(orginal);
			return isNum.matches();
		}
	  	/**
	  	 * 校验字符串是否为正整数
	  	 * @author lukai
	  	 * @param orginal
	  	 * @return
	  	 */
		public static boolean isPositiveInteger(String orginal) {
			return isMatch("^\\+{0,1}[1-9]\\d*", orginal);
		}
		/**
		 * 校验负整数
		 * @author lukai
		 * @param orginal
		 * @return
		 */
		public static boolean isNegativeInteger(String orginal) {
			return isMatch("^-[1-9]\\d*", orginal);
		}
		
		public static boolean isWholeNumber(String orginal) {
			return isMatch("[+-]{0,1}0", orginal) || isPositiveInteger(orginal) || isNegativeInteger(orginal);
		}
		
		public static boolean isPositiveDecimal(String orginal){
			return isMatch("\\+{0,1}[0]\\.[1-9]*|\\+{0,1}[1-9]\\d*\\.\\d*", orginal);
		}
		
		public static boolean isNegativeDecimal(String orginal){
			return isMatch("^-[0]\\.[1-9]*|^-[1-9]\\d*\\.\\d*", orginal);
		}
		
		public static boolean isDecimal(String orginal){
			return isMatch("[-+]{0,1}\\d+\\.\\d*|[-+]{0,1}\\d*\\.\\d+", orginal);
		}
		
		public static boolean isRealNumber(String orginal){
			return isWholeNumber(orginal) || isDecimal(orginal);
		}
	  
	  
	  
}