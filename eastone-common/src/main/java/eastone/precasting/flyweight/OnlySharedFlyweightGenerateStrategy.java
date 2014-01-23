/*
 * create time: 2013年12月7日 上午12:15:18
 * path: OnlySharedFlyweightGenerateStrategy.java
 * type: eastone.precasting.flyweight.OnlySharedFlyweightGenerateStrategy
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
 *           wangds@gmail.com, 2013年12月7日 上午12:15:18
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
public class OnlySharedFlyweightGenerateStrategy<K, F extends Flyweight>
    extends AbstractFlyweightGenerateStrategy<K, F> {

  /**
   * .
   * @param initFactoriesContext .
   */
  public OnlySharedFlyweightGenerateStrategy(
      final DefaultFlyweightFactory<K, F> initFactoriesContext) {
    super(initFactoriesContext);
  }

  @Override
  protected F generateInstanceByKey(final K key)
      throws StrategyRuntimeException {
    return this.getFactoriesContext().findFlyweightInstance(key);
  }


}
