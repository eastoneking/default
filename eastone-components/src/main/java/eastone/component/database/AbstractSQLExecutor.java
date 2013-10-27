/*
 * File:AbstractSQLExecutor.java
 * Type:eastone.component.database.AbstractSQLExecutor
 */
package eastone.component.database;

import eastone.common.Object;

/**
 * 数据库执行抽象接口.
 *
 * <p>
 *  <ol>
 *    <li>初始版本,by wangds@gmail.com, 2013-10-17 12:00:54</li>
 *    <li>根据check style修改格式, by wangds@gmail.com, 2013-10-27 14:42</li>
 *  </ol>
 * </p>
 *
 * @param <S> 数据库资源类型
 * @param <R> 结果集类型
 * @param <E> 可能抛出的异常
 *
 * @author 王东石 <wangdongshi@neusoft.com>
 * @version 0.1.1
 * @since 0.1
 */
public abstract class AbstractSQLExecutor<S, R, E extends Exception>
	extends Object implements SQLExecutor<S, R, E> {

	/**
	 * 保存执行结果.
	 */
	private R result;

	/**
	 * 数据库资源.
	 */
	private S dBResource;

	/**
	 * SQL文本或唯一标识.
	 */
	private String commandText;

	/**
	 * 执行SQL用的参数.
	 */
	private Object parameters;

	@Override
	public R getResult() {
		return result;
	}

	@Override
	public void setResult(R result) {
		this.result = result;
	}

	@Override
	public S getDBResource() {
		return dBResource;
	}

	@Override
	public void setDBResource(S resource) {
		this.dBResource = resource;
	}

	@Override
	public void setCommandText(String commandText) {
		this.commandText = commandText;
	}

	@Override
	public String getCommandText() {
		return this.commandText;
	}

	@Override
	public <T> void setParameters(T parameters) {
		this.parameters = (Object) parameters;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T getParameters() {
		return (T) this.parameters;
	}

	/* (non-Javadoc)
	 * @see eastone.common.processor.Processor#process()
	 */
	@Override
	public void process() throws E {
		this.setResult(
			executeSQL(
				this.dBResource,
				this.commandText,
				this.parameters
			)
		);
	}

	/**
	 * 执行SQL语句.
	 * @param dBResource 数据源.
	 * @param commandText SQL文本.
	 * @param parameters 参数.
	 * @return 执行结果.
	 * @throws E 可能发生的异常.
	 */
	protected abstract R executeSQL(
		S dBResource,
		String commandText,
		Object parameters
	) throws E;

}
