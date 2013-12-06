/*
 * File:FlyweightFactory.java Type:eastone.common.flyweight.FlyweightFactory
 */
package eastone.common.flyweight;

/**
 * 享元工厂.
 * <p>
 * <ol>
 * <li>初始版本, by wangdongshi@neusoft.com, 2013-11-06 12:14:35</li>
 * </ol>
 * </p>
 * @param <K> 享元标识类型.
 * @param <F> 享元类型.
 * @author 王东石 <wangdongshi@neusoft.com>
 * @version 0.1.1
 * @since 0.1
 */
public interface FlyweightFactory<K, F extends Flyweight> {

  /**
   * 获得享元实例.
   * @param key 享元标识.
   * @return 享元.
   */
  F getFlyweight(K key);

}
