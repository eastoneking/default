/*
 * File:StrategyContext.java Type:eastone.common.strategy.StrategyContext
 */
package eastone.common.strategy;

import java.util.Map;

/**
 * 策略上下文.
 * <p>
 * <h1>修改列表:</h1>
 * <ol>
 * <li>初始版本, by wangdongshi@neusoft.com, 2013-11-7 下午1:15:04</li>
 * </ol>
 * </p>
 * @param <K> 策略图中策略唯一识别标识的类型.
 * @author 王东石 <wangdongshi@neusoft.com>
 * @version 0.1.1
 * @since 0.1
 */
public interface StrategyContext<K> {

  /**
   * 注册策略.
   * @param <S> 注册策略类型.
   * @param key 策略图中策略唯一识别标识.
   * @param strategy 策略.
   */
  <S extends Strategy> void registerStrategy(K key, S strategy);

  /**
   * 从注册策略图中根据唯一标识查找策略.
   * @param <S> 注册策略类型.
   * @param key 策略图中策略唯一识别标识.
   * @return 策略.
   */
  <S extends Strategy> S findStrategy(K key);

  /**
   * 注销策略.
   * @param key 策略图中策略唯一识别标识.
   */
  void disregister(K key);

  /**
   * 注销所有策略.
   */
  void clear();

  /**
   * 获得策略图.
   * @return 策略图.
   */
  Map<K, Strategy> getStrategyMap();

}
