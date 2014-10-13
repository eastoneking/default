/*
 * create:2014年10月12日 下午6:42:36
 * author:wangds  
 */
package eastone.initializer;

import eastone.common.adapter.Adapter;
import eastone.common.processor.Processor;

/**
 * .
 * @author wangds
 *
 */
public class InitializerWrapper<T extends Processor>
    extends AbstractInitializer
    implements Adapter<T>{
    /**
     * .
     */
    private T adaptee;
    /*
     * @see eastone.common.adapter.Adapter#getAdaptee()
     * @author wangds 2014年10月12日 下午6:44:44.
     */
    @Override
    public T getAdaptee() {
        return this.adaptee;
    }
    /**
     * The setter method of the property adaptee.
     * @param theadaptee the adaptee to set
     * @author wangds 2014年10月12日 下午6:45:56.
     */
    public void setAdaptee(T theAdaptee) {
        this.adaptee = theAdaptee;
    }
    /*
     * @see eastone.common.chainofresponsibility.Handler#handle()
     * @author wangds 2014年10月12日 下午6:44:44.
     */
    @Override
    public boolean handle() {
        boolean res = false;
        try{
            if(this.adaptee!=null){
                this.adaptee.process();
            }
            res = true;
        }catch(Exception e){
            this.getLogger().error(e.getLocalizedMessage(), e);
        }
        return res;
    }

}
