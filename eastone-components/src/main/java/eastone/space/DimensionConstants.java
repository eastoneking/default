/*
 * create time: 2013年12月4日 下午8:40:20
 * path: DimensionConstants.java
 * type: eastone.space.DimensionConstants
 */
package eastone.space;

import java.util.Set;
import java.util.TreeSet;

/**
 * 维度常量列表.
 * <p>
 *   <ul>
 *     <li>修改列表:
 *       <ol>
 *         <li>
 *           wangds@gmail.com, 2013年12月4日 下午8:40:20
 *           <p>初始版本.</p>
 *         </li>
 *       </ol>
 *     </li>
 *   </ul>
 * </p>
 * @author 王东石<wangds@gmail.com>
 * @version 0.1
 * @since 0.1
 */
public final class DimensionConstants {

  /**
   * 构造函数.
   */
  private DimensionConstants() {
  }

  /**
   * 二维.
   */
  public static final Set<String> TWO_DIMENSIONS = new TreeSet<String>();

  /**
   * 三维.
   */
  public static final Set<String> THREE_DIMENSIONS = new TreeSet<String>();

  /**
   * 二维.
   */
  public static final Set<String> TWO_DIMENSIONS_UPCASE = new TreeSet<String>();

  /**
   * 三维.
   */
  public static final Set<String> THREE_DIMENSIONS_UPCASE
    = new TreeSet<String>();

  static {
    TWO_DIMENSIONS.add("x");
    TWO_DIMENSIONS.add("y");

    THREE_DIMENSIONS.add("x");
    THREE_DIMENSIONS.add("y");
    THREE_DIMENSIONS.add("z");

    TWO_DIMENSIONS_UPCASE.add("x");
    TWO_DIMENSIONS_UPCASE.add("y");

    THREE_DIMENSIONS_UPCASE.add("x");
    THREE_DIMENSIONS_UPCASE.add("y");
    THREE_DIMENSIONS_UPCASE.add("z");
  }
}
