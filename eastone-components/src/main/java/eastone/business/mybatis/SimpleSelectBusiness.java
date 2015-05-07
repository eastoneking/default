/*
 * create:2015年5月7日 上午11:53:09
 * author:wangds  
 */
package eastone.business.mybatis;

import java.util.Collection;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;

import eastone.common.utils.MybatisUtil;

/**
 * .
 * @author wangds
 *
 */
public class SimpleSelectBusiness<I, O> extends AbstractMybatisHttpIaBusiness<I, Collection<O>> {

    /*
     * @see eastone.business.mybatis.AbstractMybatisHttpIaBusiness#execute(org.apache.ibatis.session.SqlSessionFactory, java.lang.String, java.lang.Object, java.util.Map)
     * @author wangds 2015年5月7日 上午11:55:13.
     */
    @Override
    protected Collection<O> execute(SqlSessionFactory fac, String sql, I input, Map<String, Object> p) {
        Collection<O> res = null;
        res = MybatisUtil.selectList(fac, sql, input, -1, -1);
        return res;
    }

}
