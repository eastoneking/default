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
 *    <li>初始版本,by wangdongshi@neusoft.com,2013-10-17 上午12:00:54</li>
 *  </ol>
 * </p>
 * 
 * @param S 数据库资源类型
 * @param R 结果集类型
 * @param E 可能抛出的异常
 * 
 * @author 王东石 <wangdongshi@neusoft.com>
 * @version 0.1.1
 * @since 0.1
 */
public abstract class AbstractSQLExecutor<S,R,E extends Exception> extends Object implements SQLExecutor<S,R,E>{
	
	/**
	 * 保存执行结果
	 */
	private R result;
	
	/**
	 * 数据库资源.
	 */
	private S dBResource;
	
	/**
	 * SQL文本或唯一标识
	 */
	private String commandText;
	
	/**
	 * 执行SQL用的参数
	 */
	private Object parameters;

	/* (non-Javadoc)
	 * @see eastone.common.processor.ResultContainer#getResult()
	 */
	@Override
	public R getResult() {
		return result;
	}

	/* (non-Javadoc)
	 * @see eastone.common.processor.ResultContainer#setResult(java.lang.Object)
	 */
	@Override
	public void setResult(R result) {
		this.result=result;
	}

	/* (non-Javadoc)
	 * @see eastone.component.database.WithDBResource#getDBResource()
	 */
	@Override
	public S getDBResource() {
		return dBResource;
	}

	/* (non-Javadoc)
	 * @see eastone.component.database.WithDBResource#setDBResource(java.lang.Object)
	 */
	@Override
	public void setDBResource(S resource) {
		this.dBResource = resource;
	}

	/* (non-Javadoc)
	 * @see eastone.component.database.SQLExecutor#setCommandText(java.lang.String)
	 */
	@Override
	public void setCommandText(String commandText) {
		this.commandText = commandText;
	}

	/* (non-Javadoc)
	 * @see eastone.component.database.SQLExecutor#getCommandText()
	 */
	@Override
	public String getCommandText() {
		return this.commandText;
	}

	/* (non-Javadoc)
	 * @see eastone.component.database.SQLExecutor#setParameters(java.lang.Object)
	 */
	@Override
	public <T> void setParameters(T parameters) {
		this.parameters = (Object)parameters;
	}

	/* (non-Javadoc)
	 * @see eastone.component.database.SQLExecutor#getParameters()
	 */
	@Override
	public <T> T getParameters() {
		return (T)this.parameters;
	}

	/* (non-Javadoc)
	 * @see eastone.common.processor.Processor#process()
	 */
	@Override
	public void process() throws E {
		this.setResult(executeSQL(this.dBResource,this.commandText,this.parameters));
	}

	/**
	 * @param dBResource
	 * @param commandText
	 * @param parameters
	 * @return
	 */
	protected abstract R executeSQL(S dBResource, String commandText, Object parameters) throws E;

}
