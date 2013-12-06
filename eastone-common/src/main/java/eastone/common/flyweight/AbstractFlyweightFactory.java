/*
 * create time: 2013年12月6日 下午10:02:41
 * path: AbstractFlyweightFactory.java
 * type: eastone.common.flyweight.AbstractFlyweightFactory
 */
package eastone.common.flyweight;

import java.util.Map;

import eastone.common.GeneralParentObject;

/**
 * 抽象享元工厂.
 * <p>
 *   <ul>
 *     <li>修改列表:
 *       <ol>
 *         <li>
 *           wangds@gmail.com, 2013年12月6日 下午10:02:41
 *           <p>初始版本.</p>
 *         </li>
 *       </ol>
 *     </li>
 *   </ul>
 * </p>
 * @param <K> 享元标识类型.
 * @param <F> 享元类型.
 * @author 王东石<wangds@gmail.com>
 * @version 0.1
 * @since 0.1
 */
public abstract class AbstractFlyweightFactory<K, F extends Flyweight>
  extends GeneralParentObject
  implements FlyweightFactory<K, F> {

  /**
   * 实例图.
   */
  private final Map<K, F> instanceMap;

  /**
   * 构造函数.
   * @param map 实例图.
   */
  protected AbstractFlyweightFactory(Map<K, F> map) {
    this.instanceMap = map;
  }

  @Override
  public F getFlyweight(K key) {
    return instanceMap.get(key);
  }

}
