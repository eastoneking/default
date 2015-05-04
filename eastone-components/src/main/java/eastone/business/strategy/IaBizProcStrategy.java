/*
 * create:2015年5月2日 上午11:51:21
 * author:wangds  
 */
package eastone.business.strategy;

import eastone.business.IaBizProcedure;

/**
 * .
 * @author wangds
 *
 */
public interface IaBizProcStrategy<I,O,K> extends BizProcStrategy<K>, IaBizProcedure<I, O> {

}
