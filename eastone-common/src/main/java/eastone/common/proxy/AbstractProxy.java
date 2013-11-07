/*
 * File:AbstractProxy.java
 * Type:eastone.common.proxy.AbstractProxy
 */
package eastone.common.proxy;

import eastone.common.GeneralParentObject;

/**
 * 抽象代理类.
 * <p>
 * 	<h1>修改列表:</h1>
 *  <ol>
 *    <li>初始版本, by wangdongshi@neusoft.com, 2013-11-7 上午9:45:33</li>
 *  </ol>
 * </p>
 *
 * @param <Subject> 被代理的对象类型.
 * @author 王东石 <wangdongshi@neusoft.com>
 * @version 0.1.1
 * @since 0.1
 *
 */
public class AbstractProxy<Subject>
	extends GeneralParentObject
	implements Proxy<Subject> {

	/**
	 * 被代理对象.
	 */
	private Subject subject;

	@Override
	public Subject getSubject() {
		return this.subject;
	}

	@Override
	public void setSubject(Subject subject) {
		this.subject = subject;
	}

}
