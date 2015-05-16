/*
 * create:2015年4月25日 下午10:10:38
 * author:wangds  
 */
package eastone.business.strategy;

import java.util.Collection;

import eastone.business.BizProcSectionEnum;
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

    /**
     * The setter method of the property section.
     * @param thesection the section to set
     * @author wangds 2015年5月4日 上午10:19:02.
     */
    void setSection(BizProcSectionEnum section);
    /**
     * The getter method of the property section.
     * @author wangds 2015年5月4日 上午10:19:09.
     * @return the section.
     */
    BizProcSectionEnum getSection();
    public <I> I getInputNew();
    
    public <I> void setInputNew(I newInput);
    
    public <I> I getInputOld();
    
    public <I> void setInputOld(I oldInput);
    public <O> O getOutputNew();
    
    public <O> void setOutputNew(O newOutput);
    public <O> O getOutputOld();
    
    public <O> void setOutputOld(O oldOutput);
    public <E  extends Throwable> E getException();
    
    public <E  extends Throwable> void setException(E ex);
    
}
