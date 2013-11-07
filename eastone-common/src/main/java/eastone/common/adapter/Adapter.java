package eastone.common.adapter;

/**
 * Adapter接口是设计模式中适配器模式的接口定义.
 * <p>
 * 	修改列表:<br/>
 * <ol>
 * 	<li>2013-10-13 14:53 增加注释 by wangdongshi@neusoft.com</li>
 *  <li>修改方法命名为{@link #getAdaptee()} </li>
 * </ol>
 * </p>
 *
 * @param <T> 被适配的类型.
 * @author 王东石 <wangdongshi@neusoft.com>
 * @version 0.1.2
 * @since 0.1
 */
public interface Adapter<T> {

	/**
	 * 获得实现功能的内部对象.
	 * @return 被适配的对象.
	 */
	T getAdaptee();

}
