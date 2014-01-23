/*
 * File:AbstractCommand.java Type:eastone.common.command.AbstractCommand
 */
package eastone.common.command;

import eastone.common.GeneralParentObject;

/**
 * 抽象命令实现.
 * <p>
 * <h1>修改列表:</h1>
 * <ol>
 * <li>初始版本, by wangdongshi@neusoft.com, 2013-11-7 上午10:46:29</li>
 * <li>wangds@gmail.com, 2013-11-27 19:42
 * <p>
 * <ul>
 * <li>根据PMD插件提示，将 方法{@link #setReceiver(CommandReceiver)}参数设置为 “final”参数。</li>
 * <li>根据PMD插件提示，移除属性 {@link #receiver}的初始化为“null”的语句。</li>
 * </ul>
 * </p>
 * </li>
 * </ol>
 * </p>
 * @param <E>
 *          命令执行过程中可能的异常.
 * @author 王东石 <wangdongshi@neusoft.com>
 * @version 0.1.1
 * @since 0.1
 */
public abstract class AbstractCommand<E extends Exception> extends
    GeneralParentObject implements Command<E> {

  /**
   * 命令接收者.
   */
  private CommandReceiver receiver;

  @Override
  public <R extends CommandReceiver> void setReceiver(
      final R theReceiver
  ) {
    this.receiver = theReceiver;
  }

  @SuppressWarnings("unchecked")
  @Override
  public <R extends CommandReceiver> R getReceiver() {
    return (R) this.receiver;
  }

}
