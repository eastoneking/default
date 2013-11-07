/*
 * File:Visitable.java
 * Type:eastone.common.visitor.Visitable
 */
package eastone.common.visitor;

/**
 * 可访问接口.
 * <p>
 * 	<h1>修改列表:</h1>
 *  <ol>
 *    <li>初始版本, by wangdongshi@neusoft.com, 2013-11-7 下午1:38:20</li>
 *  </ol>
 * </p>
 *
 *
 * @author 王东石 <wangdongshi@neusoft.com>
 * @version 0.1.1
 * @since 0.1
 *
 */
public interface Visitable {

	/**
	 * 接受访问者.
	 * @param <E> 调用的访问者能够进行访问的类型.
	 * @param <V> 调用的访问者类型.
	 * @param visitor 访问者.
	 */
	<E extends Visitable, V extends Visitor<E>> void accept(V visitor);

}
