/*
 * File:Subject.java
 * Type:eastone.common.observer.Subject
 */
package eastone.common.observer;

/**
 * 被观察者接口.
 * <p>
 * 	<h1>修改列表:</h1>
 *  <ol>
 *    <li>初始版本, by wangdongshi@neusoft.com, 2013-11-7 下午1:29:40</li>
 *  </ol>
 * </p>
 *
 *
 * @author 王东石 <wangdongshi@neusoft.com>
 * @version 0.1.1
 * @since 0.1
 *
 */
public interface Subject {

	/**
	 * 添加观察者.
	 * @param <O> 观察者类型.
	 * @param observer 观察者.
	 */
	<O extends Observer> void attach(O observer);

	/**
	 * 移除观察者.
	 * @param <O> 观察者类型.
	 * @param observer 观察者.
	 */
	<O extends Observer> void detach(O observer);

	/**
	 * 通知观察者状态变更.
	 */
	void notifyAllObservers();

}
