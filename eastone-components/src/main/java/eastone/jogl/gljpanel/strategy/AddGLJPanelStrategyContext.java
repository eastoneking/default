/*
 * create time: 2013年12月1日 下午11:12:33
 * path: AddGLJPanelStrategyContext.java
 * type: eastone.jogl.gljpanel.strategy.AddGLJPanelStrategyContext
 */
package eastone.jogl.gljpanel.strategy;

import java.awt.Container;
import java.util.Map;

import javax.media.opengl.awt.GLJPanel;

import eastone.common.strategy.AbstractStrategyContext;
import eastone.common.strategy.Strategy;
import eastone.common.strategy.StrategyRuntimeException;

/**
 * 向容器中添加GLJPanel对象策略上下文.
 * <p>
 *   <ul>
 *     <li>修改列表:
 *       <ol>
 *         <li>
 *           wangds@gmail.com, 2013年12月1日 下午11:12:33
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
public class AddGLJPanelStrategyContext
  extends AbstractStrategyContext<String, StrategyRuntimeException> {

  /**
   * 被添加GLJPanel对象的容器.
   */
  private Container container;

  /**
   * 被添加到容器中的{@link GLJPanel}对象.
   */
  private GLJPanel panel;

  /**
   * 构造函数.
   * @param theStrategyMap 策略图.
   */
  public AddGLJPanelStrategyContext(
      Map<String, Strategy> theStrategyMap
  ) {
    super(theStrategyMap);
  }

  /**
   * 设置container属性值.
   * @param theContainer container属性的新值。
   */
  public void setContainer(Container theContainer) {
    this.container = theContainer;
  }

  /**
   * 获得container属性值.
   * @return container属性现值。
   */
  public Container getContainer() {
    return container;
  }

  /**
   * 设置panel属性值.
   * @param thePanel panel属性的新值。
   */
  public void setPanel(GLJPanel thePanel) {
    this.panel = thePanel;
  }

  /**
   * 获得panel属性值.
   * @return panel属性现值。
   */
  public GLJPanel getPanel() {
    return panel;
  }

  @Override
  public void clear() {
    super.clear();
    this.container = null;
    this.panel = null;
  }

  @Override
  protected <S extends Strategy> void proccessStrategry(S strategy)
      throws StrategyRuntimeException {
    Append2BorderLayoutStrategy a2bs = (Append2BorderLayoutStrategy) strategy;
    a2bs.append(container, panel);
  }

}
