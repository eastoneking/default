package eastone.common.processor;

/**
 * 结果容器.
 * <p>描述了一个用于容纳执行结果的接口，一般配合{@link Processor}使用.</p>
 * 
 * <p>修改列表:
 * <ol>
 * 		<li> 补充注释 by wangds@gmail.com 2013-10-13 10:30</li>
 *  </ol>
 * </p>
 * 
 * @param <T> 结果类型
 * 
 * @author 王东石 <wangds@gmail.com>
 * @version 0.1.1
 * @since 0.1
 * 
 */
public interface ResultContainer <T> {
	/**
	 * 获得结果.
	 * @return 结果实例.
	 */
	T getResult();
	/**
	 * 设置结果.
	 * @param result 结果内容.
	 */
	void setResult(T result);

}
