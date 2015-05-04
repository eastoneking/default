/*
 * create:2015年4月25日 下午10:04:28
 * author:wangds  
 */
package eastone.business.observer;

import eastone.business.IaBizProcedure;
import eastone.common.context.Context;

/**
 * .
 * @author wangds
 *
 */
public interface InteractionBusinessObserver<IN, OUT, C extends Context> extends BizObserver<C>, IaBizProcedure<IN, OUT> {

}
