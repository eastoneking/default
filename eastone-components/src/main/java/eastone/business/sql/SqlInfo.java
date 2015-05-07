/*
 * create:2015年5月5日 下午3:23:46
 * author:wangds  
 */
package eastone.business.sql;

import eastone.common.context.Environment;

/**
 * .
 * @author wangds
 *
 */
public interface SqlInfo {

    void setSql(String sql);
    String getSql();

    void setEnvironment(Environment env);
    Environment getEnvironment();
}
