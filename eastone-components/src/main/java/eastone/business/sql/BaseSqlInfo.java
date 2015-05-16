/*
 * create:2015年5月16日 上午12:23:35
 * author:wangds  
 */
package eastone.business.sql;

import eastone.common.GeneralParentObject;
import eastone.common.context.DefaultMapAsEnvironment;
import eastone.common.context.Environment;

/**
 * .
 * @author wangds
 *
 */
public class BaseSqlInfo extends GeneralParentObject implements SqlInfo {

    private Environment environment = new DefaultMapAsEnvironment();
    private String sqlText;

    /*
     * @see eastone.business.sql.SqlInfo#setSql(java.lang.String)
     * @author wangds 2015年5月16日 上午12:23:36.
     */
    @Override
    public void setSql(String sql) {
        this.sqlText = sql;
    }

    /*
     * @see eastone.business.sql.SqlInfo#getSql()
     * @author wangds 2015年5月16日 上午12:23:36.
     */
    @Override
    public String getSql() {
        return this.sqlText;
    }

    /*
     * @see eastone.business.sql.SqlInfo#setEnvironment(eastone.common.context.Environment)
     * @author wangds 2015年5月16日 上午12:23:36.
     */
    @Override
    public void setEnvironment(Environment env) {
        this.environment = env;
    }

    /*
     * @see eastone.business.sql.SqlInfo#getEnvironment()
     * @author wangds 2015年5月16日 上午12:23:36.
     */
    @Override
    public Environment getEnvironment() {
        return this.environment;
    }

}
