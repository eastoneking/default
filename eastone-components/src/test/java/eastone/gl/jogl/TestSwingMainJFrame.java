/*
 * create time: 2013年12月2日 下午9:23:47
 * path: TestSwingMainJFrame.java
 * type: eastone.gl.jogl.TestSwingMainJFrame
 */
package eastone.gl.jogl;

import java.awt.GraphicsConfiguration;

import javax.swing.JFrame;

import eastone.graphic.Rectangle;
import eastone.jogl.main.swing.AbstractSwingMainJFrame;

/**
 * 用于测试{@link AbstractSwingMainJFrame}的类.
 * <p>
 *   <ul>
 *     <li>修改列表:
 *       <ol>
 *         <li>
 *           wangds@gmail.com, 2013年12月2日 下午9:23:47
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
public class TestSwingMainJFrame extends AbstractSwingMainJFrame {

  /**
   * .
   * @param windowSize
   */
  public TestSwingMainJFrame(Rectangle<Integer> windowSize) {
    super(windowSize);
  }

  /**
   * .
   * @param gc
   * @param windowSize
   */
  public TestSwingMainJFrame(GraphicsConfiguration gc,
      Rectangle<Integer> windowSize) {
    super(gc, windowSize);
  }

  /**
   * .
   * @param title
   * @param windowSize
   */
  public TestSwingMainJFrame(String title, Rectangle<Integer> windowSize) {
    super(title, windowSize);
  }

  /**
   * .
   * @param title
   * @param gc
   * @param windowSize
   */
  public TestSwingMainJFrame(String title, GraphicsConfiguration gc,
      Rectangle<Integer> windowSize) {
    super(title, gc, windowSize);
  }

  /**
   * .
   * @param windowSize
   * @param strategyOfAddGLJPanel
   */
  public TestSwingMainJFrame(Rectangle<Integer> windowSize,
      String strategyOfAddGLJPanel) {
    super(windowSize, strategyOfAddGLJPanel);
  }

  /**
   * .
   * @param gc
   * @param windowSize
   * @param strategyOfAddGLJPanel
   */
  public TestSwingMainJFrame(GraphicsConfiguration gc,
      Rectangle<Integer> windowSize, String strategyOfAddGLJPanel) {
    super(gc, windowSize, strategyOfAddGLJPanel);
  }

  /**
   * .
   * @param title
   * @param windowSize
   * @param strategyOfAddGLJPanel
   */
  public TestSwingMainJFrame(String title, Rectangle<Integer> windowSize,
      String strategyOfAddGLJPanel) {
    super(title, windowSize, strategyOfAddGLJPanel);
  }

  /**
   * .
   * @param title
   * @param gc
   * @param windowSize
   * @param strategyOfAddGLJPanel
   */
  public TestSwingMainJFrame(String title, GraphicsConfiguration gc,
      Rectangle<Integer> windowSize, String strategyOfAddGLJPanel) {
    super(title, gc, windowSize, strategyOfAddGLJPanel);
  }
  
  public static void main(String[] args) {
    TestSwingMainJFrame f = new TestSwingMainJFrame(new Rectangle<Integer>((Integer)800,(Integer)600));
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.addGLJPanel(null);
    f.setVisible(true);
    
  }

}
