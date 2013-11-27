package eastone.common.processor;

/**
 * 可关闭接口.
 * <p>
 * 修改列表:
 * <ol>
 * <li>建立初始版本, wangdongshi@neusoft.com, 2013-10-16 13:16.</li>
 * </ol>
 * </p>
 * @author 王东石 <wangdongshi@neusoft.com>
 * @version 0.1.1
 * @since 0.1
 */
public interface Closeable {

  /**
   * 关闭方法.
   */
  void close();

}
