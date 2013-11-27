/*
 * File:Operation.java Type:eastone.common.mediator.Operation
 */
package eastone.common.mediator;

/**
 * 调用中介者进行操作的接口.
 * <p>
 * <h1>修改列表:</h1>
 * <ol>
 * <li>初始版本, by wangdongshi@neusoft.com, 2013-11-7 11:40:19</li>
 * </ol>
 * </p>
 * @param <K> 中介者中协同对象唯一标识的类型.
 * @param <C> 中介者中协同对象的基类类型.
 * @param <M> 被调用中介者类型.
 * @author 王东石 <wangdongshi@neusoft.com>
 * @version 0.1.1
 * @since 0.1
 */
public interface Operation<K, C extends Colleague, M extends Mediator<K, C>> {

  /**
   * 设置被调用中介者.
   * @param mediator 被调用中介者.
   */
  void setMediator(M mediator);

  /**
   * 设置被调用中介者.
   * @return 被调用中介者.
   */
  M getMediator();
}
