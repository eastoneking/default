/*
 * create:2015年5月5日 下午2:35:00
 * author:wangds  
 */
package eastone.business.mybatis;

import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;

import eastone.business.AbstractHttpInteractionBusiness;
import eastone.business.sql.SqlInfo;
import eastone.precasting.context.Env2MapDecorator;

/**
 * .
 * 
 * @author wangds
 *
 */
public abstract class AbstractMybatisHttpIaBusiness<I, O> extends AbstractHttpInteractionBusiness<I, O> {

    public static String SESSION_FACTORY_KEY = "BIZ_SESSION_FACTORY";
    public static String SQL_INFO_KEY = "SQL_INFO_KEY";

    private Env2MapDecorator env2MapDec = new Env2MapDecorator();

    public void setSessionFactory(SqlSessionFactory fac) {
        try {
            this.status(SESSION_FACTORY_KEY, fac);
        } catch (Exception e) {
            this.getLogger().error(e.getLocalizedMessage(), e);
        }
    }

    public SqlSessionFactory getSessionFactory() {
        SqlSessionFactory res = null;
        try {
            res = this.status(SESSION_FACTORY_KEY);
        } catch (Exception e) {
            this.getLogger().error(e.getLocalizedMessage(), e);
        }
        return res;
    }

    public <S extends SqlInfo> void setSqlInfo(S sqlInfo) {
        try {
            this.status(AbstractMybatisHttpIaBusiness.SQL_INFO_KEY, sqlInfo);
        } catch (Exception e) {
            this.getLogger().error(e.getLocalizedMessage(), e);
        }
    }

    public <S extends SqlInfo> S getSqlInfo() {
        S res = null;
        try {
            res = this.status(SQL_INFO_KEY);
        } catch (Exception e) {
            this.getLogger().error(e.getLocalizedMessage(), e);
        }
        return res;

    }

    /**
     * The getter method of the property env2MapDec.
     * 
     * @author wangds 2015年5月7日 上午9:06:01.
     * @return the env2MapDec.
     */
    public Env2MapDecorator getEnv2MapDec() {
        return env2MapDec;
    }

    /**
     * The setter method of the property env2MapDec.
     * 
     * @param theenv2MapDec
     *            the env2MapDec to set
     * @author wangds 2015年5月7日 上午9:06:09.
     */
    public void setEnv2MapDec(Env2MapDecorator env2MapDec) {
        this.env2MapDec = env2MapDec;
    }

    /*
     * @see eastone.common.processor.Processor#process()
     * 
     * @author wangds 2015年5月5日 下午2:35:51.
     */
    @Override
    public void process() {
        SqlInfo sqlinfo = this.getSqlInfo();
        String sql = sqlinfo.getSql();
        O o = null;
        SqlSessionFactory fac = this.getSessionFactory();
        this.env2MapDec.setInput(sqlinfo.getEnvironment());
        Map<String, Object> ctx = this.env2MapDec.toMap();
        o = this.execute(fac, sql, this.getInput(), ctx);
        this.setOutput(o);

    }

    /**
     * .
     * 
     * @author wangds 2015年5月7日 上午9:22:40.
     * @param factory
     * @param sql
     * @param ctx
     * @return
     */
    protected abstract O execute(SqlSessionFactory fac, String sql, I input, Map<String, Object> p);

}
