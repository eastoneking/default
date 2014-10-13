/*
 * create:2014年10月12日 下午8:48:44
 * author:wangds  
 */
package eastone.sqlgen;

import java.util.List;

/**
 * .
 * @author wangds
 *
 */
public interface SqlExpressionTree extends SqlExpression{
    List<SqlExpression> branches();
    SqlExpression branch(int idx);
}
