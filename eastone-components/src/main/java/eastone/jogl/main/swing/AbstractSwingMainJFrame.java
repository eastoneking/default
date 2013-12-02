/*
 * create time: 2013年12月1日 下午9:14:25
 * path: AbstractSwingMainJFrame.java
 * type: eastone.jogl.main.swing.AbstractSwingMainJFrame
 */
package eastone.jogl.main.swing;

import java.awt.BorderLayout;
import java.awt.GraphicsConfiguration;
import java.awt.LayoutManager;

import javax.media.opengl.awt.GLJPanel;
import javax.swing.JFrame;

import eastone.graphic.Rectangle;
import eastone.jogl.gljpanel.GLJPanelFacotry;
import eastone.jogl.gljpanel.strategy.AddGLJPanelStrategyContext;
import eastone.jogl.gljpanel.strategy.Append2BorderLayoutStrategy;

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
   * 用于保存如何添加GLJPanel的策略上下文.
   */
  private static final AddGLJPanelStrategyContext ADD_GLJP_CTX
    = new AddGLJPanelStrategyContext();

  static {
    //初始化添加GLJPanel的备选策略列表.
    ADD_GLJP_CTX.registerStrategy(
        BorderLayout.CENTER, new Append2BorderLayoutStrategy()
    );
    ADD_GLJP_CTX.registerStrategy(
        BorderLayout.NORTH, new Append2BorderLayoutStrategy(BorderLayout.NORTH)
    );
    ADD_GLJP_CTX.registerStrategy(
        BorderLayout.SOUTH, new Append2BorderLayoutStrategy(BorderLayout.SOUTH)
    );
    ADD_GLJP_CTX.registerStrategy(
        BorderLayout.EAST, new Append2BorderLayoutStrategy(BorderLayout.EAST)
    );
    ADD_GLJP_CTX.registerStrategy(
        BorderLayout.WEST, new Append2BorderLayoutStrategy(BorderLayout.WEST)
    );
  }

  /**
   * 默认布局.
   */
  private LayoutManager defaultLayout = new BorderLayout();

  /**
   * 向窗体中添加GLJPanel的策略.
   */
  private String addGLJPanelStrategy = BorderLayout.CENTER;

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
   * 默认构造函数.
   * @param windowSize 窗口大小.
   * @param strategyOfAddGLJPanel GLJPanel添加策略.
   */
  public AbstractSwingMainJFrame(
      final Rectangle<Integer> windowSize,
      final String strategyOfAddGLJPanel) {
    super();
    initLayout();
    setSize(windowSize);
    this.addGLJPanelStrategy = strategyOfAddGLJPanel;
  }

  /**
   * 构造函数.
   * @param gc 图形配置.
   * @param windowSize 窗口大小.
   * @param strategyOfAddGLJPanel GLJPanel添加策略.
   */
  public AbstractSwingMainJFrame(
      final GraphicsConfiguration gc,
      final Rectangle<Integer> windowSize,
      final String strategyOfAddGLJPanel
  ) {
    super(gc);
    initLayout();
    setSize(windowSize);
    this.addGLJPanelStrategy = strategyOfAddGLJPanel;
  }

  /**
   * 构造函数.
   * @param title 标题.
   * @param windowSize 窗口大小.
   * @param strategyOfAddGLJPanel GLJPanel添加策略.
   */
  public AbstractSwingMainJFrame(
      final String title,
      final Rectangle<Integer> windowSize,
      final String strategyOfAddGLJPanel
  ) {
    super(title);
    initLayout();
    setSize(windowSize);
    this.addGLJPanelStrategy = strategyOfAddGLJPanel;
  }

  /**
   * 构造函数.
   * @param title 标题.
   * @param gc 图形配置.
   * @param windowSize 窗口大小.
   * @param strategyOfAddGLJPanel GLJPanel添加策略.
   */
  public AbstractSwingMainJFrame(
      final String title,
      final GraphicsConfiguration gc,
      final Rectangle<Integer> windowSize,
      final String strategyOfAddGLJPanel
  ) {
    super(title, gc);
    initLayout();
    setSize(windowSize);
    this.addGLJPanelStrategy = strategyOfAddGLJPanel;
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
   * 设置addGLJPanelStrategy属性值.
   * @param theAddGLJPanelStrategy addGLJPanelStrategy属性的新值。
   */
  public void setAddGLJPanelStrategy(String theAddGLJPanelStrategy) {
    this.addGLJPanelStrategy = theAddGLJPanelStrategy;
  }

  /**
   * 获得addGLJPanelStrategy属性值.
   * @return addGLJPanelStrategy属性现值。
   */
  public String getAddGLJPanelStrategy() {
    return addGLJPanelStrategy;
  }

  /**
   * 初始化布局.
   */
  protected void initLayout() {
    this.setLayout(this.getDefaultLayout());
  }

  /**
   * 向窗体添加GLJPanel对象.
   * @param gljp GLJPanel对象.
   */
  protected void addGLJPanel(GLJPanel gljp) {
    Append2BorderLayoutStrategy strategy
      = ADD_GLJP_CTX.findStrategy(this.addGLJPanelStrategy);
    if (gljp == null) {
      gljp = new GLJPanelFacotry().getInstance();
    }
    strategy.append(this, gljp);
  }

}
