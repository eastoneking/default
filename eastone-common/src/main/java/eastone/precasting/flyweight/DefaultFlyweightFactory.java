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
  implements FlyweightFactory<K, F> {

  /**
   * 工厂图.
   */
  private final Map<K, Factory<F, Exception>> factoriesMap;
  /**
   * 示例图.
   */
  private final Map<K, F> instanceMap = new Hashtable<K, F>();

  /**
   * 构造函数.
   * <p>
   * 默认使用{@link LinkedHashMap}存储关键字-工厂图.
   * </p>
   */
  public DefaultFlyweightFactory() {
    this(new LinkedHashMap<K, Factory<F, Exception>>());
  }
  /**
   * 构造函数.
   * @param map 关键字-工厂图.
   */
  public DefaultFlyweightFactory(Map<K, Factory<F, Exception>> map) {
    this.factoriesMap = map;
  }

  @Override
  public F getFlyweight(K key) {
    F res = null;
    try {
      res = this.factoriesMap.get(key).getInstance();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
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
  public void registerFactory(K theKey, Factory<F, Exception> factory) {
    this.factoriesMap.put(theKey, factory);
  }

  /**
   * 查找共享实例.
   * @param theKey 关键字.
   * @return 实例.
   */
  protected F findFlyweightInstance(K theKey) {
    return this.instanceMap.get(theKey);
  }
}
