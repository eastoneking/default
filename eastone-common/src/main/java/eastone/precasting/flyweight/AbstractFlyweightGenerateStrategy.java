/*
 * create time: 2013年12月6日 下午11:12:46
 * path: AbstractFlyweightGenerateStrategy.java
 * type: eastone.precasting.flyweight.AbstractFlyweightGenerateStrategy
 */
package eastone.precasting.flyweight;

import eastone.common.flyweight.Flyweight;
import eastone.common.strategy.AbstractStrategy;
import eastone.common.strategy.StrategyRuntimeException;

/**
 * .
 * <p>
 *   <ul>
 *     <li>修改列表:
 *       <ol>
 *         <li>
 *           wangds@gmail.com, 2013年12月6日 下午11:12:46
 *           <p>初始版本.</p>
 *         </li>
 *       </ol>
 *     </li>
 *   </ul>
 * </p>
 * @param <K> 唯一识别编号类型.
 * @param <F> 享元类型.
 * @author 王东石<wangds@gmail.com>
 * @version 0.1
 * @since 0.1
 */
public abstract class AbstractFlyweightGenerateStrategy<K, F extends Flyweight>
  extends AbstractStrategy<K> {

  /**
   * 原始工厂类.
   */
  private DefaultFlyweightFactory<K, F> factoriesContext;

  /**
   * .
   * @param initFactoriesContext 工厂上下文.
   */
  public AbstractFlyweightGenerateStrategy(
    DefaultFlyweightFactory<K, F> initFactoriesContext
  ) {
    factoriesContext = initFactoriesContext;
  }

  /**
   * 设置factoriesContext属性值.
   * @param newFactoriesContext factoriesContext属性的新值。
   */
  public void setFactoriesContext(
    DefaultFlyweightFactory<K, F> newFactoriesContext
  ) {
    this.factoriesContext = newFactoriesContext;
  }

  /**
   * 获得factoriesContext属性值.
   * @return factoriesContext属性现值。
   */
  public DefaultFlyweightFactory<K, F> getFactoriesContext() {
    return factoriesContext;
  }

  /**
   * 生成享元实例方法.
   * @param key 关键字.
   * @return 实例对象.
   * @throws StrategyRuntimeException 异常.
   */
  public abstract F generateInstance(K key) throws StrategyRuntimeException;

}
