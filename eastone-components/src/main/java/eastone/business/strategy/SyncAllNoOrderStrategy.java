/*
 * create:2015年5月2日 下午7:55:18
 * author:wangds  
 */
package eastone.business.strategy;

import java.util.Collection;

import eastone.business.BizProcedure;
import eastone.business.IaBizProcedure;
import eastone.common.strategy.AbstractStrategy;

/**
 * 尝试运行所有注册处理过程的策略.
 * <p>一个处理过程发生错误不影响其他处理过程执行。执行顺序为同步顺序执行。</p>
 * @author wangds
 * 20150505 v0.1 初始版本.
 */
public class 
SyncAllNoOrderStrategy<I, O, K> extends AbstractStrategy<K> implements IaBizProcStrategy<I, O, K>{

    /*
     * @see eastone.business.BizProcedure#beforeProcess()
     * @author wangds 2015年5月2日 下午8:08:57.
     */
    @Override
    public void beforeProcess() {
        BizProcStrategyContext<K> ctx = this.getContext();
        for(BizProcedure p:(Collection<BizProcedure>)ctx.getBizProcedures()){
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
    @Override
    public void onProcessd() {
        BizProcStrategyContext<K> ctx = this.getContext();
        for(BizProcedure p:(Collection<BizProcedure>)ctx.getBizProcedures()){
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
    @Override
    public void afterProcess() {
        BizProcStrategyContext<K> ctx = this.getContext();
        for(BizProcedure p:(Collection<BizProcedure>)ctx.getBizProcedures()){
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
    @Override
    public <E extends Throwable> void beforeThrowException(E exception) {
        BizProcStrategyContext<K> ctx = this.getContext();
        for(BizProcedure p:(Collection<BizProcedure>)ctx.getBizProcedures()){
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
    @Override
    public <E extends Throwable> void throwedException(E exception) {
        BizProcStrategyContext<K> ctx = this.getContext();
        for(BizProcedure p:(Collection<BizProcedure>)ctx.getBizProcedures()){
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
    @Override
    public <E extends Throwable> void afterThrowException(E exception) {
        BizProcStrategyContext<K> ctx = this.getContext();
        for(BizProcedure p:(Collection<BizProcedure>)ctx.getBizProcedures()){
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
        for(BizProcedure p:(Collection<BizProcedure>)
                ((BizProcStrategyContext<K>)this.getContext()).getBizProcedures()){
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
        for(BizProcedure p:(Collection<BizProcedure>)
                ((BizProcStrategyContext<K>)this.getContext()).getBizProcedures()){
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
        for(BizProcedure p:(Collection<BizProcedure>)
                ((BizProcStrategyContext<K>)this.getContext()).getBizProcedures()){
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
        for(BizProcedure p:(Collection<BizProcedure>)
                ((BizProcStrategyContext<K>)this.getContext()).getBizProcedures()){
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
        for(BizProcedure p:(Collection<BizProcedure>)
                ((BizProcStrategyContext<K>)this.getContext()).getBizProcedures()){
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
        for(BizProcedure p:(Collection<BizProcedure>)
                ((BizProcStrategyContext<K>)this.getContext()).getBizProcedures()){
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
     * @see eastone.common.context.Context#status(java.lang.Object[])
     * @author wangds 2015年5月4日 上午10:11:06.
     */
    @Override
    public <T> T status(Object... arg0) throws Exception {
        // //TODO: Auto-generated method stub
        return null;
    }

    /*
     * @see eastone.common.Clearable#clear()
     * @author wangds 2015年5月4日 上午10:11:06.
     */
    @Override
    public void clear() {
        // //TODO: Auto-generated method stub
        
    }



}
