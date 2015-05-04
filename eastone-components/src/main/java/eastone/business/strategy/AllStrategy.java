/*
 * create:2015年5月2日 下午7:55:18
 * author:wangds  
 */
package eastone.business.strategy;

import java.util.Collection;
import java.util.LinkedList;

import eastone.business.BizProcedure;
import eastone.business.IaBizProcedure;
import eastone.common.bridge.Bridge;
import eastone.common.strategy.AbstractStrategy;

/**
 * .
 * @author wangds
 *
 */
public class 
AllStrategy<I, O, K> extends AbstractStrategy<K> implements IaBizProcStrategy<I, O, K>, Bridge<Collection<? super BizProcedure>>{

    private final Collection<? super BizProcedure> procs = new LinkedList<BizProcedure>();;
    /*
     * @see eastone.business.strategy.BizProcStrategy#registorBizProcedure(eastone.business.BizProcedure)
     * @author wangds 2015年5月2日 下午8:08:57.
     */
    @Override
    public <P extends BizProcedure> void registorBizProcedure(P proc) {
        this.procs.add(proc);
    }

    /*
     * @see eastone.business.strategy.BizProcStrategy#registorBizProcedures(java.util.Collection)
     * @author wangds 2015年5月2日 下午8:08:57.
     */
    @Override
    public <P extends BizProcedure> void registorBizProcedures(Collection<P> procs) {
        this.procs.addAll(procs);
    }

    /*
     * @see eastone.business.strategy.BizProcStrategy#unregistorBizProcedure(eastone.business.BizProcedure)
     * @author wangds 2015年5月2日 下午8:08:57.
     */
    @Override
    public <P extends BizProcedure> void unregistorBizProcedure(P proc) {
        this.procs.remove(proc);
    }

    /*
     * @see eastone.business.strategy.BizProcStrategy#unregistorBizProcedures(java.util.Collection)
     * @author wangds 2015年5月2日 下午8:08:57.
     */
    @Override
    public <P extends BizProcedure> void unregistorBizProcedures(Collection<P> procs) {
        this.procs.removeAll(procs);
    }

    /*
     * @see eastone.business.BizProcedure#beforeProcess()
     * @author wangds 2015年5月2日 下午8:08:57.
     */
    @SuppressWarnings("unchecked")
    @Override
    public void beforeProcess() {
        for(BizProcedure p:(Collection<BizProcedure>)this.procs){
            try{
                p.beforeProcess();
            }catch(Exception e){
                this.getLogger().error(e.getLocalizedMessage(), e);
            }
        }
    }

    /*
     * @see eastone.business.BizProcedure#onProcessd()
     * @author wangds 2015年5月2日 下午8:08:57.
     */
    @SuppressWarnings("unchecked")
    @Override
    public void onProcessd() {
        for(BizProcedure p:(Collection<BizProcedure>)this.procs){
            try{
                p.onProcessd();
            }catch(Exception e){
                this.getLogger().error(e.getLocalizedMessage(), e);
            }
        }
    }

    /*
     * @see eastone.business.BizProcedure#afterProcess()
     * @author wangds 2015年5月2日 下午8:08:57.
     */
    @SuppressWarnings("unchecked")
    @Override
    public void afterProcess() {
        for(BizProcedure p:(Collection<BizProcedure>)this.procs){
            try{
                p.afterProcess();
            }catch(Exception e){
                this.getLogger().error(e.getLocalizedMessage(), e);
            }
        }
    }

    /*
     * @see eastone.business.BizProcedure#beforeThrowException(java.lang.Object)
     * @author wangds 2015年5月2日 下午8:08:57.
     */
    @SuppressWarnings("unchecked")
    @Override
    public <E> void beforeThrowException(E exception) {
        for(BizProcedure p:(Collection<BizProcedure>)this.procs){
            try{
                p.beforeThrowException(exception);
            }catch(Exception e){
                this.getLogger().error(e.getLocalizedMessage(), e);
            }
        }
    }

    /*
     * @see eastone.business.BizProcedure#throwedException(java.lang.Object)
     * @author wangds 2015年5月2日 下午8:08:57.
     */
    @SuppressWarnings("unchecked")
    @Override
    public <E> void throwedException(E exception) {
        for(BizProcedure p:(Collection<BizProcedure>)this.procs){
            try{
                p.throwedException(exception);
            }catch(Exception e){
                this.getLogger().error(e.getLocalizedMessage(), e);
            }
        }
    }

    /*
     * @see eastone.business.BizProcedure#afterThrowException(java.lang.Object)
     * @author wangds 2015年5月2日 下午8:08:57.
     */
    @SuppressWarnings("unchecked")
    @Override
    public <E> void afterThrowException(E exception) {
        for(BizProcedure p:(Collection<BizProcedure>)this.procs){
            try{
                p.beforeProcess();
            }catch(Exception e){
                this.getLogger().error(e.getLocalizedMessage(), e);
            }
        }
    }

    /*
     * @see eastone.business.IaBizProcedure#beforeChangeInput(java.lang.Object, java.lang.Object)
     * @author wangds 2015年5月2日 下午8:08:57.
     */
    @SuppressWarnings("unchecked")
    @Override
    public I beforeChangeInput(I newValue, I oldValue) {
        for(BizProcedure p:(Collection<BizProcedure>)this.procs){
            try{
                if(p instanceof IaBizProcedure){
                    newValue=((IaBizProcedure<I, O>)p).beforeChangeInput(newValue, oldValue);
                }
            }catch(Exception e){
                this.getLogger().error(e.getLocalizedMessage(), e);
            }
        }
        return newValue;
    }

    /*
     * @see eastone.business.IaBizProcedure#onChangedInput(java.lang.Object, java.lang.Object)
     * @author wangds 2015年5月2日 下午8:08:57.
     */
    @SuppressWarnings("unchecked")
    @Override
    public void onChangedInput(I newValue, I oldValue) {
        for(BizProcedure p:(Collection<BizProcedure>)this.procs){
            try{
                if(p instanceof IaBizProcedure){
                    ((IaBizProcedure<I, O>)p).onChangedInput(newValue, oldValue);
                }
            }catch(Exception e){
                this.getLogger().error(e.getLocalizedMessage(), e);
            }
        }
    }

    /*
     * @see eastone.business.IaBizProcedure#afterChangedInput(java.lang.Object, java.lang.Object)
     * @author wangds 2015年5月2日 下午8:08:57.
     */
    @SuppressWarnings("unchecked")
    @Override
    public void afterChangedInput(I newValue, I oldValue) {
        for(BizProcedure p:(Collection<BizProcedure>)this.procs){
            try{
                if(p instanceof IaBizProcedure){
                    ((IaBizProcedure<I, O>)p).afterChangedInput(newValue, oldValue);
                }
            }catch(Exception e){
                this.getLogger().error(e.getLocalizedMessage(), e);
            }
        }
    }

    /*
     * @see eastone.business.IaBizProcedure#beforeChangeOutput(java.lang.Object, java.lang.Object)
     * @author wangds 2015年5月2日 下午8:08:57.
     */
    @SuppressWarnings("unchecked")
    @Override
    public O beforeChangeOutput(O newValue, O oldValue) {
        for(BizProcedure p:(Collection<BizProcedure>)this.procs){
            try{
                if(p instanceof IaBizProcedure){
                    newValue=((IaBizProcedure<I, O>)p).beforeChangeOutput(newValue, oldValue);
                }
            }catch(Exception e){
                this.getLogger().error(e.getLocalizedMessage(), e);
            }
        }
        return newValue;
    }

    /*
     * @see eastone.business.IaBizProcedure#onChangedOutput(java.lang.Object, java.lang.Object)
     * @author wangds 2015年5月2日 下午8:08:57.
     */
    @SuppressWarnings("unchecked")
    @Override
    public void onChangedOutput(O newValue, O oldValue) {
        for(BizProcedure p:(Collection<BizProcedure>)this.procs){
            try{
                if(p instanceof IaBizProcedure){
                    ((IaBizProcedure<I, O>)p).onChangedOutput(newValue, oldValue);
                }
            }catch(Exception e){
                this.getLogger().error(e.getLocalizedMessage(), e);
            }
        }
    }

    /*
     * @see eastone.business.IaBizProcedure#afterChangedOutput(java.lang.Object, java.lang.Object)
     * @author wangds 2015年5月2日 下午8:08:57.
     */
    @SuppressWarnings("unchecked")
    @Override
    public void afterChangedOutput(O newValue, O oldValue) {
        for(BizProcedure p:(Collection<BizProcedure>)this.procs){
            try{
                if(p instanceof IaBizProcedure){
                    ((IaBizProcedure<I, O>)p).afterChangedOutput(newValue, oldValue);
                }
            }catch(Exception e){
                this.getLogger().error(e.getLocalizedMessage(), e);
            }
        }
    }

    /*
     * @see eastone.common.bridge.Bridge#getImplementor()
     * @author wangds 2015年5月2日 下午8:08:57.
     */
    @Override
    public Collection<? super BizProcedure> getImplementor() {
        return this.procs;
    }

    /*
     * @see eastone.common.bridge.Bridge#setImplementor(java.lang.Object)
     * @author wangds 2015年5月2日 下午8:08:57.
     */
    @SuppressWarnings("unchecked")
    @Override
    public void setImplementor(Collection<? super BizProcedure> procs) {
        this.procs.addAll((Collection<BizProcedure>)procs);
    }



}
