/*
 * create time: 2013年12月4日 下午7:56:06
 * path: Position.java
 * type: eastone.space.Position
 */
package eastone.space;

import java.util.Set;

/**
 * 位置.
 * <p>
 *   <ul>
 *     <li>修改列表:
 *       <ol>
 *         <li>
 *           wangds@gmail.com, 2013年12月4日 下午7:56:06
 *           <p>初始版本.</p>
 *         </li>
 *       </ol>
 *     </li>
 *   </ul>
 * </p>
 * @param <T> 位置数据类型.
 * @param <D> Dimension维度标识类型.
 * @author 王东石<wangds@gmail.com>
 * @version 0.1
 * @since 0.1
 */
public interface Position<T, D> {

  /**
   * 设置位置.
   * @param thePos 位置.
   * <p>
   * 在空间不同维度上的偏移量的有序集合.
   * </p>
   */
  void setPos(T thePos);

  /**
   * 获得位置.
   * @return 位置.
   * <p>
   * 在空间不同维度上的偏移量的有序集合.
   * </p>
   */
  T getPos();

  /**
   * 获得空间位置维度命名有序列表.
   * @return n为空间中对每个维度的命名集合.
   * <p>
   * 例如:x和y轴的正交空间二维空间返回值为{"x","y"}.
   * </p>
   */
  Set<D> listDimensions();

  /**
   * 获得n维空间第index维的名称.
   * @param index 维度索引.
   * @return 维度名称.
   */
  D findDimension(int index);

  /**
   * 设置维度.
   * @param dimensions 维度列表.
   */
  void setDimensions(Set<D> dimensions);

  /**
   * 获得维度数量.
   * @return 维度数量.
   * <p>
   *    例如：二维空间返回值为“2”.
   * </p>
   */
  int size();
}
