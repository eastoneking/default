/*
 * File:Invoker.java Type:eastone.common.command.Invoker
 */
package eastone.common.command;

/**
 * 命令调用者.
 * <p>
 * <h1>修改列表:</h1>
 * <ol>
 * <li>初始版本, by wangdongshi@neusoft.com, 2013-11-7 上午10:29:56</li>
 * </ol>
 * </p>
 * @author 王东石 <wangdongshi@neusoft.com>
 * @version 0.1.1
 * @since 0.1
 */
public interface Invoker {

  /**
   * 构建命令对象.
   * @param <C> 命令.
   * @param <R> 接收者类型.
   * @param receiver 命令接收者.
   * @param command 命令.
   * @return 设置接收者的命令.
   */
  <C extends Command, R extends CommandReceiver>
    C buildCommand(
      R receiver, C command);

  /**
   * 调用命令.
   * @param <C> 命令类型.
   * @param command 命令.
   * @throws E 命令执行中可能的异常.
   */
  <C extends Command> void invoke(C command);

}
