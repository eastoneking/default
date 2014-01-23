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

}
