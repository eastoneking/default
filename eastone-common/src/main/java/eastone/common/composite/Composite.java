/*
 * File:Composite.java Type:eastone.common.composite.Composite
 */
package eastone.common.composite;

import java.util.Collection;

import eastone.common.Component;

/**
 * Composite模式.
 * <p>
 * <h1>修改列表:</h1>
 * <ol>
 * <li>初始版本, by wangdongshi@neusoft.com, 2013-11-7 08:46:41</li>
 * </ol>
 * </p>
 * @param <C> 组件接口的基类.
 *          <p>
 *          根据使用情况的要求，在API中会提供更为明确的组件基类，比如：在图形交互的应用中， 可能会有所有图形界面组件都继承自
 *          <code>GUIComponent</code>接口的设计，这时就应使 <code>GUIComponent</code>接口继承
 *          {@link Component}接口，作为图形界面组件的公共 基类。此时实现<code>GUIComponent</code>
 *          的组合模式时，应当使用 <code>GUIComponent</code>作为此参数.
 *          </p>
 * @param <I> 在组合中能够唯一标识组合中组件的唯一标识的类型.
 * @author 王东石 <wangdongshi@neusoft.com>
 * @version 0.1.1
 * @since 0.1
 */
public interface Composite<C extends Component, I> extends Component {

  /**
   * 添加组件.
   * @param <T> 组件类型.
   * @param component 被添加组件.
   */
  <T extends C> void add(T component);

  /**
   * 删除组件.
   * @param <T> 组件类型.
   * @param component 被删除的组件.
   */
  <T extends C> void remove(T component);

  /**
   * 根据标识移除组合中的组件.
   * @param identity 组件标识.
   */
  void remove(I identity);

  /**
   * 删除所有组件.
   */
  void clear();

  /**
   * 获得组件.
   * @param <T> 组件类型.
   * @param identity 组件识别标识.
   * @return 组件.
   */
  <T extends C> T getComponent(I identity);

  /**
   * 获得所有组件列表.
   * @return 所有组件列表.
   */
  Collection<C> listAllComponent();

}
