/*
 * create time: 2013年12月1日 下午9:14:25
 * path: AbstractSwingMainJFrame.java
 * type: eastone.jogl.main.swing.AbstractSwingMainJFrame
 */
package eastone.jogl.main.swing;

import java.awt.BorderLayout;
import java.awt.GraphicsConfiguration;
import java.awt.LayoutManager;

import javax.swing.JFrame;

import eastone.graphic.Rectangle;

/**
 * 抽象JFrame类.
 * <p>
 * 包含一个GL Panel的JFrame子类。
 * </p>
 * <p>
 *   <ul>
 *     <li>修改列表:
 *       <ol>
 *         <li>
 *           wangds@gmail.com, 2013年12月1日 下午9:14:25
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
public class AbstractSwingMainJFrame 
  extends JFrame {

  /**
   * 序列化所需字段.
   */
  private static final long serialVersionUID = 1449760609547802959L;

  /**
   * 默认布局.
   */
  private LayoutManager defaultLayout = new BorderLayout();

  /**
   * 默认构造函数.
   * @param windowSize 窗口大小.
   */
  public AbstractSwingMainJFrame(final Rectangle<Integer> windowSize) {
    super();
    initLayout();
    setSize(windowSize);
  }

  /**
   * 构造函数.
   * @param gc 图形配置.
   * @param windowSize 窗口大小.
   */
  public AbstractSwingMainJFrame(
      final GraphicsConfiguration gc,
      final Rectangle<Integer> windowSize
  ) {
    super(gc);
    initLayout();
    setSize(windowSize);
  }

  /**
   * 构造函数.
   * @param title 标题.
   * @param windowSize 窗口大小.
   */
  public AbstractSwingMainJFrame(
      String title,
      Rectangle<Integer> windowSize
  ) {
    super(title);
    initLayout();
    setSize(windowSize);
  }

  /**
   * 构造函数.
   * @param title 标题.
   * @param gc 图形配置.
   * @param windowSize 窗口大小.
   */
  public AbstractSwingMainJFrame(
      String title,
      GraphicsConfiguration gc,
      Rectangle<Integer> windowSize
  ) {
    super(title, gc);
    initLayout();
    setSize(windowSize);
  }

  /**
   * 设置defaultLayout属性值.
   * @param theDefaultLayout defaultLayout属性的新值。
   */
  public void setDefaultLayout(LayoutManager theDefaultLayout) {
    this.defaultLayout = theDefaultLayout;
  }

  /**
   * 获得defaultLayout属性值.
   * @return defaultLayout属性现值。
   */
  public LayoutManager getDefaultLayout() {
    return defaultLayout;
  }

  /**
   * 设置窗口大小.
   * @param windowSize 窗口大小.
   */
  public void setSize(Rectangle<Integer> windowSize) {
    if (windowSize != null) {
      this.setSize(windowSize.getWidth(), windowSize.getHeight());
    }
  }

  @Override
  public void setLayout(LayoutManager manager) {
    if (manager == null) {
      manager = this.getDefaultLayout();
    }
    super.setLayout(manager);
  }
  
  /**
   * 初始化布局.
   */
  protected void initLayout() {
    this.setLayout(this.getDefaultLayout());
  }

  
}
