package com.neusoft.sframe.util;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.neusoft.emanage.baseEasyUi.vo.EasyUiBaseBean;

public class EasyUIQueryUtil {
	
	
	
	/**
	 * 处理easy ui输入参数处理，此方法只做第一层的处理，即：如果param中有符合类型的对象，只取出对象
	 * @param baseEntity
	 * @return
	 */
	public static Map<String,Object> easyUIparamToMap(EasyUiBaseBean easyUiBaseBean){
//		offset,pagesize
		//		普通字段处理
		Map<String, Object> resultMap = beanToMapNotNull(easyUiBaseBean);
		//父类处理（即：EasyUiBaseBean中的字段的处理）
		Class chlCls = easyUiBaseBean.getClass();
		
		Class superCls = chlCls.getSuperclass();//获取当前类的父类
		if(!Object.class.equals(superCls)){
			Field[] fields = superCls.getDeclaredFields();//获取所有字段
			for (int i = 0; i < fields.length; i++) {
				String fieldName = fields[i].getName();//获取所有字段名称
				Object filedValue=null;
				try {
					int typeInt= fields[i].getModifiers();//获取字段的类型
					//获取字段的类型申明表，8静态，2私有，16final  =26，类型26为静态常量不做处理 如:serialVersionUID
					if(typeInt!=26){
						fields[i].setAccessible(true);//设置访问权限
						filedValue = fields[i].get(easyUiBaseBean);//获取所有字段的值
					}
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
				resultMap.put(fieldName,filedValue);
			}
			
			//（（第几页-1）*每页显示行数）+1。分页开始点
			if(easyUiBaseBean.getPage()==null){
				resultMap.put("offset", null);
				//每页显示多少条数据
				resultMap.put("pagesize", null);
				return resultMap;
			}
			if(easyUiBaseBean.getRows()==null){
				resultMap.put("offset", null);
				//每页显示多少条数据
				resultMap.put("pagesize", null);
				return resultMap;
			}
			int offset = (easyUiBaseBean.getPage()-1)*easyUiBaseBean.getRows();
			resultMap.put("offset", offset);
			//每页显示多少条数据
			resultMap.put("pagesize", easyUiBaseBean.getRows());
		}
		return resultMap;
		
	}
	/**
	 * 将简单（只包含存在基本类型及其封装类和string）bean类型转换为map，此方法只做第一层的处理，即：如果param中有符合类型的对象，只取出对象
	 * @param baseEntity
	 * @return
	 */
	public static Map<String,Object> beanToMap(EasyUiBaseBean easyUiBaseBean){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		//判断是否为空bean，如果是直接返回
		if(easyUiBaseBean==null){
			return resultMap; 
		}
		//获取类的class
		Class cls = easyUiBaseBean.getClass();
		
		Field[] fields = cls.getDeclaredFields();//获取所有字段
		for (int i = 0; i < fields.length; i++) {
			String fieldName = fields[i].getName();//获取所有字段名称
			Object filedValue=null;
			try {
				int typeInt= fields[i].getModifiers();//获取字段的类型
				//获取字段的类型申明表，8静态，2私有，16final  =26，类型26为静态常量，不做处理如最终serialVersionUID
				if(typeInt!=26){
					fields[i].setAccessible(true);//设置访问权限
					filedValue = fields[i].get(easyUiBaseBean);//获取所有字段的值
				}
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			resultMap.put(fieldName, filedValue==null?"":filedValue);
		}
		
		return resultMap;
		
	}
	/**
	 * 将简单（只包含存在基本类型及其封装类和string）bean类型转换为map，此方法只做第一层的处理，即：如果param中有符合类型的对象，只取出对象去掉空
	 * @param baseEntity
	 * @return
	 */
	public static Map<String,Object> beanToMapNotNull(EasyUiBaseBean easyUiBaseBean){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		//判断是否为空bean，如果是直接返回
		if(easyUiBaseBean==null){
			return resultMap; 
		}
		//获取类的class
		Class cls = easyUiBaseBean.getClass();
		
		Field[] fields = cls.getDeclaredFields();//获取所有字段
		for (int i = 0; i < fields.length; i++) {
			String fieldName = fields[i].getName();//获取所有字段名称
			Object filedValue=null;
			try {
				int typeInt= fields[i].getModifiers();//获取字段的类型
				//获取字段的类型申明表，8静态，2私有，16final  =26，类型26为静态常量，不做处理如最终serialVersionUID
				if(typeInt!=26){
					fields[i].setAccessible(true);//设置访问权限
					filedValue = fields[i].get(easyUiBaseBean);//获取所有字段的值
				}
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			if(filedValue!=null&&!"".equals(filedValue)){
				resultMap.put(fieldName, filedValue);
			}
		}
		
		return resultMap;
		
	}
	
	public static<T> Map<String, Object> retParam(List<T> rows,Integer total){
		Map<String, Object> result = new HashMap<String,Object>();
		result.put("rows", rows);
		result.put("total", total);
		
		return result;
	}
	
	/**
	 * 将给定字符窜添加或截取到指定长度长度不够时前面补0
	 * @param i
	 * @param i
	 * @return
	 */
	public static String lengthStr(int i,String str){
		//空字符串变""
		if(str==null){
			str="";
		}
		StringBuffer resultStr=new StringBuffer("");
		//长度处理，超长截取，不够前面补0
		if(str.length()<i){
			for (int j = 0; j < i-str.length(); j++) {
				resultStr.append("0");
			}
			resultStr.append(str);
		}else{
			resultStr = new StringBuffer(str.substring(0, i));
		}
		return resultStr.toString();
	}
	
}
