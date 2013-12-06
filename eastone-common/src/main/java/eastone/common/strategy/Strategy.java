/*
 * File:Strategy.java Type:eastone.common.strategy.Strategy
 */
package eastone.common.strategy;

/**
 * 策略模式.
 * <p>
 * <h1>修改列表:</h1>
 * <ol>
 * <li>初始版本, by wangdongshi@neusoft.com, 2013-11-7 下午1:13:03</li>
 * <li>wangds@gmail.com, 2013-12-06 19:44<p>添加key属性.</p></li>
 * </ol>
 * </p>
 * @param <K> 唯一标识类型.
 * @author 王东石 <wangdongshi@neusoft.com>
 * @version 0.1.1
 * @since 0.1
 */
public interface Strategy <K> {

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
}
