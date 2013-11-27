/*
 * File:a.java Type:.a
 */
package eastone.gl.jogl;

/**
 * <p>
 * <h1>修改列表:</h1>
 * <ol>
 * <li>初始版本, by wangdongshi@neusoft.com, 2013-11-25 下午10:24:34</li>
 * </ol>
 * </p>
 * @author 王东石 <wangdongshi@neusoft.com>
 * @version 0.1.1
 * @since 0.1
 */
import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;

/**
 * 三角.
 * <p>
 *   <ul>
 *     <li>修改列表:
 *       <ol>
 *         <li>
 *           wangds@gmail.com, 2013年11月27日 下午11:14:43
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
public final class OneTriangle {

  /**
   * 构造函数.
   */
  private OneTriangle() {
  }
  /**
   * 初始化.
   * @param gl2 gl
   * @param width 长。
   * @param height 宽。
   */
  protected static void setup(
      final GL2 gl2, final int width, final int height
  ) {
    gl2.glMatrixMode(GL2.GL_PROJECTION);
    gl2.glLoadIdentity();

    // coordinate system origin at lower left
    //with width and height same as the window
    GLU glu = new GLU();
    glu.gluOrtho2D(0.0f, width, 0.0f, height);

    gl2.glMatrixMode(GL2.GL_MODELVIEW);
    gl2.glLoadIdentity();

    gl2.glViewport(0, 0, width, height);
  }

  /**
   * 渲染.
   * @param gl2 gl.
   * @param width 长。
   * @param height 宽。
   */
  protected static void render(
      final GL2 gl2, final int width, final int height) {
    gl2.glClear(GL.GL_COLOR_BUFFER_BIT);

    // draw a triangle filling the window
    gl2.glLoadIdentity();
    gl2.glBegin(GL.GL_TRIANGLES);
    gl2.glColor3f(1, 0, 0);
    gl2.glVertex2f(0, 0);
    gl2.glColor3f(0, 1, 0);
    gl2.glVertex2f(width, 0);
    gl2.glColor3f(0, 0, 1);
    gl2.glVertex2f(width / 2, height);
    gl2.glEnd();
  }
}
