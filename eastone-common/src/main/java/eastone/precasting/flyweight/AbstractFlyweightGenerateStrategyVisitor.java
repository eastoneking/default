/*
 * create time: 2013年12月8日 下午11:16:38
 * path: AbstractFlyweightGenerateStrategyVisitor.java
 * type: eastone.precasting.flyweight.AbstractFlyweightGenerateStrategyVisitor
 */
package eastone.precasting.flyweight;

import java.util.Map;

import eastone.common.GeneralParentObject;
import eastone.common.flyweight.Flyweight;

/**
 * .
 * <p>
 *   <ul>
 *     <li>修改列表:
 *       <ol>
 *         <li>
 *           wangds@gmail.com, 2013年12月8日 下午11:16:38
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
public abstract class AbstractFlyweightGenerateStrategyVisitor
  <K, F extends Flyweight>
  extends GeneralParentObject
  implements FlyweightGenerateStrategyVisitor<K, F> {

  /**
   * 享元实例列表.
   */
  private Map<K, F> instanceMap;

  /**
   * 享元唯一之别标识.
   */
  private K key;

  /**
   * 享元实例.
   */
  private F instance;

  /**
   * 默认构造函数.
   */
  public AbstractFlyweightGenerateStrategyVisitor() {
  }

  @Override
  public void setFactoryInstanceMap(final Map<K, F> map) {
    this.instanceMap = map;
  }

  /**
   * 获得instanceMap属性值.
   * @return instanceMap属性现值。
   */
  public Map<K, F> getFactoryInstanceMap() {
    return instanceMap;
  }

  @Override
  public void setKey(final K theKey) {
    this.key = theKey;
  }

  /**
   * 获得key属性值.
   * @return key属性现值。
   */
  public K getKey() {
    return key;
  }

  @Override
  public void setInstance(final F theInstance) {
    this.instance = theInstance;
  }

  /**
   * 获得instance属性值.
   * @return instance属性现值。
   */
  public F getInstance() {
    return instance;
  }

  @Override
  public void clear() {
    this.instanceMap = null;
    this.instance = null;
    this.key = null;
  }

}
