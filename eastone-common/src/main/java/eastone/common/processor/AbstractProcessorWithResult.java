package eastone.common.processor;

/**
 * 抽象的带有执行结果的处理器.
 * <p>
 * 保存实现了执行结果的接口器.
 * </p>
 * <p>
 * 修改列表:
 * <ol>
 * <li>
 * <ul>
 * <li>补充注释</li>
 * <li>增加方法{@link #clear()},用于清理结果.</li>
 * <li>修改方法{@link #process()},在开始处理之前检查结果是否为空,如果不为空,抛出异常,提示结果未清理.</li>
 * </ul>
 * by wangdongshi@neusoft.com 2013-10-13 10:40</li>
 * </ol>
 * </p>
 * @param <T>
 *          执行结果的类型.
 * @param <E>
 *          执行过程中可能出现的异常,必须继承自{@link java.lang.Exception}.
 * @author 王东石 <wangdongshi@neusoft.com>
 * @version 0.1.1
 * @since 0.1
 */
public abstract class AbstractProcessorWithResult<T, E extends Exception>
    extends eastone.common.GeneralParentObject implements
    ProcessorWithResult<T, E> {

  /**
   * 保存执行结果的属性.
   */
  private T result = null;

  @Override
  public final void setResult(final T theResult) {
    this.result = theResult;
  }

  @Override
  public final T getResult() {
    return this.result;
  }

  @Override
  public final void process() throws E {
    if (this.result != null) {
      return;
    }
    this.setResult(execute());
  }

  /**
   * 执行方法.
   * @return 执行结果.
   * @throws E
   *           异常.
   */
  protected abstract T execute() throws E;

  /**
   * 清理状态.
   */
  public final void clear() {
    this.result = null;
  }

}
