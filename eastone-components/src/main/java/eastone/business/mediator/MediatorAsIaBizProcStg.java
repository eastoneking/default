/*
 * create:2015年5月2日 上午10:10:36
 * author:wangds  
 */
package eastone.business.mediator;

import java.util.Collection;

import eastone.business.BizProcedure;
import eastone.business.InteractionBusiness;
import eastone.business.strategy.BizProcStrategy;
import eastone.business.strategy.BizProcStrategyContext;
import eastone.business.strategy.IaBizProcStrategy;
import eastone.business.strategy.IaBizProcStrategyCtx;
import eastone.common.GeneralParentObject;

/**
 * 交互业务处理策略中介.
 * @author wangds
 * 20150505 v0.1 初始版本.
 */
public class MediatorAsIaBizProcStg<I,O,K, B extends InteractionBusiness<I, O>> extends GeneralParentObject implements InteractionBizProcStrategyMediator<I, O, K, B> {

    private B innerBiz;
    private BizProcStrategyContext<K> ctx = new IaBizProcStrategyCtx<K>();
    
    
    
    /*
     * @see eastone.business.mediator.BizMediator#setBusiness(eastone.business.Business)
     * @author wangds 2015年5月2日 上午10:11:21.
     */
    @Override
    public  void setBusiness(B biz) {
        this.innerBiz = biz;
    }

    /*
     * @see eastone.business.mediator.BizMediator#getBusiness()
     * @author wangds 2015年5月2日 上午10:11:21.
     */
    @Override
    public B getBusiness() {
        return this.innerBiz;
    }

    /*
     * @see eastone.business.BizProcedure#beforeProcess()
     * @author wangds 2015年5月2日 上午10:11:21.
     */
    @Override
    public void beforeProcess() {
        BizProcStrategyContext<K> ctx = this.getStrategyContext();
        BizProcStrategy<K> s = ctx.decide();
        if(s!=null){
            ctx.setSelectedStrategy(s.getKey());
            
            try {
                ctx.process();
            } catch (Exception e) {
                this.getLogger().error(e.getLocalizedMessage(), e);
            }
        }
    }

    /*
     * @see eastone.business.BizProcedure#onProcessd()
     * @author wangds 2015年5月2日 上午10:11:21.
     */
    @Override
    public void onProcessd() {
        BizProcStrategyContext<K> ctx = this.getStrategyContext();
        BizProcStrategy<K> s = ctx.decide();
        if(s!=null){
            s.onProcessd();
        }
    }

    /*
     * @see eastone.business.BizProcedure#afterProcess()
     * @author wangds 2015年5月2日 上午10:11:21.
     */
    @Override
    public void afterProcess() {
        BizProcStrategyContext<K> ctx = this.getStrategyContext();
        BizProcStrategy<K> s = ctx.decide();
        if(s!=null){
            s.afterProcess();
        }
    }

    /*
     * @see eastone.business.BizProcedure#beforeThrowException(java.lang.Object)
     * @author wangds 2015年5月2日 上午10:11:21.
     */
    @Override
    public <E> void beforeThrowException(E exception) {
        BizProcStrategyContext<K> ctx = this.getStrategyContext();
        BizProcStrategy<K> s = ctx.decide();
        if(s!=null){
            s.beforeThrowException(exception);
        }
    }

    /*
     * @see eastone.business.BizProcedure#throwedException(java.lang.Object)
     * @author wangds 2015年5月2日 上午10:11:21.
     */
    @Override
    public <E> void throwedException(E exception) {
        BizProcStrategyContext<K> ctx = this.getStrategyContext();
        BizProcStrategy<K> s = ctx.decide();
        if(s!=null){
            s.throwedException(exception);
        }
    }

    /*
     * @see eastone.business.BizProcedure#afterThrowException(java.lang.Object)
     * @author wangds 2015年5月2日 上午10:11:21.
     */
    @Override
    public <E> void afterThrowException(E exception) {
        BizProcStrategyContext<K> ctx = this.getStrategyContext();
        BizProcStrategy<K> s = ctx.decide();
        if(s!=null){
            s.afterThrowException(exception);
        }
    }

    /*
     * @see eastone.business.InteractionBusinessProcedure#beforeChangeInput(java.lang.Object, java.lang.Object)
     * @author wangds 2015年5月2日 上午10:11:21.
     */
    @Override
    public I beforeChangeInput(I newValue, I oldValue) {
        BizProcStrategyContext<K> ctx = this.getStrategyContext();
        IaBizProcStrategy<I, O, K> s = ctx.decide();
        if(s!=null){
            newValue = s.beforeChangeInput(newValue, oldValue);
        }
        return newValue;
    }

    /*
     * @see eastone.business.InteractionBusinessProcedure#onChangedInput(java.lang.Object, java.lang.Object)
     * @author wangds 2015年5月2日 上午10:11:21.
     */
    @Override
    public void onChangedInput(I newValue, I oldValue) {
        BizProcStrategyContext<K> ctx = this.getStrategyContext();
        IaBizProcStrategy<I, O, K> s = ctx.decide();
        if(s!=null){
            s.onChangedInput(newValue, oldValue);
        }
    }

    /*
     * @see eastone.business.InteractionBusinessProcedure#afterChangedInput(java.lang.Object, java.lang.Object)
     * @author wangds 2015年5月2日 上午10:11:21.
     */
    @Override
    public void afterChangedInput(I newValue, I oldValue) {
        BizProcStrategyContext<K> ctx = this.getStrategyContext();
        IaBizProcStrategy<I, O, K> s = ctx.decide();
        if(s!=null){
            s.afterChangedInput(newValue, oldValue);
        }
    }

    /*
     * @see eastone.business.InteractionBusinessProcedure#beforeChangeOutput(java.lang.Object, java.lang.Object)
     * @author wangds 2015年5月2日 上午10:11:21.
     */
    @Override
    public O beforeChangeOutput(O newValue, O oldValue) {
        BizProcStrategyContext<K> ctx = this.getStrategyContext();
        IaBizProcStrategy<I, O, K> s = ctx.decide();
        if(s!=null){
            newValue = s.beforeChangeOutput(newValue, oldValue);
        }
        return newValue;
    }

    /*
     * @see eastone.business.InteractionBusinessProcedure#onChangedOutput(java.lang.Object, java.lang.Object)
     * @author wangds 2015年5月2日 上午10:11:21.
     */
    @Override
    public void onChangedOutput(O newValue, O oldValue) {
        BizProcStrategyContext<K> ctx = this.getStrategyContext();
        IaBizProcStrategy<I, O, K> s = ctx.decide();
        if(s!=null){
            s.onChangedOutput(newValue, oldValue);
        }
    }

    /*
     * @see eastone.business.InteractionBusinessProcedure#afterChangedOutput(java.lang.Object, java.lang.Object)
     * @author wangds 2015年5月2日 上午10:11:21.
     */
    @Override
    public void afterChangedOutput(O newValue, O oldValue) {
        BizProcStrategyContext<K> ctx = this.getStrategyContext();
        IaBizProcStrategy<I, O, K> s = ctx.decide();
        if(s!=null){
            s.afterChangedOutput(newValue, oldValue);
        }
    }
    
    /*
     * @see eastone.business.mediator.BizProcStrategyMediator#setStrategyContext(eastone.business.strategy.BizProcStrategyContext)
     * @author wangds 2015年5月2日 上午11:06:40.
     */
    @Override
    public <C extends BizProcStrategyContext<K>> void setStrategyContext(C sctx) {
        this.ctx = sctx;
    }

    /*
     * @see eastone.business.mediator.BizProcStrategyMediator#getStrategyContext()
     * @author wangds 2015年5月2日 上午11:06:40.
     */
    @SuppressWarnings("unchecked")
    @Override
    public <C extends BizProcStrategyContext<K>> C getStrategyContext() {
        return (C)this.ctx;
    }

    /*
     * @see eastone.business.mediator.BizProcStrategyMediator#registorProcedure(eastone.business.BizProcedure)
     * @author wangds 2015年5月4日 上午10:03:50.
     */
    @Override
    public <P extends BizProcedure> void registorProcedure(P proc) {
        this.ctx.registorBizProcedure(proc);
    }

    /*
     * @see eastone.business.mediator.BizProcStrategyMediator#registorProcedures(java.util.Collection)
     * @author wangds 2015年5月4日 上午10:03:50.
     */
    @Override
    public <P extends BizProcedure> void registorProcedures(Collection<P> procs) {
        this.ctx.registorBizProcedures(procs);
    }

    /*
     * @see eastone.business.mediator.BizProcStrategyMediator#unregistorProcedure(eastone.business.BizProcedure)
     * @author wangds 2015年5月4日 上午10:03:50.
     */
    @Override
    public <P extends BizProcedure> void unregistorProcedure(P proc) {
        this.ctx.unregistorBizProcedure(proc);
    }

    /*
     * @see eastone.business.mediator.BizProcStrategyMediator#unregistorProcedures(java.util.Collection)
     * @author wangds 2015年5月4日 上午10:03:50.
     */
    @Override
    public <P extends BizProcedure> void unregistorProcedures(Collection<P> procs) {
        this.ctx.unregistorBizProcedures(procs);
    }

}
