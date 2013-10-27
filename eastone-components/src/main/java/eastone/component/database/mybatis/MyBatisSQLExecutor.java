/*
 * File:MyBatisSQLExecutor.java
 * Type:eastone.component.database.mybatis.MyBatisSQLExecutor
 */
package eastone.component.database.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;

import eastone.common.Object;
import eastone.component.database.AbstractSQLExecutor;

/**
 * mybatis抽象类.
 * <p>
 *  <ol>
 *    <li>初始版本,wangds@gmail.com,2013-10-17 12:00:19</li>
 *    <li>根据check style修改格式,by wangds@gmail.com 2013-10-27 14:36</li>
 *  </ol>
 * </p>
 * @param <R> 资源类型
 * @author 王东石 <wangdongshi@neusoft.com>
 * @version 0.1.1
 * @since 0.1
 */
public abstract class MyBatisSQLExecutor<R>
	extends AbstractSQLExecutor<SqlSessionFactoryBean, R, Exception> {

	@Override
	protected R executeSQL(SqlSessionFactoryBean dBResource,
			String commandText, Object parameters) throws Exception {
		SqlSessionFactory fac = dBResource.getObject();
		SqlSession session = openSession(fac);
		R res = null;
		try {
			res = executeOperation(
					session, this.getCommandText(), this.getParameters()
				);
		} finally {
			session.close();
		}
		return res;
	}

	/**
	 * 执行SQL操作.
	 * @param session 会话.
	 * @param commandText SQL唯一标识.
	 * @param parameters 参数.
	 * @return 执行结果.
	 */
	protected abstract R executeOperation(
			SqlSession session,
			String commandText,
			java.lang.Object parameters);

	/**
	 * 建立Session.
	 * @param fac 工厂类
	 * @return Session
	 */
	protected SqlSession openSession(SqlSessionFactory fac) {
		return fac.openSession();
	}

}
