/*
 * File:SelectSQL.java
 * Type:eastone.component.database.mybatis.SelectSQL
 */
package eastone.component.database.mybatis;

import java.util.Collection;

import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.SqlSession;

/**
 * 执行Select语句.
 * <p>
 *  <ol>
 *    <li>初始版本,wangds@gmail.com,2013-10-17 12:17:52</li>
 *    <li>根据check style修改格式,by wangds@gmail.com 2013-10-27 14:36</li>
 *  </ol>
 * </p>
 * @param <R> 资源类型.
 * @author 王东石 <wangdongshi@neusoft.com>
 * @version 0.1.1
 * @since 0.1
 */
public class SelectSQL<R> extends MyBatisSQLExecutor<Collection<R>> {

	@Override
	protected Collection<R> executeOperation(
			SqlSession session,
			String commandText,
			Object parameters
	) {
		return session.selectList(commandText, parameters);
	}

}
