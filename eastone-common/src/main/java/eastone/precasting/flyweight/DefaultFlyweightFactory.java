/*
 * create time: 2013年12月6日 下午10:44:20
 * path: FlyweightFactory.java
 * type: eastone.precasting.flyweight.FlyweightFactory
 */
package eastone.precasting.flyweight;

import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;

import eastone.common.factory.Factory;
import eastone.common.flyweight.Flyweight;
import eastone.common.flyweight.FlyweightFactory;
import eastone.common.strategy.AbstractStrategyContext;
import eastone.common.strategy.Strategy;
import eastone.common.strategy.StrategyRuntimeException;
import eastone.common.visitor.Visitable;

/**
 * .
 * <p>
 *   <ul>
 *     <li>修改列表:
 *       <ol>
 *         <li>
 *           wangds@gmail.com, 2013年12月6日 下午10:44:20
 *           <p>初始版本.</p>
 *         </li>
 *       </ol>
 *     </li>
 *   </ul>
 * </p>
 * @param <K> 享元标识类型.
 * @param <F> 实例类型.
 * @author 王东石<wangds@gmail.com>
 * @version 0.1
 * @since 0.1
 */
public class DefaultFlyweightFactory<K, F extends Flyweight>
  extends AbstractStrategyContext<K, StrategyRuntimeException>
  implements
    FlyweightFactory<K, F>,
    Visitable<FlyweightGenerateStrategyVisitor<K, F>> {

  /**
   * 示例图.
   */
  private final Map<K, F> instanceMap = new Hashtable<K, F>();
  /**
   * 工厂图.
   */
  private final Map<K, Factory<F, Exception>> factoriesMap;
  /**
   * 构造函数.
   * <p>
   * 默认使用{@link LinkedHashMap}存储关键字-工厂图.
   * </p>
   * @param strategyMap 策略图.
   */
  public DefaultFlyweightFactory(final Map<K, Strategy<K>> strategyMap) {
    this(new LinkedHashMap<K, Factory<F, Exception>>(), strategyMap);
  }
  /**
   * 构造函数.
   * @param map 关键字-工厂图.
   * @param strategyMap 策略图.
   */
  public DefaultFlyweightFactory(
      final Map<K, Factory<F, Exception>> map,
      final Map<K, Strategy<K>> strategyMap
  ) {
    super(strategyMap);
    this.factoriesMap = map;
  }
  /**
   * 本次调用{@link #getFlyweight(Object)}时的享元唯一识别标识.
   */
  private K currentKey = null;

  /**
   * 本次调用{@link #getFlyweight(Object)}的结果.
   */
  private F currentInstance = null;

  @Override
  public F getFlyweight(final K key) {
    F res = null;
    this.currentKey = key;
    try {
      res = this.factoriesMap.get(key).getInstance();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    this.currentInstance = res;
    return res;
  }

  /**
   * 获得内部唯一识别标识-工厂图.
   * @return 唯一识别标识-工厂图.
   */
  protected Map<K, Factory<F, Exception>> getFactoriesMapRef() {
    return this.factoriesMap;
  }
  /**
   * 注册工厂类到唯一识别标识-工厂图.
   * @param theKey 唯一识别标识.
   * @param factory 工厂实例.
   */
  public void registerFactory(
      final K theKey,
      final Factory<F, Exception> factory
  ) {
    this.factoriesMap.put(theKey, factory);
  }

  /**
   * 查找共享实例.
   * @param theKey 关键字.
   * @return 实例.
   */
  protected F findFlyweightInstance(final K theKey) {
    F res = null;
    res = this.instanceMap.get(theKey);
    return res;
  }

  @Override
  protected <S extends Strategy<K>> void proccessStrategry(final S strategy)
      throws StrategyRuntimeException {
  }

  @Override
  public void accept(final FlyweightGenerateStrategyVisitor<K, F> visitor) {
    visitor.setFactoryInstanceMap(this.instanceMap);
    visitor.setKey(this.currentKey);
    visitor.setInstance(this.currentInstance);
    visitor.visit();
    visitor.clear();
  }

}
