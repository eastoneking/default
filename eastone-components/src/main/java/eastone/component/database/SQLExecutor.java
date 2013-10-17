/*
 * File:SQLExecutor.java
 * Type:eastone.component.database.SQLExecutor
 */
package eastone.component.database;

import eastone.common.processor.Processor;
import eastone.common.processor.ResultContainer;

/**
 * SQL执行接口.
 * <p>接口用于执行SQL.因为考虑兼容myBatis方式,所以方法命名没有完全依照SQL的习惯.
 * </p>
 * <p>
 *  <ol>
 *    <li>初始版本,wangds@gmail.com,2013-10-16 下午10:21:48</li>
 *  </ol>
 * </p>
 * @param S 数据库资源,DataSource等.
 * @param R 结果类型.
 * @param E 执行时可能发生的异常.
 * @author 王东石 <wangds@gmail.com>
 * @version 0.1.1
 * @since 0.1
 */
public interface SQLExecutor<S,R,E extends Exception> extends Processor<E>,ResultContainer<R>,WithDBResource<S>{
	
	
	
	/**
	 * 设置要执行SQL文本.
	 * <p>对于JDBC,是SQL语句;对于MyBatis等,是用来唯一标识SQL的ID.</p>
	 * 
	 * @param commandText SQL文本
	 */
	public void setCommandText(String commandText);
	
	/**
	 * 获得要执行的SQL文本.
	 * @return SQL文本
	 */
	public String getCommandText();
	
	/**
	 * 执行SQL时所需的参数.
	 * @param T 参数类型.
	 * <p>JDBC接口时,T类型应该为"Object[]".</p>
	 * @param parameters 参数值.
	 * 
	 */
	public <T> void setParameters(T parameters);
	
	/**
	 * 获得参数值
	 * @return 参数值
	 */
	public <T> T getParameters();
		
}
