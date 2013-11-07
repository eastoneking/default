/*
 * File:AbstractCommand.java
 * Type:eastone.common.command.AbstractCommand
 */
package eastone.common.command;

import eastone.common.GeneralParentObject;

/**
 * 抽象命令实现.
 * <p>
 * 	<h1>修改列表:</h1>
 *  <ol>
 *    <li>初始版本, by wangdongshi@neusoft.com, 2013-11-7 上午10:46:29</li>
 *  </ol>
 * </p>
 *
 * @param <E> 命令执行过程中可能的异常.
 * @author 王东石 <wangdongshi@neusoft.com>
 * @version 0.1.1
 * @since 0.1
 *
 */
public abstract class AbstractCommand<E extends Exception>
	extends GeneralParentObject implements Command<E> {

	/**
	 * 命令接收者.
	 */
	private CommandReceiver receiver = null;

	@Override
	public <R extends CommandReceiver> void setReceiver(R receiver) {
		this.receiver = receiver;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <R extends CommandReceiver> R getReceiver() {
		return (R) this.receiver;
	}

}
