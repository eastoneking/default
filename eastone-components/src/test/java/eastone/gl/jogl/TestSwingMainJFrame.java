/*
 * create time: 2013年12月2日 下午9:23:47 path: TestSwingMainJFrame.java type:
 * eastone.gl.jogl.TestSwingMainJFrame
 */
package eastone.gl.jogl;

import java.awt.GraphicsConfiguration;

import javax.swing.JFrame;

import eastone.graphic.Rectangle;
import eastone.jogl.main.swing.AbstractSwingMainJFrame;

/**
 * 用于测试{@link AbstractSwingMainJFrame}的类.
 * <p>
 * <ul>
 * <li>修改列表:
 * <ol>
 * <li>wangds@gmail.com, 2013年12月2日 下午9:23:47
 * <p>
 * 初始版本.
 * </p>
 * </li>
 * </ol>
 * </li>
 * </ul>
 * </p>
 * @author 王东石<wangds@gmail.com>
 * @version 0.1
 * @since 0.1
 */
public class TestSwingMainJFrame extends AbstractSwingMainJFrame {

  /**
   * .
   */
  private static final int WINDOW_HEIGHT = 600;
  /**
   * .
   */
  private static final int WINDOW_WIDTH = 800;
  /**
   * .
   */
  private static final long serialVersionUID = 8643834252000912393L;

  /**
   * 构造函数.
   * @param windowSize 窗口大小.
   */
  public TestSwingMainJFrame(final Rectangle<Integer> windowSize) {
    super(windowSize);
  }

  /**
   * 构造函数.
   * @param gc 图形配置.
   * @param windowSize 窗口大小.
   */
  public TestSwingMainJFrame(
      final GraphicsConfiguration gc,
      final Rectangle<Integer> windowSize) {
    super(gc, windowSize);
  }

  /**
   * 构造函数.
   * @param title 标题.
   * @param windowSize 窗口大小.
   */
  public TestSwingMainJFrame(
      final String title,
      final Rectangle<Integer> windowSize) {
    super(title, windowSize);
  }

  /**
   * 构造函数.
   * @param title 标题.
   * @param gc 图形配置.
   * @param windowSize 窗口大小.
   */
  public TestSwingMainJFrame(
      final
      String title,
      final
      GraphicsConfiguration gc,
      final
      Rectangle<Integer> windowSize
  ) {
    super(title, gc, windowSize);
  }

  /**
   * 构造函数.
   * @param windowSize 窗口大小.
   * @param strategyOfAddGLJPanel GL面板添加策略.
   */
  public TestSwingMainJFrame(
      final
      Rectangle<Integer> windowSize,
      final
      String strategyOfAddGLJPanel) {
    super(windowSize, strategyOfAddGLJPanel);
  }

  /**
   * 构造函数.
   * @param gc 图形配置.
   * @param windowSize 窗口大小.
   * @param strategyOfAddGLJPanel GL面板添加策略.
   */
  public TestSwingMainJFrame(
      final GraphicsConfiguration gc,
      final Rectangle<Integer> windowSize,
      final String strategyOfAddGLJPanel
  ) {
    super(gc, windowSize, strategyOfAddGLJPanel);
  }

  /**
   * 构造函数.
   * @param title 标题.
   * @param windowSize 窗口大小.
   * @param strategyOfAddGLJPanel GL面板添加策略.
   */
  public TestSwingMainJFrame(
      final String title,
      final Rectangle<Integer> windowSize,
      final String strategyOfAddGLJPanel
  ) {
    super(title, windowSize, strategyOfAddGLJPanel);
  }

  /**
   * 构造函数.
   * @param title 标题.
   * @param gc 图形配置.
   * @param windowSize 窗口大小.
   * @param strategyOfAddGLJPanel GL面板添加策略.
   */
  public TestSwingMainJFrame(
      final String title,
      final GraphicsConfiguration gc,
      final Rectangle<Integer> windowSize,
      final String strategyOfAddGLJPanel
  ) {
    super(title, gc, windowSize, strategyOfAddGLJPanel);
  }

  /**
   * 测试主函数.
   * @param args 命令行参数.
   */
  public static void main(final String[] args) {
    TestSwingMainJFrame f = new TestSwingMainJFrame(
        new Rectangle<Integer>((Integer) WINDOW_WIDTH, (Integer) WINDOW_HEIGHT)
     );
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.addGLJPanel(null);
    f.setVisible(true);

  }

}
