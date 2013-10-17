/*
 * File:SelectSQL.java
 * Type:eastone.component.database.mybatis.SelectSQL
 */
package eastone.component.database.mybatis;

import java.util.Collection;

import org.apache.ibatis.session.SqlSession;

/**
 * 执行Select语句
 * <p>
 *  <ol>
 *    <li>初始版本,wangdongshi@neusoft.com,2013-10-17 上午12:17:52</li>
 *  </ol>
 * </p>
 * @author 王东石 <wangdongshi@neusoft.com>
 * @version 0.1.1
 * @since 0.1
 */
public class SelectSQL<R> extends MyBatisSQLExecutor<Collection<R>> {

	/* (non-Javadoc)
	 * @see eastone.component.database.mybatis.MyBatisSQLExecutor#executeOperation(org.apache.ibatis.session.SqlSession, java.lang.String, java.lang.Object)
	 */
	@Override
	protected Collection<R> executeOperation(SqlSession session,
			String commandText, Object parameters) {
		return session.selectList(commandText, parameters);
	}

}
