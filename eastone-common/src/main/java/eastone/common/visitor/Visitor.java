/*
 * File:Visitor.java
 * Type:eastone.common.visitor.Visitor
 */
package eastone.common.visitor;

/**
 * 访问者.
 * <p>
 * 	<h1>修改列表:</h1>
 *  <ol>
 *    <li>初始版本, by wangdongshi@neusoft.com, 2013-11-7 下午1:38:41</li>
 *  </ol>
 * </p>
 *
 * @param <E> 能够接受访问者访问的类型.
 * @author 王东石 <wangdongshi@neusoft.com>
 * @version 0.1.1
 * @since 0.1
 *
 */
public interface Visitor<E extends Visitable> {

	/**
	 * 访问被访问者.
	 * @param visitable 被访问者.
	 */
	void visit(E visitable);

}
