/*
 * File:AbstractLinkedListComposite.java
 * Type:eastone.common.composite.AbstractLinkedListComposite
 */
package eastone.common.composite;

import java.util.LinkedList;
import java.util.List;

import eastone.common.Component;
import eastone.common.GeneralParentObject;

/**
 * 使用 {@link LinkedList}作为组件存储媒介的组合模式抽象实现.
 * <p>
 * <h1>修改列表:</h1>
 * <ol>
 * <li>初始版本, by wangdongshi@neusoft.com, 2013-11-7 09:06:19</li>
 * </ol>
 * </p>
 * @param <C>
 *          组件接口的基类.
 * @author 王东石 <wangdongshi@neusoft.com>
 * @version 0.1.1
 * @since 0.1
 */
public abstract class AbstractLinkedListComposite<C extends Component> extends
    GeneralParentObject implements Composite<C, Integer> {

  /**
   * 组合中组件的存储媒介.
   */
  private final List<C> components = new LinkedList<C>();

  @Override
  public <T extends C> void add(final T component) {
    this.components.add(component);
  }

  @Override
  public <T extends C> void remove(final T component) {
    this.components.remove(component);
  }

  @Override
  public void remove(final Integer identity) {
    this.components.remove(identity.intValue());
  }

  @Override
  public void clear() {
    this.components.clear();
  }

  @SuppressWarnings("unchecked")
  @Override
  public <T extends C> T getComponent(final Integer identity) {
    T res = null;
    res = (T) this.components.get(identity.intValue());
    return res;
  }

  @Override
  public List<C> listAllComponent() {
    return this.components;
  }

}
