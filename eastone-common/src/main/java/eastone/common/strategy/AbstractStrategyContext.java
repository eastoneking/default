/*
 * create time: 2013年12月1日 下午11:26:49
 * path: AbstractStrategyContext.java
 * type: eastone.common.strategy.AbstractStrategyContext
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
 *         <li>
 *           wangds@gmail.com, 2013年12月3日 上午08:48
 *           <ul>
 *              <li>类名从DefaultStrategyContext变更为AbstractStrategyContext;</li>
 *              <li>类变更为抽象类;</li>
 *              <li>
 *                  {@link #AbstractStrategyContext(Map)}访问修饰符改为
 *                  “protected”.
 *              </li>
 *           </ul>
 *         </li>
 *       </ol>
 *     </li>
 *   </ul>
 * </p>
 * @param <K> KEY类型.
 * @param <E> 执行策略时可能抛出的异常.
 * @author 王东石<wangds@gmail.com>
 * @version 0.1
 * @since 0.1
 */
public abstract class AbstractStrategyContext
  <K, E extends StrategyRuntimeException>
  extends GeneralParentObject
  implements StrategyContext<K, E> {

  /**
   * 策略图.
   */
  private final Map<K, Strategy> contextMap;

  /**
   * 选中的策略.
   */
  private K selectedStrategy;

  /**
   * 构造函数.
   * @param theStrategyMap 用于保存策略图的Map实例.
   * <p>根据策略图的需要，选择不同该类型的{@link Map}类实例.</p>
   */
  protected AbstractStrategyContext(final Map<K, Strategy> theStrategyMap) {
    this.contextMap = theStrategyMap;
  }

  /**
   * 设置selectedStrategy属性值.
   * @param theSelectedStrategy selectedStrategy属性的新值。
   */
  public void setSelectedStrategy(K theSelectedStrategy) {
    this.selectedStrategy = theSelectedStrategy;
  }

  /**
   * 获得selectedStrategy属性值.
   * @return selectedStrategy属性现值。
   */
  public K getSelectedStrategy() {
    return selectedStrategy;
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
  public void clearStrategyMap() {
    this.contextMap.clear();
  }

  @Override
  public Map<K, Strategy> getStrategyMap() {
    return this.contextMap;
  }

  @Override
  public void process() throws E {
    Strategy selectStrategy = this.findStrategy(selectedStrategy);
    if (selectStrategy != null) {
      proccessStrategry(selectStrategy);
    }
  }

  /**
   * 执行策略.
   * @param <S> 被执行策略类型.
   * @param strategy 被执行策略.
   * @throws E 执行期间可能发生的异常.
   */
  protected abstract <S extends Strategy> void proccessStrategry(S strategy)
      throws E;

}
