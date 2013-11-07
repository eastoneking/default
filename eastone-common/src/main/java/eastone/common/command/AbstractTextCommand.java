/*
 * File:AbstractTextCommand.java
 * Type:eastone.common.command.AbstractTextCommand
 */
package eastone.common.command;

/**
 * 抽象文本命令.
 * <p>
 * 	<h1>修改列表:</h1>
 *  <ol>
 *    <li>初始版本, by wangdongshi@neusoft.com, 2013-11-7 上午10:53:42</li>
 *  </ol>
 * </p>
 *
 * @param <E> 异常.
 * @author 王东石 <wangdongshi@neusoft.com>
 * @version 0.1.1
 * @since 0.1
 *
 */
public abstract class AbstractTextCommand<E extends Exception>
	extends AbstractCommand<E> {

	/**
	 * 命令文本.
	 */
	private String commandText;

	/**
	 * 获得命令文本.
	 * @return 命令文本.
	 */
	public String getCommandText() {
		return commandText;
	}

	/**
	 * 设置命令文本.
	 * @param commandText 命令文本.
	 */
	public void setCommandText(String commandText) {
		this.commandText = commandText;
	}

}
