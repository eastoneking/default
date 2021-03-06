/*
 * create:2015年5月2日 上午11:51:21
 * author:wangds  
 */
package eastone.business.strategy;

import eastone.business.IaBizProcedure;

/**
 * 交互业务处理策略.
 * @author wangds
 * 20150505 v0.1 初始版本.
 */
public interface IaBizProcStrategy<I,O,K> extends BizProcStrategy<K>, IaBizProcedure<I, O> {

}
