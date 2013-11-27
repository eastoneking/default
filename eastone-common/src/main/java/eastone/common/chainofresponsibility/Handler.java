/*
 * File:Handler.java Type:eastone.common.chainofresponsibility.Handler
 */
package eastone.common.chainofresponsibility;

import eastone.common.processor.Processor;

/**
 * 责任链中的处理器.
 * <p>
 * <h1>修改列表:</h1>
 * <ol>
 * <li>初始版本, by wangdongshi@neusoft.com, 2013-11-7 09:52:18</li>
 * </ol>
 * </p>
 * @param <E> 处理中可能发生的异常.
 * @author 王东石 <wangdongshi@neusoft.com>
 * @version 0.1.1
 * @since 0.1
 */
public interface Handler<E extends Exception> extends Processor<E> {

  /**
   * 获得下一个责任链处理器.
   * @param <H> 责任链处理器类型.
   * @return 下一个责任链处理器.
   */
  <H extends Handler<E>> H getNext();

  /**
   * 设置下一个责任链处理器.
   * @param <H> 责任链处理器类型.
   * @param next 下一个责任链处理器.
   */
  <H extends Handler<E>> void setNext(H next);

  /**
   * 执行本责任链处理过程.
   * @return 是否通过.
   * @throws E 异常类型.
   */
  boolean handle() throws E;

}
