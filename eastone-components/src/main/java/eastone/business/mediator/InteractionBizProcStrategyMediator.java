/*
 * create:2015年5月1日 下午9:28:41
 * author:wangds  
 */
package eastone.business.mediator;

import eastone.business.Business;

/**
 * .
 * @author wangds
 *
 * @param <I> .
 * @param <O> .
 * @param <K> .
 */
public interface InteractionBizProcStrategyMediator<I,O,K, B extends Business>
extends InteractionMediator<I, O, B>, BizProcStrategyMediator<K, B>{

}
