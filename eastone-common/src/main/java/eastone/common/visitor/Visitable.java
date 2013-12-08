/*
 * File:Visitable.java Type:eastone.common.visitor.Visitable
 */
package eastone.common.visitor;

/**
 * 可访问接口.
 * <p>
 *   <h1>修改列表:</h1>
 *   <ol>
 *     <li>初始版本, by wangdongshi@neusoft.com, 2013-11-7 下午1:38:20</li>
 *   </ol>
 * </p>
 * @param <V> 调用的访问者类型.
 * @author 王东石 <wangdongshi@neusoft.com>
 * @version 0.1.1
 * @since 0.1
 */
public interface Visitable <V extends Visitor> {

  /**
   * 接受访问者.
   * @param visitor 访问者.
   */
  void accept(V visitor);

}
