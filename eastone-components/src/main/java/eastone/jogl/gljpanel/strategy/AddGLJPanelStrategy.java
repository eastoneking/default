/*
 * create time: 2013年12月1日 下午10:59:46
 * path: AddGLJPanelStrategy.java
 * type: eastone.jogl.gljpanel.strategy.AddGLJPanelStrategy
 */
package eastone.jogl.gljpanel.strategy;

import java.awt.Container;

import javax.media.opengl.awt.GLJPanel;

import eastone.common.strategy.Strategy;

/**
 * 添加GLJpendl到容器策略接口.
 * <p>
 *   <ul>
 *     <li>修改列表:
 *       <ol>
 *         <li>
 *           wangds@gmail.com, 2013年12月1日 下午10:59:46
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
public interface AddGLJPanelStrategy extends Strategy {

  /**
   * 向容器中添加GL面板.
   * @param container 容器.
   * @param panel 被添加的GL面板.
   */
  void append(Container container, GLJPanel panel);

}
