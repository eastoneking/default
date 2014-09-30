/*
 * create:2014年9月28日 下午8:03:45
 * author:wangds  
 */
package eastone.precasting.processor;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import eastone.common.exception.MultiException;
import eastone.common.processor.Processor;
import eastone.common.strategy.AbstractStrategy;

/**
 * 多个执行器的默认执行策略.
 * @author wangds
 *
 */
public class DefaultMultiProcessorExecuteStrategy<K, P extends Processor>
    extends AbstractStrategy<K>
    implements MultiProcessorExecuteStrategy<K, P> {

    /**
     * 异常处理类型.
     */
    private int breakType = BREAK_ON_EXCEPTION;
    /**
     * 处理器组.
     */
    private Collection<P> processors = null;

    /*
     * @see
     * eastone.precasting.processor.MultiProcessorExecuteStrategy#setType(int)
     * 
     * @author wangds 2014年9月28日 下午8:04:47.
     */
    @Override
    public void setBreakType(int type) {
        this.breakType = type;
    }

    /*
     * @see eastone.precasting.processor.MultiProcessorExecuteStrategy#getType()
     * 
     * @author wangds 2014年9月28日 下午8:04:47.
     */
    @Override
    public int getBreakType() {
        return this.breakType;
    }

    /*
     * @see
     * eastone.precasting.processor.MultiProcessorExecuteStrategy#setProcessors
     * (java.util.Collection)
     * 
     * @author wangds 2014年9月28日 下午8:11:10.
     */
    @Override
    public void setProcessors(Collection<P> theProcessors) {
        this.processors = theProcessors;
    }

    /*
     * @see
     * eastone.precasting.processor.MultiProcessorExecuteStrategy#getProcessors
     * ()
     * 
     * @author wangds 2014年9月28日 下午8:11:10.
     */
    @Override
    public Collection<P> getProcessors() {
        return this.processors;
    }

    /*
     * @see eastone.common.processor.Processor#process()
     * 
     * @author wangds 2014年9月28日 下午8:15:13.
     */
    @Override
    public void process() {
        if (this.processors != null) {
            List<Throwable> exceptions = new LinkedList<Throwable>();
            for (Processor p : this.getProcessors()) {
                try {
                    p.process();
                } catch (Exception e) {
                    exceptions.add(e);
                    if (this.getBreakType() == this.breakType) {
                        break;
                    }
                }
            }
            int expSize = exceptions.size();
            if (expSize == 1) {
                Throwable e = exceptions.get(0);
                throw new RuntimeException(e.getLocalizedMessage(), e);
            } else if (expSize > 1) {
                throw new MultiException(exceptions);
            }
        }
    }

}
