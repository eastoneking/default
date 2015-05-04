/*
 * create:2015年4月25日 下午10:11:21
 * author:wangds  
 */
package eastone.business.strategy;

import java.util.Collection;

import eastone.business.BizProcedure;
import eastone.common.strategy.Strategy;

/**
 * .
 * @author wangds
 *
 */
public interface BizProcStrategy<K> extends Strategy<K>, BizProcedure{
    
    <P extends BizProcedure> void registorBizProcedure(P proc);
    <P extends BizProcedure> void registorBizProcedures(Collection<P> procs);
    <P extends BizProcedure> void unregistorBizProcedure(P proc);
    <P extends BizProcedure> void unregistorBizProcedures(Collection<P> procs);
    

}
