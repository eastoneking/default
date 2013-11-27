/*
 * File:Memento.java Type:eastone.common.memonto.Memento
 */
package eastone.common.memento;

/**
 * 备忘接口.
 * <p>
 * <h1>修改列表:</h1>
 * <ol>
 * <li>初始版本, by wangdongshi@neusoft.com, 2013-11-7 下午12:24:59</li>
 * </ol>
 * </p>
 * @param <T> 备忘内容类型.
 * @author 王东石 <wangdongshi@neusoft.com>
 * @version 0.1.1
 * @since 0.1
 */
public interface Memento<T> {
  /**
   * 获得备忘状态.
   * @return 备忘状态.
   */
  T getState();

  /**
   * 设置备忘状态.
   * @param state 备忘状态.
   */
  void setState(T state);

}
