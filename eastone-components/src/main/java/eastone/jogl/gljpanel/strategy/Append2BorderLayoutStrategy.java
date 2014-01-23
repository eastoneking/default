/*
 * create time: 2013年12月1日 下午10:57:52
 * path: Append2BorderLayoutStrategy.java
 * type: eastone.jogl.gljpanel.strategy.Append2BorderLayoutStrategy
 */
package eastone.jogl.gljpanel.strategy;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.media.opengl.awt.GLJPanel;

import eastone.common.GeneralParentObject;

/**
 * .
 * <p>
 *   <ul>
 *     <li>修改列表:
 *       <ol>
 *         <li>
 *           wangds@gmail.com, 2013年12月1日 下午10:57:52
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
public class Append2BorderLayoutStrategy
  extends GeneralParentObject
  implements AddGLJPanelStrategy<String> {

  /**
   * 策略关键字.
   */
  private String key;
  /**
   * 在BorderLayout中添加JPanel的区域名称.
   */
  private String borderName = BorderLayout.CENTER;

  /**
   * 默认构造函数.
   */
  public Append2BorderLayoutStrategy() {
    this(BorderLayout.CENTER);
  }

  @Override
  public void setKey(final String theKey) {
    this.key = theKey;
  }
  @Override
  public String getKey() {
    return this.key;
  }
  /**
   * 构造函数.
   * @param target 要添加的目标位置.
   * <p>
   *    <ul>可选值:
   *        <li>{@link BorderLayout#CENTER}(默认值);</li>
   *        <li>{@link BorderLayout#NORTH};</li>
   *        <li>{@link BorderLayout#SOUTH};</li>
   *        <li>{@link BorderLayout#EAST};</li>
   *        <li>{@link BorderLayout#WEST}.</li>
   *    </ul>
   * </p>
   */
  public Append2BorderLayoutStrategy(final String target) {
    if (target == null) {
      this.setBorderName(BorderLayout.CENTER);
    } else {
      this.setBorderName(target);
    }
  }

  /**
   * 设置borderName属性值.
   * @param theBorderName borderName属性的新值。
   */
  public void setBorderName(final String theBorderName) {
    this.borderName = theBorderName;
  }

  /**
   * 获得borderName属性值.
   * @return borderName属性现值。
   */
  public String getBorderName() {
    return borderName;
  }


  @Override
  public void append(final Container container, final GLJPanel panel) {
    if (container == null) {
      return;
    }
    if (panel == null) {
      return;
    }

    container.add(this.borderName, panel);
  }

}
