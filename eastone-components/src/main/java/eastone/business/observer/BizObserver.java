/*
 * create:2015年4月25日 下午10:03:16
 * author:wangds  
 */
package eastone.business.observer;

import eastone.business.BizProcedure;
import eastone.common.context.Context;
import eastone.common.observer.Observer;
import eastone.precasting.context.ReadOnlyContext;

/**
 * .
 * @author wangds
 *
 * @param <C>
 */
public interface BizObserver<C extends Context> extends Observer, BizProcedure {

    ReadOnlyContext<C> getContext();
    void setContext(ReadOnlyContext<C> context);

}
