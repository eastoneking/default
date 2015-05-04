/*
 * create:2015年5月1日 下午7:35:40
 * author:wangds  
 */
package eastone.business.mediator;

import java.util.Collection;

import eastone.business.BizProcedure;
import eastone.business.Business;
import eastone.business.strategy.BizProcStrategyContext;

/**
 * .
 * @author wangds
 *
 */
public interface BizProcStrategyMediator<K, B extends Business> extends BizMediator<B>{
    <C extends BizProcStrategyContext<K>> void setStrategyContext(C sctx);
    <C extends BizProcStrategyContext<K>> C getStrategyContext();
    <P extends BizProcedure> void registorProcedure(P proc);
    <P extends BizProcedure> void registorProcedures(Collection<P> proc);
    <P extends BizProcedure> void unregistorProcedure(P proc);
    <P extends BizProcedure> void unregistorProcedures(Collection<P> proc);
}
