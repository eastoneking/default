/*
 * create time: 2013年12月1日 下午10:53:06
 * path: GLJPanelFacotry.java
 * type: eastone.jogl.gljpanel.GLJPanelFacotry
 */
package eastone.jogl.gljpanel;

import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLJPanel;

import eastone.common.factory.Factory;

/**
 * GLJPanel工厂类.
 * <p>
 *   <ul>
 *     <li>修改列表:
 *       <ol>
 *         <li>
 *           wangds@gmail.com, 2013年12月1日 下午10:53:06
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
public class GLJPanelFacotry implements Factory<GLJPanel, RuntimeException> {

  /**
   * 构造函数.
   */
  public GLJPanelFacotry() {
  }

  @Override
  public GLJPanel getInstance() {
    GLJPanel res = null;
    GLProfile glprofile = GLProfile.getDefault();
    GLCapabilities glcapabilities = new GLCapabilities(glprofile);
    res = new GLJPanel(glcapabilities);
    return res;
  }

}
