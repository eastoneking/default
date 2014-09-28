/*
 * File:AbstractSQLExecutor.java
 * Type:eastone.component.database.AbstractSQLExecutor
 */
package eastone.component.database;

import eastone.common.GeneralParentObject;

/**
 * 数据库执行抽象接口.
 * <p>
 * <ol>
 * <li>初始版本,by wangds@gmail.com, 2013-10-17 12:00:54</li>
 * <li>根据check style修改格式, by wangds@gmail.com, 2013-10-27 14:42</li>
 * </ol>
 * </p>
 * @param <S> 数据库资源类型
 * @param <R> 结果集类型
 * @param <E> 可能抛出的异常
 * @author 王东石 <wangdongshi@neusoft.com>
 * @version 0.1.1
 * @since 0.1
 */
public abstract class AbstractSQLExecutor<S, R, E extends Exception> extends
    GeneralParentObject implements SQLExecutor<S, R, E> {

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

  public R getResult() {
    return result;
  }

  public void setResult(final R theResult) {
    this.result = theResult;
  }

  /**
   * 获得数据库资源.
   * @return 数据库资源.
   */
  public S getDBResource() {
    return dBResource;
  }

  public void setDBResource(final S resource) {
    this.dBResource = resource;
  }

  public void setCommandText(final String theCommandText) {
    this.commandText = theCommandText;
  }

  public String getCommandText() {
    return this.commandText;
  }

  public <T> void setParameters(final T theParameters) {
    this.parameters = (Object) theParameters;
  }

  @SuppressWarnings("unchecked")
  public <T> T getParameters() {
    return (T) this.parameters;
  }

  /**
   * 业务处理.
   * @throws E 异常.
   */
  public void process() throws E {
    this.setResult(executeSQL(this.dBResource, this.commandText,
        this.parameters));
  }

  /**
   * 执行SQL语句.
   * @param theDBResource 数据源.
   * @param theCommandText SQL文本.
   * @param theParameters 参数.
   * @return 执行结果.
   * @throws E 可能发生的异常.
   */
  protected abstract R executeSQL(S theDBResource, String theCommandText,
      Object theParameters) throws E;

}
