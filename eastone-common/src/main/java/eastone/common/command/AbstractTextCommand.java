/*
 * File:AbstractTextCommand.java Type:eastone.common.command.AbstractTextCommand
 */
package eastone.common.command;

/**
 * 抽象文本命令.
 * <p>
 * <h1>修改列表:</h1>
 * <ol>
 * <li>初始版本, by wangds@gmail.com, 2013-11-7 上午10:53:42</li>
 * <li>wangds@gmail.com, 2013-11-27 19:46
 * <p>
 * <li>根据PMD插件提示，将 方法{@link #setCommandText(String)}参数设置为“final”参数。</li>
 * </p>
 * </li>
 * </ol>
 * </p>
 * @param <E>
 *          异常.
 * @author 王东石 <wangdongshi@neusoft.com>
 * @version 0.1.1
 * @since 0.1
 */
public abstract class AbstractTextCommand<E extends Exception> extends
    AbstractCommand<E> {

  /**
   * 命令文本.
   */
  private String commandText;

  /**
   * 获得命令文本.
   * @return 命令文本.
   */
  public final String getCommandText() {
    return commandText;
  }

  /**
   * 设置命令文本.
   * @param theCommandText
   *          命令文本.
   */
  public final void setCommandText(final String theCommandText) {
    this.commandText = theCommandText;
  }

}
