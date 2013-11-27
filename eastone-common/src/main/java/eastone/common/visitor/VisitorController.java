/*
 * File:VisitorController.java Type:eastone.common.visitor.VisitorController
 */
package eastone.common.visitor;

import java.util.List;

/**
 * 访问者控制器.
 * <p>
 * <h1>修改列表:</h1>
 * <ol>
 * <li>初始版本, by wangdongshi@neusoft.com, 2013-11-7 下午2:17:18</li>
 * </ol>
 * </p>
 * @author 王东石 <wangdongshi@neusoft.com>
 * @version 0.1.1
 * @since 0.1
 */
public interface VisitorController {

  /**
   * 注册访问者.
   * @param <E> 被访问者类型.
   * @param <V> 访问者类型.
   * @param type 被访问者类型.
   * @param visitor 访问者.
   */
  <E extends Visitable, V extends Visitor<E>> void registorVisitor(
      Class<E> type, V visitor);

  /**
   * 撤销注册.
   * @param <E> 被访问者类型.
   * @param <V> 访问者类型.
   * @param type 被访问者类型.
   * @param visitor 访问者.
   */
  <E extends Visitable, V extends Visitor<E>> void disregister(Class<E> type,
      V visitor);

  /**
   * 撤销指定类型的访问者注册.
   * @param <E> 被访问者类型.
   * @param type 被访问者类型.
   */
  <E extends Visitable> void clear(Class<E> type);

  /**
   * 撤销所有访问者注册.
   */
  void clear();

  /**
   * 查找被访问者对应的访问者列表.
   * @param <E> 被访问者类型.
   * @param <V> 访问者类型.
   * @param type 被访问者类型.
   * @return 访问者列表.
   */
  <E extends Visitable, V extends Visitor<E>>
  List<V> findVisitors(Class<E> type);

  /**
   * 触发被访者被访问.
   * @param <E> 被访问者类型.
   * @param visitable 被访问者.
   */
  <E extends Visitable> void visit(E visitable);

}
