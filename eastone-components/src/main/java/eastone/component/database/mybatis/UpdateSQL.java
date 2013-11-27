/*
 * File:UpdateSQL.java Type:eastone.component.database.mybatis.UpdateSQL
 */
package eastone.component.database.mybatis;

import org.apache.ibatis.session.SqlSession;

/**
 * 执行update语句.
 * <p>
 * <ol>
 * <li>初始版本, by wangds@gmail.com, 2013-10-17 12:23:41</li>
 * <li>根据check style修改格式,by wangds@gmail.com 2013-10-27 14:41</li>
 * </ol>
 * </p>
 * @author 王东石 <wangdongshi@neusoft.com>
 * @version 0.1.1
 * @since 0.1
 */
public class UpdateSQL extends MyBatisSQLExecutor<Integer> {

  @Override
  protected final Integer executeOperation(
      final SqlSession session, final String commandText,
      final Object parameters) {
    int res = -1;
    try {
      res = session.update(commandText, parameters);
    } finally {
      session.commit();
    }
    return res;
  }

}
