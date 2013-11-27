/*
 * File:Mediator.java Type:eastone.common.mediator.Mediator
 */
package eastone.common.mediator;

import java.util.Map;

/**
 * 中介者模式.
 * <p>
 * <h1>修改列表:</h1>
 * <ol>
 * <li>初始版本, by wangdongshi@neusoft.com, 2013-11-7 11:32:04</li>
 * </ol>
 * </p>
 * @param <K> 协同组件的唯一识别标识类型.
 * @param <C> 协同组件的基类类型.
 * @author 王东石 <wangdongshi@neusoft.com>
 * @version 0.1.1
 * @since 0.1
 */
public interface Mediator<K, C extends Colleague> {

  /**
   * 添加协作对象.
   * @param <T> 协作对象类型.
   * @param key 唯一标识.
   * @param colleague 协作对象.
   */
  <T extends C> void addColleague(K key, T colleague);

  /**
   * 获得指定的唯一标识对应的协作对象.
   * @param <T> 协作对象类型.
   * @param key 唯一标识.
   * @return 协作对象.
   */
  <T extends C> T getColleague(K key);

  /**
   * 通过唯一标识移除协作对象.
   * @param <T> 协作对象类型.
   * @param key 唯一标识.
   */
  <T extends C> void removeColleague(K key);

  /**
   * 清空协作对象.
   */
  void clear();

  /**
   * 获得所有协作对象的唯一标识图.
   * @param <T> 协作对象类型.
   * @return 所有协作对象的唯一标识图.
   */
  <T extends C> Map<K, T> mapColleagues();

}
