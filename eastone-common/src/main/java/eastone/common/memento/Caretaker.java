/*
 * File:Caretaker.java Type:eastone.common.memento.Caretaker
 */
package eastone.common.memento;

import java.util.Map;

/**
 * 备份维护者.
 * <p>
 * <h1>修改列表:</h1>
 * <ol>
 * <li>初始版本, by wangdongshi@neusoft.com, 2013-11-7 下午12:33:25</li>
 * </ol>
 * </p>
 * @author 王东石 <by wangdongshi@neusoft.com>
 * @version 0.1.1
 * @since 0.1
 */
public interface Caretaker {

  /**
   * 添加备忘.
   * @param <K> 备忘唯一标识类型.
   * @param <T> 备忘内容类型.
   * @param <M> 备忘类型.
   * @param key 备忘唯一标识.
   * @param memento 备忘.
   */
  <K, T, M extends Memento<T>> void putMemento(K key, final M memento);

  /**
   * @param <K> 备忘唯一标识类型.
   * @param <T> 备忘内容类型.
   * @param <M> 备忘类型.
   * @param key 备忘唯一标识.
   * @return 备忘.
   */
  <K, T, M extends Memento<T>> M getMemento(K key);

  /**
   * @param <K> 备忘唯一标识类型.
   * @param key 备忘唯一标识.
   */
  <K> void removeMemento(K key);

  /**
   * 清空备忘图.
   */
  void clear();

  /**
   * 获得完整的备忘图.
   * @param <K> 备忘唯一标识类型.
   * @param <T> 备忘内容类型.
   * @param <M> 备忘类型.
   * @return 备忘图.
   */
  <K, T, M extends Memento<T>> Map<K, M> mapMementos();

}
