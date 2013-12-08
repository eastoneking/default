/*
 * create time: 2013年12月6日 下午11:58:43
 * path: NotSharedFlyweightGenerateStrategy.java
 * type: eastone.precasting.flyweight.NotSharedFlyweightGenerateStrategy
 */
package eastone.precasting.flyweight;

import eastone.common.flyweight.Flyweight;
import eastone.common.strategy.StrategyRuntimeException;

/**
 * .
 * <p>
 *   <ul>
 *     <li>修改列表:
 *       <ol>
 *         <li>
 *           wangds@gmail.com, 2013年12月6日 下午11:58:43
 *           <p>初始版本.</p>
 *         </li>
 *       </ol>
 *     </li>
 *   </ul>
 * </p>
 * @param <K> .
 * @param <F> .
 * @author 王东石<wangds@gmail.com>
 * @version 0.1
 * @since 0.1
 */
public class NotSharedFlyweightGenerateStrategy<K, F extends Flyweight>
  extends AbstractFlyweightGenerateStrategy<K, F> {

  /**
   * .
   * @param initFactoriesContext .
   */
  public NotSharedFlyweightGenerateStrategy(
      DefaultFlyweightFactory<K, F> initFactoriesContext) {
    super(initFactoriesContext);
  }

  @Override
  protected F generateInstanceByKey(K key) throws StrategyRuntimeException {
    return this.getFactoriesContext().getFlyweight(key);
  }

}
