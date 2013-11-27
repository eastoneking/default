/*
 * File:Decorator.java Type:eastone.common.decorator.Decorator
 */
package eastone.common.decorator;

import eastone.common.Component;

/**
 * 装饰模式(Decorator).
 * <p>
 * <h1>修改列表:</h1>
 * <ol>
 * <li>初始版本, by wangdongshi@neusoft.com, 2013-11-7 上午9:20:04</li>
 * </ol>
 * </p>
 * @param <C> 被装饰组件类型.
 * @author 王东石 <wangdongshi@neusoft.com>
 * @version 0.1.1
 * @since 0.1
 */
public interface Decorator<C extends Component> {
  /**
   * 获得被装饰组件.
   * @return 被装饰组件.
   */
  C getComponent();

  /**
   * 设置被装饰组件.
   * @param component 被装饰组件.
   */
  void setComponent(C component);
}
