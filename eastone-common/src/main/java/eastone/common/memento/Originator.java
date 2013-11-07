/*
 * File:Originator.java
 * Type:eastone.common.memento.Originator
 */
package eastone.common.memento;

/**
 * 备忘源接口.
 * <p>
 * 	<h1>修改列表:</h1>
 *  <ol>
 *    <li>初始版本, by wangdongshi@neusoft.com, 2013-11-7 下午12:27:58</li>
 *  </ol>
 * </p>
 *
 *
 * @author 王东石 <wangdongshi@neusoft.com>
 * @version 0.1.1
 * @since 0.1
 *
 */
public interface Originator {

	/**
	 * 创建备忘.
	 * @param <T> 备忘中保存的状态类型.
	 * @param <M> 备忘类型.
	 * @return 备忘对象.
	 */
	<T, M extends Memento<T>> M createMemento();

	/**
	 * 恢复备忘状态.
	 * @param <T> 备忘中保存的状态类型.
	 * @param <M> 备忘类型.
	 * @param memento 备忘对象.
	 */
	<T, M extends Memento<T>> void restoreMemento(M memento);

}
