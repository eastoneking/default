/*
 * create:2015年4月25日 下午10:10:38
 * author:wangds  
 */
package eastone.business.strategy;

import java.util.Collection;

import eastone.business.BizProcedure;
import eastone.common.context.Context;
import eastone.common.strategy.StrategyContext;

/**
 * 业务处理策略上下文.
 * @author wangds
 * 20150505 v0.1 初始版本.
 */
public interface BizProcStrategyContext<K> extends StrategyContext<K>, Context {

    <P extends BizProcedure> void registorBizProcedure(P proc);
    <P extends BizProcedure> void registorBizProcedures(Collection<P> procs);
    <P extends BizProcedure> void unregistorBizProcedure(P proc);
    <P extends BizProcedure> void unregistorBizProcedures(Collection<P> procs);
    Collection<BizProcedure> getBizProcedures();
}
