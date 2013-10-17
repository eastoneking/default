/*
 * File:UpdateSQL.java
 * Type:eastone.component.database.mybatis.UpdateSQL
 */
package eastone.component.database.mybatis;

import org.apache.ibatis.session.SqlSession;

/**
 * 执行update语句
 * <p>
 *  <ol>
 *    <li>初始版本,wangdongshi@neusoft.com,2013-10-17 上午12:23:41</li>
 *  </ol>
 * </p>
 * @author 王东石 <wangdongshi@neusoft.com>
 * @version 0.1.1
 * @since 0.1
 */
public class UpdateSQL extends MyBatisSQLExecutor<Integer> {

	/* (non-Javadoc)
	 * @see eastone.component.database.mybatis.MyBatisSQLExecutor#executeOperation(org.apache.ibatis.session.SqlSession, java.lang.String, java.lang.Object)
	 */
	@Override
	protected Integer executeOperation(SqlSession session,
			String commandText, Object parameters) {
		int res = -1;
		try{
			res= session.update(commandText, parameters);
		}finally{
			session.commit();
		}
		return res;
	}
	
	

}
