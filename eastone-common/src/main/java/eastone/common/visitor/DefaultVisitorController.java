/*
 * File:DefaultVisitorController.java
 * Type:eastone.common.visitor.DefaultVisitorController
 */
package eastone.common.visitor;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import eastone.common.GeneralParentObject;

/**
 * {@link VisitorController}的默认实现.
 * <p>
 * <h1>修改列表:</h1>
 * <ol>
 * <li>初始版本, by wangdongshi@neusoft.com, 2013-11-7 下午3:03:47</li>
 * </ol>
 * </p>
 * @param <E> 被访问者类型.
 * @param <V> 访问者类型.
 * @author 王东石 <wangdongshi@neusoft.com>
 * @version 0.1.1
 * @since 0.1
 */
public class DefaultVisitorController
  <V extends Visitor, E extends Visitable<V>>
  extends GeneralParentObject
  implements VisitorController<V, E> {

  /**
   * 访问者注册图.
   */
  @SuppressWarnings("rawtypes")
  private final Map<Class, List<Visitor>> registedVisitorMap
    = new LinkedHashMap<Class, List<Visitor>>(
      0);

  @Override
  public void registorVisitor(final Class<E> type, final V visitor) {

    List<Visitor> list = this.registedVisitorMap.get(type);
    if (list == null) {
      list = new LinkedList<Visitor>();
      this.registedVisitorMap.put(type, list);
    }

    list.add(visitor);

  }

  @Override
  public void disregister(final Class<E> type, final V visitor) {
    List<Visitor> list = this.registedVisitorMap.get(type);
    if (list == null) {
      list = new LinkedList<Visitor>();
      this.registedVisitorMap.put(type, list);
    }

    list.remove(visitor);
  }

  @Override
  public void clear(final Class<E> type) {
    List<Visitor> list = this.registedVisitorMap.get(type);
    if (list == null) {
      list = new LinkedList<Visitor>();
      this.registedVisitorMap.put(type, list);
    }

    list.clear();
  }

  @Override
  public void clear() {
    this.registedVisitorMap.clear();
  }

  @SuppressWarnings({"unchecked" })
  @Override
  public List<V> findVisitors(final Class<E> type) {
    List<Visitor> list = this.registedVisitorMap.get(type);
    if (list == null) {
      list = new LinkedList<Visitor>();
      this.registedVisitorMap.put(type, list);
    }
    return (List<V>) list;
  }

  @SuppressWarnings("unchecked")
  @Override
  public void invokeVisitors(final E visitable) {
    if (visitable == null) {
      return;
    }

    List<V> visitors =  this.findVisitors((Class<E>) visitable.getClass());
    for (V visitor : visitors) {
      visitable.accept(visitor);
    }

  }

}
