/*
 * File:InsertSQL.java
 * Type:eastone.component.database.mybatis.InsertSQL
 */
package eastone.component.database.mybatis;

import org.apache.ibatis.session.SqlSession;

/**
 * 执行Insert语句.
 * <p>
 *  <ol>
 *    <li>初始版本,wangds@gmail.com,2013-10-17 上午12:20:08</li>
 *    <li>根据check style修改格式,by wangds@gmail.com 2013-10-27 14:35</li>
 *  </ol>
 * </p>
 * @author 王东石 <wangdongshi@neusoft.com>
 * @version 0.1.1
 * @since 0.1
 */
public class InsertSQL  extends MyBatisSQLExecutor<Integer> {

	@Override
	protected Integer executeOperation(SqlSession session,
			String commandText, Object parameters) {
		int res = -1;
		try {
			res = session.insert(commandText, parameters);
		} finally {
			session.commit();
		}
		return res;
	}



}
