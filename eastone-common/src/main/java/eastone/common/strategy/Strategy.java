/*
 * File:Strategy.java Type:eastone.common.strategy.Strategy
 */
package eastone.common.strategy;

import eastone.common.Component;

/**
 * 策略模式.
 * <p>
 * <h1>修改列表:</h1>
 * <ol>
 * <li>初始版本, by wangdongshi@neusoft.com, 2013-11-7 下午1:13:03</li>
 * <li>wangds@gmail.com, 2013-12-06 19:44<p>添加key属性.</p></li>
 * <li>增加属主上下文属性,继承 {@link Component} 。2014-09-28 21:15 @D51</li>
 * </ol>
 * </p>
 * @param <K> 唯一标识类型.
 * @author 王东石 <wangdongshi@neusoft.com>
 * @version 0.1.1
 * @since 0.1
 */
public interface Strategy <K> extends Component{

  /**
   * 设置唯一识别标识.
   * @param key 唯一识别标识.
   */
  void setKey(K key);
  /**
   * 获得唯一识别标识.
   * @return 唯一识别标识.
   */
  K getKey();
  /**
   * 获得属主上下文.
   * @author wangds 2014年9月28日 下午9:00:11.
   * @return 属主上下文。
   */
  <C extends StrategyContext<K>> C getContext();
  /**
   * 设置属主上下文.
   * @author wangds 2014年9月28日 下午9:01:24.
   * @param ctx 属主上下文。
   */
  <C extends StrategyContext<K>> void setContext(C ctx);
  
}
