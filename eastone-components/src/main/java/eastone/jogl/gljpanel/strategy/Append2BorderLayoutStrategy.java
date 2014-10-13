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
import eastone.common.strategy.StrategyContext;

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

    
  private StrategyContext<String> context = null;
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

  public void setKey(final String theKey) {
    this.key = theKey;
  }

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

  public void append(final Container container, final GLJPanel panel) {
    if (container == null) {
      return;
    }
    if (panel == null) {
      return;
    }

    container.add(this.borderName, panel);
  }

/*
 * @see eastone.common.strategy.Strategy#getContext()
 * @author wangds 2014年10月5日 下午7:29:45.
 */
@SuppressWarnings("unchecked")
public <C extends StrategyContext<String>> C getContext() {
    return (C)this.context;
}

/*
 * @see eastone.common.strategy.Strategy#setContext(eastone.common.strategy.StrategyContext)
 * @author wangds 2014年10月5日 下午7:29:45.
 */
public <C extends StrategyContext<String>> void setContext(C ctx) {
    this.context = ctx;
}

}
