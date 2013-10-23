package eastone.common.processor;

/**
 * 带有执行结果的处理器接口.
 * <p>
 * 	修改列表:
 * 	<ol>
 *  	<li>补充注释. by wangds@gmail.com 2013-10-13 15:45</li>
 *  </ol>
 * </p>
 * 
 * @param <T> 执行结果类型.
 * @param <E> 执行时可能出现的异常.
 * 
 * @author 王东石 <wangds@gmail.com>
 * @version 0.1.1
 * @since 0.1
 */
public interface ProcessorWithResult<T, E extends Exception> 
	extends Processor<E>, ResultContainer<T> {

}
