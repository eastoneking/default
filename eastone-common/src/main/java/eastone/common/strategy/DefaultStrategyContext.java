/*
 * create time: 2013年12月1日 下午11:26:49
 * path: DefaultStrategyContext.java
 * type: eastone.common.strategy.DefaultStrategyContext
 */
package eastone.common.strategy;

import java.util.Map;

import eastone.common.GeneralParentObject;

/**
 * 策略上下文默认实现类.
 * <p>
 *   <ul>
 *     <li>修改列表:
 *       <ol>
 *         <li>
 *           wangds@gmail.com, 2013年12月1日 下午11:26:49
 *           <p>初始版本.</p>
 *         </li>
 *       </ol>
 *     </li>
 *   </ul>
 * </p>
 * @param <K> KEY类型.
 * @author 王东石<wangds@gmail.com>
 * @version 0.1
 * @since 0.1
 */
public class DefaultStrategyContext<K> extends GeneralParentObject implements
    StrategyContext<K> {

  /**
   * .
   */
  private final Map<K, Strategy> contextMap;

  /**
   * 构造函数.
   * @param theStrategyMap 用于保存策略图的Map实例.
   * <p>根据策略图的需要，选择不同该类型的{@link Map}类实例.</p>
   */
  public DefaultStrategyContext(final Map<K, Strategy> theStrategyMap) {
    this.contextMap = theStrategyMap;
  }

  @Override
  public <S extends Strategy> void registerStrategy(K key, S strategy) {
    this.contextMap.put(key, strategy);
  }

  @SuppressWarnings("unchecked")
  @Override
  public <S extends Strategy> S findStrategy(K key) {
    return (S) this.contextMap.get(key);
  }

  @Override
  public void disregister(K key) {
    this.contextMap.remove(key);
  }

  @Override
  public void clear() {
    this.contextMap.clear();
  }

  @Override
  public Map<K, Strategy> getStrategyMap() {
    return this.contextMap;
  }

}
