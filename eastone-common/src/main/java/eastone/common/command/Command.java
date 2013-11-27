/*
 * File:Command.java Type:eastone.common.command.Command
 */
package eastone.common.command;

import eastone.common.processor.Processor;

/**
 * 命令接口.
 * <p>
 * <h1>修改列表:</h1>
 * <ol>
 * <li>初始版本, by wangdongshi@neusoft.com, 2013-11-7 上午10:28:08</li>
 * </ol>
 * </p>
 * @param <E> 可能的异常.
 * @author 王东石 <wangdongshi@neusoft.com>
 * @version 0.1.1
 * @since 0.1
 */
public interface Command<E extends Exception> extends Processor<E> {

  /**
   * 设置命令接收者.
   * @param <R> 命令接收者类型.
   * @param receiver 命令接收者.
   */
  <R extends CommandReceiver> void setReceiver(R receiver);

  /**
   * 获得命令接收者.
   * @param <R> 命令接收者类型.
   * @return 命令接收者
   */
  <R extends CommandReceiver> R getReceiver();

}
