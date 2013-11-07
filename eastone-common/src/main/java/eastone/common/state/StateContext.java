/*
 * File:StateContext.java
 * Type:eastone.common.state.StateContext
 */
package eastone.common.state;

/**
 * 状态上下文.
 * <p>
 * 	<h1>修改列表:</h1>
 *  <ol>
 *    <li>初始版本, by wangdongshi@neusoft.com, 2013-11-7 下午12:49:58</li>
 *  </ol>
 * </p>
 *
 *
 * @author 王东石 <wangdongshi@neusoft.com>
 * @version 0.1.1
 * @since 0.1
 *
 */
public interface StateContext {
	/**
	 * 获得当前状态.
	 * @param <S> 状态类型.
	 * @return 当前状态.
	 */
	<S extends State> S getState();

	/**
	 * 设置当前状态.
	 * @param <S> 状态类型.
	 * @param state 当前状态.
	 */
	<S extends State> void setState(S state);

}
