/*
 * File:NonTerminalExpression.java
 * Type:eastone.common.interpreter.NonTerminalExpression
 */
package eastone.common.interpreter;

import eastone.common.context.Context;

/**
 * 非原子表达式.
 * <p>
 * <h1>修改列表:</h1>
 * <ol>
 * <li>初始版本, by wangdongshi@neusoft.com, 2013-11-7 上午11:18:46</li>
 * </ol>
 * </p>
 * @param <C> 上下文.
 * @author 王东石 <wangdongshi@neusoft.com>
 * @version 0.1.1
 * @since 0.1
 */
public interface NonTerminalExpression
  <C extends Context> extends Expression<C> {

}
