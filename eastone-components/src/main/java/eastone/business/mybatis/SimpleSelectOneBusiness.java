/*
 * create:2015年5月7日 上午11:59:10
 * author:wangds  
 */
package eastone.business.mybatis;

import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;

import eastone.common.utils.MybatisUtil;

/**
 * .
 * @author wangds
 *
 */
public class SimpleSelectOneBusiness<I, O> extends AbstractMybatisHttpIaBusiness<I, O> {

    /*
     * @see eastone.business.mybatis.AbstractMybatisHttpIaBusiness#execute(org.apache.ibatis.session.SqlSessionFactory, java.lang.String, java.lang.Object, java.util.Map)
     * @author wangds 2015年5月7日 上午11:59:27.
     */
    @Override
    protected O execute(SqlSessionFactory fac, String sql, I input, Map<String, Object> p) {
        O res = null;
        res = MybatisUtil.selectOne(fac, sql, input);
        return res;
    }

}
