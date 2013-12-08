/*
 * create time: 2013年12月8日 下午11:23:30
 * path: UpdateFlayweightInContextByClassVisitor.java
 * type: eastone.precasting.flyweight.UpdateFlayweightInContextByClassVisitor
 */
package eastone.precasting.flyweight;

import eastone.common.flyweight.Flyweight;
import eastone.common.flyweight.SharedFlyweight;

/**
 * .
 * <p>
 *   <ul>
 *     <li>修改列表:
 *       <ol>
 *         <li>
 *           wangds@gmail.com, 2013年12月8日 下午11:23:30
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
public class UpdateFlayweightInContextByClassVisitor<K, F extends Flyweight>
  extends UpdateFlyweightInContextVisitor<K, F> {

  /**
   * .
   */
  public UpdateFlayweightInContextByClassVisitor() {
  }

  @Override
  public void visit() {
    if (this.getInstance() instanceof SharedFlyweight) {
      super.visit();
    }
  }

}
