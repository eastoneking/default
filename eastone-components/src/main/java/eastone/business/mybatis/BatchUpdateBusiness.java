/*
 * create:2015年5月7日 下午12:05:01
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
public class BatchUpdateBusiness<I> extends AbstractMybatisHttpIaBusiness<Collection<I>, Collection<int[]>> {

    private int batchSize = 100;

    /**
     * The setter method of the property batchSize.
     * @param thebatchSize the batchSize to set
     * @author wangds 2015年5月7日 下午12:07:20.
     */
    public void setBatchSize(int batchSize) {
        this.batchSize = batchSize;
    }
    /**
     * The getter method of the property batchSize.
     * @author wangds 2015年5月7日 下午12:07:24.
     * @return the batchSize.
     */
    public int getBatchSize() {
        return batchSize;
    }
    /*
     * @see eastone.business.mybatis.AbstractMybatisHttpIaBusiness#execute(org.apache.ibatis.session.SqlSessionFactory, java.lang.String, java.lang.Object, java.util.Map)
     * @author wangds 2015年5月7日 下午12:05:45.
     */
    @Override
    protected Collection<int[]> execute(SqlSessionFactory fac, String sql, Collection<I> input, Map<String, Object> p) {
        Collection<int[]> res = null;
        res = MybatisUtil.multiUpdate(fac, sql, input, batchSize );
        return res;
    }

}
