package eastone.common.processor;

/**
 * 过程处理器接口.
 * <p>
 * 过程处理器一般用于完成一个完整的功能。本接口定义了方法{@link #process()}用于 执行功能。
 * </p>
 * <p>
 * 修改列表：
 * <ol>
 * <li>
 * <ul>
 * <li>补充注释</li>
 * <li>将方法<code>run()</code>更名为{@link #process()},因为方法 <code>run()</code>很可能与
 * {@link java.lang.Runnable}和 {@link java.lang.Thread}的方法<code>run()</code>
 * 覆盖.这种情况下会 出现本希望调用Process在线程中执行，而调用方法<code>run()</code> 实际上无法实现在线程中执行的效果.更改为
 * {@link #process()}之后，就可 以在{@link #process()}方法中给调用方法
 * {@link java.lang.Thread#start()}实现线程并发的效果.</li>
 * </ul>
 * by wangdongshi@neusoft.com 2013-10-13 09:20</li>
 * </ol>
 * </p>
 * @param <E> 执行过程中可能抛出的异常
 * @author 王东石 <wangdongshi@neusoft.com>
 * @version 0.1.1
 * @since 0.1
 */
public interface Processor<E extends Exception> {

  /**
   * 执行功能的方法.
   * @throws E 可能出现的异常类型.
   */
  void process() throws E;

}
