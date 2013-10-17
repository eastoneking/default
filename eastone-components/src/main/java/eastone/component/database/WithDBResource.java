/*
 * File:WithDBResource.java
 * Type:eastone.component.database.WithDBResource
 */
package eastone.component.database;

import javax.sql.DataSource;

/**
 * 使用数据库资源接口.
 * <p>DBResouce指数据源或Session等.</p>
 * <p>
 *  <ol>
 *    <li>初始版本,wangdongshi@neusoft.com,2013-10-16 下午11:11:25</li>
 *  </ol>
 * </p>
 * @param T 数据资源,一遍为{@link DataSource}等.
 * 
 * @author 王东石 <wangdongshi@neusoft.com>
 * @version 0.1.1
 * @since 0.1
 */
public interface WithDBResource <T>{
	
	/**
	 * 获得数据资源
	 * @return
	 */
	public T getDBResource();
	
	/**
	 * 设置数据资源
	 * @param resource
	 */
	public void setDBResource(T resource);
	
}
