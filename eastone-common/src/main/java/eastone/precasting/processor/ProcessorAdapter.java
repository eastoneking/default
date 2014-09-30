/*
 * create:2014年9月28日 下午6:40:20
 * author:wangds  
 */
package eastone.precasting.processor;

import eastone.common.Component;
import eastone.common.GeneralParentObject;
import eastone.common.adapter.Adapter;
import eastone.common.processor.Processor;

/**
 * 处理器适配抽象类.
 * @author wangds
 *
 */
public abstract class ProcessorAdapter<P extends Processor> extends GeneralParentObject
    implements Adapter<P>, Processor, Component {

    private P inner;

    /**
     * The constructor of ProcessorAdapter.
     * 
     * @author wangds 2014年9月28日 下午7:06:18.
     */
    public ProcessorAdapter() {
    }

    /*
     * @see eastone.common.adapter.Adapter#getAdaptee()
     * 
     * @author wangds 2014年9月28日 下午6:40:20.
     */
    @Override
    public P getAdaptee() {
        return this.inner;
    }

    /**
     * 设置被适配对象.
     * 
     * @author wangds 2014年9月28日 下午7:08:54 @D51 return to Shenyang.
     * @param adaptee
     *            被适配对象.
     */
    public void setAdaptee(P adaptee) {
        this.inner = adaptee;
    }

    /*
     * @see eastone.common.processor.Processor#process()
     * 
     * @author wangds 2014年9月28日 下午7:11:18.
     */
    @Override
    public void process() throws Exception{
        if (this.inner != null) {
            this.inner.process();
        }
    }

}
