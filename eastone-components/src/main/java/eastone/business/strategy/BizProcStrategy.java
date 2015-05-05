/*
 * create:2015年4月25日 下午10:11:21
 * author:wangds  
 */
package eastone.business.strategy;

import eastone.business.BizProcedure;
import eastone.common.context.InterimContext;
import eastone.common.strategy.Strategy;

/**
 * 业务处理策略.
 * @author wangds
 * 20150505 v0.1 初始版本.
 */
public interface BizProcStrategy<K> extends Strategy<K>, BizProcedure, InterimContext{
    
    
    
}
