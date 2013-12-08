/*
 * create time: 2013年12月8日 下午10:45:17
 * path: UpdateFlyweightInContextVisitor.java
 * type: eastone.precasting.flyweight.UpdateFlyweightInContextVisitor
 */
package eastone.precasting.flyweight;

import java.util.Map;

import eastone.common.flyweight.Flyweight;

/**
 * .
 * <p>
 *   <ul>
 *     <li>修改列表:
 *       <ol>
 *         <li>
 *           wangds@gmail.com, 2013年12月8日 下午10:45:17
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
public class UpdateFlyweightInContextVisitor<K, F extends Flyweight>
  extends AbstractFlyweightGenerateStrategyVisitor<K, F> {

  /**
   * .
   */
  public UpdateFlyweightInContextVisitor() {
  }

  @Override
  public void visit() {
    Map<K, F> map = this.getFactoryInstanceMap();
    F inst = this.getInstance();
    K key = this.getKey();
    map.put(key, inst);
  }

}
