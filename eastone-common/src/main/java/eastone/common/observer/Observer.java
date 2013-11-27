/*
 * File:Observer.java Type:eastone.common.observer.Observer
 */
package eastone.common.observer;

/**
 * 观察者.
 * <p>
 * <h1>修改列表:</h1>
 * <ol>
 * <li>初始版本, by wangdongshi@neusoft.com, 2013-11-7 下午1:28:12</li>
 * </ol>
 * </p>
 * @author 王东石 <wangdongshi@neusoft.com>
 * @version 0.1.1
 * @since 0.1
 */
public interface Observer {

  /**
   * 获得被观察者.
   * @param <S> 被观察者类型.
   * @return 被观察者.
   */
  <S extends Subject> S getSubject();

  /**
   * 设置被观察者.
   * @param <S> 被观察者类型.
   * @param subject 被观察者.
   */
  <S extends Subject> void setSubject(S subject);

  /**
   * 处理被观察者状态更新情况.
   */
  void update();

}
