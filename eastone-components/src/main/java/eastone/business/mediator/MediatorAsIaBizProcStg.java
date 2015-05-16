/*
 * create:2015年5月2日 上午10:10:36
 * author:wangds  
 */
package eastone.business.mediator;

import java.util.Collection;

import eastone.business.BizProcSectionEnum;
import eastone.business.BizProcedure;
import eastone.business.InteractionBusiness;
import eastone.business.strategy.BizProcStrategyContext;
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
        ctx.setSection(BizProcSectionEnum.BEFORE_PROC);
        try {
            ctx.process();
        } catch (Exception e) {
            this.getLogger().error(e.getLocalizedMessage(), e);
        }
    }

    /*
     * @see eastone.business.BizProcedure#onProcessd()
     * @author wangds 2015年5月2日 上午10:11:21.
     */
    @Override
    public void onProcessd() {
        BizProcStrategyContext<K> ctx = this.getStrategyContext();
        ctx.setSection(BizProcSectionEnum.ON_PROC);
        try {
            ctx.process();
        } catch (Exception e) {
            this.getLogger().error(e.getLocalizedMessage(), e);
        }
    }

    /*
     * @see eastone.business.BizProcedure#afterProcess()
     * @author wangds 2015年5月2日 上午10:11:21.
     */
    @Override
    public void afterProcess() {
        BizProcStrategyContext<K> ctx = this.getStrategyContext();
        ctx.setSection(BizProcSectionEnum.AFTER_PROC);
        try {
            ctx.process();
        } catch (Exception e) {
            this.getLogger().error(e.getLocalizedMessage(), e);
        }
    }

    /*
     * @see eastone.business.BizProcedure#beforeThrowException(java.lang.Object)
     * @author wangds 2015年5月2日 上午10:11:21.
     */
    @Override
    public <E extends Throwable> void beforeThrowException(E exception) {
        BizProcStrategyContext<K> ctx = this.getStrategyContext();
        ctx.setSection(BizProcSectionEnum.BEFORE_THROW);
        ctx.setException(exception);
        try {
            ctx.process();
        } catch (Exception e) {
            this.getLogger().error(e.getLocalizedMessage(), e);
        }
    }

    /*
     * @see eastone.business.BizProcedure#throwedException(java.lang.Object)
     * @author wangds 2015年5月2日 上午10:11:21.
     */
    @Override
    public <E extends Throwable> void throwedException(E exception) {
        BizProcStrategyContext<K> ctx = this.getStrategyContext();
        ctx.setSection(BizProcSectionEnum.ON_THROW);
        ctx.setException(exception);
        try {
            ctx.process();
        } catch (Exception e) {
            this.getLogger().error(e.getLocalizedMessage(), e);
        }
    }

    /*
     * @see eastone.business.BizProcedure#afterThrowException(java.lang.Object)
     * @author wangds 2015年5月2日 上午10:11:21.
     */
    @Override
    public <E extends Throwable> void afterThrowException(E exception) {
        BizProcStrategyContext<K> ctx = this.getStrategyContext();
        ctx.setSection(BizProcSectionEnum.AFTER_THROW);
        ctx.setException(exception);
        try {
            ctx.process();
        } catch (Exception e) {
            this.getLogger().error(e.getLocalizedMessage(), e);
        }
    }

    /*
     * @see eastone.business.InteractionBusinessProcedure#beforeChangeInput(java.lang.Object, java.lang.Object)
     * @author wangds 2015年5月2日 上午10:11:21.
     */
    @Override
    public I beforeChangeInput(I newValue, I oldValue) {
        BizProcStrategyContext<K> ctx = this.getStrategyContext();
        ctx.setSection(BizProcSectionEnum.BEFORE_INPUT);
        ctx.setInputNew(newValue);
        ctx.setInputOld(oldValue);
        try {
            ctx.process();
        } catch (Exception e) {
            this.getLogger().error(e.getLocalizedMessage(), e);
        }
        return ctx.getInputNew();
    }

    /*
     * @see eastone.business.InteractionBusinessProcedure#onChangedInput(java.lang.Object, java.lang.Object)
     * @author wangds 2015年5月2日 上午10:11:21.
     */
    @Override
    public void onChangedInput(I newValue, I oldValue) {
        BizProcStrategyContext<K> ctx = this.getStrategyContext();
        ctx.setSection(BizProcSectionEnum.ON_INPUT);
        ctx.setInputNew(newValue);
        ctx.setInputOld(oldValue);
        try {
            ctx.process();
        } catch (Exception e) {
            this.getLogger().error(e.getLocalizedMessage(), e);
        }
    }

    /*
     * @see eastone.business.InteractionBusinessProcedure#afterChangedInput(java.lang.Object, java.lang.Object)
     * @author wangds 2015年5月2日 上午10:11:21.
     */
    @Override
    public void afterChangedInput(I newValue, I oldValue) {
        BizProcStrategyContext<K> ctx = this.getStrategyContext();
        ctx.setSection(BizProcSectionEnum.AFTER_INPUT);
        ctx.setInputNew(newValue);
        ctx.setInputOld(oldValue);
        try {
            ctx.process();
        } catch (Exception e) {
            this.getLogger().error(e.getLocalizedMessage(), e);
        }
    }

    /*
     * @see eastone.business.InteractionBusinessProcedure#beforeChangeOutput(java.lang.Object, java.lang.Object)
     * @author wangds 2015年5月2日 上午10:11:21.
     */
    @Override
    public O beforeChangeOutput(O newValue, O oldValue) {
        BizProcStrategyContext<K> ctx = this.getStrategyContext();
        ctx.setSection(BizProcSectionEnum.BEFORE_OUTPUT);
        ctx.setOutputNew(newValue);
        ctx.setOutputOld(oldValue);
        try {
            ctx.process();
        } catch (Exception e) {
            this.getLogger().error(e.getLocalizedMessage(), e);
        }
        return ctx.getOutputNew();
    }

    /*
     * @see eastone.business.InteractionBusinessProcedure#onChangedOutput(java.lang.Object, java.lang.Object)
     * @author wangds 2015年5月2日 上午10:11:21.
     */
    @Override
    public void onChangedOutput(O newValue, O oldValue) {
        BizProcStrategyContext<K> ctx = this.getStrategyContext();
        ctx.setSection(BizProcSectionEnum.ON_OUTPUT);
        ctx.setOutputNew(newValue);
        ctx.setOutputOld(oldValue);
        try {
            ctx.process();
        } catch (Exception e) {
            this.getLogger().error(e.getLocalizedMessage(), e);
        }
    }

    /*
     * @see eastone.business.InteractionBusinessProcedure#afterChangedOutput(java.lang.Object, java.lang.Object)
     * @author wangds 2015年5月2日 上午10:11:21.
     */
    @Override
    public void afterChangedOutput(O newValue, O oldValue) {
        BizProcStrategyContext<K> ctx = this.getStrategyContext();
        ctx.setSection(BizProcSectionEnum.AFTER_OUTPUT);
        ctx.setOutputNew(newValue);
        ctx.setOutputOld(oldValue);
        try {
            ctx.process();
        } catch (Exception e) {
            this.getLogger().error(e.getLocalizedMessage(), e);
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
