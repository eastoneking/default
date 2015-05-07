/*
 * create:2015年5月7日 上午11:49:50
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
public class SimpleUpdateBusiness<I> extends AbstractMybatisHttpIaBusiness<I, Integer> {

    /*
     * @see eastone.business.mybatis.AbstractMybatisHttpIaBusiness#execute(org.apache.ibatis.session.SqlSessionFactory, java.lang.String, java.util.Map)
     * @author wangds 2015年5月7日 上午11:50:21.
     */
    @Override
    protected Integer execute(SqlSessionFactory fac, String sql, I input, Map<String, Object> ctx) {
        Integer res = 0;
        res = MybatisUtil.update(fac, sql, input);
        return res;
    }

}
