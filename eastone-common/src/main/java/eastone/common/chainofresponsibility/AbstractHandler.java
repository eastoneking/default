/*
 * File:AbstractHandler.java
 * Type:eastone.common.chainofresponsibility.AbstractHandler
 */
package eastone.common.chainofresponsibility;

import eastone.common.GeneralParentObject;

/**
 * 抽象责任链处理器.
 * <p>
 * 	<h1>修改列表:</h1>
 *  <ol>
 *    <li>初始版本, by wangdongshi@neusoft.com, 2013-11-7 10:08:01</li>
 *  </ol>
 * </p>
 *
 * @param <E> 处理过程中可能出现的异常.
 * @author 王东石 <wangdongshi@neusoft.com>
 * @version 0.1.1
 * @since 0.1
 *
 */
public abstract class AbstractHandler<E extends Exception>
	extends GeneralParentObject
	implements Handler<E> {

	/**
	 * 责任链中下一个处理器.
	 */
	private Handler<E> next;

	@SuppressWarnings("unchecked")
	@Override
	public <H extends Handler<E>> H getNext() {
		return (H) this.next;
	}

	@Override
	public <H extends Handler<E>> void setNext(H next) {
		this.next = next;
	}

	@Override
	public void process() throws E {
		if (this.handle() && this.next != null) {
			this.next.process();
		}
	}

}
