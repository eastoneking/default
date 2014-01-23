/*
 * File:DefaultCommandInvoker.java
 * Type:eastone.common.command.DefaultCommandInvoker
 */
package eastone.common.command;

import eastone.common.GeneralParentObject;

/**
 * 默认命令调用者.
 * <p>
 * <h1>修改列表:</h1>
 * <ol>
 * <li>初始版本, by wangdongshi@neusoft.com, 2013-11-7 上午10:50:26</li>
 * </ol>
 * </p>
 * @author 王东石 <wangdongshi@neusoft.com>
 * @version 0.1.1
 * @since 0.1
 */
public class DefaultCommandInvoker extends GeneralParentObject implements
    Invoker {

  @Override
  public
    <E extends Exception, C extends Command<E>, R extends CommandReceiver>
    C buildCommand(
      final R receiver, final C command) {
    if (receiver != null && command != null) {
      command.setReceiver(receiver);
    }
    return command;
  }

  @Override
  public <E extends Exception, C extends Command<E>>
  void invoke(final C command)
      throws E {
    if (command != null) {
      command.process();
    }
  }

}
