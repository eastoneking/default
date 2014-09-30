/*
 * File:StrategyContext.java Type:eastone.common.strategy.StrategyContext
 */
package eastone.common.strategy;

import java.util.Map;

import eastone.common.annotation.Callback;
import eastone.common.composite.Composite;
import eastone.common.processor.Processor;

/**
 * 策略上下文.
 * <p>
 * <h1>修改列表:</h1>
 * <ol>
 * <li>初始版本, by wangds@gmail.com, 2013-11-7 下午1:15:04</li>
 * <li>
 *  by wangds@gmail.com, 2013-12-03 09:15
 *  <p>
 *      <ul>
 *          <li>继承{@link Processor}接口;</li>
 *          <li>添加{@link #setSelectedStrategy(Object)}方法.</li>
 *      </ul>
 *  </p>
 * </li>
 * <li>
 *      by wangds@gmail.com, 2013-12-03 10:10
 *      <p>添加 {@link #clear()}方法.</p>
 * </li>
 * </ol>
 * </p>
 * @param <K> 策略图中策略唯一识别标识的类型.
 * @param <E> 执行策略时可能抛出的异常.
 * @author 王东石 <wangds@gmail.com>
 * @version 0.1.1
 * @since 0.1
 */
public interface StrategyContext<K>
  extends Processor, Composite<Strategy<K>, K> {

  /**
   * 注册策略.
   * @param <S> 注册策略类型.
   * @param strategy 策略.
   */
  <S extends Strategy<K>> void registerStrategy(S strategy);

  /**
   * 从注册策略图中根据唯一标识查找策略.
   * @param <S> 注册策略类型.
   * @param key 策略图中策略唯一识别标识.
   * @return 策略.
   */
  <S extends Strategy<K>> S findStrategy(K key);

  /**
   * 注销策略.
   * @param key 策略图中策略唯一识别标识.
   */
  void disregister(K key);

  /**
   * 注销所有策略.
   */
  void clearStrategyMap();

  /**
   * 清理资源.
   */
  @Callback
  void clear();

  /**
   * 获得策略图.
   * @return 策略图.
   */
  Map<K, Strategy<K>> getStrategyMap();

  /**
   * 设置被选策略.
   * <p>
   * 被选策略在下次执行时生效.
   * </p>
   * @param theSelectedStrategy 被选策略.
   */
  void setSelectedStrategy(K theSelectedStrategy);

}
