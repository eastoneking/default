/*
 * create:2014年9月28日 下午7:51:22
 * author:wangds  
 */
package eastone.precasting.processor;

import java.util.Collection;

import eastone.common.processor.Processor;
import eastone.common.strategy.Strategy;

/**
 * 当一组处理器接口被执行时的执行策略.
 * @author wangds
 *
 */
public interface MultiProcessorExecuteStrategy<K, P extends Processor>
    extends Strategy<K>, Processor{
    /**
     * 任何一个发生异常即停止执行.
     */
    int BREAK_ON_EXCEPTION = 1;
    /**
     * 不管是否发生异常执行全部处理器.
     */
    int CONTINUE_ON_EXCEPTION = 2;
    /**
     * 设置异常时是否中断.
     * @author wangds 2014年9月28日 下午7:56:59.
     * @param type 处理类型.
     * @see #BREAK_ON_EXCEPTION
     * @see #CONTINUE_ON_EXCEPTION
     */
    void setBreakType(int type);
    /**
     * 获得发生异常时的后续处理方式.
     * @author wangds 2014年9月28日 下午7:58:11.
     * @return 异常时的处理方式.
     * @see #BREAK_ON_EXCEPTION
     * @see #CONTINUE_ON_EXCEPTION
     */
    int getBreakType();
    /**
     * 设置要执行的一组处理器.
     * @author wangds 2014年9月28日 下午8:09:30.
     * @param processors
     */
    void setProcessors(Collection<P> processors);
    /**
     * 获得要被执行的处理器.
     * @author wangds 2014年9月28日 下午8:10:04.
     * @return 处理器.
     */
    Collection<P> getProcessors();
}
