/*
 * create:2015年5月4日 上午9:23:37
 * author:wangds  
 */
package eastone.business.strategy;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;

import eastone.business.BizProcSectionEnum;
import eastone.business.BizProcedure;
import eastone.common.context.InterimContext;
import eastone.common.strategy.AbstractStrategyContext;
import eastone.common.strategy.Strategy;
import eastone.precasting.context.InterimMapContext;

/**
 * 交互业务处理策略上下文.
 * @author wangds
 * 20150505 v0.1 初始版本.
 */
public class IaBizProcStrategyCtx<K> extends AbstractStrategyContext<K> implements BizProcStrategyContext<K>{
    
    private final Collection<BizProcedure> procs = new LinkedList<BizProcedure>();
    
    private final InterimContext procInterimCtx = new InterimMapContext();
    
    /**
     * The constructor of IaBizProcStrategyCtx.
     * @author wangds 2015年5月4日 上午9:25:17.
     * @param theStrategyMap
     */
    protected IaBizProcStrategyCtx(Map<K, Strategy<K>> theStrategyMap) {
        super(theStrategyMap);
    }
    

    /*
     * @see eastone.business.mediator.BizProcStrategyMediator#registorProcedure(eastone.business.BizProcedure)
     * @author wangds 2015年5月2日 上午10:11:21.
     */
    @Override
    public <P extends BizProcedure> void registorBizProcedure(P proc) {
        this.procs.add(proc);
    }

    /*
     * @see eastone.business.mediator.BizProcStrategyMediator#registorProcedures(java.util.Collection)
     * @author wangds 2015年5月2日 上午10:11:21.
     */
    @Override
    public <P extends BizProcedure> void registorBizProcedures(Collection<P> procs) {
        this.procs.addAll(procs);
    }

    /*
     * @see eastone.business.mediator.BizProcStrategyMediator#unregistorProcedure(eastone.business.BizProcedure)
     * @author wangds 2015年5月2日 上午10:11:21.
     */
    @Override
    public <P extends BizProcedure> void unregistorBizProcedure(P proc) {
        this.procs.remove(proc);
    }

    /*
     * @see eastone.business.mediator.BizProcStrategyMediator#unregistorProcedures(java.util.Collection)
     * @author wangds 2015年5月2日 上午10:11:21.
     */
    @Override
    public <P extends BizProcedure> void unregistorBizProcedures(Collection<P> procs) {
        this.procs.removeAll(procs);
    }


    /*
     * @see eastone.common.strategy.AbstractStrategyContext#proccessStrategry(eastone.common.strategy.Strategy)
     * @author wangds 2015年5月4日 上午9:24:32.
     */
    @Override
    protected <S extends Strategy<K>> void proccessStrategry(S strategy) {
        strategy.setContext(this);
        
        BizProcStrategy<?> s = null;
        if(strategy instanceof BizProcStrategy){
            s = (BizProcStrategy<?>)strategy;
        }
        IaBizProcStrategy<?, ?, ?> ias = null;
        if(strategy instanceof IaBizProcStrategy){
            ias = (IaBizProcStrategy<?,?,?>)strategy;
        }
        BizProcSectionEnum sect = this.getSection();
        switch(sect){
        case BEFORE_INPUT:
            if(ias!=null){
                ias.beforeChangeInput(this.getInputNew(), this.getInputOld());
            }
            break;
        case BEFORE_OUTPUT:
            if(ias!=null){
                ias.beforeChangeOutput(this.getOutputNew(), this.getOutputOld());
            }
            break;
        case BEFORE_PROC:
            if(s!=null){
                s.beforeProcess();
            }
            break;

        case BEFORE_THROW:
            if(s!=null){
                s.beforeThrowException(this.getException());
            }
            break;
        case ON_INPUT:
            if(ias!=null){
                ias.onChangedInput(this.getInputNew(), this.getInputOld());
            }
            break;
        case ON_OUTPUT:
            if(ias!=null){
                ias.onChangedOutput(this.getOutputNew(), this.getOutputOld());
            }
            break;
        case ON_PROC:
            if(s!=null){
                s.onProcessd();
            }
            break;
        case ON_THROW:
            if(s!=null){
                s.throwedException(this.getException());
            }
            break;
        case AFTER_INPUT:
            if(ias!=null){
                ias.afterChangedInput(this.getInputNew(), this.getInputOld());
            }
            break;
        case AFTER_OUTPUT:
            if(ias!=null){
                ias.afterChangedOutput(this.getOutputNew(), this.getOutputOld());
            }
            break;
        case AFTER_PROC:
            if(s!=null){
                s.afterProcess();
            }
            break;
        case AFTER_THROW:
            if(s!=null){
                s.afterThrowException(this.getException());
            }
            break;
         default:;
        }
    }


    /*
     * @see eastone.business.strategy.BizProcStrategyContext#getBizProcedures()
     * @author wangds 2015年5月4日 上午10:17:25.
     */
    @Override
    public Collection<BizProcedure> getBizProcedures() {
        return this.procs;
    }
    
    /**
     * The setter method of the property section.
     * @param thesection the section to set
     * @author wangds 2015年5月4日 上午10:19:02.
     */
    public void setSection(BizProcSectionEnum section) {
        try {
            this.procInterimCtx.status(BizProcStrConstrants.PROC_SECTION, section);
        } catch (Exception e) {
            this.getLogger().error(e.getLocalizedMessage(), e);
        }
    }
    
    /**
     * The getter method of the property section.
     * @author wangds 2015年5月4日 上午10:19:09.
     * @return the section.
     */
    public BizProcSectionEnum getSection() {
        BizProcSectionEnum res = null;
        try {
            res = this.procInterimCtx.status(BizProcStrConstrants.PROC_SECTION);
        } catch (Exception e) {
            this.getLogger().error(e.getLocalizedMessage(), e);
        }
        return res;
    }
    
    public <I> I getInputNew(){
        I res = null;
        try {
            res = this.procInterimCtx.status(BizProcStrConstrants.PROC_INPUT_NEW);
        } catch (Exception e) {
            this.getLogger().error(e.getLocalizedMessage(), e);
        }
        return res;
    }
    
    public <I> void setInputNew(I newInput){
        try {
            this.procInterimCtx.status(BizProcStrConstrants.PROC_INPUT_NEW, newInput);
        } catch (Exception e) {
            this.getLogger().error(e.getLocalizedMessage(), e);
        }
    }
    
    public <I> I getInputOld(){
        I res = null;
        try {
            res = this.procInterimCtx.status(BizProcStrConstrants.PROC_INPUT_OLD);
        } catch (Exception e) {
            this.getLogger().error(e.getLocalizedMessage(), e);
        }
        return res;
    }
    
    public <I> void setInputOld(I oldInput){
        try {
            this.procInterimCtx.status(BizProcStrConstrants.PROC_INPUT_OLD, oldInput);
        } catch (Exception e) {
            this.getLogger().error(e.getLocalizedMessage(), e);
        }
    }
    public <O> O getOutputNew(){
        O res = null;
        try {
            res = this.procInterimCtx.status(BizProcStrConstrants.PROC_OUTPUT_NEW);
        } catch (Exception e) {
            this.getLogger().error(e.getLocalizedMessage(), e);
        }
        return res;
    }
    
    public <O> void setOutputNew(O newOutput){
        try {
            this.procInterimCtx.status(BizProcStrConstrants.PROC_OUTPUT_NEW, newOutput);
        } catch (Exception e) {
            this.getLogger().error(e.getLocalizedMessage(), e);
        }
    }
    public <O> O getOutputOld(){
        O res = null;
        try {
            res = this.procInterimCtx.status(BizProcStrConstrants.PROC_OUTPUT_OLD);
        } catch (Exception e) {
            this.getLogger().error(e.getLocalizedMessage(), e);
        }
        return res;
    }
    
    public <O> void setOutputOld(O oldOutput){
        try {
            this.procInterimCtx.status(BizProcStrConstrants.PROC_OUTPUT_OLD, oldOutput);
        } catch (Exception e) {
            this.getLogger().error(e.getLocalizedMessage(), e);
        }
    }
    public <E extends Exception> E getException(){
        E res = null;
        try {
            res = this.procInterimCtx.status(BizProcStrConstrants.PROC_EXCEPTION);
        } catch (Exception e) {
            this.getLogger().error(e.getLocalizedMessage(), e);
        }
        return res;
    }
    
    public <E extends Exception> void setException(E ex){
        try {
            this.procInterimCtx.status(BizProcStrConstrants.PROC_EXCEPTION, ex);
        } catch (Exception e) {
            this.getLogger().error(e.getLocalizedMessage(), e);
        }
    }
    
    /*
     * @see eastone.common.context.Context#status(java.lang.Object[])
     * @author wangds 2015年5月5日 上午9:38:11.
     */
    @Override
    public <T> T status(Object... status) throws Exception {
        return this.procInterimCtx.status(status);
    }

}
