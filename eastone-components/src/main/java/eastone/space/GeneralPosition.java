/*
 * create time: 2013年12月4日 下午8:12:41
 * path: TwoDimansionalXandYPosition.java
 * type: eastone.space.TwoDimansionalXandYPosition
 */
package eastone.space;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Set;

/**
 * 二维空间位置.
 * <p>
 *   <ul>
 *     <li>修改列表:
 *       <ol>
 *         <li>
 *           wangds@gmail.com, 2013年12月4日 下午8:12:41
 *           <p>初始版本.</p>
 *         </li>
 *       </ol>
 *     </li>
 *   </ul>
 * </p>
 * @param <T> 数据类型.
 * @param <D> 维度命名类型.
 * @author 王东石<wangds@gmail.com>
 * @version 0.1
 * @since 0.1
 */
public class GeneralPosition<T, D>
  implements Position<T, D>, Serializable, Cloneable {

  /**
   * 序列化版本唯一编号.
   */
  private static final long serialVersionUID = -6442427783180060229L;

  /**
   * 位置.
   */
  private T pos = null;

  /**
   * 维度列表.
   */
  private Set<D> dimensions = null;

  /**
   * 构造函数.
   * @param theDimensions 维度.
   */
  public GeneralPosition(final Set<D> theDimensions) {
    this.setDimensions(theDimensions);
  }

  @Override
  public void setPos(final T thePos) {
    this.pos = thePos;
  }

  @Override
  public T getPos() {
    return this.pos;
  }

  @Override
  public Set<D> listDimensions() {
    return this.dimensions;
  }

  @Override
  public D findDimension(final int index) {
    D res = null;
    int size = this.size();
    if (index < size) {
      Iterator<D> it = this.dimensions.iterator();
      for (int i = 0; i < index; i++) {
        res = it.next();
      }
    }
    return res;
  }

  @Override
  public void setDimensions(final Set<D> theDimensions) {
    this.dimensions = theDimensions;
  }

  @Override
  public int size() {
    return this.dimensions.size();
  }

}
