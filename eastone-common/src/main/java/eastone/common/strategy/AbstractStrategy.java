/*
 * create time: 2013年12月6日 下午11:35:02
 * path: AbstractStrategy.java
 * type: eastone.common.strategy.AbstractStrategy
 */
package eastone.common.strategy;

import eastone.common.GeneralParentObject;

/**
 * 抽象策略.
 * <p>
 *   <ul>
 *     <li>修改列表:
 *       <ol>
 *         <li>
 *           wangds@gmail.com, 2013年12月6日 下午11:35:02
 *           <p>初始版本.</p>
 *         </li>
 *       </ol>
 *     </li>
 *     <li>增加属主上下文接口.
 *     </li>
 *   </ul>
 * </p>
 * @param <K> 唯一识别编号类型.
 * @author 王东石<wangds@gmail.com>
 * @version 0.1
 * @since 0.1
 */
public class AbstractStrategy<K>
  extends GeneralParentObject
  implements Strategy<K> {

  private StrategyContext<K> ownerContext;
  /**
   * 唯一识别编号.
   */
  private K key;

  @Override
  public void setKey(final K newkey) {
    this.key = newkey;
  }

  @Override
  public K getKey() {
    return this.key;
  }

/*
 * @see eastone.common.strategy.Strategy#getContext()
 * @author wangds 2014年9月28日 下午9:02:04.
 */
@SuppressWarnings("unchecked")
@Override
public <C extends StrategyContext<K>> C getContext() {
    return (C)this.ownerContext;
}

/*
 * @see eastone.common.strategy.Strategy#setContext(eastone.common.strategy.StrategyContext)
 * @author wangds 2014年9月28日 下午9:02:04.
 */
@Override
public <C extends StrategyContext<K>> void setContext(C ctx) {
    this.ownerContext = ctx;
}

}
