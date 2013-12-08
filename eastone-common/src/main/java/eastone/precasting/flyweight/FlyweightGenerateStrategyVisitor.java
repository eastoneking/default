/*
 * create time: 2013年12月8日 下午10:20:12
 * path: FlyweightGenerateStrategyVisitor.java
 * type: eastone.precasting.flyweight.FlyweightGenerateStrategyVisitor
 */
package eastone.precasting.flyweight;

import java.util.Map;

import eastone.common.flyweight.Flyweight;
import eastone.common.visitor.Visitor;

/**
 * .
 * <p>
 *   <ul>
 *     <li>修改列表:
 *       <ol>
 *         <li>
 *           wangds@gmail.com, 2013年12月8日 下午10:20:12
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
public interface FlyweightGenerateStrategyVisitor<K, F extends Flyweight>
  extends Visitor {

  /**
   * 设置享元实例图.
   * @param map 实例图.
   */
  void setFactoryInstanceMap(Map<K, F> map);

  /**
   * 设置享元标识.
   * @param key 享元标识.
   */
  void setKey(K key);

  /**
   * 享元实例.
   * @param instance 实例.
   */
  void setInstance(F instance);

}
