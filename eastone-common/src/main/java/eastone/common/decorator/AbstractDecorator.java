/*
 * File:AbstractDecorator.java
 * Type:eastone.common.decorator.AbstractDecorator
 */
package eastone.common.decorator;

import eastone.common.Component;
import eastone.common.GeneralParentObject;

/**
 * 抽象装饰类.
 * <p>
 * 	<h1>修改列表:</h1>
 *  <ol>
 *    <li>初始版本, by wangdongshi@neusoft.com, 2013-11-7 上午9:26:41</li>
 *  </ol>
 * </p>
 *
 * @param <C> 被装饰组件类型.
 * @author 王东石 <wangdongshi@neusoft.com>
 * @version 0.1.1
 * @since 0.1
 *
 */
public abstract class AbstractDecorator <C extends Component>
extends GeneralParentObject
implements Decorator <C> {

	/**
	 * 被装饰组件.
	 */
	private C component;

	//@Override
	@Override
	public C getComponent() {
		return this.component;
	}

	//@Override
	@Override
	public void setComponent(C component) {
		this.component = component;
	}

}
