/*
 * create time: 2013年12月1日 下午9:25:31
 * path: Rectangle.java
 * type: eastone.graphic.Rectangle
 */
package eastone.graphic;

/**
 * 矩形.
 * <p>
 *   <ul>
 *     <li>修改列表:
 *       <ol>
 *         <li>
 *           wangds@gmail.com, 2013年12月1日 下午9:25:31
 *           <p>初始版本.</p>
 *         </li>
 *       </ol>
 *     </li>
 *   </ul>
 * </p>
 * @param <T> 保存矩形长宽定义的数据的类型.
 * @author 王东石<wangds@gmail.com>
 * @version 0.1
 * @since 0.1
 */
public class Rectangle<T extends Number> implements Graphic {

  /**
   * 矩形高.
   */
  private T height;

  /**
   * 矩形宽.
   */
  private T width;

  /**
   * 默认构造函数.
   */
  public Rectangle() {
  }

  /**
   * 构造函数.
   * @param theWidth 宽.
   * @param theHeight 高.
   */
  public Rectangle(final T theWidth, final T theHeight) {
    this.width = theWidth;
    this.height = theHeight;
  }

  /**
   * 设置height属性值.
   * @param theHeight height属性的新值。
   */
  public void setHeight(final T theHeight) {
    this.height = theHeight;
  }

  /**
   * 获得height属性值.
   * @return height属性现值。
   */
  public T getHeight() {
    return height;
  }

  /**
   * 设置width属性值.
   * @param theWidth width属性的新值。
   */
  public void setWidth(final T theWidth) {
    this.width = theWidth;
  }

  /**
   * 获得width属性值.
   * @return width属性现值。
   */
  public T getWidth() {
    return width;
  }

}
